package com.company.Listeners;

import com.company.components.ComboBox;
import com.company.components.Config;
import com.company.components.Label;

import java.awt.*;
import java.awt.event.ItemEvent;
import java.lang.reflect.Field;

public class MyItemListener extends Adapter {
    private final Config config;
    private final Label label;
    public MyItemListener(Config config, Label label) {
        this.config = config;
        this.label = label;
    }

    @Override
    public void itemStateChanged(ItemEvent e) {
        ComboBox cb = (ComboBox) e.getSource();
        String selectedItem = (String) cb.getSelectedItem();
        try {
            Field f = Color.class.getField(selectedItem);
            Color color = (Color)f.get(null);
            config.setCurrentColor(color);
            label.setBackground(color);
        } catch (NoSuchFieldException | IllegalAccessException ex) {
            ex.printStackTrace();
        }
    }
}
