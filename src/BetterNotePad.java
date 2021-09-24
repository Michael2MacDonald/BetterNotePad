// Import Dependencies
import javax.swing.*;
import java.awt.*;
import java.awt.datatransfer.*;

// Main Class
public class BetterNotePad extends JFrame {

    public BetterNotePad() {
        // Create window
        JFrame frame = new JFrame("Better NotePad");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(700,500);
        frame.setMinimumSize(new Dimension(400, 300));

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

        // Create Text Area
        JTextPane textArea = new JTextPane();
        textArea.setCaretPosition(0);
        textArea.setMargin(new Insets(5,5,5,5));
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

        // MenuItemBold.addActionListener((event) -> setNewStyle(textArea, styledDoc, "bold", false));
        MenuItemCopy.addActionListener((event) -> copy(textArea));
        MenuItemCut.addActionListener((event) -> cut(textArea));
        MenuItemPaste.addActionListener((event) -> paste(textArea));

        // Add All Components To Window
        frame.getContentPane().add(MenuBar, BorderLayout.NORTH);
        frame.getContentPane().add(ScrollPane, BorderLayout.CENTER);
        frame.getContentPane().add(ToolBar, BorderLayout.SOUTH);

        // Set frame as visible
        frame.setVisible(true);
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

    public void copy(JTextPane textArea){
        Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
        Transferable transferable = new StringSelection(textArea.getSelectedText());
        clipboard.setContents(transferable, null);
    }
    public void cut(JTextPane textArea){
        Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
        Transferable transferable = new StringSelection(textArea.getSelectedText());
        clipboard.setContents(transferable, null);
        textArea.replaceSelection("");
    }
    public void paste(JTextPane textArea){
        textArea.paste();
    }

    public static void main(String[] args) {
        new BetterNotePad();
    }
}
