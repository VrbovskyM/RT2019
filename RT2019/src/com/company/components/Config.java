package com.company.components;

import lombok.Data;

import java.awt.*;
import java.util.ArrayList;
@Data
public class Config {
    private ArrayList<Color> colors;
    private boolean plus;
    private boolean line;
    private boolean changeColor;
    private boolean circle;

    private Color currentColor;
    public Config() {
        colors = new ArrayList<>();
        createColors();
        currentColor = colors.get(0);
        plus = true;
    }
    private void createColors() {
        colors.add(Color.RED);
        colors.add(Color.ORANGE);
        colors.add(Color.CYAN);
    }
}
