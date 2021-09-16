// Import Dependencies
import javax.swing.*;
import javax.swing.text.*;
import java.awt.*;

// Main Class
public class Main {

//     public void addStylesToDocument(StyledDocument doc) {
//         Style def = StyleContext.getDefaultStyleContext()
//                                 .getStyle(StyleContext.DEFAULT_STYLE);
//         Style regular = doc.addStyle("regular", def);
//         StyleConstants.setFontFamily(def, "Serif");
//         StyleConstants.setFontSize(regular, 12);
//         bold = doc.addStyle("bold", regular);
//         StyleConstants.setBold(bold, true);
//         StyleConstants.setForeground(bold, new Color(90,0,90));
//         StyleConstants.setAlignment(bold, StyleConstants.ALIGN_LEFT);
//         justified = doc.addStyle("justified", regular);
//         StyleConstants.setAlignment(justified, StyleConstants.ALIGN_JUSTIFIED);
//         StyleConstants.setForeground(justified, new Color(90,0,90));
//    }
    public static void main(String[] args) throws Exception {

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
        JMenuItem MenuItemCut = new JMenuItem("Cut");
        MenuItemEdit.add(MenuItemCut);
        JMenuItem MenuItemCopy = new JMenuItem("Copy");
        MenuItemEdit.add(MenuItemCopy);
        JMenuItem MenuItemPaste = new JMenuItem("Paste");
        MenuItemEdit.add(MenuItemPaste);

        JTextPane TextArea = new JTextPane();
        TextArea.setCaretPosition(0);
        TextArea.setMargin(new Insets(5,5,5,5));
        StyledDocument styledDoc = TextArea.getStyledDocument();
        // addStylesToDocument(styledDoc);
        // TextArea.setLineWrap(true);
        // TextArea.setWrapStyleWord(true);

        JScrollPane ScrollPane = new JScrollPane(TextArea);
        // ScrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        // ScrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);

        JToolBar ToolBar = new JToolBar();
        FlowLayout ToolBarLayout = new FlowLayout();
        ToolBar.setLayout(ToolBarLayout);
        ToolBar.setFloatable(false);

        frame.getContentPane().add(MenuBar, BorderLayout.NORTH);
        frame.getContentPane().add(ScrollPane, BorderLayout.CENTER);
        frame.getContentPane().add(ToolBar, BorderLayout.SOUTH);

        // Set frame as visible
        frame.setVisible(true);
    }
}
