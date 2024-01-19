package com.tictactoe.views;

import com.tictactoe.game.user.User;
import com.tictactoe.windows.MainWindow;
import lombok.Getter;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

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

    private JLabel header;
    private JLabel player1;
    private JLabel player2;
    private JLabel setUpLabel;
    private JLabel warningLabel1;
    private JLabel warningLabel2;

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
        header = new JLabel("Set up your configuration", SwingConstants.CENTER);
        header.setFont(new Font("Monospace", Font.BOLD, 40));
    }

    private void createLabels() {
        player1 = new JLabel("Player 1");
        player2 = new JLabel("Player 2");
        setUpLabel = new JLabel();
        setUpLabel.setHorizontalAlignment(SwingConstants.CENTER);
        setUpLabel.setText("Bitte Charakternamen eingeben, maximal 10 Zeichen");

        warningLabel1 = new JLabel("Bitte Usernamen wählen.");
        warningLabel1.setHorizontalAlignment(SwingConstants.CENTER);
        warningLabel2 = new JLabel("Bitte Usernamen wählen.");
        warningLabel2.setHorizontalAlignment(SwingConstants.CENTER);
      //  warningLabel2 = new JLabel("Testo");
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
        startGameButton.setHorizontalAlignment(SwingConstants.CENTER);

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

        setTextMessage(userTextField1);
        setTextMessage(userTextField2);
    }

    private void setTextMessage (JTextField textField) {
        if (userTextField1.getText().isBlank()) {
            userTextField1.setToolTipText("Bitte Usernamen wählen. Maximal 10 Zeichen");
        }
        textField.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                warn();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                warn();

            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                warn();

            }
        });
    }

    private void warn(){
        if (userTextField1.getText().isEmpty()){
            warningLabel1.setText(userTextField1.getText());

        }
        if (userTextField1.getText().length() < 2) {
            String toolTipText = userTextField1.getToolTipText();
            warningLabel1.setText(toolTipText);
            System.out.println("text zu kurz");



        }
        if (userTextField1.getText().length() > 10) {
            JOptionPane.showMessageDialog(null, "Bitte weniger als 10 Zeichen eingeben",
                    "Error Message", JOptionPane.ERROR_MESSAGE);
        }

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
                   // .addComponent(setUpLabel)
                    .addComponent(userTextField2)
                    .addComponent(startGameButton)
                    .addComponent(warningLabel1)
                    .addComponent(warningLabel2)
            )
            .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addComponent(confirmButton1)
                    .addComponent(confirmButton2)
            )))
        );
        linkSizeElements();
        layout.setVerticalGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(setUpLabel)
                )
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(player1)
                        .addComponent(userTextField1)
                        .addComponent(confirmButton1)
                )
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(warningLabel1)
                )
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(player2)
                        .addComponent(userTextField2)
                        .addComponent(confirmButton2)
                )
                .addComponent(warningLabel2)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(startGameButton)
                )
        );
    }

    private void linkSizeElements() {
        layout.linkSize(SwingConstants.HORIZONTAL, player1, userTextField1, confirmButton1);
        layout.linkSize(SwingConstants.VERTICAL, player1, userTextField1, confirmButton1);
        layout.linkSize(SwingConstants.HORIZONTAL, userTextField2, confirmButton2);
        layout.linkSize(SwingConstants.VERTICAL, player2, userTextField2, confirmButton2);
        layout.linkSize(SwingConstants.HORIZONTAL, userTextField2, userTextField1, startGameButton);
    }
}
