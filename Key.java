/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package characterfrequency;

import java.util.List;

/**
 *
 * @author Ben
 */
public class Key {
    private List<Character> encrypt;
    private List<Character> decrypt;
    public Key (List<Character> encrypt){
        this.encrypt = encrypt;
        for(int i=0; i<encrypt.size();i++){
            System.out.println(encrypt.get(i));
        }
    }
}
