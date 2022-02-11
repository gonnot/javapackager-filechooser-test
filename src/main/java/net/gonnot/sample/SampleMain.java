package net.gonnot.sample;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SampleMain {
  private final JFrame frame = new JFrame();

  public static void main(String[] args) {
    new SampleMain().show();
  }

  public void show() {
    frame.setTitle("macOS 10.15 Catalina Java File Chooser Directory Access Test");
    frame.setLayout(new BoxLayout(frame.getContentPane(), BoxLayout.Y_AXIS));
    ((JComponent)frame.getContentPane()).setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    // show Java runtime info
    final String jreArch = System.getProperty("os.arch").contains("64") ? "64-bit" : "32-bit";
    final String javaVersion = System.getProperty("java.version");
    final String javaVendor = System.getProperty("java.vendor");
    final String javaHome = System.getProperty("java.home");
    addCentered(new JLabel("Running Java " + javaVersion + " (" + jreArch + ", " + javaVendor + ")"));
    addCentered(new JLabel("Java home: " + javaHome));
    addCentered(new JSeparator());

    JLabel label = new JLabel("Try to access contents of [home]/Documents, Desktop, and Downloads folder in each dialog.");
    addCentered(label);
    addCentered(new JLabel("On macOS Catalina 10.15, they're accessible in FileDialog but not in JFileChooser."));
    JButton fdButton = new JButton("Use FileDialog...");
    fdButton.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        openFileDialog();
      }
    });
    addCentered(fdButton);
    JButton jfcButton = new JButton("Use JFileChooser...");
    jfcButton.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        openJFileChooser();
      }
    });
    addCentered(jfcButton);
    frame.setLocationRelativeTo(null);
    frame.pack();
    frame.setVisible(true);
  }

  private void openJFileChooser() {
    JFileChooser chooser = new JFileChooser();
    chooser.setDialogTitle("JFileChooser - Choose a file.");
    chooser.showOpenDialog(frame);
  }

  private void openFileDialog() {
    FileDialog fd = new FileDialog(frame, "FileDialog - Choose a file.");
    fd.setMode(FileDialog.LOAD);
    fd.setVisible(true);
  }

  private void addCentered(JComponent c) {
    c.setAlignmentX(Component.CENTER_ALIGNMENT);
    frame.add(c);
  }

}
