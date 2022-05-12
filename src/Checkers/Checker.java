package Checkers;

import org.jetbrains.annotations.NotNull;

public class Checker {
    private final DrawChecker checker;
    private final Board board;
    int x, y;

    Checker(@NotNull Board board, @NotNull ColorChecker color, int x, int y) {
        checker = new DrawChecker(color);

        this.board = board;
        this.x = x;
        this.y = y;

        board.add(checker);
    }

    public void setCoords(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void repaintChecker() {
        int a = board.getDelta() + board.getStep() * (x - 1);
        int b = board.getDelta() + board.getStep() * (y - 1);
        int radius = board.getStep();

        checker.setBounds(a, b, radius, radius);
    }
}
