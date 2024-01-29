package com.tictactoe.game.grid;

import com.tictactoe.game.user.User;
import com.tictactoe.windows.ResultWindow;

import javax.swing.*;
import java.util.Random;

public class GameLogic {

    private final JButton[][] buttons;
    private final User user1;
    private final User user2;
    private int round = 1;

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

    public void determineWinner() {
        if (this.round >= 4) {
            Symbol winner = calculateWinner();
            if(winner != Symbol.U) {
                new ResultWindow(winner);
                disableButtons();
            }
            if(round == 9) {
                new ResultWindow(winner);
                disableButtons();
            }
        }
        round++;
        swap();
    }

    public Symbol calculateWinner() {
        Symbol rowSymbol = calculateRows();
        Symbol columnSymbol = calculateColumns();
        Symbol diagonalSymbol = calculateDiagonals();
        if (rowSymbol != Symbol.U) {
            return rowSymbol;
        } else if (columnSymbol != Symbol.U) {
            return columnSymbol;
        } else return diagonalSymbol;
    }

    private Symbol calculateRows() {
        for (int row = 0; row < 3; row++) {
            if (buttons[row][0].getText().equals(buttons[row][1].getText()) &&
                    buttons[row][1].getText().equals(buttons[row][2].getText())) {
                return Symbol.getFromButtonText(buttons[row][0]);
            }
        }
        return Symbol.U;
    }

    private Symbol calculateColumns() {
        for (int column = 0; column < 3; column++) {
            if (buttons[0][column].getText().equals(buttons[1][column].getText()) &&
                    buttons[1][column].getText().equals(buttons[2][column].getText())) {
                return Symbol.getFromButtonText(buttons[0][column]);
            }
        }
        return Symbol.U;
    }

    private Symbol calculateDiagonals() {
        if (buttons[0][2].getText().equals(buttons[1][1].getText()) &&
                buttons[1][1].getText().equals(buttons[2][0].getText())) {
            return Symbol.getFromButtonText(buttons[0][2]);
        }
        if (buttons[0][0].getText().equals(buttons[1][1].getText()) &&
                buttons[1][1].getText().equals(buttons[2][2].getText())) {

            return Symbol.getFromButtonText(buttons[0][0]);
        }
        return Symbol.U;
    }

    public void setButtonSymbol(JButton button) {
        if (user1.isNext()) {
            button.setText(user1.getSymbol().name());
        } else {
            button.setText(user2.getSymbol().name());
        }
        button.setEnabled(false);
    }

    private void swap() {
        user1.swap();
        user2.swap();
    }

    private void disableButtons() {
        for(int i = 0; i < 3; i++) {
            for(int j = 0; j < 3; j++) {
                buttons[i][j].setEnabled(false);
            }
        }
    }
}
