package Checkers.draw;

import Checkers.enums.ColorGradient;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Line2D;
import java.awt.geom.Rectangle2D;

public class DrawBoard extends JComponent {
    private final DrawFields drawFields = new DrawFields();
    private Graphics2D graphics2D = null;
    private int delta, side, sideRectangle, step;
    private boolean isOne = true;

    @Override
    public void paintComponent(Graphics graphics) {
        this.side = Math.min(this.getWidth(), this.getHeight());
        this.delta = 4 * side / 100;
        this.sideRectangle = side - 2 * delta;
        this.step = sideRectangle / 8;
        this.graphics2D = (Graphics2D) graphics;

        drawFields.recalculateDrawFields(delta, step);
        drawFields.fillFields(graphics2D);

        if(isOne) {
            drawFields.setBlackFields();
            isOne = false;
        }

        drawBoard();
    }

    public int getDelta() {
        return delta;
    }

    public int getStep() {
        return step;
    }

    private void drawBoard() {
        drawRectangle();
        drawVerticalLines();
        drawHorizontalLines();
        drawLetters();
        drawNumbers();
    }

    private void drawRectangle() {
        graphics2D.setColor(Color.BLACK);
        graphics2D.setPaint(null);
        Rectangle2D rectangle =  new Rectangle2D.Double(delta, delta, sideRectangle, sideRectangle);
        graphics2D.draw(rectangle);
    }

    private void drawVerticalLines() {
        Line2D.Double[] lines = new Line2D.Double[7];

        for(int i = 0, position = delta + step; i < lines.length; i++) {
            lines[i] = new Line2D.Double(position, delta, position, side - delta);
            position = delta + step * (i + 2);
            graphics2D.draw(lines[i]);
        }
    }

    private void drawHorizontalLines() {
        Line2D.Double[] lines = new Line2D.Double[7];

        for(int i = 0, position = delta + step; i < lines.length; i++) {
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

    public void setColorGradientField(ColorGradient colorGradient, int x, int y) {
        drawFields.setColorGradientField(colorGradient, x - 1, y - 1);
        repaint();
    }
}
