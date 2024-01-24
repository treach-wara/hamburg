package com.tictactoe.game.grid;

import javax.swing.*;

public enum Symbol {

    X,
    O,
    U;

    public static Symbol getFromButtonText(JButton button) {
        return switch (button.getText()) {
            case "X" -> X;
            case "O" -> O;
            default -> U;
        };
    }
}
