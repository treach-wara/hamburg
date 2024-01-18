package com.tictactoe.views;

import com.tictactoe.game.listeners.GridButtonListener;
import com.tictactoe.game.grid.GameLogic;
import lombok.Getter;

import javax.swing.plaf.basic.BasicBorders;
import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Color;
import java.awt.Font;


public class GameView {

    private static final int ROW = 3;
    private static final int COLUMN = 3;
    private static final int FONT_SIZE = 100;
    private static final int BUTTON_SIZE = 100;
    private static final int WIDTH = 1000;
    private static final int HEIGHT = 1000;

    @Getter
    private final JPanel panel = new JPanel(new GridLayout(ROW, COLUMN));
    // todo: we don't actually need this, we can just get the child elements from the grid panel
    @Getter
    private final JButton[][] buttons = new JButton[ROW][COLUMN];


    public GameView() {
        create();
        GridButtonListener.GAME_LOGIC = new GameLogic(buttons);
    }

    public void create() {
        panel.setPreferredSize(new Dimension(WIDTH, HEIGHT));
        addButtons();
    }

    private void addButtons() {
        for (int i = 0; i < ROW; i++) {
            for (int j = 0; j < COLUMN; j++) {
                buttons[i][j] = new JButton();
                setDefaultButtonProperties(buttons[i][j]);
                buttons[i][j].addActionListener(new GridButtonListener(buttons[i][j]));
                panel.add(buttons[i][j]);
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
