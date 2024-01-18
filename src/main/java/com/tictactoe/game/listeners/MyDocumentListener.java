package com.tictactoe.game.listeners;

import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.text.Document;

public class MyDocumentListener implements DocumentListener {
    @Override
    public void insertUpdate(DocumentEvent e) {

    }

    @Override
    public void removeUpdate(DocumentEvent e) {

    }

    @Override
    public void changedUpdate(DocumentEvent e) {

    }

    private void updateLog(DocumentEvent e, String action) {
        Document document = (Document)e.getDocument();

    }
}
