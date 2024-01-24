package com.tictactoe.windows;

import com.tictactoe.game.grid.Symbol;
import com.tictactoe.views.WindowUtility;

import javax.swing.*;

public class ResultWindow {

    private final JFrame window = new JFrame();
    private final JPanel panel = new JPanel();
    private final JLabel label = new JLabel();
    private final Symbol result;
    private final WindowUtility utility = new WindowUtility(window);

    public ResultWindow(Symbol result) {
        this.window.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.result = result;
        this.setText();
        this.window.getContentPane().add(label);
        this.utility.setAndCenterPanel(panel);
        this.window.setVisible(true);
    }

    public void setText() {
        switch(result) {
            case X -> this.label.setText("Spieler 1 / X hat gewonnen");
            case O -> this.label.setText("Spieler 2 / O hat gewonnen");
            case U -> this.label.setText("Unentschieden");
        }
    }
}
