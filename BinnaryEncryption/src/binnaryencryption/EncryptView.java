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
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Arrays;
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

public class EncryptView extends JPanel {

    public static int progressCounter = 0;
    ;
    public static JButton chooseFileButton;
    public static JComboBox currentFileCombo;
    public static JComboBox keyLengthComboBox;
    public static JButton viewCipherConsol;
    public static JLabel backgroundImageLabel;
    public static JLabel chosenFileLabel;
    public static JFileChooser fileChooser;
    public static JButton runEncryptwithout;
    public static String b_File;
    public static File targetFile;
    public static List<String> cipherTextLines;
    private static JProgressBar progressBar;

    public EncryptView() {

        setLayout(null);
        setBackground(Color.WHITE);

        String[] temp = {".txt", ".docx", ".mp4", ".mp3", ".jpeg"};
        String[] keyLengthValue = {"8 bit", "16 bit", "32 bit", ""};

        progressBar = new JProgressBar();
        fileChooser = new JFileChooser();
        runEncryptwithout = new JButton("Run Encryption without console");
        chosenFileLabel = new JLabel("chosenFile.txt");
        backgroundImageLabel = new JLabel(new ImageIcon(getClass().getResource("/appimages/pxdHYA.jpg")));
        chooseFileButton = new JButton("Choose File");
        currentFileCombo = new JComboBox(temp);
        keyLengthComboBox = new JComboBox(keyLengthValue);
        viewCipherConsol = new JButton("View Encryption Console");
        chosenFileLabel.setFont(new Font("Calibri", Font.BOLD, 22));
        chosenFileLabel.setForeground(Color.RED);
        progressBar.setStringPainted(true);
        progressBar.setMaximum(100);
        progressBar.setValue(0);

        chooseFileButton.addActionListener(e -> {

            fileChooser.showDialog(this, "Select a File ");
            targetFile = fileChooser.getSelectedFile();
            chosenFileLabel.setText(fileChooser.getSelectedFile().getName());

        });

        viewCipherConsol.addActionListener(e -> {
            BinnaryEncryption.replaceRightComponent(new ViewCipher());
        });

        chooseFileButton.setBounds(20, 100, 200, 35);
        chosenFileLabel.setBounds(250, 100, 200, 40);
        currentFileCombo.setBounds(20, 150, 200, 25);
        keyLengthComboBox.setBounds(20, 210, 200, 25);
        viewCipherConsol.setBounds(20, 250, 200, 35);
        backgroundImageLabel.setBounds(0, 0, 800, 500);
        runEncryptwithout.setBounds(20, 300, 250, 35);
        progressBar.setBounds(20, 350, 500, 20);

        runEncryptwithout.addActionListener(e -> {
            b_File = JOptionPane.showInputDialog("Enter encryption key for the File...");
            List<String> plainTextlines = readTargetFile(targetFile);
            cipherTextLines = new ArrayList<>();
            int i = 0;
            /* while(i < plainTextlines.size()){
            cipherTextLines.add(BinnaryEncryptionAlogorithm.getCipherText(plainTextlines.get(i)));
            plainTextlines.remove(i);
            i++;
            }*/

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
                        }
                    }

                }
            }
            );
            scan.start();

            plainTextlines.forEach(en -> {

                Integer cipherLength = 16;
                String selectedLength = keyLengthComboBox.getSelectedItem().toString();

                if (selectedLength.equals("8 bit")) {
                    cipherLength = 8;
                } else if (selectedLength.equals("16 bit")) {
                    cipherLength = 16;
                } else if (selectedLength.equals("32 bit")) {
                    cipherLength = 32;
                }

                String cipherLine = BinnaryEncryptionAlogorithm.getCipherText(en, cipherLength);
                cipherTextLines.add(cipherLine);
            });

            //write cipher to file
            writeCipherToBackUpFile(cipherTextLines, targetFile);

            //write plain text to back up file
            writeCipherToBackUpFile(plainTextlines, new File(b_File + ".txt"));

            //String cipher = MessageDigestClass.getCipherText(textArea.getText());
            // textArea.setText("");
            int j = 0;
            while (j < cipherTextLines.size()) {
                // textArea.append(cipherTextLines.get(j));
                // textArea.append("\n");
                cipherTextLines.remove(j);
                j++;
            }

            writeCipherToBackUpFile(plainTextlines, new File(b_File + ".txt"));
            //writeCipherToFile(cipher);
        });

        List<JButton> buttons = Arrays.asList(
                chooseFileButton, viewCipherConsol, runEncryptwithout
        );

        setButtonProperties(buttons);

        add(chooseFileButton);
        add(chosenFileLabel);
        add(currentFileCombo);
        add(keyLengthComboBox);
        add(viewCipherConsol);
        add(runEncryptwithout);
        add(progressBar);
        add(backgroundImageLabel);

        repaint();
        setVisible(true);
    }

    public final void setButtonProperties(List<JButton> buttons) {
        buttons.stream()
                .forEach(e -> {
                    e.setBackground(Color.decode("#1e90ff"));
                    e.setForeground(Color.white);
                    e.setBorder(new LineBorder(Color.decode("#1e90ff")));
                    e.setFont(new Font("Calibri", Font.BOLD, 18));
                });

    }

    public static List<String> getCipherTextLogs() {
        return cipherTextLines;
    }

    public static List<String> readTargetFile(File backUpFile) {
        try {
        } catch (NullPointerException ex) {
        }
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(backUpFile))) {
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

    /**
     * Reads the specified category file foe applications names
     *
     * @param categoryFile
     * @return String[] - arrays of lines read from this category file
     */
    public final Object[] getFileNames(File categoryFile) {
        try {

            List<String> lines = new ArrayList<>();
            BufferedReader in = new BufferedReader(new FileReader(categoryFile)); //read app file
            String line;
            for (int i = 0; (line = in.readLine()) != null; i++) {
                lines.add(line);
                //textArea.append(line);
                // textArea.append("\n");
            }
            return lines.toArray();
        } catch (IOException e) {
            return null;
        } catch (NullPointerException e) {
            return null;
        }
    }

    /**
     * Write a new list representing the selected cipher for this category
     *
     * @param cipherLines
     * @param categoryFile
     */
    public static void writeCipherToBackUpFile(List<String> cipherLines, File categoryFile) {

        try {
            FileWriter fileWriter = new FileWriter(categoryFile);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

            cipherLines.stream()
                    .forEach(e -> {
                        try {
                            bufferedWriter.write(e);
                            bufferedWriter.newLine();
                        } catch (IOException ex) {
                            JOptionPane.showMessageDialog(null, "Unable to Encrypt File\n"
                                    + ex.getMessage(), "Desktop Secure", JOptionPane.ERROR_MESSAGE);
                        }
                    });
            bufferedWriter.flush();
            bufferedWriter.close();

        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Unable to Encrypt File\n"
                    + e.getMessage(), "Desktop Secure", JOptionPane.ERROR_MESSAGE);

        }
    }

}
