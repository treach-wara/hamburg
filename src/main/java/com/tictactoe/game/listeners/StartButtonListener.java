package com.tictactoe.game.listeners;

import com.tictactoe.game.grid.Symbol;
import com.tictactoe.game.user.User;
import com.tictactoe.views.GameView;
import com.tictactoe.views.SetupView;
import com.tictactoe.views.WindowUtility;
import com.tictactoe.windows.MainWindow;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class StartButtonListener implements ActionListener {

    private final MainWindow mainWindow;
    private final SetupView setupView;
    private GameView gameView;
    private final WindowUtility utility;

    public StartButtonListener(MainWindow mainWindow, SetupView setupView) {
        this.mainWindow = mainWindow;
        this.setupView = setupView;
        utility = new WindowUtility(mainWindow.getWindow());
    }

    public void changeToGamePanel() {
        setupView.getContentPanel().setVisible(false);
        mainWindow.getWindow().getContentPane().add(gameView.getPanel());
        utility.setAndCenterPanel(gameView.getPanel());
        gameView.getPanel().setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        gameView = new GameView(new User("1", Symbol.X), new User("2", Symbol.O));
        changeToGamePanel();
    }
}
