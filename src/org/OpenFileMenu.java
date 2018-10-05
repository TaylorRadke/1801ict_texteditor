package org;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;

/**
 * This class creates an open file menu item that allows the user to open any text file and display it's content
 * to the text editor.
 */
public class OpenFileMenu extends JMenuItem implements ActionListener {

    private Editor editor;

    public OpenFileMenu(Editor a){
        super("Open");
        this.editor = a;
        super.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JFileChooser selectFile = new JFileChooser();
        int option = selectFile.showOpenDialog(new JFrame());
        if (option == selectFile.APPROVE_OPTION){
            editor.setCurrentFile(selectFile.getSelectedFile());
            try{
                FileInputStream readFile = new FileInputStream(editor.getCurrentFile());
                try{
                    String fileText = "";
                    for (int i= readFile.read() ; i !=-1; i = readFile.read()){
                        fileText += (char)i;
                    }
                    readFile.close();

                    editor.setSavedText(fileText);
                    editor.setCurrentText(fileText);
                    editor.setTitle(this.editor.getCurrentFile().getName());

                }catch (IOException err){
                    System.err.println(err);
                }
            }catch (FileNotFoundException err){
                System.err.println(err);
            }
        }
    }
}
