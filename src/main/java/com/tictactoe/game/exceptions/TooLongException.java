package com.tictactoe.game.exceptions;

public class TooLongException extends RuntimeException {

    public TooLongException(String message){
        super(message);
    }
}
