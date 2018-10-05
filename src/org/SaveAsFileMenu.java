package org;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;

/**
 * This class creates a Save As file menu item to replace the name of the current file
 */
public class SaveAsFileMenu extends JMenuItem implements ActionListener {
    private Editor editor;

    public SaveAsFileMenu(Editor a){
        super("Save As");
        this.editor = a;
        super.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent action) {

        JFileChooser selectFile = new JFileChooser();
        File currentFile = editor.getCurrentFile();
        int option = selectFile.showSaveDialog(new JFrame());
        if (option == selectFile.APPROVE_OPTION){
            currentFile.renameTo(selectFile.getSelectedFile());
            editor.setCurrentFile(selectFile.getSelectedFile());
            try {
                FileOutputStream writeFile = new FileOutputStream(editor.getCurrentFile());
                try{
                    String currentText = editor.getCurrentText();
                    writeFile.write(currentText.getBytes(),0,currentText.length());
                    writeFile.close();
                    editor.setTitle(currentFile.getName());
                    editor.setSavedText(currentText);
                } catch (IOException e){System.err.println(e.toString());}
            } catch (FileNotFoundException e){
                System.err.println(e.toString());
            }
        }
    }
}
