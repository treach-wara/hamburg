package com.tictactoe.game.grid;

import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ButtonMouseEventListener extends MouseAdapter {

    private JButton button;

    public ButtonMouseEventListener(JButton button) {
        this.button = button;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        button.setText(Symbol.X.toString());
    }
}
