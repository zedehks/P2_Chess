package P2_Chess;

import java.io.Serializable;
import javax.swing.JLabel;

public abstract class Ficha extends JLabel implements Serializable
{
    protected int x,y;
    
    protected char colour;
    
    protected boolean hasMoved;
    
    protected boolean isDed;
    
    public Ficha()
    {
        this.addMouseListener(new java.awt.event.MouseAdapter()
        {
            @Override
            public void mousePressed(java.awt.event.MouseEvent evt)
            {
                PieceMousePressed(evt);
            }
        }); 
    }
    
    ///////////////////
    
    void mover(int x, int y)
    {
        this.x = x;
        this.y = y;
        
        this.hasMoved = true;
        this.setLocation(PosX.get(x), PosY.get(y));
        this.setToolTipText(x+":"+y);
    }
    
    void getEaten()
    {
        this.setVisible(false);
        this.x = -1;
        this.y = -1;
        this.isDed = true;
        this.setSize(0, 0);
        Ajedrez.layers.remove(this);
        switch(colour)
        {
            case 'w':
                Tablero.wPieces.remove(this);
            case 'b':
                Tablero.bPieces.remove(this);
        }
    }
    
    
    void showAvailableMoves()
    {
        Tablero.spawnValidMove(colour,x,y, this, true, false,false);
        //seekTargets();
        
    }
    void PieceMousePressed(java.awt.event.MouseEvent evt)
    {
        //System.out.println("click");
        if(Tablero.turn == this.colour)
        {
            if(Tablero.isMoving )
            {
                Ajedrez.cleanGlows();
            }
            showAvailableMoves();
            Tablero.isMoving = true;
            
        }
    }
    

    /********************
    *
    *Movement Prototypes
    *
    ********************/

    void crossMovement()
    {
        
        int xPos = x;
        int yPos = y;
        while(true)
        {
            xPos += 1;
            if(xPos > 8)
                break;
            if(!Tablero.spawnValidMove(colour, xPos, y, this, false, false,false))
            {
                if(Tablero.checkSpace(xPos, y).colour != this.colour )
                    Tablero.spawnValidMove(colour, xPos, y, this, false, true,false);
                break;
            } 
        }
        xPos = x;
        while(true)
        {
            xPos -= 1;
            if(xPos < 1)
                break;
            if(!Tablero.spawnValidMove(colour, xPos, y, this, false, false,false))
            {
                if(Tablero.checkSpace(xPos, y).colour != this.colour )
                    Tablero.spawnValidMove(colour, xPos, y, this, false, true,false);
                break;
            }
        }
        
        while(true)
        {
            yPos += 1;
            if(yPos > 8)
                break;
            if(!Tablero.spawnValidMove(colour, x, yPos, this, false, false,false))
            {
                if(Tablero.checkSpace(x, yPos).colour != this.colour )
                    Tablero.spawnValidMove(colour, x, yPos, this, false, true,false);
                break;
            } 
        }
        yPos =y;
        while(true)
        {
            yPos -= 1;
            if(yPos < 1)
                break;
            if(!Tablero.spawnValidMove(colour, x, yPos, this, false, false,false))
            {
                if(Tablero.checkSpace(x, yPos).colour != this.colour )
                    Tablero.spawnValidMove(colour, x, yPos, this, false, true,false);
                break;
            } 
        }
    }
    
    void diagonalMovement()
    {
        int xPos = x;
        int yPos = y;
        while(true)
        {
            xPos += 1;
            yPos += 1;
            if(xPos > 8 || yPos > 8)
                break;
            if(!Tablero.spawnValidMove(colour, xPos, yPos, this, false, false,false))
            {
                if( (Tablero.checkSpace(xPos,yPos)).colour != this.colour )
                    Tablero.spawnValidMove(colour, xPos, yPos, this, false, true,false);
                break; 
            }
        }
        xPos = x;
        yPos = y;
        while(true)
        {
            xPos -= 1;
            yPos -= 1;
            if(xPos < 1 || yPos < 1)
                break;
            if(!Tablero.spawnValidMove(colour, xPos, yPos, this, false, false,false))
            {
                if( (Tablero.checkSpace(xPos,yPos)).colour != this.colour )
                    Tablero.spawnValidMove(colour, xPos, yPos, this, false, true,false);
                break; 
            }
        }
        xPos = x;
        yPos = y;
        while(true)
        {
            yPos += 1;
            xPos -= 1;
            if(yPos > 8 || xPos < 1)
                break;
            if(!Tablero.spawnValidMove(colour, xPos, yPos, this, false, false,false))
            {
                if( (Tablero.checkSpace(xPos,yPos)).colour != this.colour )
                    Tablero.spawnValidMove(colour, xPos, yPos, this, false, true,false);
                break; 
            } 
        }
        xPos = x;
        yPos = y;
        while(true)
        {
            yPos -= 1;
            xPos += 1;
            if(yPos < 1 || xPos > 8)
                break;
            if(!Tablero.spawnValidMove(colour, xPos, yPos, this, false, false,false))
            {
                if( (Tablero.checkSpace(xPos,yPos)).colour != this.colour )
                    Tablero.spawnValidMove(colour, xPos, yPos, this, false, true,false);
                break; 
            } 
        }
        
    }
    
    void seekTargets(boolean isChecking4Checkmate)
    {
        if(this instanceof Torre)
            seekCross();
        else if (this instanceof Alfil)
            seekDiagonal();
        else if (this instanceof Reina)
        {
            seekCross();
            seekDiagonal();
        }
        
            
    }
    
    void seekCross()
    {
        Ficha target;
        int xPos = x;
        int yPos = y;
        while(true)
        {
            xPos += 1;
            if(xPos > 8)
                break;
            target = Tablero.checkSpace(xPos, y);
            if (!check4Check(target))
                break;
        }
        xPos = x;
        while(true)
        {
            xPos -= 1;
            if(xPos < 1)
                break;
            target = Tablero.checkSpace(xPos, y);
            if (!check4Check(target))
                break;
        }
        
        while(true)
        {
            yPos += 1;
            if(yPos > 8)
                break;
            target = Tablero.checkSpace(x, yPos);
            if (!check4Check(target))
                break;
        }
        yPos =y;
        while(true)
        {
            yPos -= 1;
            if(yPos < 1)
                break;
            target = Tablero.checkSpace(x, yPos);
           if (!check4Check(target))
                break;
        }
    }
    
    void seekDiagonal()
    {
        Ficha target;
        int xPos = x;
        int yPos = y;
        while(true)
        {
            xPos += 1;
            yPos += 1;
            if(xPos > 8 || yPos > 8)
                break;
            target = Tablero.checkSpace(xPos,yPos);
            if (!check4Check(target))
                break;
            
        }
        xPos = x;
        yPos = y;
        while(true)
        {
            xPos -= 1;
            yPos -= 1;
            if(xPos < 1 || yPos < 1)
                break;
            target = Tablero.checkSpace(xPos,yPos);
            if (!check4Check(target))
                break;
        }
        xPos = x;
        yPos = y;
        while(true)
        {
            yPos += 1;
            xPos -= 1;
            if(yPos > 8 || xPos < 1)
                break;
            target = Tablero.checkSpace(xPos,yPos);
            if (!check4Check(target))
                break;
        }
        xPos = x;
        yPos = y;
        while(true)
        {
            yPos -= 1;
            xPos += 1;
            if(yPos < 1 || xPos > 8)
                break;
            target = Tablero.checkSpace(xPos,yPos);
            if (!check4Check(target))
                break;
        }
    }
    
    boolean check4Check(Ficha target)
    {
        if(target != null)
        {
            if(target.colour != this.colour)
            {
                if(target instanceof Rey)
                {
                    Tablero.broadcastCheck(target.colour);
                    Tablero.spawnValidMove(colour, target.x, target.y, this, false, false, true);
                    return true;
                }
            }
            return false;
        }
        
        
        return true;
    }
}
