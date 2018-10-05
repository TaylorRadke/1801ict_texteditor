package org;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * This class creates a new file menu item. When selected, if there is unsaved text in the editor
 * it will ask the user if they would like to save the text. Then it clears the current editor and
 * replaces the title.
 */
public class NewFileMenu extends JMenuItem implements ActionListener {
    private Editor editor;

    public NewFileMenu(Editor a){
        super("New");
        editor = a;
        super.addActionListener(this);
    }

    /**
     * Listeners for the new file menu item
     * @param e the action
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        if (!editor.getCurrentText().equals("")){
            int option = JOptionPane.showConfirmDialog(null,
                    "Do you want to save changes to " + editor.getCurrentFileName() + "?","TextEditor",
                    JOptionPane.YES_NO_CANCEL_OPTION);

            if (option == JOptionPane.YES_OPTION){
                try{
                    FileOutputStream os = new FileOutputStream(editor.getCurrentFile());
                    try {
                        os.write(editor.getCurrentText().getBytes(),0,editor.getCurrentText().length());
                        os.close();
                        System.exit(0);
                    } catch (IOException err){}
                }
                catch(FileNotFoundException err){}
                catch (NullPointerException err){
                    JFileChooser fileChooser = new JFileChooser();
                    option = fileChooser.showSaveDialog(new JFrame());
                    if (option == fileChooser.APPROVE_OPTION){
                        editor.setCurrentFile(fileChooser.getSelectedFile());
                        try{
                            FileOutputStream os = new FileOutputStream(editor.getCurrentFile());
                            try {
                                os.write(editor.getCurrentText().getBytes(),0,editor.getCurrentText().length());
                                os.close();
                                editor.setCurrentFile(null);
                                editor.setCurrentText("");
                                editor.setSavedText("");
                                editor.setTitle("Untitled");
                            } catch (IOException err2){}
                        }catch (NullPointerException err2){ }
                        catch (FileNotFoundException err2){
                            System.err.println(err.toString());
                        }
                    }

                }
            }
            else if (option == JOptionPane.NO_OPTION){
                editor.setCurrentFile(null);
                editor.setCurrentText("");
                editor.setSavedText("");
                editor.setTitle("Untitled");
            }
        }
    }
}
