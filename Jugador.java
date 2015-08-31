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
    
    public String nombre, password;
    
    public Jugador(String nombre, String password){
        this.nombre=nombre;
        this.password=password;
    }
    
    public String getNombre(){
        return nombre;
    }
    
    public String getPassword(){
        return password;                
    }
    
}
