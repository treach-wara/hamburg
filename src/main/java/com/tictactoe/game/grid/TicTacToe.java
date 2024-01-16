package com.tictactoe.game.grid;

import lombok.Getter;

import javax.swing.*;

public class TicTacToe {

    @Getter
    private JFrame window;
    private GroupLayout layout;
    private JPanel panel = new JPanel();

    private final Grid grid = new Grid();
    private GameLogic gameLogic;

    private final static String title = "Tic Tac Toe";
    private final static int width = 1280;
    private final static int height = 720;

    public TicTacToe() {
        window = new JFrame(title);
    }

    public void start() {
        configure();
        setGrid();
        window.setVisible(true);
    }

    private void configure() {
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setSize(width, height);
        window.setLocationRelativeTo(null);
    }

    private void setGrid() {
        layout = new GroupLayout(panel);
        panel.setLayout(layout);

        layout.setVerticalGroup(layout.createSequentialGroup()
                .addComponent(grid.getGrid()));
    }
}
