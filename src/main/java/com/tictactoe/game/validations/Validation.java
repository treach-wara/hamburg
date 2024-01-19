package com.tictactoe.game.validations;

import javax.naming.LimitExceededException;

public class Validation {

    public Validation(){

    }

    // Methods for validation
    public static void isNotNull(String input) throws IllegalStateException{
        if(input.isBlank()){
            throw new IllegalStateException("Bitte setze einen Username.");
        }
    }

    public static void isInRange(String input) throws IllegalArgumentException {
        if(input.length() > 15){
            throw new IllegalArgumentException("Bitte einen kürzeren Username wählen.");
        }
        if(input.length() < 2){
            throw new IllegalArgumentException("Bitte einen längeren Username wählen.");
        }
    }

}
