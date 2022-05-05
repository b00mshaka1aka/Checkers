package Checkers;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;
import java.awt.geom.QuadCurve2D;
import java.security.spec.EllipticCurve;

public class DrawChecker extends JLabel {
    private Graphics2D graphics2D = null;
    private int x, y, radius;
    private TypeChecker typeChecker;

    DrawChecker(int x, int y, int radius, TypeChecker typeChecker) {
        this.x = x;
        this.y = y;
        this.radius = radius;
        this.typeChecker = typeChecker;
    }

    @Override
    public void paintComponent(Graphics graphics) {
        this.graphics2D = (Graphics2D) graphics;
        drawChecker();
    }

    private void drawChecker() {
        Ellipse2D.Double circle = new Ellipse2D.Double(x, y, radius, radius);
        BasicStroke basicStroke = new BasicStroke(radius / 4, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND);

        graphics2D.setColor(typeChecker == TypeChecker.BLACK ? Color.WHITE : Color.BLACK);
        graphics2D.setStroke(basicStroke);
        graphics2D.draw(circle);
        graphics2D.setColor(typeChecker == TypeChecker.BLACK ? Color.BLACK : Color.WHITE);
        graphics2D.fillOval(x, y, radius, radius);
    }
}
