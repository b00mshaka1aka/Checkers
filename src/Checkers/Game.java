package Checkers;

import Checkers.enums.ColorChecker;
import Checkers.enums.SideChecker;

import javax.swing.*;
import java.util.Arrays;
import java.util.Collections;

public class Game {
    private final JFrame parent;
    private final Board board = new Board();
    private final Checker[] whiteCheckers = new Checker[12];
    private final Checker[] blackCheckers = new Checker[12];
    private Checker[] checkers;

    Game(JFrame parent) {
        this.parent = parent;
        parent.add(board);

        initCheckers(whiteCheckers, SideChecker.TOP, ColorChecker.WHITE);
        initCheckers(blackCheckers, SideChecker.BOTTOM, ColorChecker.BLACK);

        checkers = Arrays.copyOf(blackCheckers, 24);
        System.arraycopy(whiteCheckers, 0, checkers, blackCheckers.length, whiteCheckers.length);

        board.addCheckers(checkers);
    }

    private void initCheckers(Checker[] checkers, SideChecker sideChecker, ColorChecker colorChecker) {
        int k = 0;

        if(sideChecker == SideChecker.TOP)
            for(int i = 1; i <= 8; i++)
                for(int j = 1; j <= 3; j++)
                    if(board.isBlack(i, j)) {
                        checkers[k] = new Checker(board, colorChecker, sideChecker, i, j);
                        k++;
                    }

        k = 0;
        if(sideChecker == SideChecker.BOTTOM) {
            for(int i = 8; i >= 1; i--)
                for(int j = 8; j >= 6; j--)
                    if(board.isBlack(i, j)) {
                        checkers[k] = new Checker(board, colorChecker, sideChecker, i, j);
                        k++;
                    }
        }
    }
}
