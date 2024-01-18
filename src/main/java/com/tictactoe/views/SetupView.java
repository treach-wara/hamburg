package com.tictactoe.views;

import com.tictactoe.game.user.User;
import com.tictactoe.windows.MainWindow;
import lombok.Getter;

import javax.swing.JPanel;
import javax.swing.GroupLayout;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JButton;

import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

@Getter
public class SetupView {

    private final JPanel contentPanel = new JPanel();
    private GroupLayout layout;
    private JButton confirmButton1;
    private JButton confirmButton2;
    private JButton startGameButton;
    private JTextField userTextField1;
    private JTextField userTextField2;
    private JLabel player1;
    private JLabel player2;
    private User  user1;
    private User user2;
    private final MainWindow mainWindow;

    public SetupView(MainWindow mainWindow) {
        this.mainWindow = mainWindow;
        setHeading();
        createLabels();
        createButtons();
        createTextFields();
        createGroupLayout();
        contentPanel.setLayout(layout);
    }

    private void setHeading() {
        JLabel heading = new JLabel("Set up your configuration", SwingConstants.CENTER);
        heading.setFont(new Font("Monospace", Font.BOLD, 40));
    }

    private void createLabels() {
        player1 = new JLabel("Player 1");
        player2 = new JLabel("Player 2");
    }

    private void startGameButton() {
        if (user1 != null & user2 != null){
            startGameButton.setEnabled(true);
        }
    }

    private void createButtons() {
        confirmButton1 = new JButton("confirm");
        confirmButton2 = new JButton("confirm");
        startGameButton = new JButton("Start Game");
        startGameButton.setEnabled(false);

        confirmButton1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                user1 = new User(userTextField1.getText());
                System.out.println(user1.getName());
                startGameButton();
            }
        });

        confirmButton2.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                user2 = new User(userTextField2.getText());
                System.out.println(user2.getName());
                startGameButton();
            }
        });

        startGameButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                System.out.println(user1.getName() + " spielt gegen " + user2.getName());
                mainWindow.changeToGamePanel();
            }

        });
    }

    private void createTextFields() {
        userTextField1 = new JTextField();
        userTextField2 = new JTextField();
    }

    private void createGroupLayout() {
        layout = new GroupLayout(this.contentPanel);
        layout.setAutoCreateGaps(true);
        layout.setAutoCreateContainerGaps(true);

        layout.setHorizontalGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(player1)
                        .addComponent(player2)
                )
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(userTextField1)
                        .addComponent(userTextField2)
                        .addComponent(startGameButton)
                )
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(confirmButton1)
                        .addComponent(confirmButton2)
                )
        );
        linkSizeElements();
        layout.setVerticalGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(player1)
                        .addComponent(userTextField1)
                        .addComponent(confirmButton1)
                )
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(player2)
                        .addComponent(userTextField2)
                        .addComponent(confirmButton2)
                )
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.CENTER)
                        .addComponent(startGameButton)
                )
        );
    }

    private void linkSizeElements() {
        layout.linkSize(SwingConstants.HORIZONTAL, player1, userTextField1, confirmButton1);
        layout.linkSize(SwingConstants.VERTICAL, player1, userTextField1, confirmButton1);
        layout.linkSize(SwingConstants.HORIZONTAL, player2, userTextField2, confirmButton2);
        layout.linkSize(SwingConstants.VERTICAL, player2, userTextField2, confirmButton2);
    }
}
