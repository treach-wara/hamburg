package com.tictactoe.game.validations;

import javax.swing.JTextField;

public class JTextFieldValidator implements Validator<String> {

    @Override
    public void validate(String text) throws IllegalArgumentException, IllegalStateException {
        Validation.isNotNull(text);
        Validation.isInRange(text);
    }
}
