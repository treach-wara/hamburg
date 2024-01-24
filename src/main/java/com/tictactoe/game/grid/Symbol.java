package com.tictactoe.game.grid;

import javax.swing.*;

public enum Symbol {

    X,
    O,
    U;

    public static Symbol getFromButtonText(JButton button) {
        switch(button.getText()) {
            case "X":
                return X;
            case "O":
                return O;
            default:
                return U;
        }
    }
}
