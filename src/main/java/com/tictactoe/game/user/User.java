package com.tictactoe.game.user;


import lombok.Getter;
import lombok.Setter;

@Setter @Getter
public class User {

    private String name;

    public User(String username){
        this.name = username;
    }
}
