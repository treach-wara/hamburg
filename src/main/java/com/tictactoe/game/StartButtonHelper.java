package com.tictactoe.game;


import com.tictactoe.game.listeners.UserTextFieldListener;

import javax.swing.*;

public record StartButtonHelper(UserTextFieldListener listener, JButton button) {

    public void tryEnableStartButton(UserTextFieldListener listener) {
        if (listener.isValid() && this.listener.isValid()) {
            button.setEnabled(true);
        }
    }

    public void disableStartButton() {
        button.setEnabled(false);
    }
}
