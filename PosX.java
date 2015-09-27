/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package P2_Chess;

import java.util.Hashtable;

/**
 *
 * @author waldonavas
 */
public final class PosX
{
    private final static Hashtable<Integer,Integer> xpos = new Hashtable<>();

    private static void setValues()
    {
        xpos.put(1,13);
        xpos.put(2,87);
        xpos.put(3,160);
        xpos.put(4,234);
        xpos.put(5,306);
        xpos.put(6,380);
        xpos.put(7,453);
        xpos.put(8,527);      
    }
    
    final static int get(int x)
    {
        setValues();
        return xpos.get(x);
    }
    
    final static int getNext(int x)
    {
        setValues();
        if(x==8)
            x=0;
        return xpos.get(x+1)-7;
    }
    
    private static int parseLetters(String l)
    {
        switch(l.toLowerCase())
        {
            case "a":
                return 1;
            case "b":
                return 2;
            case "c":
                return 3;
            case "d":
                return 4;
            case "e":
                return 5;
            case "f":
                return 6;
            case "g":
                return 7;
            case "h":
                return 8;
        }
        return 0;
    }

}
