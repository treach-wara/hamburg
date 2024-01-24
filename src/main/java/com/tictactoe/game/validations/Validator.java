package com.tictactoe.game.validations;

public interface Validator<TYPE> {

    void validate(TYPE object);
}
