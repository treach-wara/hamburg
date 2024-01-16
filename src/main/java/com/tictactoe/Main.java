package com.tictactoe;

import com.tictactoe.window.SetUp;

import javax.swing.*;
import java.awt.*;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable(){
            @Override
            public void run(){
                SetUp frame = new SetUp();
                frame.initialize();
            }
        });
    }
}