/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package binnaryencryption;

import static binnaryencryption.BinnaryEncryption.replaceRightComponent;
import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

public class MainNavigationMenu extends JPanel {

    private static JLabel topSectionLabel;
    private static JButton encryptModeMenu;
    private static JButton decryptModeMenu;
    private static JButton exitButton;
    private static JButton aboutButton;

    public MainNavigationMenu(JFrame rootView) {

        setBackground(Color.WHITE);
        setBounds(0, 0, 200, 500);
        setLayout(null);

        encryptModeMenu = new JButton("Encrypt Mode", new ImageIcon(getClass().getResource("/appimages/ic_action_bicustomicon.png")));
        decryptModeMenu = new JButton("Decrypt Mode", new ImageIcon(getClass().getResource("/appimages/ic_action_payment_icon.png")));
        exitButton = new JButton("Exit", new ImageIcon(getClass().getResource("/appimages/ic_action_backarrow.png")));
        topSectionLabel = new JLabel(new ImageIcon(getClass().getResource("/appimages/topSectionImage.png")));
        aboutButton = new JButton("About", new ImageIcon(getClass().getResource("/appimages/ic_action_about.png")));

        topSectionLabel.setBounds(0, 0, 200, 150);
        encryptModeMenu.setBounds(10, 160, 130, 30);
        decryptModeMenu.setBounds(10, 200, 120, 30);
        aboutButton.setBounds(10, 240, 80, 30);
        exitButton.setBounds(10,290,70,30);

        encryptModeMenu.setBackground(Color.WHITE);
        decryptModeMenu.setBackground(Color.WHITE);
        exitButton.setBackground(Color.WHITE);
        encryptModeMenu.setBorder(new LineBorder(Color.WHITE));
        decryptModeMenu.setBorder(new LineBorder(Color.WHITE));
        exitButton.setBorder(new LineBorder(Color.WHITE));
        aboutButton.setBackground(Color.WHITE);
        aboutButton.setBorder(new LineBorder(Color.WHITE));

        exitButton.addActionListener(e -> {
            rootView.setVisible(false);
        });

        encryptModeMenu.addActionListener(e -> replaceRightComponent(new EncryptView()));
        decryptModeMenu.addActionListener(e -> replaceRightComponent(new DecryptView()));
        aboutButton.addActionListener(e -> new About());

        add(topSectionLabel);
        add(decryptModeMenu);
        add(exitButton);
        add(encryptModeMenu);
        add(aboutButton);
    }

}
