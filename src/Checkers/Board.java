package Checkers;

import Checkers.draw.DrawBoard;
import Checkers.enums.ColorChecker;
import Checkers.enums.ColorGradient;
import Checkers.enums.SideChecker;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import javax.swing.*;
import java.awt.*;

public class Board extends JPanel {
    private final DrawBoard board = new DrawBoard();
    private boolean isAddedCheckers = false;
    private final LinkedList<Checker> checkers = new LinkedList<>();
    private final boolean[][] checkersPosition = new boolean[8][8];

    Board() {
        board.setBounds(0, 0, this.getWidth(), this.getHeight());

        for (boolean[] booleans : checkersPosition)
            Arrays.fill(booleans, false);
    }

    public void addCheckers(Checker[] checkers) {
        Collections.addAll(this.checkers, checkers);
        isAddedCheckers = true;
        repaint();
    }

    public boolean[][] getCheckersPosition() {
        return checkersPosition;
    }

    public int getDelta() {
        return board.getDelta();
    }

    public int getStep() {
        return board.getStep();
    }

    public boolean isBlack(int x, int y) {
        return ((x % 2 == 0) && (y % 2 == 1)) || ((x % 2 == 1) && (y % 2 == 0));
    }

    public boolean isOnBoard(int x, int y) {
        return (x >= 1) && (x <= 8) && (y >= 1) && (y <= 8);
    }

    public void setColorGradientField(ColorGradient colorGradient, int x, int y) {
        board.setColorGradientField(colorGradient, x, y);
    }

    @Override
    public void paintComponent(Graphics graphics) {
        if(isAddedCheckers) {
            add(board);
            isAddedCheckers = false;
        }

        board.setBounds(0, 0, this.getWidth(), this.getHeight());

        repaintCheckers();
    }

    void repaintCheckers() {
        boolean[][] temp = new boolean[8][8];

        for(Checker checker : checkers) {
            checker.repaintChecker();

            temp[checker.getX() - 1][checker.getY() - 1] = true;
        }

        for(int i = 0; i < temp.length; i++)
            System.arraycopy(temp[i], 0, checkersPosition[i], 0, temp[i].length);
    }
}
