package com.tictactoe.game.grid;

import com.tictactoe.game.user.User;

import javax.swing.JButton;
import java.util.Random;

public class GameLogic {

    private final JButton[][] buttons;
    private final User user1;
    private final User user2;

    public GameLogic(JButton[][] buttons, User user1, User user2) {
        this.buttons = buttons;
        this.user1 = user1;
        this.user2 = user2;
        setStartingUser();
    }

    public void setStartingUser() {
        if (new Random().nextBoolean()) {
            user1.setNext(true);
        } else {
            user2.setNext(true);
        }
    }

    public void start(JButton button) {
        setSymbol(button);
        swapTurn();
        determineWinner();
    }

    /**
     * Calculates the winner of a finished tictactoe game
     * @return Symbol.U if no one won, otherwise Symbol.X / Symbol.O
     */
    public Symbol calculateWinner() {
        Symbol rowWinner = calculateRows();
        Symbol columnWinner = calculateColumns();
        Symbol diagonalWinner = calculateDiagonals();

        if (rowWinner != Symbol.U) {
            return rowWinner;
        }
        if (columnWinner != Symbol.U) {
            return rowWinner;
        }

        if (diagonalWinner != Symbol.U) {
            return rowWinner;
        }
        return Symbol.U;
    }

    private Symbol calculateRows() {
        for (int row = 0; row < 3; row++) {
            if (buttons[row][0].getText().equals("X") &&
                    buttons[row][1].getText().equals("X") &&
                    buttons[row][2].getText().equals("X")) {
                return Symbol.X;
            }
            if (buttons[row][0].getText().equals("O") &&
                    buttons[row][1].getText().equals("O") &&
                    buttons[row][2].getText().equals("O")) {
                return Symbol.O;
            }
        }
        return Symbol.U;
    }

    private Symbol calculateColumns() {
        for (int column = 0; column < 3; column++) {
            if (buttons[0][column].getText().equals("X") &&
                    buttons[1][column].getText().equals("X") &&
                    buttons[2][column].getText().equals("X")) {
                return Symbol.X;
            }
            if (buttons[0][column].getText().equals("O") &&
                    buttons[1][column].getText().equals("O") &&
                    buttons[2][column].getText().equals("O")) {
                return Symbol.O;
            }
        }
        return Symbol.U;
    }

    private void determineWinner() {
        Symbol winner = calculateWinner();
        switch (winner) {
            case X -> System.out.println("X hat gewonnen!");
            case O -> System.out.println("O hat gewonnen!");
            case U -> System.out.println("Niemand hat gewonnen");
        }
    }

    private void setSymbol(JButton button) {
        if(user1.isNext()) {
            button.setText(user1.getSymbol().name());
        } else {
            button.setText(user2.getSymbol().name());
        }
        button.setEnabled(false);
    }

    private void swapTurn() {
        if (user1.isNext()) {
            user1.setNext(false);
            user2.setNext(true);
        } else {
            user1.setNext(true);
            user2.setNext(false);
        }
    }

    private Symbol calculateDiagonals() {
        if (buttons[0][2].getText().equals("X") &&
                buttons[1][1].getText().equals("X") &&
                buttons[2][0].getText().equals("X")) {
            return Symbol.X;
        }
        if (buttons[0][0].getText().equals("X") &&
                buttons[1][1].getText().equals("X") &&
                buttons[2][2].getText().equals("X")) {
            return Symbol.X;
        }
        return Symbol.U;
    }

}
