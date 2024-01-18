package com.tictactoe.game.listeners;

import com.tictactoe.windows.MainWindow;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class StartButtonMouseListener extends MouseAdapter {

    MainWindow mainWindow;

    public StartButtonMouseListener(MainWindow mainWindow) {
        this.mainWindow = mainWindow;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        mainWindow.changeToGamePanel();
    }
}
