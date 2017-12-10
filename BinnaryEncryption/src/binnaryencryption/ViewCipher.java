/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package binnaryencryption;

import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.border.LineBorder;

public class ViewCipher extends JPanel {

    private static JButton backButton;
    private static JTextArea textArea;
    private static JLabel infoLabel;
    private static JLabel backgroundIamegLabel;
    private static JButton runEncryptButton;
    private static JScrollPane scrollPane;

    public ViewCipher() {
        setLayout(null);
        setBackground(Color.WHITE);

        textArea = new JTextArea();
        scrollPane = new JScrollPane();
        backButton = new JButton("BACK");
        runEncryptButton = new JButton("RUN ENCRYPT");
        
        
        backgroundIamegLabel = new JLabel(new ImageIcon("C:\\Users\\HACKER\\"
                + "Documents\\NetBeansProjects\\BinnaryEncryption\\src\\binnaryencryption\\pxdHYA.jpg"));
        
        infoLabel = new JLabel("/*\n"
                + " * To change this license header, choose License Headers in Project Properties.\n"
                + " * To change this template file, choose Tools | Templates\n"
                + " * and open the template in the editor.\n"
                + "public class BinnaryEncryption extends JFrame {\n"
                + ""
                + "    private static JMenuBar menuBar;\n"
                + "    private static JMenu fileMenu;\n"
                + "    private static JMenu actionMenu;\n"
                + "    private static JMenuItem encryptFile;\n"
                + "    private static JMenuItem decryptFile;\n"
                + "    private static JMenu about;\n"
                + "    private static JMenuItem viewAboItem;\n"
                + "    private static JSplitPane splitPane;\n"
                + "\n");
        
        
        scrollPane.setBounds(20, 10, 500, 300);
        infoLabel.setBounds(550, 10, 150, 500);
        backgroundIamegLabel.setBounds(0, 0, 800, 500);
        runEncryptButton.setBounds(20, 600, 100, 35);
        backButton.setBounds(20,330,100,30);
        infoLabel.setBackground(Color.decode("#1e90ff"));
        scrollPane.getViewport().add(textArea);
        infoLabel.setForeground(Color.WHITE);
        textArea.setForeground(Color.BLUE);
        textArea.setBackground(Color.black);
        backButton.setForeground(Color.white);
        backButton.setBackground(Color.red);
        backButton.setBorder( new LineBorder(Color.red));

        textArea.setText("Encrypt Console/>");

        textArea.addMouseListener(
                new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent event) {
                List<String> cipherLines = EncryptView.getCipherTextLogs();
                
                    textArea.append("1110110111111101001100010001111011011111101111\n"
                            + "1110010110010001010001111011111010111111111011\n"
                            + "01001111010101111011010101100011001000000111111\n"
                            + "10010100000101110110001111100011100010000110111\n"
                            + "100110101000111100101111000001101100000111011110\n"
                            + "10100111110000000010110100110110101011101010110\n"
                            + "0010000\n"
                            + "1110110111111101001100010001111011011111101111\n"
                            + "111001011001000101000111101111101011111111101101\n"
                            + "001111010101111011010101100011001000000111111100\n"
                            + "101000001011101100011111000111000100001101111001\n"
                            + "101010001111001011110000011011000001110111101010\n"
                            + "01111100000000101101001101101010111010101100010000\n"
                            + "1110110111111101001100010001111011011111101111\n"
                            + "11100101100100010100011110111110101111111110110100\n"
                            + "11110101011110110101011000110010000001111111001010\n"
                            + "00001011101100011111000111000100001101111001101010\n"
                            + "00111100101111000001101100000111011110101001111100\n"
                            + "000000101101001101101010111010101100010000\n"
                            + "1110110111111101001100010001111011011111101111\n"
                            + "111001011001000101000111101111101011111111101101001\n"
                            + "1110101011110110101011000110010000001111111001010\n"
                            + "00001011101100011111000111000100001101111001101\n"
                            + "0100011110010111100000110110000011101111010100111\n"
                            + "1100000000101101001101101010111010101100010000\n"
                            + "11101101111111010011000100011110110111111011111110010\n"
                            + "11001000101000111101111101011111111101101001111010101\n"
                            + "11101101010110001100100000011111110010100000101110110\n"
                            + "00111110001110001000011011110011010100011110010111100\n"
                            + "00011011000001110111101010011111000000001011010011011\n"
                            + "01010111010101100010000\n"
                            + "111011011111110100110001000111101101111110111111100101100100010100011110111110101111111110110100111101010111101101010110001100100000011111110010100000101110110001111100011100010000110111100110101000111100101111000001101100000111011110101001111100000000101101001101101010111010101100010000\n"
                            + "111011011111110100110001000111101101111110111111100101100100010100011110111110101111111110110100111101010111101101010110001100100000011111110010100000101110110001111100011100010000110111100110101000111100101111000001101100000111011110101001111100000000101101001101101010111010101100010000\n"
                            + "111011011111110100110001000111101101111110111111100101100100010100011110111110101111111110110100111101010111101101010110001100100000011111110010100000101110110001111100011100010000110111100110101000111100101111000001101100000111011110101001111100000000101101001101101010111010101100010000\n");
            }
        }
        );

        backButton.addActionListener( e -> BinnaryEncryption.replaceRightComponent( new EncryptView()));
        
        add(runEncryptButton);
        add(scrollPane);
        add(infoLabel);
        add(backButton);
        add(backgroundIamegLabel);
    }
}
