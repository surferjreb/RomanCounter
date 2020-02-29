package com.jbrown;

import java.util.Scanner;

public class RomanInput {
    private VerifyRoman vRoman;
    private String userInput;
    private Scanner input;

    RomanInput(VerifyRoman vRoman){
        this.vRoman = vRoman;
        userInput = " ";
        input = new Scanner(System.in);
    }
//------------------------------------------
    public void runInput(){
        getUserInput();
    }
//------------------------------------------
    private void getUserInput(){
        String temp = " ";
        try{
            System.out.print("Enter Roman Numerals: ");
            temp = input.nextLine();
            setUserInput(checkInput(temp.strip()));
        }
        catch(Exception e){
            e.printStackTrace();
            System.out.println("Error!...Please enter Roman Numerals...");
        }
    }
//------------------------------------------
    public void setUserInput(String uInput){
        this.userInput = uInput;
    }
//------------------------------------------
    public String getValidatedInput(){
        return userInput;
    }
//------------------------------------------
    private String checkInput(String uInput){
        if(vRoman.verifyInput(uInput)){
            return uInput;
        }

        throw new IllegalArgumentException();
    }
//============================================
    public static void main(String[] args){
        VerifyRoman myRoman = new VerifyRoman();
        RomanInput rInput = new RomanInput(myRoman);

        rInput.runInput();
        System.out.println("You entered: " + rInput.getValidatedInput());

    }
}
