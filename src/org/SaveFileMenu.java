package org;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.*;

public class SaveFileMenu extends JMenuItem implements ActionListener {
    private Editor editor;

    public SaveFileMenu(Editor a){
        super("Save");
        this.editor = a;
        super.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try{
            FileOutputStream writeFile = new FileOutputStream(this.editor.getCurrentFile());
            try{
                String currentText = this.editor.getCurrentText();
                writeFile.write(currentText.getBytes(),0,currentText.length());
                this.editor.setSavedText(currentText);
                writeFile.close();
            }catch (IOException err){
                System.err.println(err.toString());
            }catch (NullPointerException err){
                System.err.println(err.toString());
            }
        }catch (FileNotFoundException err){
            System.err.println(err.toString());
        } catch (NullPointerException err){
            JFileChooser selectFile = new JFileChooser();
            int option = selectFile.showSaveDialog(new JFrame());
            if (option == selectFile.APPROVE_OPTION){
                editor.setCurrentFile(selectFile.getSelectedFile());
                editor.setTitle(editor.getCurrentFileName());
            }
        }

    }
}
