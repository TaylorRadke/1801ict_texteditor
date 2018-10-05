package org;

import javax.swing.*;
import java.awt.*;
import java.io.File;

/**
 *
 * @author Taylor Radke
 * This is the main class to create the text editor. It uses the menu items from
 * newFileMenu,OpenFileMenu,saveFileMenu,SaveFileMenu,FontFamilyMenu and FontSizeMenu to which
 * have listeners to act if they are selected. It also incorporates a window listener to act if the window is being closed.
 */
public class Editor  {
    private JFrame frame;
    private JTextArea text;
    private File currentFile;
    private String savedText;
    private String fontFamily;
    private JScrollPane scroll;
    int fontSize = 12;

    /**
     * This is the constructor to build the GUI for the Text Editor
     */
    public Editor() {

         	frame = new JFrame("Untitled - TextEditor");
        	text = new JTextArea();
        	JMenuBar options = new JMenuBar();
         	JMenu fileOptions = new JMenu("File");
         	JMenu formatOptions = new JMenu("Font");
         	scroll = new JScrollPane(text);
            scroll.setSize(100,100);

            NewFileMenu newFile = new NewFileMenu(this);
         	OpenFileMenu open = new OpenFileMenu(this);
         	SaveFileMenu save = new SaveFileMenu(this);
            SaveAsFileMenu saveAs = new SaveAsFileMenu(this);

            FontFamilyMenu fontFamily = new FontFamilyMenu(this);
            FontSizeMenu fontSize = new FontSizeMenu(this);

            fileOptions.add(newFile);
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

    /**
     *Gets the current opened file.
     * @return File returns the current File from the text editor
     */
    public File getCurrentFile(){
        return currentFile;
    }

    /**
     *Sets the text editors font family to the new font family.
     * @param newFontFamily the font family to the to for the text editor
     */
    public void setFontFamily(String newFontFamily){
        fontFamily = newFontFamily;
        text.setFont(new Font(fontFamily,Font.PLAIN,fontSize));
    }

    /**
     *Sets the text editor's font to the new font size.
     * @param newFontSize the font size to change the font in the text editor to
     */
    public void setFontSize(int newFontSize){
        fontSize = newFontSize;
        text.setFont(new Font(fontFamily,Font.PLAIN,newFontSize));
    }

    /**
     *This function sets the initial text of the document when opening or saving to be used to tell if the
     * if the document has been modified.
     * @param newText the text for the document being opened or saved.
     */
    public void setSavedText(String newText){
        savedText = newText;
    }

    /**
     *Gets the name of the current open File
     * @return currentFile the name of the current or Untitled if current file is null
     */
    public String getCurrentFileName(){
        try{
            return currentFile.getName();
        }catch (NullPointerException e){
            return "Untitled";
        }
    }

    /**
     * Gets the text that was previously saved to check if the text  has been updated
     * @return savedText the current saved text or empty string.
     */
    public String getSavedText(){
        try {
            return savedText;
        }catch (NullPointerException e){
            return "";
        }
    }

    /**
     * Sets the editors current file
     * @param newFile the new file to set the current file to
     */

    public void setCurrentFile(File newFile){
        currentFile = newFile;
    }

    /**
     * Sets the frames title to change the file name in the title.
     * @param title the next file name
     */
    public void setTitle(String title){
        frame.setTitle(title + " - TextEditor");
    }

    /**
     * Gets the text currently in the text area.
     * @return text the text currently in the editor
     */
    public String getCurrentText() {
        try{
            return text.getText();
        }catch (NullPointerException e){
            return "";
        }
    }

    /**
     * set the text in the text editor to display the nextText
     * @param newText the next text to display
     */
    public void setCurrentText(String newText){
        text.setText(newText);
    }

    public static void main(String[] args) {
        new Editor();
    }
}
