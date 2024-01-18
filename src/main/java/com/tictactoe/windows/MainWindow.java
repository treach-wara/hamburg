package com.tictactoe.windows;

import com.tictactoe.views.GameView;
import com.tictactoe.views.SetupView;

import javax.swing.JPanel;
import javax.swing.JFrame;
import javax.swing.WindowConstants;

public class MainWindow {

    private final JPanel gamePanel = new GameView().getGridPanel();
    private final SetupView setupView = new SetupView(this);
    private final JPanel setupPanel = setupView.getContentPanel();
    private JFrame window;

    public void initialize() {
        window = new JFrame("Setup");
        window.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setAndCenterPanel(setupPanel);
        window.setVisible(true);
    }

    public void changeToGamePanel() {
        setupPanel.setVisible(false);
        setAndCenterPanel(gamePanel);
        gamePanel.setVisible(true);
    }

    private void setAndCenterPanel(JPanel panelType) {
        window.getContentPane().add(panelType);
        window.pack();
        System.out.println("windows packed");
        window.setLocationRelativeTo(null);
    }
}
