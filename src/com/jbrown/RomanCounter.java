package com.jbrown;

public class RomanCounter {
    private int numeralValue;
    private String userInput;
    private NumeralList myList;

    RomanCounter(){
        numeralValue = 0;
        userInput = " ";
        myList = NumeralList.getInstanceOf();
    }
//------------------------------------------------------------
    public boolean runRomanCounter(String userInput){
        boolean wanaQuit = false;
        setNumeralValue(0);
        try {
            setUserInput(userInput);
            countNumeralValues();
            return wanaQuit;
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return wanaQuit;
    }
//------------------------------------------------------------
    private void setNumeralValue(int numeralValue){
        this.numeralValue = numeralValue;
    }
//------------------------------------------------------------
    private int getNumeralValue() {
        return numeralValue;
    }
//------------------------------------------------------------
    private void setUserInput(String userInput){
        this.userInput = userInput;
    }
//------------------------------------------------------------
    public String getUserInput(){
        return userInput;
    }
//-------------------------------------------------------------
    private void countNumeralValues(){
        char[] myNumerals = userInput.toUpperCase().toCharArray();

        //check the length if greater than 1
        checkIfSingleRoman(myNumerals);


    }

    private void checkIfSingleRoman(char[] myNumerals){
        if(myNumerals.length <= 1){
            setNumeralValue(getRomanNumeralValue(myNumerals[0]));
        }
        else{
            checkRomanValue(myNumerals);
        }
    }
//-------------------------------------------------------------
    private int getRomanNumeralValue(char value){
        if(myList.getNumeralList().containsKey(value)){
            return myList.getNumeralList().get(value);
        }

        return -1;
    }
//-------------------------------------------------------------
    private void checkRomanValue(char[] myNumerals){
        int first = 0;
        int second = 0;

        for(int i = 1; i < myNumerals.length; i++){
            if(myNumerals[i-1] != 'a') {
                second = getRomanNumeralValue(myNumerals[i]);

                first = getRomanNumeralValue(myNumerals[i - 1]);

                if (first >= second) {
                    setNumeralValue((getNumeralValue() + first + second));
                } else if (first < second) {
                    setNumeralValue((getNumeralValue() + (second - first)));
                }

                myNumerals[i] = 'a';
                myNumerals[i-1] = 'a';
            }
            else{
                setNumeralValue((getNumeralValue() + getRomanNumeralValue(myNumerals[i])));
            }
        }
    }
//==============================================================
    public static void main(String[] args){
        RomanCounter myCounter = new RomanCounter();
        String test = "XXI";
        String test2 = "IV";
        String test3 = "XXVI";
        String test4 = "V";

        myCounter.runRomanCounter(test);
        System.out.println(myCounter.getUserInput() + " :: " + myCounter.getNumeralValue());
        myCounter.runRomanCounter(test2);
        System.out.println(myCounter.getUserInput() + " :: " + myCounter.getNumeralValue());
        myCounter.runRomanCounter(test3);
        System.out.println(myCounter.getUserInput() + " :: " + myCounter.getNumeralValue());
        myCounter.runRomanCounter(test4);
        System.out.println(myCounter.getUserInput() + " :: " + myCounter.getNumeralValue());
    }
}
