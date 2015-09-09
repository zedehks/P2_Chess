/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package P2_Chess;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Scanner;

/**
 *
 * @author Roberto
 */
public class Data {
    
    public static File savefolder = null;
    public static String folder_dir;
    
    public static File savefile = null;
    public static String file_dir;
    
    public static Scanner reader;
    
    public static int i=1;
    
        
    public static void createFolder(){
            folder_dir = "usuarios";
            savefolder = new File(folder_dir);
            savefolder.mkdirs();
    }
    
    public static void createSaveFile() throws FileNotFoundException{ 

            file_dir = folder_dir+"/savefiles";
            savefile = new File(file_dir);
            try{
                
                savefile.createNewFile();    
                
            }catch(IOException e){
                System.out.println(e.getMessage());
            }
    }
        
    public static Jugador createPlayer(String u, String p) throws FileNotFoundException{
                
        Jugador newPlayer = new Jugador(u, p);
        newPlayer.isLoggedIn = true;
        return newPlayer;                           
    }
    
    public static void fileWritter(Jugador newPlayer) throws IOException{                   
        try(RandomAccessFile raf = new RandomAccessFile(savefile, "rw")){
            
            raf.seek(raf.length());
            raf.writeUTF(newPlayer.usuario);
            raf.writeUTF(newPlayer.password);
            //raf.writeInt(newPlayer.puntos);
            
        }catch(IOException e){
            System.out.println(e.getMessage());
        }
    }
    
    
    public static boolean login(String u, String p) throws IOException{
        try(RandomAccessFile raf = new RandomAccessFile(savefile, "r")){ 

        raf.seek(0);
        while(raf.getFilePointer() < raf.length()){
            String user = raf.readUTF();
            String pass = raf.readUTF();
            long pos = raf.getFilePointer();
            if(u.equals(user)){
                raf.seek(pos);
                System.out.println("Usuario Correcto!");
                if(p.equals(pass)){
                    System.out.println("Password Correcto!");
                    raf.seek(pos);
                    return true;
                }
                else{
                    System.out.println("Password Incorrecto!");
                    raf.seek(pos);
                    break;
                }
            }
             
        } 
            
        }catch(IOException e){
            System.out.println(e.getMessage());
        }catch(NullPointerException e){
            System.out.println(e.getMessage());
        }
        return false;
    }
    
    public static void fileReader(Jugador user) throws FileNotFoundException{
        
        
    }
    
         
}
