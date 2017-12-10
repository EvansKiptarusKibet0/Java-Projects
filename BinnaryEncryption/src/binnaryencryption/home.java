/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package binnaryencryption;

import java.awt.Color;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

public class home extends JPanel{
    
    private static JLabel backgroundImageLabel;
    private static JLabel pNameLabel;
    private static JButton encryptAFile;
    
    public home(){
        
        setLayout(null);
        setBackground(Color.WHITE);
        
        pNameLabel = new JLabel("Binnary Encryptor", new ImageIcon(getClass().getResource("/appimages/ic_launcher.png")),SwingConstants.CENTER);
        backgroundImageLabel = new JLabel( new ImageIcon(getClass().getResource("/appimages/pxdHYA.jpg")));
        
        backgroundImageLabel.setBounds(0,0,800,500);
        pNameLabel.setBounds(150,200,500,50);
        encryptAFile = new JButton("QUCK START");
        encryptAFile.setForeground(Color.white);
        encryptAFile.setBackground(Color.blue);
        encryptAFile.setBorder( new LineBorder(Color.blue));
        
        pNameLabel.setFont( new Font("Calibri BOLD",Font.BOLD,50));
        pNameLabel.setForeground(Color.red);
        
        encryptAFile.addActionListener(e -> {
            BinnaryEncryption.replaceRightComponent( new EncryptView());
        });
        
        add(pNameLabel);
        add(encryptAFile);
        add(backgroundImageLabel);
    }
}
