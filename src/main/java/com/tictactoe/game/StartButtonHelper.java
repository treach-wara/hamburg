package com.tictactoe.game;


import com.tictactoe.game.listeners.UserTextFieldListener;
import lombok.Getter;

import javax.swing.*;

@Getter
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