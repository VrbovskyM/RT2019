package com.company;

import com.company.components.Config;
import com.company.components.TopMenu;
import com.company.components.PaintPanel;

import javax.swing.*;
import java.awt.*;

public class Gui {
    public Gui() {
        JFrame f = new JFrame();
        Config config = new Config();
        new TopMenu(f, config);
        f.add("Center",new PaintPanel(config));
        f.setMinimumSize(new Dimension(700,700));
        f.setFocusable(false);
        f.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        f.setVisible(true);
        f.setLocationRelativeTo(null);


    }
}
