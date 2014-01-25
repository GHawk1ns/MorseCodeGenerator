package com.ghawk1ns.morsecodegenerator;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MorseCodeConverter {
   public static enum UNIT  {DASH,DOT,CHAR_GAP,WORD_GAP};
   public static MorseCodeMap morseCodeMap = new MorseCodeMap();

   public static List<UNIT> convertString(String _s){

      List<UNIT> list = new ArrayList<UNIT>();

      String str = _s.toLowerCase();
      for(int i = 0; i < str.length(); i++){
         String ch = str.substring(i,i+1);
         //between words
         if(str.charAt(i)==' '){
            list.add(UNIT.WORD_GAP);
         }
         else{
            if(morseCodeMap.get(ch) != null){
               list.addAll(morseCodeMap.get(ch));
               //look ahead to see if we append a char gap
               if(i+1 < str.length() && str.charAt(i+1) != ' '){
                  list.add(UNIT.CHAR_GAP);
               }
            }
         }
      }
      return list;
   }

   public static List<UNIT> convertChar(char _c){

      List<UNIT> list = new ArrayList<UNIT>();

      if(Character.isLetterOrDigit(_c)){
         String key = (String.valueOf(_c).toLowerCase());
         list = morseCodeMap.get(key);
      }
      else {
         list.add(UNIT.WORD_GAP);
      }

      return list;
   }
}
