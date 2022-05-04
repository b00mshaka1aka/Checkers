package Checkers;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Line2D;
import java.awt.geom.Rectangle2D;

public class DrawBoard extends JPanel {
    int delta, side, sideRectangle, step;
    Graphics2D graphics2D = null;
    Graphics graphics = null;

    @Override
    public void paintComponent(Graphics graphics) {
        this.side = Math.min(this.getWidth(), this.getHeight());
        this.delta = 4 * side / 100;
        this.sideRectangle = side - 2 * delta;
        this.step = sideRectangle / 8;
        this.graphics = graphics;
        this.graphics2D = (Graphics2D) graphics;

        drawBoard();
    }

    private void drawBoard() {
        drawRectangle();
        drawVerticalLines();
        drawHorizontalLines();
        drawLetters();
        drawNumbers();
        fillBlackField();
    }

    private void drawRectangle() {
        Rectangle2D rectangle =  new Rectangle2D.Double(delta, delta, sideRectangle, sideRectangle);
        graphics2D.draw(rectangle);
    }

    private void drawVerticalLines() {
        Line2D.Double[] lines = new Line2D.Double[7];

        for(int i = 0, position = delta + step; i < 7; i++) {
            lines[i] = new Line2D.Double(position, delta, position, side - delta);
            position = delta + step * (i + 2);
            graphics2D.draw(lines[i]);
        }
    }

    private void drawHorizontalLines() {
        Line2D.Double[] lines = new Line2D.Double[7];

        for(int i = 0, position = delta + step; i < 7; i++) {
            lines[i] = new Line2D.Double(delta, position, side - delta, position);
            position = delta + step * (i + 2);
            graphics2D.draw(lines[i]);
        }
    }

    private void drawLetters() {
        int lettersStep = delta + step / 2;

        for(char c = 'a'; c <= 'h'; c++) {
            graphics2D.drawString(String.valueOf(c), delta / 4, lettersStep);
            lettersStep += step;
        }
    }

    private void drawNumbers() {
        int numbersStep = delta + step / 2;

        for(int i = 0; i < 8; i++) {
            graphics2D.drawString(String.valueOf(i), numbersStep, delta / 2);
            numbersStep += step;
        }
    }

    private void fillBlackField() {
        for(int i = 0; i < 8; i++)
            for(int j = 0; j < 8; j++)
                if((i + j) % 2 == 1)
                     fillField(delta + step * i, delta + step * j, step);
    }

    private void fillField(int x, int y, int side) {
        graphics2D.setColor(Color.BLACK);
        graphics2D.fillRect(x, y, side, side);
    }

}
