package org;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * This is the class that creates a font family menu with a listener and lets the user
 * set the font family of the text in the editor.
 */
public class FontFamilyMenu extends JMenuItem implements ActionListener {

    private Editor editor;
    private Object[] fonts;

    public FontFamilyMenu(Editor a){
        super("Family");
        this.editor = a;
        this.fonts = GraphicsEnvironment.getLocalGraphicsEnvironment().getAvailableFontFamilyNames();
        super.addActionListener(this);
    }

    /**
     * Listener for the menu item to react when it is selected.
     * @param e the action
     */
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
