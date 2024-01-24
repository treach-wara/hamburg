package com.tictactoe.game.grid;

import com.tictactoe.game.exceptions.NoWinnerException;
import com.tictactoe.game.user.User;
import lombok.Getter;

import javax.swing.*;
import java.util.Random;

public class GameLogic {

    private final JButton[][] buttons;
    private final User user1;
    private final User user2;

    @Getter
    private int round = 0;

    @Getter
    private Symbol winner = Symbol.U;

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
        if (this.round >= 5) {
            try {
                winner = calculateWinner();
            } catch (NoWinnerException e) {
                nextRound();
            }
        }
    }

    public void nextRound() {
        swap();
        round++;
    }

    public Symbol calculateWinner() throws NoWinnerException {
        Symbol rowSymbol = calculateRows();
        Symbol columnSymbol = calculateColumns();
        Symbol diagonalSymbol = calculateDiagonals();
        if (rowSymbol != Symbol.U) {
            return rowSymbol;
        } else if (columnSymbol != Symbol.U) {
            return columnSymbol;
        } else if (diagonalSymbol != Symbol.U) {
            return diagonalSymbol;
        } else {
            throw new NoWinnerException();
        }
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
        if (buttons[0][2].getText().equals("X") &&
                buttons[1][1].getText().equals("X") &&
                buttons[2][0].getText().equals("X")) {
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
}
