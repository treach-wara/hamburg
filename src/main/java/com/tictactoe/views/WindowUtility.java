package com.tictactoe.views;

import javax.swing.*;

public class WindowUtility {

    private final JFrame window;

    public WindowUtility(JFrame window) {
        this.window = window;
    }

    public void setAndCenterPanel(JPanel panel) {
        window.getContentPane().add(panel);
        window.pack();
        window.setLocationRelativeTo(null);
    }
}
