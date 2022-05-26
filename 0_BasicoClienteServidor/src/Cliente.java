import java.util.Scanner;
import java.io.*;
import java.net.*;

public class Cliente {
    static DataInputStream entrada;
    static DataOutputStream salida;
    static Socket conexion;
    
    public static void main(String[] args) {
        try{
            conexion = new Socket("localhost",5000);
            entrada = new DataInputStream(conexion.getInputStream());
            salida = new DataOutputStream(conexion.getOutputStream());
            
            
            
            
            conexion.close();
            salida.close();
            entrada.close();
        }catch(IOException e){System.out.println("Error");}
    }
}
