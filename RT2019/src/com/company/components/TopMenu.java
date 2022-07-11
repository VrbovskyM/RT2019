package com.company.components;

import com.company.Listeners.MyButtoonListener;
import com.company.Listeners.MyItemListener;

import javax.swing.*;
import java.awt.*;

public class TopMenu{
    public TopMenu(JFrame f, Config config) {
        JPanel topMenu = new JPanel();
        JPanel botMenu = new JPanel();
        topMenu.setLayout(new GridLayout());
        botMenu.setLayout(new GridLayout());
        f.add("North", topMenu);
        f.add("South", botMenu);

        Label label = new Label("Plus", config);
        MyButtoonListener buttoonListener = new MyButtoonListener(config, label);
        MyButton plus = new MyButton("Plus", buttoonListener);
        MyButton line = new MyButton("Line", buttoonListener);
        MyButton circle = new MyButton("Circle", buttoonListener);
        MyButton changeColor = new MyButton("ChangeColor", buttoonListener);
        MyItemListener myItemListener = new MyItemListener(config, label);
        ComboBox comboBox = new ComboBox(myItemListener);

        topMenu.add(plus);
        topMenu.add(line);
        topMenu.add(circle);
        topMenu.add(changeColor);

        botMenu.add(comboBox);
        botMenu.add(label);
    }
}
