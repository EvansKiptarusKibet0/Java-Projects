/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package binnaryencryption;

import javax.swing.Box;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JSplitPane;


public class BinnaryEncryption extends JFrame {
    
    private static JMenuBar menuBar;
    private static JMenu fileMenu;
    private static JMenu actionMenu;
    private static JMenuItem encryptFile;
    private static JMenuItem decryptFile;
    private static JMenu about;
    private static JMenuItem viewAboItem;
    private static JSplitPane splitPane;
    private static JMenuItem aboutButton;

    public BinnaryEncryption(){
        
        setSize(1000, 550);
        setLocation(80, 0);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setLayout(null);
        
        splitPane = new JSplitPane();
        menuBar = new JMenuBar();
        fileMenu = new JMenu("File");
        actionMenu = new JMenu("Action");
        about =new JMenu("About");
        aboutButton = new JMenuItem();
        encryptFile = new JMenuItem("Encrypt File");
        decryptFile = new JMenuItem("Decrypt File");
        
        splitPane.setDividerSize(1);
        splitPane.setDividerLocation(200);
        splitPane.setEnabled(false);
        
        splitPane.setBounds(0,0,1000,500);
        splitPane.setRightComponent( new home());
        splitPane.setLeftComponent( new MainNavigationMenu(this));
        
        setJMenuBar(menuBar);
        
        menuBar.add(fileMenu);
        menuBar.add(actionMenu);
        menuBar.add(about);
        about.add(aboutButton);
        
        actionMenu.add(Box.createHorizontalStrut(200));
        actionMenu.add(encryptFile);
        actionMenu.add(decryptFile);
        
        encryptFile.addActionListener(e -> replaceRightComponent(new EncryptView()));
        decryptFile.addActionListener(e -> replaceRightComponent(new DecryptView()));
        aboutButton.addActionListener(e -> new About());
        
        
        add(splitPane);
        
        repaint();
        setVisible(true);
    }
    
    public static  void replaceRightComponent(JPanel nextPanel){
        splitPane.remove(splitPane.getRightComponent());
        splitPane.setRightComponent(nextPanel);
        splitPane.setDividerLocation(200);
    }
    
        public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(() -> {
            BinnaryEncryption desktopSecure = new BinnaryEncryption();
        });
    }
    
}
