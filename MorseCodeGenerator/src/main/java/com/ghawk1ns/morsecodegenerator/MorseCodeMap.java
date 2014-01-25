package com.ghawk1ns.morsecodegenerator;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import com.ghawk1ns.morsecodegenerator.MorseCodeConverter.UNIT;


/**
 * Created by GHawkins on 8/16/13.
 */
public class MorseCodeMap {
   private HashMap<String,List<UNIT>> map;

   public MorseCodeMap(){
      map = new HashMap<String, List<UNIT>>();
      initialize();
   }

   public List<UNIT> get(String key){
      return map.get(key);
   }

   private void initialize(){
      UNIT[] aList = {UNIT.DOT,UNIT.DASH};
      map.put("a", Arrays.asList(aList) );

      UNIT[] bList = {UNIT.DASH,UNIT.DOT,UNIT.DOT,UNIT.DOT};
      map.put("b", Arrays.asList(bList) );

      UNIT[] cList = {UNIT.DASH,UNIT.DOT,UNIT.DASH,UNIT.DOT};
      map.put("c", Arrays.asList(cList) );

      UNIT[] dList = {UNIT.DASH,UNIT.DOT,UNIT.DOT};
      map.put("d", Arrays.asList(dList) );

      UNIT[] eList = {UNIT.DOT};
      map.put("e", Arrays.asList(eList) );

      UNIT[] fList = {UNIT.DOT,UNIT.DOT,UNIT.DASH,UNIT.DOT};
      map.put("f", Arrays.asList(fList) );

      UNIT[] gList = {UNIT.DASH,UNIT.DASH,UNIT.DOT};
      map.put("g", Arrays.asList(gList) );

      UNIT[] hList = {UNIT.DASH,UNIT.DASH,UNIT.DOT};
      map.put("h", Arrays.asList(hList) );

      UNIT[] iList = {UNIT.DOT,UNIT.DOT,UNIT.DOT,UNIT.DOT};
      map.put("i", Arrays.asList(iList) );

      UNIT[] jList = {UNIT.DOT,UNIT.DASH,UNIT.DASH,UNIT.DASH};
      map.put("j", Arrays.asList(jList) );

      UNIT[] kList = {UNIT.DASH,UNIT.DOT,UNIT.DASH};
      map.put("k", Arrays.asList(kList) );

      UNIT[] lList = {UNIT.DOT,UNIT.DASH,UNIT.DOT,UNIT.DOT};
      map.put("l", Arrays.asList(lList) );

      UNIT[] mList = {UNIT.DASH,UNIT.DASH};
      map.put("m", Arrays.asList(mList) );

      UNIT[] nList = {UNIT.DASH,UNIT.DOT,};
      map.put("n", Arrays.asList(nList) );

      UNIT[] oList = {UNIT.DASH,UNIT.DASH,UNIT.DASH};
      map.put("o", Arrays.asList(oList) );

      UNIT[] pList = {UNIT.DOT,UNIT.DASH,UNIT.DASH,UNIT.DOT};
      map.put("p", Arrays.asList(pList) );

      UNIT[] qList = {UNIT.DASH,UNIT.DASH,UNIT.DOT,UNIT.DASH};
      map.put("q", Arrays.asList(qList) );

      UNIT[] rList = {UNIT.DOT,UNIT.DASH,UNIT.DOT};
      map.put("r", Arrays.asList(rList) );

      UNIT[] sList = {UNIT.DOT,UNIT.DOT,UNIT.DOT};
      map.put("s", Arrays.asList(sList) );

      UNIT[] tList = {UNIT.DASH};
      map.put("t", Arrays.asList(tList) );

      UNIT[] uList = {UNIT.DOT,UNIT.DOT,UNIT.DASH,UNIT.DASH};
      map.put("u", Arrays.asList(uList) );

      UNIT[] vList = {UNIT.DOT,UNIT.DOT,UNIT.DOT,UNIT.DASH,UNIT.DASH};
      map.put("v", Arrays.asList(vList) );

      UNIT[] wList = {UNIT.DOT,UNIT.DASH,UNIT.DASH};
      map.put("w", Arrays.asList(wList) );

      UNIT[] xList = {UNIT.DASH,UNIT.DOT,UNIT.DOT,UNIT.DASH};
      map.put("x", Arrays.asList(xList) );

      UNIT[] yList = {UNIT.DASH,UNIT.DOT,UNIT.DASH,UNIT.DASH};
      map.put("y", Arrays.asList(yList) );

      UNIT[] zList = {UNIT.DASH,UNIT.DASH,UNIT.DOT,UNIT.DOT};
      map.put("z", Arrays.asList(zList) );

      UNIT[] oneList = {UNIT.DOT,UNIT.DASH,UNIT.DASH,UNIT.DASH,UNIT.DASH};
      map.put("1", Arrays.asList(oneList) );

      UNIT[] twoList = {UNIT.DOT,UNIT.DOT,UNIT.DASH,UNIT.DASH,UNIT.DASH};
      map.put("2", Arrays.asList(twoList) );

      UNIT[] threeList = {UNIT.DOT,UNIT.DOT,UNIT.DOT,UNIT.DASH,UNIT.DASH};
      map.put("3", Arrays.asList(threeList) );

      UNIT[] fourList = {UNIT.DOT,UNIT.DOT,UNIT.DOT,UNIT.DOT,UNIT.DASH};
      map.put("4", Arrays.asList(fourList) );

      UNIT[] fiveList = {UNIT.DOT,UNIT.DOT,UNIT.DOT,UNIT.DOT,UNIT.DOT};
      map.put("5", Arrays.asList(fiveList) );

      UNIT[] sixList = {UNIT.DASH,UNIT.DOT,UNIT.DOT,UNIT.DOT,UNIT.DOT};
      map.put("6", Arrays.asList(sixList) );

      UNIT[] sevenList = {UNIT.DASH,UNIT.DASH,UNIT.DOT,UNIT.DOT,UNIT.DOT};
      map.put("7", Arrays.asList(sevenList) );

      UNIT[] eightList = {UNIT.DASH,UNIT.DASH,UNIT.DASH,UNIT.DOT,UNIT.DOT};
      map.put("8", Arrays.asList(eightList) );

      UNIT[] nineList = {UNIT.DASH,UNIT.DASH,UNIT.DASH,UNIT.DASH,UNIT.DOT};
      map.put("9", Arrays.asList(nineList) );

      UNIT[] zeroList = {UNIT.DASH,UNIT.DASH,UNIT.DASH,UNIT.DASH,UNIT.DASH};
      map.put("0", Arrays.asList(zeroList) );
   }
}
