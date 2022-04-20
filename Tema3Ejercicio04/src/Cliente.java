import java.io.*;
import java.net.*;
import java.util.Scanner;
        
public class Cliente {
    private static int PUERTO = 5000;
    private static String HOST = "localhost";
    
    public static void main (String args[]){
        DataInputStream entrada;
        DataOutputStream salida;
        Socket conexion;
        Scanner sc = new Scanner(System.in);
        int numero = 1;
        
        try{
            conexion = new Socket(HOST,PUERTO);
            entrada = new DataInputStream(conexion.getInputStream());
            salida = new DataOutputStream(conexion.getOutputStream());
            
            
            String mensajeRecibido = entrada.readUTF();
            System.out.println(mensajeRecibido);
            numero = sc.nextInt();
            salida.writeInt(numero);
            mensajeRecibido = entrada.readUTF();
            System.out.println(mensajeRecibido);     
            
            
            entrada.close();
            salida.close();
            conexion.close();

        }catch (IOException e){
            System.out.println("Error");
        }  
    }
}
