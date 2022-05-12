package Checkers;

import javax.swing.*;
import java.awt.*;

public class Board extends JPanel {
    private final DrawBoard board = new DrawBoard();
    private final Checker checker;

    Board() {
        board.setBounds(0, 0, this.getWidth(), this.getHeight());
        checker = new Checker(this, ColorChecker.WHITE, 1, 1);

        add(board);
    }

    @Override
    public void paintComponent(Graphics graphics) {
        board.setBounds(0, 0, this.getWidth(), this.getHeight());
        checker.repaintChecker();
    }

    public int getDelta() {
        return board.getDelta();
    }

    public int getStep() {
        return board.getStep();
    }

    public void setCheckerOnBoard(int a, int b) {
        checker.setCoords(a, b);
        repaint();
    }
}
