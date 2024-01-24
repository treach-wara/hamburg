package com.tictactoe.game.listeners;

import com.tictactoe.game.exceptions.TooLongException;
import com.tictactoe.game.exceptions.TooShortException;
import com.tictactoe.game.user.User;
import com.tictactoe.game.validations.JTextFieldValidator;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

public class UserTextFieldListener implements DocumentListener {

    private final JTextFieldValidator validator = new JTextFieldValidator();
    JTextField textField;
    JLabel label;
    private int counter = 0;

    public UserTextFieldListener(JTextField textField, JLabel label) {
        this.textField = textField;
        this.label = label;
    }

    @Override
    public void insertUpdate(DocumentEvent e) {
        updateWarningLabel();
    }

    @Override
    public void removeUpdate(DocumentEvent e) {
        updateWarningLabel();
    }

    @Override
    public void changedUpdate(DocumentEvent e) {
        updateWarningLabel();
    }

    private void updateWarningLabel() {
        try {
            validator.validate(textField.getText());
            setLabelText("");


        } catch (IllegalStateException | TooLongException | TooShortException e) {
            setLabelText(e.getMessage());

        }
    }

    private void activateStartbutton(boolean valid){
        if(counter == 2){

        }

    }
    private void setLabelText(String message) {
        label.setText(message);
    }
}
