package com.tictactoe.game.validations;

public interface Validator<TYPE> {

    public void validate(TYPE object);
}
