// Import Dependencies
import javax.swing.*;
import java.awt.*;
import java.awt.Font.*;
import java.awt.datatransfer.*;
import java.io.*;
import java.io.File;
import java.io.FileWriter;
import java.io.FileReader;
import java.util.Scanner;

// Main Class
public class BetterNotePad extends JFrame {

    private static JFrame frame = new JFrame("Better NotePad");
    private static JTextPane textArea = new JTextPane();

    private String Font = "LucidaSans";
    private int FontDecoration = 0;
    private int FontSize = 12;

    private JFileChooser fileChooser = new JFileChooser();

    public BetterNotePad() {
        // Window Settings
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(700,500);
        frame.setMinimumSize(new Dimension(400, 300));
        // Text Area Settings
        textArea.setCaretPosition(0);
        textArea.setMargin(new Insets(5,5,5,5));
        textArea.setFont(new Font(Font, FontDecoration, FontSize));

        // Create menu bar
        JMenuBar MenuBar = new JMenuBar();
        // Create menu items
        JMenu MenuItemFile = new JMenu("File");
        MenuBar.add(MenuItemFile);
        JMenu MenuItemEdit = new JMenu("Edit");
        MenuBar.add(MenuItemEdit);
        JMenu MenuItemFormat = new JMenu("Format");
        MenuBar.add(MenuItemFormat);
        // Create menu sub-items
        JMenuItem MenuItemOpen = new JMenuItem("Open");
        MenuItemFile.add(MenuItemOpen);
        JMenuItem MenuItemSave = new JMenuItem("Save");
        MenuItemFile.add(MenuItemSave);
        JMenuItem MenuItemSaveAs = new JMenuItem("Save as");
        MenuItemFile.add(MenuItemSaveAs);
        JMenuItem MenuItemExit = new JMenuItem("Exit");
        MenuItemFile.add(MenuItemExit);
        MenuItemExit.addActionListener((event) -> System.exit(0));

        JMenuItem MenuItemCut = new JMenuItem("Cut");
        MenuItemEdit.add(MenuItemCut);
        JMenuItem MenuItemCopy = new JMenuItem("Copy");
        MenuItemEdit.add(MenuItemCopy);
        JMenuItem MenuItemPaste = new JMenuItem("Paste");
        MenuItemEdit.add(MenuItemPaste);
        // JMenuItem MenuItemBold = new JMenuItem("Bold");
        // MenuItemEdit.add(MenuItemBold);

        // JMenuItem MenuItemFont = new JMenuItem("Font");
        // MenuItemFormat.add(MenuItemFont);
        // JMenuItem MenuItemFontDecoration = new JMenuItem("Font Decoration");
        // MenuItemFormat.add(MenuItemFontDecoration);

        JMenuItem MenuItemNormal = new JMenuItem("Normal");
        MenuItemFormat.add(MenuItemNormal);
        JMenuItem MenuItemBold = new JMenuItem("Bold");
        MenuItemFormat.add(MenuItemBold);
        JMenuItem MenuItemItalic = new JMenuItem("Italic");
        MenuItemFormat.add(MenuItemItalic);
        

        // StyledDocument styledDoc = textArea.getStyledDocument();
        // addStyles(styledDoc);
        // textArea.setLineWrap(true);
        // textArea.setWrapStyleWord(true);

        // Create Scroll Pane
        JScrollPane ScrollPane = new JScrollPane(textArea);
        // ScrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS); // Uncomment this if you want the vertical scroll bar to always be visible
        // ScrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS); // Uncomment this if you want the horizontal scroll bar to always be visible

        // Create Bottom Toolbar
        JToolBar ToolBar = new JToolBar();
        FlowLayout ToolBarLayout = new FlowLayout();
        ToolBar.setLayout(ToolBarLayout);
        ToolBar.setFloatable(false);

        MenuItemOpen.addActionListener((event) -> showOpenFileDialog());
        MenuItemSave.addActionListener((event) -> showSaveFileDialog());
        MenuItemSaveAs.addActionListener((event) -> showSaveAsFileDialog());
        // MenuItemBold.addActionListener((event) -> setNewStyle(textArea, styledDoc, "bold", false));
        MenuItemCopy.addActionListener((event) -> copy());
        MenuItemCut.addActionListener((event) -> cut());
        MenuItemPaste.addActionListener((event) -> paste());
        MenuItemNormal.addActionListener((event) -> SetFontDecoration(0));
        MenuItemBold.addActionListener((event) -> SetFontDecoration(1));
        MenuItemItalic.addActionListener((event) -> SetFontDecoration(2));

        // Add All Components To Window
        frame.getContentPane().add(MenuBar, BorderLayout.NORTH);
        frame.getContentPane().add(ScrollPane, BorderLayout.CENTER);
        frame.getContentPane().add(ToolBar, BorderLayout.SOUTH);

        // Set frame as visible
        frame.setVisible(true);

        // void SetFont(String fontSelection){
        //     Font = fontSelection;
        //     textArea.setFont(new Font(Font, FontDecoration, FontSize))
        // }
        // void SetFontDecoration(int decoration){

        //     textArea.setFont(new Font(Font, FontDecoration, FontSize))
        // }
        // void SetFontSize(int size){
        //     FontSize = size;
        //     textArea.setFont(new Font(Font, FontDecoration, FontSize))
        // }
    }

    // Add some styles to the document, to retrieve and use later
    // private void addStyles(StyledDocument doc) {
    //     StyleContext sc = StyleContext.getDefaultStyleContext(); 
    //     Style defaultContextStyle = sc.getStyle(StyleContext.DEFAULT_STYLE);
    //     Style normalStyle = doc.addStyle("normal", defaultContextStyle); 

    //     // Create a bold style 
    //     Style boldStyle = doc.addStyle("bold", normalStyle); 
    //     StyleConstants.setBold(boldStyle, true); 

    //     // Create an italic style 
    //     Style italicStyle = doc.addStyle("italic", normalStyle); 
    //     StyleConstants.setItalic(italicStyle, true); 

    //     // Create an underline style 
    //     Style underlineStyle = doc.addStyle("underline", normalStyle); 
    //     StyleConstants.setUnderline(underlineStyle, true); 
    // }

    // private void setNewStyle(JTextPane textArea, StyledDocument doc, String styleName, boolean isCharacterStyle) {  
    //     Style newStyle = doc.getStyle(styleName); 
    //     int start = textArea.getSelectionStart(); 
    //     int end = textArea.getSelectionEnd(); 
    //     if (isCharacterStyle) { 
    //         boolean replaceOld = styleName.equals("normal");
    //         doc.setCharacterAttributes(start, end - start, newStyle, replaceOld); 
    //     } else { 
    //         doc.setParagraphAttributes(start, end - start, newStyle, false); 
    //     } 
    // }

    void SetFont(String fontSelection){
        Font = fontSelection;
        textArea.setFont(new Font(Font, FontDecoration, FontSize));
    }
    void SetFontDecoration(int decoration){
        FontDecoration = decoration;
        textArea.setFont(new Font(Font, FontDecoration, FontSize));
    }
    void SetFontSize(int size){
        FontSize = size;
        textArea.setFont(new Font(Font, FontDecoration, FontSize));
    }

    // void open(){
    //     if (returnValue == JFileChooser.APPROVE_OPTION) {
    //         File f = new File(jfc.getSelectedFile().getAbsolutePath());
    //         try{
    //             FileReader read = new FileReader(f);
    //             Scanner scan = new Scanner(read);
    //             while(scan.hasNextLine()){
    //                 String line = scan.nextLine() + "\n";
    //                 ingest = ingest + line;
    //             }
    //             area.setText(ingest);
    //         } catch ( FileNotFoundException ex) {
    //             ex.printStackTrace();
    //         }
    //     }
    // }

    private void showOpenFileDialog() {
        String ingest = "";
        fileChooser.setDialogTitle("Choose a File to open");
 
        int response = fileChooser.showOpenDialog(this);
        if (response == JFileChooser.APPROVE_OPTION) {
            File selectedFile = new File(fileChooser.getSelectedFile().getAbsolutePath());
            selectedFile.getAbsolutePath();
            System.out.println("Save as file: " + selectedFile.getAbsolutePath());
            
            try {
                FileReader read = new FileReader(selectedFile);
                Scanner scan = new Scanner(read);
                while(scan.hasNextLine()){
                    String line = scan.nextLine() + "\n";
                    ingest = ingest + line;
                }
                if(ingest != null){
                    ingest = ingest.substring(0, ingest.length() - 1);
                }
                textArea.setText(ingest);
            } catch ( FileNotFoundException ex) {
                ex.printStackTrace();
            }
            frame.setTitle(selectedFile.getName() + " - Better NotePad");
        }
    }

    private void showSaveFileDialog() {
        if(fileChooser.getSelectedFile() == null){
            fileChooser.setDialogTitle("Choose a file to save to");
            int response = fileChooser.showSaveDialog(this);
            if (response != JFileChooser.APPROVE_OPTION) {
                return; // If nothing is selected then just don't try to save file to prevent errors
            }
        }
        File selectedFile = new File(fileChooser.getSelectedFile().getAbsolutePath());
        try {
            FileWriter out = new FileWriter(selectedFile);
            out.write(textArea.getText());
            out.close();
        } catch (FileNotFoundException ex) {
            Component f = null;
            JOptionPane.showMessageDialog(f,"File not found.");
        } catch (IOException ex) {
            Component f = null;
            JOptionPane.showMessageDialog(f,"Error.");
        }
        frame.setTitle(selectedFile.getName() + " - Better NotePad");
    }

    private void showSaveAsFileDialog() {
        fileChooser.setDialogTitle("Save File As");
 
        int response = fileChooser.showSaveDialog(this);
        if (response == JFileChooser.APPROVE_OPTION) {
            File selectedFile = new File(fileChooser.getSelectedFile().getAbsolutePath());
            System.out.println("Save as file: " + selectedFile.getAbsolutePath());

            try {
                FileWriter out = new FileWriter(selectedFile);
                out.write(textArea.getText());
                out.close();
            } catch (FileNotFoundException ex) {
                Component f = null;
                JOptionPane.showMessageDialog(f,"File not found.");
            } catch (IOException ex) {
                Component f = null;
                JOptionPane.showMessageDialog(f,"Error.");
            }
            frame.setTitle(selectedFile.getName() + " - Better NotePad");
        }
    }

    public void copy(){
        Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
        Transferable transferable = new StringSelection(textArea.getSelectedText());
        clipboard.setContents(transferable, null);
    }
    public void cut(){
        Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
        Transferable transferable = new StringSelection(textArea.getSelectedText());
        clipboard.setContents(transferable, null);
        textArea.replaceSelection("");
    }
    public void paste(){
        textArea.paste();
    }

    public static void main(String[] args) {
        new BetterNotePad();
    }
}
