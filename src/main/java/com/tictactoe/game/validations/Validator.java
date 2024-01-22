package com.tictactoe.game.validations;

import com.tictactoe.game.user.User;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public interface Validator<TYPE> {

    public void validate(TYPE object);



}
