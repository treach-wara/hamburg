package com.tictactoe.windows;

import com.tictactoe.views.SetupView;
import com.tictactoe.views.WindowUtility;
import lombok.Getter;

import javax.swing.JPanel;
import javax.swing.JFrame;
import javax.swing.WindowConstants;

public class MainWindow {

    private final SetupView setupView;
    private final JPanel setupPanel;

    @Getter
    private JFrame window = new JFrame("Tic Tac Toe");
    private final WindowUtility utility = new WindowUtility(window);

    public MainWindow() {
        setupView = new SetupView(this);
        setupPanel = setupView.getContentPanel();
    }

    public void initialize() {
        window.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        utility.setAndCenterPanel(setupPanel);
        window.setVisible(true);
    }
}
