package com.tictactoe.windows;

import com.tictactoe.views.GameView;
import com.tictactoe.views.SetupView;

import javax.swing.*;

public class MainWindow {

    private JPanel gamePanel = new GameView().getGridPanel();
    private final SetupView setupView = new SetupView(this);
    private final JPanel setupPanel = setupView.getContentPanel();
    private JFrame window;
    public MainWindow(){
        JFrame window = new JFrame();

    }

    public void initialize(){
        window = new JFrame("Setup");
        window.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        setAndCenterPanel(setupPanel);

        window.setVisible(true);
    }

    public void changeToGamePanel(){
        setupPanel.setVisible(false);
        setAndCenterPanel(gamePanel);
        gamePanel.setVisible(true);

//        window.pack();
    }
    private void setAndCenterPanel(JPanel panelType){

        window.getContentPane().add(panelType);
        window.pack();
        window.setLocationRelativeTo(null);

    }
}
