package com.jbrown;

public class RomanCounter {
    private int numeralValue;
    private String userInput;

    RomanCounter(){
        numeralValue = 1;
        userInput = " ";
    }
//--------------------------------------
    public void runRomanCounter(String userInput){
        try {
            setUserInput(userInput);
            countNumeralValues();
        }
        catch(Exception e){

        }
    }
//--------------------------------------
    private void setNumeralValue(int numeralValue){
        this.numeralValue = numeralValue;
    }
//--------------------------------------
    private void setUserInput(String userInput){
        this.userInput = userInput;
    }
//-----------------------------------------------------
    private void countNumeralValues(){
        char[] myNumerals = userInput.toUpperCase().toCharArray();

        //check the length if greater than 1
        //if greater check second numeral
        //repeat for next numeral or set
        //get value
        //return value if not greater than Max Integer value

    }
}
