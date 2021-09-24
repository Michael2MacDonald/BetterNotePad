import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
 
/**
* Java program to demonstrate how to use JFileChooser for showing open file
* dialog and save file dialog in Java application.
 */
public class Test extends JFrame {
 
    private final JButton upload = new JButton("Upload");
    private final JButton save = new JButton("Save");
   
 
    public Test() {
        super("JFileChooser Example - Open Save File Dialong in Java");
        setLayout(new FlowLayout());
        upload.addActionListener(new ActionListener() {
 
            @Override
            public void actionPerformed(ActionEvent arg0) {
                showSelectFileDialong();
            }
        });
        getContentPane().add(upload);
        setSize(300, 100);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }
 
    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException 
                   | InstantiationException
                   | IllegalAccessException 
                   | UnsupportedLookAndFeelException e) {
        }
 
        SwingUtilities.invokeLater(new Runnable() {
 
            @Override
            public void run() {
                Test t = new Test();
            }
        });
    }
 
    private void showSelectFileDialong() {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Choose a File to upload");
 
        // pass reference of your JFrame here
        int response = fileChooser.showSaveDialog(this);
        if (response == JFileChooser.APPROVE_OPTION) {
            File selectedFile = fileChooser.getSelectedFile();
            System.out.println("Save as file: " 
                      + selectedFile.getAbsolutePath());
        }
    }
 
}