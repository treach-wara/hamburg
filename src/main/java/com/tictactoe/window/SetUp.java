package com.tictactoe.window;

import javax.swing.*;
import java.awt.*;

public class SetUp {
    JFrame frame;
    JPanel contentPanel;
    GroupLayout layout;
    JButton confirmButton1;
    JButton confirmButton2;
    JButton startGameButton;
    JTextField userTextField1;
    JTextField userTextField2;
    JLabel player1;
    JLabel player2;
    public SetUp(){
        contentPanel = new JPanel();
        contentPanel.setPreferredSize(new Dimension(400,200));

        setHeading();
        createLabels();

        createButtons();
        createTextFields();

        // add GroupLayout
        createGroupLayout();
        contentPanel.setLayout(layout);
    }

    public void initialize(){
        frame = new JFrame("Setup");
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.getContentPane().add(this.contentPanel);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    private JLabel setHeading(){
        JLabel heading = new JLabel("Set up your configuration", SwingConstants.CENTER);
        heading.setFont(new Font("Monospace", Font.BOLD, 40));
        return heading;
    }
    private void createLabels(){
        player1 = new JLabel("Player 1");
        player2 = new JLabel("Player 2");

    }

    private void createButtons(){
        confirmButton1 = new JButton("confirm");
        confirmButton2 = new JButton("confirm");
        startGameButton = new JButton("Start Game");
    }

    private void createTextFields(){
        userTextField1 = new JTextField();
        userTextField2 = new JTextField();
    }

    private void createGroupLayout(){
        layout = new GroupLayout(this.contentPanel);
        // creates automatic gap insertion
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

    private void linkSizeElements(){
        layout.linkSize(SwingConstants.HORIZONTAL, player1, userTextField1, confirmButton1);
        layout.linkSize(SwingConstants.VERTICAL, player1, userTextField1, confirmButton1);
        layout.linkSize(SwingConstants.HORIZONTAL, player2, userTextField2, confirmButton2);
        layout.linkSize(SwingConstants.VERTICAL, player2, userTextField2, confirmButton2);
    }
}
