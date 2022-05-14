package Checkers.draw;

import Checkers.enums.ColorGradient;

import java.awt.*;

public class DrawFields {
    private final DrawField[][] drawFields = new DrawField[8][8];

    DrawFields() {
        for(int i = 0; i < drawFields.length; i++)
            for(int j = 0; j < drawFields[0].length; j++)
                drawFields[i][j] = new DrawField(0, 0, 0, null);
    }

    public void recalculateDrawFields(int delta, int step) {
        for(int i = 0; i < drawFields.length; i++)
            for(int j = 0; j < drawFields[0].length; j++) {
                int x = delta + step * i;
                int y = delta + step * j;

                drawFields[i][j].recalculateField(x, y, step);
            }
    }

    public void fillFields(Graphics2D graphics2D) {
        for (DrawField[] drawField : drawFields)
            for (DrawField field : drawField)
                field.fillField(graphics2D);
    }

    public void setBlackFields() {
        for(int i = 0; i < drawFields.length; i++)
            for(int j = 0; j < drawFields[0].length; j++)
                if((i + j) % 2 == 1)
                    drawFields[i][j].setColorGradient(ColorGradient.BLACK);
    }

    public void setColorGradientField(ColorGradient colorGradient, int x, int y) {
        drawFields[x][y].setColorGradient(colorGradient);
    }
}
