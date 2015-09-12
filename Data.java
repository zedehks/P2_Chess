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
    public static final String ROOT = "usuarios";    
    public static RandomAccessFile savefile;   
    public static Scanner reader;
        
        
    public static void createFolder(){
            savefolder = new File(ROOT);
            savefolder.mkdirs();
    }
    
    public static void createSaveFile() throws FileNotFoundException{ 

            //file_dir = ROOT+"/savefiles.cht";
            //savefile = new RandomAccessFile(file_dir , "rw");
            try{
                savefile = new RandomAccessFile(ROOT+"/savefiles.cht" , "rw");
                savefile.seek(savefile.length());
                savefile.writeUTF("admin");
                savefile.writeUTF("admin");
                //savefile.createNewFile();    
                
            }catch(IOException e){
                System.out.println(e.getMessage());
            }
    }
        
    public static Jugador createPlayer(String u, String p) throws FileNotFoundException{
                
        Jugador newPlayer = new Jugador(u, p);
        newPlayer.isLoggedIn = true;
        return newPlayer;                           
    }
    
    public static boolean playerExist(String u) throws IOException{
        try(RandomAccessFile raf = new RandomAccessFile(ROOT+"/savefiles.cht", "rw")){
            raf.seek(0);
            while(raf.getFilePointer()<raf.length()){
                String user = raf.readUTF();
                if(u.equals(user)){
                    System.out.println("Usuario ya existe");
                    return false;
                }
            }           
        }catch(IOException e){
            
        }
        return true;
    }
    
    public static boolean passwordValid(String p){
        if(p.length() == 5){
            return true;
        }
        System.out.println("Password must contain 5 Char!");
        return false;
    }
    
    public static void fileWritter(Jugador newPlayer) throws IOException{                   
        try(RandomAccessFile raf = new RandomAccessFile(ROOT+"/savefiles.cht", "rw")){
            
            raf.seek(raf.length());
            raf.writeUTF(newPlayer.usuario);
            raf.writeUTF(newPlayer.password);
            raf.writeInt(newPlayer.puntos);
            
        }catch(IOException e){
            System.out.println(e.getMessage());
        }
    }
      
    public static boolean login(String u, String p) throws IOException{
        
        try(RandomAccessFile raf = new RandomAccessFile(ROOT+"/savefiles.cht", "rw")){ 

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
                    raf.seek(raf.length());
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
