package Checkers;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Line2D;
import java.awt.geom.Rectangle2D;


public class Board extends JPanel {
    Board() {

    }

    @Override
    public void paintComponent(Graphics graphics) {
        drawBoard(graphics, Math.min(this.getWidth(), this.getHeight()));
    }

    void drawBoard(Graphics graphics, int side) {
        Graphics2D graphics2D = (Graphics2D) graphics;
        int delta = 4 * side / 200;
        int sideRectangle = side - 2 * delta;

        Rectangle2D rectangle =  new Rectangle2D.Double(delta, delta, sideRectangle, sideRectangle);

        Line2D.Double[] lines = new Line2D.Double[7];

        for(int i = 0, position = delta; i < 7; i++) {
            lines[i] = new Line2D.Double(position, delta, position, side + delta);
            position = (sideRectangle / 8) * (i + 1);
            graphics2D.draw(lines[i]);
        }

        graphics2D.draw(rectangle);
    }
}
