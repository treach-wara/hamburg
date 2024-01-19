package com.tictactoe.views;


import com.tictactoe.game.grid.GameLogic;
import com.tictactoe.game.user.User;
import lombok.Getter;

import javax.swing.plaf.basic.BasicBorders;
import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


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
    private final GameLogic gameLogic;

    private final User user1;
    private final User user2;


    public GameView(User user1, User user2) {
        create();
        this.user1 = user1;
        this.user2 = user2;
        gameLogic = new GameLogic(buttons, user1, user2);
    }

    public void create() {
        panel.setPreferredSize(new Dimension(WIDTH, HEIGHT));
        addButtons();
    }

    private void addButtons() {
        for (int i = 0; i < ROW; i++) {
            for (int j = 0; j < COLUMN; j++) {
                buttons[i][j] = new JButton();
                setButtonProperties(buttons[i][j]);
                setButtonListener(buttons[i][j]);
                panel.add(buttons[i][j]);
            }
        }
    }

    private void setButtonProperties(JButton button) {
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

    private void setButtonListener(JButton button) {
        button.addActionListener(event -> gameLogic.start(button));
    }
}
