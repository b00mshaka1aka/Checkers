package Checkers.draw;

import Checkers.enums.ColorChecker;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Ellipse2D;

public class DrawChecker extends JComponent {
    private Graphics2D graphics2D = null;
    private final ColorChecker colorChecker;

    public DrawChecker(ColorChecker colorChecker) {
        this.colorChecker = colorChecker;
    }

    @Override
    public void paintComponent(Graphics graphics) {
        this.graphics2D = (Graphics2D) graphics;
        drawChecker();
    }

    private void drawChecker() {
        int delta = 5;
        int lineThickness = getWidth() / 4;
        int radius = (2 * getWidth()) / 3 + lineThickness / 2 - (2 * delta);

        int x = (lineThickness / 2) + delta;
        int y = (lineThickness / 2) + delta;

        Ellipse2D.Double circle = new Ellipse2D.Double(x, y, radius, radius);
        BasicStroke basicStroke = new BasicStroke(lineThickness, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND);

        graphics2D.setColor(colorChecker == ColorChecker.BLACK ? Color.WHITE : Color.BLACK);
        graphics2D.setStroke(basicStroke);
        graphics2D.draw(circle);
        graphics2D.setColor(colorChecker == ColorChecker.BLACK ? Color.BLACK : Color.WHITE);
        graphics2D.fillOval(x, y, radius, radius);
    }
}
