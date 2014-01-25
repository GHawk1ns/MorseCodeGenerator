package com.ghawk1ns.morsecodegenerator;

import android.media.AudioManager;
import android.media.Ringtone;
import android.media.RingtoneManager;
import android.media.ToneGenerator;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;


public class MainActivity extends Activity {

   static CameraHandler camHandler;
   long DOT_LENGTH = 100;
   long DASH_LENGTH = DOT_LENGTH * 5;
   long WORD_GAP_LENGTH = DASH_LENGTH-DOT_LENGTH;
   long CHAR_GAP_LENGTH = DOT_LENGTH;
   TextView tv;
   Button encodeButton;
   EditText input;
   Switch lightSwitch;
   Switch soundSwitch;
   Switch repeatSwitch;
   MorseCodeTask mTask;


   @Override
   protected void onCreate(Bundle savedInstanceState) {
      super.onCreate(savedInstanceState);
      setContentView(R.layout.activity_main);
      camHandler = new CameraHandler();
      tv = (TextView) findViewById(R.id.text);
      encodeButton = (Button) findViewById(R.id.button);
      input = (EditText) findViewById(R.id.input);
      lightSwitch = (Switch) findViewById(R.id.lightSwitch);
      soundSwitch = (Switch) findViewById(R.id.soundSwitch);
      repeatSwitch = (Switch) findViewById(R.id.repeatSwitch);
   }

   @Override
   public boolean onCreateOptionsMenu(Menu menu) {
      // Inflate the menu; this adds items to the action bar if it is present.
      getMenuInflater().inflate(R.menu.main, menu);
      return true;
   }


   @Override
   public void onResume(){
      super.onResume();
      if(!encodeButton.isClickable()){
         tv.setText("");
         encodeButton.setClickable(true);
      }
   }

   @Override
   public void onPause(){
      super.onPause();
      if(mTask != null){
         mTask.cancel(true);
      }
   }

   public void lightSwitch(View v) {
      camHandler.lightSwitch();
   }

   public void encode(View v) throws InterruptedException {
      encodeButton.setClickable(false);
      tv.setText("");
      String str = input.getText().toString();
      mTask = new MorseCodeTask();
      mTask.execute(str);
      //new MorseCodeTask().execute(str);
   }

   private class MorseCodeTask extends AsyncTask<String, Character, Boolean> {
      protected Boolean doInBackground(String... str) {
         //sound demo
         final ToneGenerator dot = new ToneGenerator(AudioManager.STREAM_NOTIFICATION, 100);
         final ToneGenerator dash = new ToneGenerator(AudioManager.STREAM_NOTIFICATION, 100);

         //maybe only have one or the other?
         boolean withLight = lightSwitch.isChecked();
         boolean withSound = soundSwitch.isChecked();

         List<MorseCodeConverter.UNIT> sequence;

         char[] charList = (str[0].toCharArray());
         for (char c : charList) {
            sequence = MorseCodeConverter.convertChar(c);
            publishProgress(c);
            for (MorseCodeConverter.UNIT unit : sequence) {
               if(isCancelled()){
                  return false;
               }
               switch (unit) {
                  case DOT:
                     if(withLight){
                        camHandler.flicker(DOT_LENGTH);
                     }
                     if(withSound){
                        dot.startTone(ToneGenerator.TONE_PROP_BEEP2);
                        sleep(DOT_LENGTH);
                     }
                     break;
                  case DASH:
                     if(withLight){
                        camHandler.flicker(DASH_LENGTH);
                     }
                     if(withSound){
                        dash.startTone(ToneGenerator.TONE_PROP_BEEP2);
                        sleep(DASH_LENGTH);
                     }
                     break;
                  case WORD_GAP:
                     sleep(WORD_GAP_LENGTH);
                     break;
               }
               sleep(CHAR_GAP_LENGTH);
            }

         }
         return true;
      }

      protected void onProgressUpdate(Character... c) {
         tv.setText(tv.getText() + String.valueOf(c[0]));
      }

      protected void onPostExecute(Boolean result) {
            encodeButton.setClickable(true);
      }
      //put the thread to sleep for "time" milliseconds
      public void sleep(long time){
         try {
            Thread.sleep(time);
         } catch (InterruptedException e) {
            e.printStackTrace();
         }

      }
   }

   public void toast(String str){
      Toast.makeText(this,str,Toast.LENGTH_LONG).show();
   }

}