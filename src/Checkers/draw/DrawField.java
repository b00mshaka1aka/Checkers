package Checkers.draw;

import Checkers.enums.ColorGradient;
import java.awt.*;

public class DrawField {
    private int x, y, side;
    private ColorGradient colorGradient;

    DrawField(int x, int y, int side, ColorGradient colorGradient) {
        this.colorGradient = colorGradient;
        this.x = x;
        this.y = y;
        this.side = side;
    }

    public void setColorGradient(ColorGradient colorGradient) {
        this.colorGradient = colorGradient;
    }

    public void recalculateField(int x, int y, int side) {
        this.x = x;
        this.y = y;
        this.side = side;
    }

    public void fillField(Graphics2D graphics2D) {
        if(colorGradient != null) {
            GradientPaint paint = getGradient();
            if(graphics2D.getPaint() != paint)
                graphics2D.setPaint(paint);
            graphics2D.fillRect(x, y, side, side);
        }
    }

    public GradientPaint getGradient() {
        return new GradientPaint(x, y, colorGradient == ColorGradient.BLACK ? Color.BLACK : Color.ORANGE,
                x + side, y + side, Color.WHITE);
    }
}
