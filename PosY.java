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
public final class PosY
{
    private final static Hashtable<Integer,Integer> ypos = new Hashtable<>(); 
    
    private static void setValues()
    {
        ypos.put(1,524);
        ypos.put(2,452);
        ypos.put(3,378);
        ypos.put(4,305);
        ypos.put(5,232);
        ypos.put(6,160);
        ypos.put(7,86);
        ypos.put(8,11);      
    }
    
    final static Integer get(int y)
    {
        setValues();
        return ypos.get(y);
    }
    
    
    /**
     * 
     * @param y The y value that you want to start from.
     * @return  The y value of the next Y Position, adjusted for the yellow squares.
     */
    final static int getNext(int y)
    {
        setValues();
        if(y==8)
            y=0;
        return ypos.get(y+1)-7;
    }
}
