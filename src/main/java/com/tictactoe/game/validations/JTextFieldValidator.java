package com.tictactoe.game.validations;

import com.tictactoe.game.exceptions.TooLongException;
import com.tictactoe.game.exceptions.TooShortException;

public class JTextFieldValidator implements Validator<String> {

    @Override
    public void validate(String text) throws IllegalStateException, TooLongException, TooShortException {
        Validation.isNotBlank(text);
        Validation.isInRange(text);
    }
}
