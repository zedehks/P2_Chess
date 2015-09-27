    /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package P2_Chess;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Roberto
 */
public class Data {
    public Scanner lea = new Scanner(System.in);
    public static File savefolder = null;
    public static final String ROOT = "usuarios";    
    public static RandomAccessFile savefile;   
    public static Scanner reader;
    static File logs = null; //heheheh, logs
    
    public static ArrayList<String> jg = new ArrayList<>();
        
        
    public static void createFolder(){
            savefolder = new File(ROOT);
            savefolder.mkdirs();
            logs = new File(ROOT+"/logs.txt");
            
    }
    static void writeLog(String log)//logs, jajajaja...
    {
        try(FileWriter fw = new FileWriter(logs,true))
        {
            fw.write(log);
        }
        catch(IOException e)
        { System.out.println("nunca hacemos nada con esto so..."); }
    }
    
    static ArrayList<Jugador> getPlayers()
    {
        try(RandomAccessFile raf = new RandomAccessFile(ROOT+"/savefiles.cht", "rw"))
        {
            ArrayList<Jugador> players = new ArrayList<>();
            raf.seek(0);
            while(raf.getFilePointer() < raf.length() )
            {
                String n = raf.readUTF();
                String p = raf.readUTF();
                int w = raf.readInt();
                players.add(new Jugador(n,p,w));                
            }
            return players;
            
            
        }
         catch(IOException e){
             //System.out.println("error en e:" );
             e.printStackTrace();
            return null;
        }
    }
    
    static boolean gameExists(String oponent)
    {
        File game = new File(ROOT+"/"+MainMenu.currentPlayer.usuario);
        
        for(File f : game.listFiles())
        {
            if(new File( ROOT+"/"+MainMenu.currentPlayer.usuario+"/vs"+oponent+".cht" ).exists() )
                return true;
        }
        return false;
    }
    
    //El código de ustedes dos me marea :[ -Waldo
    
    public static void createSaveFile() throws FileNotFoundException{ 

            try{
                savefile = new RandomAccessFile(ROOT+"/savefiles.cht" , "rw");
                savefile.seek(savefile.length());
              //  savefile.writeUTF("admin");
              //  savefile.writeUTF("admin");
               // savefile.writeInt(0);   
                
            }catch(IOException e){
                System.out.println(e.getMessage());
            }
    }
        
    public static Jugador createPlayer(String u, String p) throws FileNotFoundException{
                
        Jugador newPlayer = new Jugador(u, p);
        new File(ROOT+"/"+u).mkdir();
        newPlayer.isLoggedIn = true;
        return newPlayer;                           
    }
    
    public static boolean playerExist(String u){
        
        try(RandomAccessFile raf = new RandomAccessFile(ROOT+"/savefiles.cht", "rw")){
            raf.seek(0);
            while(raf.getFilePointer()<raf.length()){
                String user = raf.readUTF();
                if(u.equals(user)){
                    System.out.println("Usuario existe");
                    return false;
                }
            }           
        }catch(IOException e){
            
        }
        return true;
    }//regresa falso si existe, for some reason.... >:[
    
    public static boolean passwordValid(String p){
        if(p.length() == 5){
            return true;
        }
        System.out.println("Password must contain 5 Char!");
        return false;
    }
    
    public static Jugador getJugador(String n)
    {
       try(RandomAccessFile raf = new RandomAccessFile(ROOT+"/savefiles.cht", "rw")){
               
            raf.seek(0);
            while(raf.getFilePointer() < raf.length() )
            {
                String name = raf.readUTF();
                String pass = raf.readUTF();
                int points = raf.readInt();
                if(name.equals(n))
                    return new Jugador(name, pass, points);
            } 
            
        }catch(IOException e){
            System.out.println(e.getMessage());
        }
       return null;
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
    
    public static void fileWriter(Jugador newPlayer) throws IOException
    {                   
        try(RandomAccessFile raf = new RandomAccessFile(ROOT+"/savefiles.cht", "rw"))
        {        
            raf.seek(0);
            while(raf.getFilePointer() < raf.length())
            {
                String name = raf.readUTF();
                System.out.println("Escribiendole los puntos a "+name);
                if(name.equals(newPlayer.usuario))
                {
                    raf.readUTF();
                    raf.writeInt(newPlayer.puntos);
                    break;
                }
                else
                {
                    System.out.println( raf.readUTF() );
                    System.out.println( raf.readInt() );
                }
            }
            
        }
        catch(IOException e)
        {
            System.out.println(e.getMessage());
        }
    }
      
    public static boolean login(String u, String p) throws IOException{
        
        try(RandomAccessFile raf = new RandomAccessFile(ROOT+"/savefiles.cht", "rw")){ 

        raf.seek(0);
        while(raf.getFilePointer() < raf.length()){
            String user = raf.readUTF();
            long pos = raf.getFilePointer();
            String pass = raf.readUTF();
            
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
    
    public static void changePassword(String u, String p, String np)throws IOException{
        
        try(RandomAccessFile raf = new RandomAccessFile(ROOT+"/savefiles.cht", "rw")){ 

        raf.seek(0);
        while(raf.getFilePointer() < raf.length()){
            String user = raf.readUTF();
            long pos = raf.getFilePointer();
            String pass = raf.readUTF();
            if(u.equals(user)){
                System.out.println("Usuario Correcto!");
                if(p.equals(pass)){
                    System.out.println("Password Correcto!");
                        raf.seek(pos);
                        raf.writeUTF(np);    
                    }
                }
            }   
        }
    }
    
    
         
}
