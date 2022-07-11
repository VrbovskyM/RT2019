package com.company.Objects;

import lombok.Data;

import java.awt.*;
@Data
public class Plus {
    private int x1, y1, width1, height1;
    private int x2, y2, width2, height2;
    private Color c;
    private int x, y;
    private final int startX, startY;
    public Plus(int x, int y, Color c) {
        this.x = x;
        this.y = y;
        this.startX = x;
        this.startY = y;
        this.c = c;
    }
    public void drawPlus(Graphics g) {
        g.setColor(c);
        g.fillRect(x1, y1, width1, height1);
        g.fillRect(x2, y2, width2, height2);
    }
    public void setDimensions(int dx, int dy) {
        width1 = Math.abs(dx - startX);
        height1 = Math.abs((dy - startY) / 3);
        width2 = Math.abs((dx - startX) / 3);
        height2 = Math.abs(dy - startY);
        x1 = x;
        y1 = y + height2 / 3;
        x2 = x + (width1 / 3);
        y2 = y;
    }
    public boolean clickedObject(int x, int y) {
        Rectangle r = new Rectangle(x1, y1, width1, height1);
        Rectangle r2 = new Rectangle(x2, y2, width2, height2);
        return r.contains(x, y) || r2.contains(x, y);
    }
}
