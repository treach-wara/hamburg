package com.tictactoe.game.exceptions;

public class TooShortException extends RuntimeException {

    public TooShortException(String message) {
        super(message);
    }
}
