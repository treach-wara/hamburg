package com.tictactoe.game.grid;

import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ButtonMouseEventListener extends MouseAdapter {

    private final JButton button;

    public ButtonMouseEventListener(JButton button) {
        this.button = button;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        button.setText(Symbol.X.toString());
    }
}
