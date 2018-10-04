package org;

import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import javax.swing.*;
import java.io.*;
import java.rmi.ServerError;

public class WindowOnExit implements WindowListener {

    private Editor editor;
    private Object[] options = {"Save","Don't Save","Cancel"};
    public WindowOnExit(Editor a){
        this.editor = a;
    }

    @Override
    public void windowClosing(WindowEvent e) {
        if (!editor.getCurrentText().equals(editor.getSavedText()) || editor.getCurrentFile() == null){

            int option = JOptionPane.showConfirmDialog(null,
                    "Do you want to save changes to " + editor.getCurrentFileName() + "?","TextEditor",
                    JOptionPane.YES_NO_CANCEL_OPTION);

            if (option == JOptionPane.YES_OPTION){


                String currentText = editor.getCurrentText();
                try{
                    FileOutputStream os = new FileOutputStream(editor.getCurrentFile());
                    try {
                        os.write(currentText.getBytes(),0,currentText.length());
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
                                os.write(currentText.getBytes(),0,currentText.length());
                                os.close();
                                System.exit(0);
                            } catch (IOException err2){}
                        }catch (NullPointerException err2){ }
                        catch (FileNotFoundException err2){
                            System.err.println(err.toString());
                        }
                    }

                }
            }
            else if (option == JOptionPane.NO_OPTION){
                System.exit(1);
            }
        }else{
            System.exit(1);
        }
    }

    @Override
    public void windowActivated(WindowEvent e) {}

    @Override
    public void windowClosed(WindowEvent e) { }

    @Override
    public void windowDeactivated(WindowEvent e) { }

    @Override
    public void windowDeiconified(WindowEvent e) { }

    @Override
    public void windowIconified(WindowEvent e) { }

    @Override
    public void windowOpened(WindowEvent e) { }
}
