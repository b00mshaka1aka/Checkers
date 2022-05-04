package Checkers;

import javax.swing.*;
import java.awt.*;

public class Checkers extends JFrame {
    Checkers() {
        super();
        setSettings();

        DrawBoard board = new DrawBoard();
        getContentPane().add(board);
    }

    void setSettings() {
        EventQueue.invokeLater(() -> {
            setTitle("Checkers");
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            setSize(500, 500);
        });
    }

    void start() {
        setVisible(true);
    }
}
