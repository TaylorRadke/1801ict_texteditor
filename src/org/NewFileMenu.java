package org;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class NewFileMenu extends JMenuItem implements ActionListener {
    private Editor editor;
    public NewFileMenu(Editor a){
        super("New");
        editor = a;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
