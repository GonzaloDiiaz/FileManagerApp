package org.example.filemanagerapp;

import org.example.filemanagerapp.ui.FileManagerUI;
import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new FileManagerUI().setVisible(true);
            }
        });
    }
}