import java.io.*;
import java.net.*;

public class Servidor {
    static DataInputStream entrada;
    static DataOutputStream salida;
    static Socket conexion;
    static ServerSocket servidor;
    
    public static void main(String[] args) {
        try{
            servidor = new ServerSocket(5000);
            System.out.println("---SERVIDOR INICIADO---");
            while(true){
            try{
                conexion = servidor.accept();
                System.out.println("--CLIENTE CONECTADO--");
                entrada = new DataInputStream(conexion.getInputStream());
                salida = new DataOutputStream(conexion.getOutputStream());
                
                
                
                
                conexion.close();
                salida.close();
                entrada.close();
            }catch(IOException e){System.out.println("Error entrada/salida");}
            }
        }catch(IOException e){System.out.println("Error");}
    }
}

