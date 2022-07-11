package com.company.components;

import com.company.Listeners.MyItemListener;

import javax.swing.*;

public class ComboBox extends JComboBox<String> {

    public ComboBox(MyItemListener itemListener) {
        super(new String[] {"RED", "ORANGE", "CYAN"});
        setFocusable(false);
        addItemListener(itemListener);

    }
}
