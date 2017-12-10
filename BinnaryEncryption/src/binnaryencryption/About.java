/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package binnaryencryption;

import java.awt.Color;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JLabel;


public class About extends JDialog{
    
    private static JLabel creator;
    private static JLabel copyRight;
    private static JLabel backfg;
    
    public About(){
        setSize(450,200);
        setLocation(300,150);
        setLayout(null);
        setResizable(false);
        setBackground(Color.WHITE);
        
        creator = new JLabel("Designed and Develoepd by Isaac Wamalwa");
        copyRight = new JLabel("(c) Isaac Wamalwa 2017");
        backfg = new JLabel( new ImageIcon(getClass().getResource("/appimages/pxdHYA.jpg")));
        
        creator.setBounds(10,10,450,25);
        copyRight.setBounds(70,45,450,25);
        backfg.setBounds(0,0,700,700);
        
        backfg.setFont( new Font("Calibri",Font.BOLD,16));
        creator.setFont( new Font("Calibri BOLD", Font.BOLD,22));
        copyRight.setFont( new Font("Calibri BOLD", Font.BOLD,22));
       
       creator.setForeground(Color.RED);
       copyRight.setForeground(Color.red);
        
        
        add(creator);
        add(copyRight);
        add(backfg);
        
        repaint();
        setVisible(true);
    }
}
