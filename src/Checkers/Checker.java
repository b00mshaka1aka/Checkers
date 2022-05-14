package Checkers;

import Checkers.draw.DrawChecker;
import Checkers.enums.ColorChecker;
import Checkers.enums.ColorGradient;
import Checkers.enums.SideChecker;
import org.jetbrains.annotations.NotNull;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.Arrays;

public class Checker implements MouseListener, MouseMotionListener {
    private final DrawChecker checker;
    private final Board board;
    private final SideChecker sideChecker;
    private boolean isMoved = false, isLighted = false;
    private int x, y;
    private int a, b, radius;
    private int draggedX, draggedY;
    private boolean isTurns = false;

    Checker(@NotNull Board board, @NotNull ColorChecker color, @NotNull SideChecker sideChecker, int x, int y) {
        checker = new DrawChecker(color);

        this.board = board;
        this.sideChecker = sideChecker;
        this.x = x;
        this.y = y;

        checker.addMouseListener(this);
        checker.addMouseMotionListener(this);
        board.add(checker);
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    private void setPosition() {
        a = board.getDelta() + board.getStep() * (x - 1);
        b = board.getDelta() + board.getStep() * (y - 1);
        radius = board.getStep();

        setBounds();
    }

    private void setBounds() {
        checker.setBounds(a, b, radius, radius);
    }

    public void repaintChecker() {
        if(!isMoved)
            setPosition();
    }

    private int getCoordFromPosition(int position) {
        return (int) Math.floor((double) (position - board.getDelta()) / board.getStep()) + 1;
    }

    private void moveChecker(MouseEvent e) {
        a = e.getX() - draggedX + checker.getLocation().x;
        b = e.getY() - draggedY + checker.getLocation().y;

        setBounds();
    }

    private boolean isTryTurn(int x, int y) {
        int currentY = sideChecker == SideChecker.TOP ? this.y + 1 : this.y - 1;
        return ((this.x == x - 1) || (this.x == x + 1)) && (y == currentY)
                && !board.getCheckersPosition()[x - 1][y - 1];
    }

    private void lightFields(ColorGradient colorGradient) {
        int lightY = (sideChecker == SideChecker.TOP ? y + 1 : y - 1);
        int lightX = x - 1;

        if(board.isOnBoard(lightX, lightY)) {
            board.setColorGradientField(colorGradient, lightX, lightY);
        }

        if(board.isOnBoard(lightX + 2, lightY)) {
            board.setColorGradientField(colorGradient, lightX + 2, lightY);
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {
        isMoved = true;

        draggedX = e.getX();
        draggedY = e.getY();
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        if(isMoved)
            moveChecker(e);
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        if(isLighted) {
            lightFields(ColorGradient.BLACK);
            isLighted = false;
        }

        isMoved = false;

        int x = getCoordFromPosition(a + (radius / 2));
        int y = getCoordFromPosition(b + (radius / 2));

        if(board.isBlack(x, y) && board.isOnBoard(x, y) && isTryTurn(x, y)
                && !board.getCheckersPosition()[x - 1][y - 1]) {
            this.x = x;
            this.y = y;
        }

        setPosition();

        if(!isLighted) {
            lightFields(ColorGradient.ORANGE);
            isLighted = true;
        }
    }

    @Override
    public void mouseMoved(MouseEvent e) { }

    @Override
    public void mouseClicked(MouseEvent e) { }

    @Override
    public void mouseEntered(MouseEvent e) {
        isLighted = true;
        lightFields(ColorGradient.ORANGE);
    }

    @Override
    public void mouseExited(MouseEvent e) {
        isLighted = false;
        lightFields(ColorGradient.BLACK);
    }
}
