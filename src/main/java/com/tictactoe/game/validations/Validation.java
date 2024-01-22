package com.tictactoe.game.validations;

public class Validation {

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
