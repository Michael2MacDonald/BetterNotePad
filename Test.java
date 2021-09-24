import javax.swing.*;
import java.awt.*;
import java.io.File;
 
/**
* Java program to demonstrate how to use JFileChooser for showing open file
* dialog and save file dialog in Java application.
 */
public class Test extends JFrame {

    private final JButton upload = new JButton("open");

    public Test() {
        super("JFileChooser Example - Open File Dialog in Java");
        setLayout(new FlowLayout());
        upload.addActionListener((event) -> showOpenFileDialog());
        getContentPane().add(upload);
        setSize(300, 100);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }
 
    public static void main(String[] args) {
        new Test();
    }
 
    private void showOpenFileDialog() {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Choose a File to open");
 
        // pass reference of your JFrame here
        int response = fileChooser.showSaveDialog(this);
        if (response == JFileChooser.APPROVE_OPTION) {
            File selectedFile = fileChooser.getSelectedFile();
            System.out.println("Open file: " + selectedFile.getAbsolutePath());
        }
    }
 
}