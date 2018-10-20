/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package characterfrequency;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author silbaughbw02
 */
public class CharacterFrequency {

   // public static List<CharCounter> alphabet = new ArrayList<>();
    public static List<CharCounter> chars = new ArrayList<>();
    public static Decrypter decrypter = new Decrypter();

   /* public static void initAlphabet() {
        String alph = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        for (int i = 0; i < 26; i++) {
            alphabet.add(new CharCounter(alph.charAt(i)));
        }
        for (int i = 0; i < alphabet.size(); i++) {
            findFreq(alphabet.get(i));
        }
    }*/

    /*public static boolean findFreq(CharCounter findThisChar) {
        try (BufferedReader BR = new BufferedReader(new FileReader("BenS.txt"))) {
            String str;

            while ((str = BR.readLine()) != null) {
                for (int i = 0; i < str.length(); i++) {
                    if (str.charAt(i) == findThisChar.getChar()) {
                        findThisChar.iterateChar();
                    }
                }
            }
        } catch (IOException e) {
            System.out.println("File not Found");
        }
        return false;
    }*/

    public static void initChars() {
        for (int i = 0; i < 126; i++) {
            chars.add(new CharCounter(i));
        }
    }

    public static void findFreq(String fileName) {
        try (BufferedReader BR = new BufferedReader(new FileReader(fileName))) {
            String str;

            while ((str = BR.readLine()) != null) {
                decrypter.addLine(str);
                for (int i = 0; i < str.length(); i++) {
                    int index = str.charAt(i);
                    chars.get(index).iterateChar();
                }
            }
        } catch (IOException e) {
            System.out.println("File not Found");
        }
    }

     public static void printCheck() {
        try (BufferedReader BR = new BufferedReader(new FileReader("BenS.txt"))) {
            String str;
            String newStr="";

            while ((str = BR.readLine()) != null) {
                newStr="";
                for (int i = 0; i < str.length(); i++) {
                    
                    int index = str.charAt(i);
                    if(index >= 65 && index <= 90)
                        newStr+= chars.get(index).changeChar();
                    else
                        newStr+= str.charAt(i);
                    
                }
                System.out.println(newStr);
            }
        } catch (IOException e) {
            System.out.println("File not Found");
        }
    }
     public static void bonusCheck() {
        try (BufferedReader BR = new BufferedReader(new FileReader("bonus.txt"))) {
            String str;
            String newStr="";

            while ((str = BR.readLine()) != null) {
                newStr="";
                for (int i = 0; i < str.length(); i++) {
                    
                    int index = str.charAt(i);
                    if(index >= 65 && index <= 90)
                        newStr+= chars.get(index).changeCharBonus();
                    else
                        newStr+= str.charAt(i);
                    
                }
                System.out.println(newStr);
            }
        } catch (IOException e) {
            System.out.println("File not Found");
        }
    }
    public static void main(String[] args) {
        /*initAlphabet();
        for (int i = 0; i < alphabet.size(); i++) {
            System.out.println(alphabet.get(i).getChar() + " :" + alphabet.get(i).getCount());
        }
        System.out.println("--------------------------------------------");
        */
        initChars();
        findFreq("BenS.txt");
        for (int i = 0; i < chars.size(); i++) {
            System.out.println(chars.get(i).getChar() + ": " + chars.get(i).getCount());
        }
       printCheck();
       System.out.println("\n\n\n\n\n\n");
       bonusCheck();
        //for (int i = 0; i < chars.size(); i++) {
            //System.out.println(chars.get(i).getChar() + ": " + chars.get(i).getCount());
        //}
        
    }

}
