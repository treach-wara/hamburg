package com.tictactoe.game.listeners;

import com.tictactoe.views.GameView;
import com.tictactoe.views.SetupView;
import com.tictactoe.views.WindowUtility;
import com.tictactoe.windows.MainWindow;

import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class StartButtonListener extends MouseAdapter {

    private final MainWindow mainWindow;
    private final SetupView setupView;
    private final GameView gameView;
    private final WindowUtility utility;

    public StartButtonListener(MainWindow mainWindow, SetupView setupView, GameView gameView) {
        this.mainWindow = mainWindow;
        this.setupView = setupView;
        this.gameView = gameView;
        utility = new WindowUtility(mainWindow.getWindow());
    }

    public void changeToGamePanel() {
        setupView.getPanel().setVisible(false);
        mainWindow.getWindow().getContentPane().add(gameView.getPanel());
        utility.setAndCenterPanel(gameView.getPanel());
        gameView.getPanel().setVisible(true);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        changeToGamePanel();
    }
}
