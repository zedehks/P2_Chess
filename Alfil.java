/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package P2_Chess;

import javax.swing.ImageIcon;

/**
 *
 * @author waldonavas
 */
public class Alfil extends Ficha
{
    public Alfil(char colour, int x, int y)
    {
        super();
        this.colour = colour;
        switch(colour)
        {
            case 'w':
                this.setIcon(new ImageIcon(getClass().getResource("/P2_Chess/sprites/Weiß/bishop.png")));
                break;
            case 'b':
                this.setIcon(new ImageIcon(getClass().getResource("/P2_Chess/sprites/Schwarz/bishop.png")));
        }
        
        this.x = x;
        this.y = y;
        
        this.setLocation(PosX.get(x), PosY.get(y));
        
        hasMoved = false;
        isDed = false;
        
        this.setToolTipText(x+":"+y);
        this.setVisible(true);
        this.setSize(new java.awt.Dimension(71,71));
        
        
    }

    @Override
    void showAvailableMoves()
    {
        super.showAvailableMoves();
        
        super.diagonalMovement();
    }
}
