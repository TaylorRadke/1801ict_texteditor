package org;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FontFamilyMenu extends JMenuItem implements ActionListener {

    private Editor editor;
    private Object[] fonts;

    public FontFamilyMenu(Editor a){
        super("Family");
        this.editor = a;
        this.fonts = GraphicsEnvironment.getLocalGraphicsEnvironment().getAvailableFontFamilyNames();
        super.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String newFont = (String) JOptionPane.showInputDialog(
                null,
                "Select a font family",
                "Font Family",
                JOptionPane.PLAIN_MESSAGE,
                null,
                this.fonts,
                this.fonts[0]
        );

        this.editor.setFontFamily(newFont);
    }
}
