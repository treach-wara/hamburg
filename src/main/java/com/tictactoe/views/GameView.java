package com.tictactoe.views;

import com.tictactoe.game.grid.ButtonMouseEventListener;
import com.tictactoe.game.grid.Symbol;
import lombok.Getter;

import javax.swing.*;
import javax.swing.plaf.basic.BasicBorders;
import java.awt.*;

public class GameView {
    @Getter
    private JPanel gridPanel;
    @Getter
    // we don't actually need this, we can just get the child elements from the grid panel
    private final JButton[][] buttons = new JButton[ROW][COLUMN];
    private Symbol symbol;

    /* constants */
    private static final int ROW = 3;
    private static final int COLUMN = 3;
    private static final int FONT_SIZE = 100;
    private static final int BUTTON_SIZE = 100;

    public GameView() {
        gridPanel = new JPanel(new GridLayout(ROW, COLUMN));
        gridPanel.setPreferredSize(new Dimension(1000, 1000));
        create();
    }

    public void create() {
        addButtons();
    }

    private void addButtons() {
        for (int i = 0; i < ROW; i++) {
            for (int j = 0; j < COLUMN; j++) {
                buttons[i][j] = new JButton();
                setDefaultButtonProperties(buttons[i][j]);
                buttons[i][j].addMouseListener(new ButtonMouseEventListener(buttons[i][j]));
                gridPanel.add(buttons[i][j]);
            }
        }
    }

    private void setDefaultButtonProperties(JButton button) {
        button.setText("");
        button.setFont(new Font("Ubuntu", Font.BOLD, FONT_SIZE));
        button.setPreferredSize(new Dimension(BUTTON_SIZE, BUTTON_SIZE));
        button.setBackground(Color.WHITE);
        button.setBorder(
                new BasicBorders.ButtonBorder(
                        Color.BLACK,
                        Color.BLACK,
                        Color.BLACK,
                        Color.BLACK)
        );
    }
}
