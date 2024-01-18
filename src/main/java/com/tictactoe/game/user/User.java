package com.tictactoe.game.user;

import lombok.Getter;
import lombok.Setter;

public class User {

    @Getter
    @Setter
    private String name;

    public User(String username){
        this.name = username;
    }
}
