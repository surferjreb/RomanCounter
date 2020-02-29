package com.jbrown;

import java.util.HashMap;
import java.util.Map;

public class NumeralList {
    //private final char[] nums = {'I', 'V', 'X', 'L', 'C', 'D', 'M'};
    private HashMap<Character , Integer> numerals;
    private static NumeralList numeralList = new NumeralList();

    private NumeralList(){
        numerals = new HashMap<>(7);
        createNumeralList(numerals);
    }

    public static NumeralList getInstanceOf(){

        return numeralList;
    }
//----------------------------------------------------------
    private void createNumeralList(HashMap<Character, Integer> numerals){
        if(numeralList == null) {
            numerals.put('I', 1);
            numerals.put('V', 5);
            numerals.put('X', 10);
            numerals.put('L', 50);
            numerals.put('C', 100);
            numerals.put('D', 500);
            numerals.put('M', 1000);
        }
    }
//----------------------------------------------------------
    public HashMap<Character, Integer> getNumeralList(){
        return numerals;
    }
//----------------------------------------------------------
    public int getNumeralValue(char myChar){
        try{
            if(numerals.containsKey(myChar))
                return numerals.get(myChar);
        }
        catch(Exception e){
            e.printStackTrace();
        }

        return -1;
    }
//-----------------------------------------------------------
    public boolean checkListExists(){

        if(!numerals.isEmpty()){
            return true;
        }

        return false;
    }
//-----------------------------------------------------------

//============================================================
    public static void main(String[] args){
        NumeralList myList = NumeralList.getInstanceOf();
        Map<Character, Integer> myMap;
        try{
            if(!myList.getNumeralList().isEmpty()){
                myMap = myList.getNumeralList();

                if(myList.checkListExists()) {
                    for (Map.Entry<Character, Integer> value : myMap.entrySet()) {
                        System.out.println(value.getKey() + " :: " + value.getValue());
                    }
                }
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }

    }
}
