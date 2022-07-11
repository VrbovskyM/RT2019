package com.company.Listeners;

import com.company.components.Config;
import com.company.components.Label;

import java.awt.event.ActionEvent;

public class MyButtoonListener extends Adapter {
    private final Config config;
    private final Label label;
    public MyButtoonListener(Config config, Label label) {
        this.config = config;
        this.label = label;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()) {
            case "Plus":
                label.setText("Plus");
                config.setPlus(true);
                config.setLine(false);
                config.setChangeColor(false);
                config.setCircle(false);
                break;
            case "Line":
                label.setText("Line");
                config.setPlus(false);
                config.setLine(true);
                config.setChangeColor(false);
                config.setCircle(false);
                break;
            case "ChangeColor":
                label.setText("Change Color");
                config.setPlus(false);
                config.setLine(false);
                config.setChangeColor(true);
                config.setCircle(false);
                break;
            case "Circle":
                label.setText("Circle");
                config.setCircle(true);
                config.setPlus(false);
                config.setLine(false);
                config.setChangeColor(false);
        }
    }
}
