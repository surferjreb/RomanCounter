package com.jbrown;

import java.util.IllegalFormatException;

public class VerifyRoman {
    private NumeralList myList;

    VerifyRoman(){
        myList = NumeralList.getInstanceOf();
    }
//-----------------------------------------------
    public boolean verifyInput(String uInput){
        try {
            if (checkIfString(uInput)) {
                verifyIsNumeral(uInput);
                return true;
            }

        }
        catch(Exception e){
            e.printStackTrace();
        }
        return false;
    }
//------------------------------------------------
//validate it is a string and of letters
    private boolean checkIfString(String uInput){

        if(uInput.matches("^[a-zA-Z]*$"))
            return true;

        return false;
    }
//------------------------------------------------
    private void verifyIsNumeral(String uInput){
        char[] numerals = uInput.toUpperCase().toCharArray();

        for (char value : numerals) {
            if(!checkNumeral(value))
                throw new IllegalArgumentException();
        }
    }
//-------------------------------------------------
    //validate they are roman numerals
    private boolean checkNumeral(char numeral){

        if(myList.getNumeralList().containsKey(numeral)){
            return true;
        }

        return false;
    }
}
