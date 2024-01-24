package com.tictactoe.game.listeners;

import com.tictactoe.game.StartButtonHelper;
import com.tictactoe.game.exceptions.TooLongException;
import com.tictactoe.game.exceptions.TooShortException;
import com.tictactoe.game.validations.JTextFieldValidator;
import lombok.Getter;
import lombok.Setter;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

public class UserTextFieldListener implements DocumentListener {

    private final JTextFieldValidator validator = new JTextFieldValidator();
    private final JTextField textField;
    private final JLabel label;

    @Setter
    private StartButtonHelper startButtonHelper;

    @Getter
    private boolean valid = false;

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
            valid = true;
            startButtonHelper.tryEnableStartButton(this);
        } catch (IllegalStateException | TooLongException | TooShortException e) {
            setLabelText(e.getMessage());
            startButtonHelper.disableStartButton();
            valid = false;
        }
    }

    private void setLabelText(String message) {
        label.setText(message);
    }
}
