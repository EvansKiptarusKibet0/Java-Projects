/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package binnaryencryption;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;



public class BinnaryEncryptionAlogorithm {
    
    
   
    public static String getCipherText(String plainText,int cipherLength) {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("SHA-256"); // Uses MessageDigest to generate a SHA-256 standard cipher 
            byte[] cipherLavelOne = messageDigest.digest(plainText.getBytes()); //executes cycles to randomize the bytes generated
            messageDigest.update(plainText.getBytes()); // the second cipher cycle is executed
            StringBuilder stringBuilder = new StringBuilder(); //processes the cipher text from bytes to readable text (characters)
            /**
             * RANDOMIZATION STEP
             * Loops arround the genrated cipher in memory converting each character into bits (1s and 0s);
             */
            for (int i = 0; i < cipherLavelOne.length; i++) {
                stringBuilder.append(Integer.toString((cipherLavelOne[i] & 0xff) + 0x100, 2)).substring(cipherLength);
            }
            return stringBuilder.toString(); //return the generated bits in a String block 
        } catch (NoSuchAlgorithmException ex) { // handles AlgorithException if system does not support SHA-256
            ex.printStackTrace(); // catches and informs user when system does does not support SHA-256
            return "";
        }

    }

    public static String getCipher(String plainText) {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
            byte[] cipherLavelOne = messageDigest.digest(plainText.getBytes());
            messageDigest.update(plainText.getBytes());
            StringBuilder stringBuilder = new StringBuilder();
            for (int i = 0; i < cipherLavelOne.length; i++) {
                stringBuilder.append(Integer.toString((cipherLavelOne[i] & 0xff) + 0x100, 2)).toString();
            }
            String cipher = stringBuilder.toString();
            return cipher;
        } catch (NoSuchAlgorithmException ex) {
            return "";
        }

    }
}
