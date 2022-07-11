package com.company.components;

import javax.swing.*;

public class Label extends JLabel {

    public Label(String label, Config config) {
        super(label);
        setOpaque(true);
        setFocusable(false);
        setBackground(config.getColors().get(0));
    }
}
