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
    public static List<CharCounter> chars = new ArrayList<>();  //Every time chars is used, it looks up by index then calls a method on a CharCounter. Let's create a custom list type to simplify its use
    public static Decrypter decrypter = new Decrypter();
   
   // You're using source control; you can delete commented out code and recover it later
   
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
        try (BufferedReader BR = new BufferedReader(new FileReader(fileName))) { // Very good. Wasn't expecting a good try-with-resources block
            String str;

            while ((str = BR.readLine()) != null) {
                decrypter.addLine(str);
                for (int i = 0; i < str.length(); i++) {  // use String.toCharArray() to get an array of characters to iterate over the string characters
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
                newStr="";  // often, having to reset a variable to  blank state is an indicator that you need another scope for it
                            // plus, it's often better to try to have only one or two lines inside a loop body; the extracted method
                            // labels succinctly what is happening in the loop.
                for (int i = 0; i < str.length(); i++) { // use String.toCharArray() to get an array of characters to iterate over the string characters
                    
                    int index = str.charAt(i);
                    // There's no need for this check, as I explain in bonusCheck()
                    if(index >= 65 && index <= 90)
                        newStr+= chars.get(index).changeChar(); // If you're going to build up a String character-by-character, use a StringBuilder
                    else
                        newStr+= str.charAt(i);
                    
                }
                System.out.println(newStr);
            }
        } catch (IOException e) {
            System.out.println("File not Found");
        }
    }
     public static void bonusCheck() { //there's an extra space at the beginning of this line
        try (BufferedReader BR = new BufferedReader(new FileReader("bonus.txt"))) {
            String str;
            String newStr="";

            while ((str = BR.readLine()) != null) {
                newStr="";
                for (int i = 0; i < str.length(); i++) {
                    
                    int index = str.charAt(i);
                   // There's no need for this check; CharCounter.changeCharBonus() already returns the original if it's not one of the ones we want
                   // If performance is your concern, we can try to find a way to increase the performance of CharCounter.changeCharBonus()
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
        for (int i = 0; i < chars.size(); i++) {  // use a iterator for loop
            System.out.println(chars.get(i).getChar() + ": " + chars.get(i).getCount());
        }
       // the next three lines don't line up with the other lines
       printCheck();
       System.out.println("\n\n\n\n\n\n");
       bonusCheck();
        //for (int i = 0; i < chars.size(); i++) {
            //System.out.println(chars.get(i).getChar() + ": " + chars.get(i).getCount());
        //}
        
    }

}
