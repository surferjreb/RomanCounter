package com.jbrown;

public class RomanMenu {

    private final String instructions;

    RomanMenu(){
        instructions = "Enter a Roman Numeral(i.e. I, X, C, D) or several to get the value: ";
    }

    private void displayMenu(){
        System.out.println("**************************************************");
        System.out.println("**************************************************");
        System.out.println("**************************************************");
        System.out.println("\tWelcome to the Roman Numeral Interpreter!");
        System.out.println(instructions);
    }
//----------------------------------------------------------
    public void runMenu(){
        displayMenu();
    }


}
