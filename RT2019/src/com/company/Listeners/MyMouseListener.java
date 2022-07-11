package com.company.Listeners;

import com.company.Objects.Circles;
import com.company.Objects.Line;
import com.company.Objects.Plus;
import com.company.components.Config;
import com.company.components.PaintPanel;

import java.awt.event.MouseEvent;
import java.util.ArrayList;

public class MyMouseListener extends Adapter {
    private final ArrayList<Plus> pluses;
    private final ArrayList<Line> lines;
    private final ArrayList<Circles> circles;
    private final Config config;
    private final PaintPanel panel;
    private Plus curPlus;
    private Line curLine;
    private Circles curCircle;
    public MyMouseListener(PaintPanel panel, Config config, ArrayList<Plus> pluses, ArrayList<Line> lines, ArrayList<Circles> circles) {
        this.pluses = pluses;
        this.lines = lines;
        this.config = config;
        this.panel = panel;
        this.circles = circles;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if (config.isChangeColor()) {
            for (Plus plus : pluses) {
                if (plus.clickedObject(e.getX(), e.getY())) {
                    plus.setC(config.getCurrentColor());
                }
            }
            for (Line line : lines) {
                if (line.clickedLine(e.getX(), e.getY())) {
                    line.setC(config.getCurrentColor());
                }
            }
        }
        panel.repaint();
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        if (config.isChangeColor()) return;
        if (curPlus != null) {
            dragPlus(e.getX(), e.getY());
        }
        else if (curLine != null) {
            dragLine(e.getX(), e.getY());
        }
        else if (curCircle != null) {
            dragCircle(e.getX(), e.getY());
        }
        panel.repaint();
    }
    private void dragCircle(int dx, int dy) {
        int startX = curCircle.getStartX();
        int startY = curCircle.getStartY();
        if (dx > startX && dy > startY) {
            curCircle.setX(startX);
            curCircle.setY(startY);
            curCircle.setDimensions(dx, dy);

        }
        if (dx > startX && dy < startY) {
            curCircle.setX(startX);
            curCircle.setY(dy);
            curCircle.setDimensions(dx, dy);
        }
        if (dx < startX && dy > startY) {
            curCircle.setX(dx);
            curCircle.setY(startY);
            curCircle.setDimensions(dx, dy);
        }
        if (dx < startX && dy < startY) {
            curCircle.setX(dx);
            curCircle.setY(dy);
            curCircle.setDimensions(dx, dy);
        }
    }

    private void dragLine(int dx, int dy) {
        curLine.setX2(dx);
        curLine.setY2(dy);
    }
    private void dragPlus(int dx, int dy) {
        int startX = curPlus.getStartX();
        int startY = curPlus.getStartY();
        if (dx > curPlus.getStartX() && dy > curPlus.getStartY()) {
            curPlus.setX(startX);
            curPlus.setY(startY);
            curPlus.setDimensions(dx, dy);
        }

        if (dx > curPlus.getStartX() && dy < curPlus.getStartY()) {
            curPlus.setX(startX);
            curPlus.setY(dy);
            curPlus.setDimensions(dx, dy);
        }

        if (dx < curPlus.getStartX() && dy > curPlus.getStartY()) {
            curPlus.setX(dx);
            curPlus.setY(startY);
            curPlus.setDimensions(dx, dy);
        }

        if (dx < curPlus.getStartX() && dy < curPlus.getStartY()) {
            curPlus.setX(dx);
            curPlus.setY(dy);
            curPlus.setDimensions(dx, dy);
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {
        if (config.isPlus()) {
            pluses.add(new Plus(e.getX(), e.getY(), config.getCurrentColor()));
            curPlus = pluses.get(pluses.size() - 1);
            curLine = null;
            curCircle = null;
        }
        else if (config.isLine()) {
            lines.add(new Line(e.getX(), e.getY(), config.getCurrentColor()));
            curLine = lines.get(lines.size() - 1);
            curPlus = null;
            curCircle = null;
        }
        else if (config.isCircle()) {
            circles.add(new Circles(e.getX(), e.getY(), config.getCurrentColor()));
            curCircle = circles.get(circles.size() - 1);
            System.out.println(curCircle.getC());
            curPlus = null;
            curLine = null;
        }
        panel.repaint();
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        panel.repaint();
    }
}
