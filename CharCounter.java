/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package characterfrequency;

/**
 *
 * @author silbaughbw02
 */
public class CharCounter {
    private char character;
    private int count =0;   // Move this 0 assignment to the primary constructor
    private int index;  
    //Add empty lines around methods
    public CharCounter(char character, int index){
        this.character = character;
        this.index = index;
    }
    public CharCounter(char character){
        this.character = character;     // you have a "primary" constructor (one that takes all of the parameters of the others), so you should use that instead of duplicating assignments
        this.index = character;
    }
    public CharCounter(int index){
        this.index = index;
        this.character = (char) index;
    }
    public char getChar(){
        return character;
    }
    public void setCount(int count){
        this.count = count;
    }
    public void iterateChar(){
        count++;
    }
    public int getCount(){
        return count;
    }
    public int getIndex(){
        return index;
    }
    public char changeChar(){
        switch(index){
            case 74:
                return 'E';
            case 70:
                return 'T';
            case 88:
                return 'A';
            case 65:
                return 'O';
            case 68:
                return 'I';
            case 80:
                return 'N';
            case 76:
                return 'R';
            case 73:
                return 'S';
            case 87:
                return 'H';
            case 71:
                return 'D';
            case 72:
                return 'L';
            case 89:
                return 'U';
            case 69:
                return 'C';
            case 67:
                return 'G';
            case 85:
                return 'M'; 
            case 83:
                return 'F';
            case 66:
                return 'W';
            case 90:
                return 'Y';
            case 86:
                return 'P';
            case 77:
                return 'B';
            case 82:
                return 'K';
            case 75:
                return 'V';
            case 84:
                return 'Z';
            case 78:
                return 'X';
            case 79:
                return 'J';
            case 81:
                return 'Q';
        }
        return character;
    }
    
    public char changeCharBonus(){
        switch((char) index){
            case 'Q':
                return 'E';
            case 'N':
                return 'T';
            case 'U':
                return 'A';
            case 'H':
                return 'O';
            case 'M':
                return 'I';
            case 'K':
                return 'N';
            case 'J':
                return 'R';
            case 'G':
                return 'S';
            case 'V':
                return 'H';
            case 'Z':
                return 'D';
            case 'S':
                return 'L';
            case 'T':
                return 'U';
            case 'F':
                return 'C';
            case 'X':
                return 'G';
            case 'A':
                return 'M'; 
            case 'W':
                return 'F';
            case 'E':
                return 'W';
            case 'D':
                return 'Y';
            case 'C':
                return 'P';
            case 'I':
                return 'B';
            case 'R':
                return 'K';
            case 'P':
                return 'V';
            case 'O':
                return 'Z';
            case 'L':
                return 'X';
            case 'B':
                return 'J';
            case 'Y':
                return 'Q';
        }
        return character;
    }
}
