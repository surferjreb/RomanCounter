package com.jbrown;

public class Controller{
    private RomanInput rInput;
    private NumeralList numerals;
    private RomanCounter myRoman;
    private VerifyRoman myVerify;
    private RomanMenu rMenu;
    private String userInput;
    private boolean romanQuit;

    Controller(){
        myRoman = new RomanCounter();
        myVerify = new VerifyRoman();
        rInput = new RomanInput(myVerify);
        rMenu = new RomanMenu();
        userInput = " ";
        romanQuit = false;
    }

    public void runController(){

        try{
            //display initial menu
            rMenu.runMenu();
            while(!romanQuit) {
                //display menu
                //get user input
                //verify input - display an error message if not correct
                //run input through roman counter
                //output echo of input and numerical meaning
                rInput.runInput();
                userInput = rInput.getValidatedInput();
                romanQuit = myRoman.runRomanCounter(userInput);

                //will start taking input from user, verify that they
                // are roman numerals and in the correct order.
                // Interpret the numerical value of the statement
                // Ask whether to input another value or quit..
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }

    }


}
