package org;

import javax.swing.*;
import java.awt.*;
import java.io.File;

/**
 *
 * @author Taylor Radke
 * <p> This is a project for assignment</p>
 */
public class Editor  {
    private JFrame frame;
    private JTextArea text;
    private File currentFile;
    private String savedText;
    private String fontFamily;
    private JScrollPane scroll;
    int fontSize = 12;

    public Editor() {

         	frame = new JFrame("Untitled - TextEditor");
        	text = new JTextArea();
        	JMenuBar options = new JMenuBar();
         	JMenu fileOptions = new JMenu("File");
         	JMenu formatOptions = new JMenu("Font");
         	scroll = new JScrollPane(text);
            scroll.setSize(100,100);
         	OpenFileMenu open = new OpenFileMenu(this);
         	SaveFileMenu save = new SaveFileMenu(this);
            SaveAsFileMenu saveAs = new SaveAsFileMenu(this);

            FontFamilyMenu fontFamily = new FontFamilyMenu(this);
            FontSizeMenu fontSize = new FontSizeMenu(this);

         	fileOptions.add(open);
         	fileOptions.add(save);
         	fileOptions.add(saveAs);

        	formatOptions.add(fontFamily);
        	formatOptions.add(fontSize);

         	options.add(fileOptions);
         	options.add(formatOptions);
            frame.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
        	frame.add(scroll);
        	frame.addWindowListener(new WindowOnExit(this));
         	frame.setSize(500,500);
         	frame.setJMenuBar(options);
         	frame.setVisible(true);


    }

    public File getCurrentFile(){
        return currentFile;
    }

    public void setFontFamily(String newFontFamily){
        fontFamily = newFontFamily;
        text.setFont(new Font(fontFamily,Font.PLAIN,fontSize));
    }

    public void setFontSize(int newFontSize){
        fontSize = newFontSize;
        text.setFont(new Font(fontFamily,Font.PLAIN,newFontSize));
    }

    public void setSavedText(String newText){
        savedText = newText;
    }

    public String getCurrentFileName(){
        try{
            return currentFile.getName();
        }catch (NullPointerException e){
            return "Untitled";
        }
    }
    public String getSavedText(){
        try {
            return savedText;
        }catch (NullPointerException e){
            return "";
        }
    }

    public void setCurrentFile(File newFile){
        currentFile = newFile;
    }

    public void setTitle(String title){
        frame.setTitle(title + " - TextEditor");
    }

    public String getCurrentText() {
        try{
            return text.getText();
        }catch (NullPointerException e){
            return "";
        }
    }

    public void setCurrentText(String newText){
        text.setText(newText);
    }

    public static void main(String[] args) {
        new Editor();
    }
}
