package com.company.Objects;

import lombok.Data;

import java.awt.*;
@Data
public class Circles {
    private int x, y, startX, startY;
    private int x1, x2, y1, y2;
    private int circleWidth, circleHeight;
    private int circleWidth2, circleHeight2;
    private Color c;
    public Circles(int x, int y, Color c) {
        this.x = x;
        this.y = y;
        this.startX = x;
        this.startY = y;
        this.c = c;
    }
    public void drawCircle(Graphics g) {
        g.setColor(c);
        g.fillOval(x1,y1,circleWidth, circleHeight);
        g.setColor(Color.WHITE);
        g.fillOval(x2,y2,circleWidth2,circleHeight2);
    }
    public void setDimensions(int dx, int dy) {
        circleWidth = Math.abs(dx - startX);
        circleHeight = Math.abs((dy - startY));
        circleWidth2 = circleWidth / 3;
        circleHeight2 = circleHeight / 3;
        x1 = x;
        y1 = y;
        x2 = x + (circleWidth / 3);
        y2 = y + (circleHeight / 3);

    }
}
