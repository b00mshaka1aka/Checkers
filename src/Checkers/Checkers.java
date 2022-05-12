package Checkers;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.util.Scanner;

public class Checkers extends JFrame {
    private Board board;

    Checkers() throws IOException {
        super();
        setSettings();

        board = new Board();
        add(board);
    }

    public void test() {
        Scanner in = new Scanner(System.in);
        while(true) {
            int x = in.nextInt();
            int y = in.nextInt();
            board.setCheckerOnBoard(x, y);
        }
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
