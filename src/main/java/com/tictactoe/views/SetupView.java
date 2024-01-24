package com.tictactoe.views;

import com.tictactoe.game.StartButtonHelper;
import com.tictactoe.game.listeners.StartButtonListener;
import com.tictactoe.game.listeners.UserTextFieldListener;
import com.tictactoe.game.user.User;
import com.tictactoe.game.validations.JTextFieldValidator;
import com.tictactoe.windows.MainWindow;
import lombok.Getter;

import javax.swing.*;
import java.awt.Font;

@Getter
public class SetupView {

    private final JPanel contentPanel = new JPanel();
    private final MainWindow mainWindow;
    private final JTextFieldValidator validator = new JTextFieldValidator();
    private GroupLayout layout;
    private JButton startGameButton;
    private JTextField userTextField1;
    private JTextField userTextField2;
    private JLabel player1;
    private JLabel player2;
    private JLabel setUpLabel;
    private JLabel warningLabel1;
    private JLabel warningLabel2;
    private UserTextFieldListener userTextFieldListener1;
    private UserTextFieldListener userTextFieldListener2;
    User user1;
    User user2;

    private static final int MAX_NAME_LENGTH = 12;
    private static final int MIN_NAME_LENGTH = 2;

    public SetupView(MainWindow mainWindow) {
        this.mainWindow = mainWindow;
        createLabels();
        createButtons();
        createTextFields();
        createGroupLayout();
        contentPanel.setLayout(layout);
    }

    private void createLabels() {
        player1 = new JLabel("Player 1");
        player2 = new JLabel("Player 2");
        setUpLabel = new JLabel();
        setUpLabel.setHorizontalAlignment(SwingConstants.CENTER);
        setUpLabel.setText("Bitte Charakternamen eingeben, maximal 12 Zeichen");

        warningLabel1 = new JLabel("Bitte Usernamen wählen.");
        warningLabel1.setFont(new Font("Ubuntu", Font.BOLD, 12));

        warningLabel2 = new JLabel("Bitte Usernamen wählen.");
        warningLabel2.setFont(new Font("Ubuntu", Font.BOLD, 12));
    }

    private void createButtons() {
        startGameButton = new JButton("Start Game");
        startGameButton.setEnabled(false);
        startGameButton.setHorizontalAlignment(SwingConstants.CENTER);
        startGameButton.addActionListener(new StartButtonListener(mainWindow, this));
    }

    private void createTextFields() {
        userTextField1 = new JTextField();
        userTextField2 = new JTextField();
        userTextFieldListener1 = new UserTextFieldListener(userTextField1, warningLabel1);
        userTextFieldListener2 = new UserTextFieldListener(userTextField2, warningLabel2);
        userTextField1.getDocument().addDocumentListener(userTextFieldListener1);
        userTextField2.getDocument().addDocumentListener(userTextFieldListener2);
        userTextFieldListener1.setStartButtonHelper(new StartButtonHelper(userTextFieldListener2, startGameButton));
        userTextFieldListener2.setStartButtonHelper(new StartButtonHelper(userTextFieldListener1, startGameButton));
    }

    private void createGroupLayout() {
        layout = new GroupLayout(this.contentPanel);
        layout.setAutoCreateGaps(true);
        layout.setAutoCreateContainerGaps(true);

        layout.setHorizontalGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.CENTER)
                        .addComponent(setUpLabel)
                        .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addComponent(player1)
                                        .addComponent(player2)

                                )
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addComponent(userTextField1)
                                        .addComponent(userTextField2)
                                        .addComponent(startGameButton)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.CENTER)
                                                        .addComponent(warningLabel1)
                                                )
                                        )
                                        .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.CENTER)
                                                        .addComponent(warningLabel2)
                                                )
                                        )

                                )
                        )
                )
        );
        linkSizeElements();
        layout.setVerticalGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(setUpLabel)
                )
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(player1)
                        .addComponent(userTextField1)
                )
                .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.CENTER)
                                .addComponent(warningLabel1)
                        )
                )
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(player2)
                        .addComponent(userTextField2)
                )
                .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.CENTER)
                                .addComponent(warningLabel2)
                        )
                )
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(startGameButton)
                )
        );
    }

    private void linkSizeElements() {
        layout.linkSize(SwingConstants.VERTICAL, player1, player2, userTextField1, userTextField2);
        layout.linkSize(SwingConstants.HORIZONTAL, player1, player2, userTextField1, userTextField2, startGameButton, warningLabel1, warningLabel2);
    }

    public void tryEnableStartButton() {
        if(userTextFieldListener1.isValid() && userTextFieldListener2.isValid()) {
            startGameButton.setEnabled(true);
        }
    }

    public void disableStartButton() {
        startGameButton.setEnabled(false);
    }
}
