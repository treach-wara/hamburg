package com.tictactoe.game.listeners;

import com.tictactoe.game.grid.GameLogic;
import com.tictactoe.game.grid.Symbol;

import javax.swing.JButton;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GridButtonListener implements ActionListener {

    private final JButton button;
    public static GameLogic GAME_LOGIC;
    private static Symbol nextSymbol = Symbol.X;
    private boolean clicked = false;

    public GridButtonListener(JButton button) {
        this.button = button;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (!clicked) {
            setSymbol();
            swapSymbol();
            calculateWinner();
            clicked = true;
        }

    }

    private void calculateWinner() {
        Symbol winner = GAME_LOGIC.calculateWinner();
        switch (winner) {
            case X -> System.out.println("X hat gewonnen!");
            case O -> System.out.println("O hat gewonnen!");
            case U -> System.out.println("Niemand hat gewonnen");
        }
    }


    private void setSymbol() {
        if (nextSymbol.equals((Symbol.X))) {
            button.setText(Symbol.X.toString());
        } else {
            button.setText(Symbol.O.toString());
        }
    }

    private void swapSymbol() {
        if (nextSymbol.equals(Symbol.X)) {
            nextSymbol = Symbol.O;
        } else {
            nextSymbol = Symbol.X;
        }
    }
}
