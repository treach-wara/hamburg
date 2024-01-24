package com.tictactoe.game.user;

import com.tictactoe.game.grid.Symbol;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class User {

    private String name;
    private Symbol symbol;
    private boolean next = false;

    public User(String username, Symbol symbol){
        this.name = username;
        this.symbol = symbol;
    }

    public String getSymbolName() {
        return this.symbol.name();
    }
}
