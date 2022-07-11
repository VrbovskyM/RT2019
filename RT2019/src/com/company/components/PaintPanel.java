package com.company.components;

import com.company.Listeners.MyMouseListener;
import com.company.Objects.Circles;
import com.company.Objects.Line;
import com.company.Objects.Plus;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class PaintPanel extends JPanel {
    private final ArrayList<Circles> circles;
    private final ArrayList<Plus> pluses;
    private final ArrayList<Line> lines;
    public PaintPanel(Config config) {
        circles = new ArrayList<>();
        pluses = new ArrayList<>();
        lines = new ArrayList<>();
        MyMouseListener mouseListener = new MyMouseListener(this, config, pluses, lines, circles);
        addMouseMotionListener(mouseListener);
        addMouseListener(mouseListener);
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        for (Plus plus : pluses) {
            plus.drawPlus(g);
        }
        for (Line line : lines) {
            line.drawLine(g);
        }
        for (Circles circle : circles) {
            circle.drawCircle(g);
        }
    }
}
