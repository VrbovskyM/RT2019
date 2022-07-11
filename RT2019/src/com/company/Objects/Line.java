package com.company.Objects;

import lombok.Data;

import java.awt.*;
import java.awt.geom.Line2D;

@Data
public class Line{
    private int x1, x2, y1, y2;
    private Color c;
    public Line(int x, int y, Color c) {
        x1 = x;
        y1 = y;
        x2 = x;
        y2 = y;
        this.c = c;
    }

    public void drawLine(Graphics g) {
        g.setColor(c);
        g.drawLine(x1, y1, x2, y2);
    }
    public boolean clickedLine(int x, int y) {
        Line2D l = new Line2D.Double(x1,y1,x2,y2);
        return l.contains(x, y);
    }
}
