package com.jbrown;

import java.util.Scanner;

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
            displayNumeralValues();
            return wanaQuit = continueRoman();
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
    private boolean countNumeralValues(){
        char[] myNumerals = userInput.toUpperCase().toCharArray();
        //check the length if greater than 1

        try {
                checkIfSingleRoman(myNumerals);
        }
        catch(IllegalArgumentException e){
            countNumeralValues();
        }

        return true;
    }

    private void checkIfSingleRoman(char[] myNumerals){
        if(myNumerals.length <= 1){
            setNumeralValue(getRomanNumeralValue(myNumerals[0]));
        }
        else{
            checkRomanLaw(myNumerals);
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
    private void checkRomanLaw(char[] myNumerals) throws IllegalArgumentException{
        char temp = ' ';
        for(int i = 1; i < myNumerals.length; i++){
            temp = myNumerals[i-1];

            if(myNumerals[i] == temp){
                if((i+2) < myNumerals.length && myNumerals[i+2] == temp)
                    throw new IllegalArgumentException("Entry incorrect");
            }

        }

        checkRomanValue(myNumerals);
    }
//-------------------------------------------------------------
    private void checkRomanValue(char[] myNumerals){
        int first = 0;
        int second = 0;

        for(int i = 1; i < myNumerals.length; i++){
            if(myNumerals[i-1] != 'a') {
                second = getRomanNumeralValue(myNumerals[i]);
                first = getRomanNumeralValue(myNumerals[i - 1]);

                compareRomans(first, second);

                setCounted(myNumerals, i, (i - 1));

            }
            else{
                setNumeralValue((getNumeralValue() + getRomanNumeralValue(myNumerals[i])));
            }
        }
    }
//-------------------------------------------------------------
    private void compareRomans(int first, int second){
        if (first >= second) {
            setNumeralValue((getNumeralValue() + first + second));
        } else {
            setNumeralValue((getNumeralValue() + (second - first)));
        }
    }
//-------------------------------------------------------------
    private char[] setCounted(char[] myNumerals, int first, int second){
        myNumerals[first] = 'a';
        myNumerals[second] = 'a';

        return myNumerals;
    }
//--------------------------------------------------------------
    private boolean continueRoman(){
        Scanner uInput = new Scanner(System.in);
        char answer = ' ';

        System.out.print("Do you want to enter another one?(Y or N): ");
        answer = uInput.nextLine().charAt(0);
        if(answer == 'Y' || answer == 'y')
            return false;

        return true;

    }
//-------------------------------------------------------------
    public void displayNumeralValues(){
        System.out.println(getUserInput() + " :: " + getNumeralValue());
    }
//==============================================================
    public static void main(String[] args){
        RomanCounter myCounter = new RomanCounter();
        String test = "DCM";
        String test2 = "IV";
        String test3 = "XXXI";
        String test4 = "V";

        try {
            myCounter.runRomanCounter(test);

            myCounter.runRomanCounter(test2);

            myCounter.runRomanCounter(test3);
            System.out.println(myCounter.getUserInput() + " :: " + myCounter.getNumeralValue());
            myCounter.runRomanCounter(test4);
            System.out.println(myCounter.getUserInput() + " :: " + myCounter.getNumeralValue());
        }
        catch(Exception e){
            e.getCause();
        }
    }
}
