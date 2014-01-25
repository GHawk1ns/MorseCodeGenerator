package com.ghawk1ns.morsecodegenerator;

import android.hardware.Camera;
import android.view.View;

/**
 * Created by GHawkins on 8/16/13.
 */
public class CameraHandler {
   private Camera cam;
   private Camera.Parameters params;
   private boolean ledOn;

   CameraHandler(){
      cam = Camera.open();
      params = cam.getParameters();
      params.setFlashMode(Camera.Parameters.FLASH_MODE_TORCH);
      cam.release();
   }

   public void lightSwitch(){
      if(ledOn){
         ledOff();
      } else {
         ledOn();
      }
   }

   public void flicker(long time) {
      lightSwitch();
      try {
         Thread.sleep(time);
      } catch (InterruptedException e) {
         e.printStackTrace();
      }
      lightSwitch();
   }

   private void ledOn() {
      ledOn = true;
      cam = Camera.open();
      cam.setParameters(params);
      cam.startPreview();
   }

   private void ledOff() {
      ledOn = false;
      cam.stopPreview();
      cam.release();
   }

   public void OnDestroy() {
      if(ledOn){
         ledOff();
      }
   }
}
