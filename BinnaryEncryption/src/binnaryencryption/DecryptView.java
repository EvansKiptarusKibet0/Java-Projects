/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package binnaryencryption;


import java.awt.Color;
import java.awt.Font;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.SwingUtilities;
import javax.swing.border.LineBorder;

public class DecryptView extends JPanel {

    private static JButton chooseFileButton;
    private static JComboBox currentFileCombo;
    private static JComboBox keyLength;
    private static JButton viewCipherConsol;
    private static JLabel backgroundImageLabel;
    private static JLabel chosenFileLabel;
    private static JFileChooser fileChooser;
    private static JButton runDecryptwithoutConsole;
    private static File tFile;
    private static String targetFile;
    private static JProgressBar progressBar;
    private static int progressCounter = 0;

    public DecryptView() {

        setLayout(null);
        setBackground(Color.WHITE);

        String[] temp = {".txt"};
        String[] keyLengthValue = {"Generate 8 bit Cipher", "Gnerate 16 bit Cipher", " Generate 32 bit Cipher", ""};

        progressBar = new JProgressBar();
        progressBar.setStringPainted(true);
        progressBar.setMaximum(100);
        progressBar.setValue(0);
        fileChooser = new JFileChooser();
        runDecryptwithoutConsole = new JButton("Run Decryption without console", new ImageIcon(getClass().getResource("/appimages/ic_action_feeed_icon_b.png")));
        chosenFileLabel = new JLabel("chosen_file.txt");
        backgroundImageLabel = new JLabel(new ImageIcon(getClass().getResource("/appimages/pxdHYA.jpg")));

        chooseFileButton = new JButton("Choose File");
        currentFileCombo = new JComboBox(temp);
        keyLength = new JComboBox(keyLengthValue);
        viewCipherConsol = new JButton("View Decrypt Console");
        chosenFileLabel.setFont(new Font("Calibri", Font.BOLD, 22));
        chosenFileLabel.setForeground(Color.RED);

        chooseFileButton.addActionListener(e -> {

            fileChooser.showDialog(this, "Select a File ");
            chosenFileLabel.setText(fileChooser.getSelectedFile().getName());
            tFile = fileChooser.getSelectedFile();
        });

        viewCipherConsol.addActionListener(e -> {
            BinnaryEncryption.replaceRightComponent(new ViewCipher());
        });

        runDecryptwithoutConsole.addActionListener(e -> {
            //String cipher = MessageDigestClass.getCipherText(textArea.getText());
            //read back up file
            String input = JOptionPane.showInputDialog(this, "Please enter your decryption key"
                    + " to obtain the encrypted file...", "Desktop Secure", JOptionPane.INFORMATION_MESSAGE);
            List<String> backUpData = readFileBackUpFile(input + ".txt");
            int i = 0;
            while (backUpData.size() < i) {
            }
            //textArea.append(backUpData.get(i));
            //textArea.append("\n");
            i++;
            writeCipherToFile(backUpData, tFile);
            
            
            Thread scan = new Thread(
                    new Runnable() {
                @Override
                public void run() {
                    while (progressCounter <= 100) {

                        SwingUtilities.invokeLater(new Runnable() {
                            @Override
                            public void run() {
                                progressBar.setValue(progressCounter++);
                            }
                        }
                        );
                        try {
                            Thread.sleep(100);
                        } catch (InterruptedException ex) {
                            ex.printStackTrace();
                        }
                    }

                }
            }
            );
            scan.start();

        });

        currentFileCombo.setBackground(Color.WHITE);
        keyLength.setBackground(Color.WHITE);
        runDecryptwithoutConsole.setBackground(Color.GREEN);
        chooseFileButton.setBackground(Color.GREEN);
        viewCipherConsol.setBackground(Color.GREEN);
        
        viewCipherConsol.setForeground(Color.WHITE);
        chooseFileButton.setForeground(Color.WHITE);
        runDecryptwithoutConsole.setBackground(Color.GREEN);
        
        viewCipherConsol.setBorder( new LineBorder(Color.GREEN));
        chooseFileButton.setBorder( new LineBorder(Color.GREEN));
        runDecryptwithoutConsole.setBorder( new LineBorder(Color.GREEN));

        chooseFileButton.setBounds(20, 100, 200, 35);
        chosenFileLabel.setBounds(250, 100, 200, 40);
        currentFileCombo.setBounds(20, 150, 200, 30);
        keyLength.setBounds(20, 210, 200, 30);
        viewCipherConsol.setBounds(20, 250, 200, 35);
        backgroundImageLabel.setBounds(0, 0, 800, 500);
        runDecryptwithoutConsole.setBounds(20, 300, 250, 35);
        progressBar.setBounds(20,350,500,30);

        add(chooseFileButton);
        add(chosenFileLabel);
        add(currentFileCombo);
        add(keyLength);
        add(viewCipherConsol);
        add(runDecryptwithoutConsole);
        add(progressBar);
        add(backgroundImageLabel);

        repaint();
        setVisible(true);
    }

    /**
     * Write a new list representing the selected cipher for this category
     *
     * @param cipherLines
     * @param categoryFile
     */
    public final void writeCipherToFile(List<String> cipherLines, File categoryFile) {

        try {
            FileWriter fileWriter = new FileWriter(categoryFile);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

            cipherLines.stream()
                    .forEach(e -> {
                        try {
                            bufferedWriter.write(e);
                            bufferedWriter.newLine();
                        } catch (IOException ex) {
                            JOptionPane.showMessageDialog(this, "Unable to Encrypt File\n"
                                    + ex.getMessage(), "Desktop Secure", JOptionPane.ERROR_MESSAGE);
                        }
                    });
            bufferedWriter.flush();
            bufferedWriter.close();

        } catch (IOException e) {
            JOptionPane.showMessageDialog(this, "Unable to Encrypt File\n"
                    + e.getMessage(), "Desktop Secure", JOptionPane.ERROR_MESSAGE);

        }
    }

    public final List<String> readFileBackUpFile(String backUpFile) {
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(new File(backUpFile)))) {
            String line = "";
            List<String> lines = new ArrayList<>();
            while (((line = bufferedReader.readLine()) != null)) {
                lines.add(line);
            }
            return lines;

        } catch (IOException e) {
            return new ArrayList<>();
        }
    }
}
