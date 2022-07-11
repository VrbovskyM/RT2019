package com.company.components;

import com.company.Listeners.MyButtoonListener;

import javax.swing.*;

public class MyButton extends JButton {

    public MyButton(String label, MyButtoonListener buttonListener) {
        super(label);
        setFocusable(false);
        addActionListener(buttonListener);

    }
}
