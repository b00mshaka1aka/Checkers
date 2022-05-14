package Checkers;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class Checkers extends JFrame {
    Checkers() {
        super();
        setSettings();

        Game game = new Game(this);
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
