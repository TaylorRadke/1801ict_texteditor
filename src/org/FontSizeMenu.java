package org;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * This class creates a font size menu item with a listener.
 * When this is selected the user is shown a list of fonts from 1 to 72 and then the text in the text area
 * will have the new font size
 */
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

    /**
     * Listener for the font size menu
     * @param e the action
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            int fontSize = (int) JOptionPane.showInputDialog(
                    null,
                    "Select a font size",
                    "Font Size",
                    JOptionPane.PLAIN_MESSAGE,
                    null,
                    sizes,
                    sizes[0]
            );
            editor.setFontSize(fontSize);
        }catch (NullPointerException err){ }
    }
}
