package org;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FontSizeMenu extends JMenuItem implements ActionListener {
    private Editor editor;
    private Object[] sizes = new Object[73];

    public FontSizeMenu(Editor a){
        super("Size");
        this.editor = a;
        for (int i = 1; i < 73; i++){
            sizes[i-1] = i;
        }
        super.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        int fontSize = (int)JOptionPane.showInputDialog(
                null,
                "Select a font size",
                "Font Size",
                JOptionPane.PLAIN_MESSAGE,
                null,
                sizes,
                sizes[0]
        );

        editor.setFontSize(fontSize);
    }
}
