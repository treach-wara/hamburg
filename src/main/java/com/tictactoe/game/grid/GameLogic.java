package com.tictactoe.game.grid;

import com.tictactoe.game.Symbol;

import javax.swing.*;

public class GameLogic {

    private final JButton[][] buttons;

    public GameLogic(JButton[][] buttons) {
        this.buttons = buttons;
    }

    /**
     * Calculates the winner of a finished tictactoe game
     * @return Symbol.U if no one won, otherwise Symbol.X / Symbol.O
     */
    public Symbol calculateWinner() {
        Symbol rowWinner = calculateRows();
        Symbol columnWinner = calculateColumns();
        if(rowWinner != Symbol.U) {
            return rowWinner;
        }
        return columnWinner;
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
}
