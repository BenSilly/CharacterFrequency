/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package characterfrequency;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 *
 * @author Ben
 */
public class Decrypter {
    private String message;
    private List<CharCounter> frequencies;
    private List<String> lines = new ArrayList<String>();
    public Comparator<CharCounter> charCountCompare = new Comparator<CharCounter>(){
        
        @Override
        public int compare(CharCounter c1, CharCounter c2) {
            Integer c1Count = c1.getCount();
            Integer c2Count = c2.getCount();
            return c2Count.compareTo(c1Count);
        }
    };
    
    public Decrypter (){
        message = "";
        frequencies = CharacterFrequency.chars;
        Collections.sort(frequencies, charCountCompare);
        List<Character> encrypt = new ArrayList<Character>();
        for(int i=0; i<frequencies.size(); i++){
            encrypt.add(frequencies.get(i).getChar());
        }
        Key key = new Key(encrypt);
    }
    
    public void addLine(String line){
        lines.add(line);
    }
    public void print(){
         for(int i=0; i<frequencies.size(); i++){
             if(frequencies.get(i).getIndex() >=64 && frequencies.get(i).getIndex()<=90)
                System.out.println(frequencies.get(i).getChar()+": "+ frequencies.get(i).getCount());
        }
    }
    
}
