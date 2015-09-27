/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package P2_Chess;

/**
 *
 * @author Roberto
 */
public class Jugador {
    
    public String usuario, password;
    public int puntos;
    public boolean isLoggedIn;
    
    public Jugador(String usuario, String password){
        this.usuario=usuario;
        this.password=password;
        puntos = 0;
        isLoggedIn = false;
        
    } 
    
    public Jugador(String usuario, int puntos, boolean isLoggedIn)
    {
        this.usuario = usuario;
        this.puntos = puntos;
        this.isLoggedIn = isLoggedIn;
    }
    
    public Jugador(String usuario,String pass, int puntos)
    {
        this.usuario = usuario;
        password = pass;
        this.puntos = puntos;
        //this.isLoggedIn = true;
    }
    
}
