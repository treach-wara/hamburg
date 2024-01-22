package com.tictactoe.game.validations;

import com.tictactoe.game.exceptions.TooLongException;
import com.tictactoe.game.exceptions.TooShortException;

public class Validation {

    public static void isNotBlank(String input) throws IllegalStateException{
        if(input.isBlank()){
            throw new IllegalStateException("Bitte setze einen Username.");
        }
    }

    public static void isInRange(String input) throws TooLongException, TooShortException {
        if(input.length() > 15){
            throw new TooLongException("Bitte einen kürzeren Username wählen.");
        }
        if(input.length() < 2){
            throw new TooShortException("Bitte längeren Namen wählen");
        }
    }

}
