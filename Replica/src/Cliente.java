import java.io.*;
import java.net.*;
import java.util.Scanner;

public class Cliente {
    static DataInputStream entrada;
    static DataOutputStream salida;
    static Socket conexion;
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        try {
            conexion = new Socket("localhost", 5000);
            entrada = new DataInputStream(conexion.getInputStream());
            salida = new DataOutputStream(conexion.getOutputStream());
            
            System.out.println("Intrduce un mensaje el servidor te lo replicara: ");
            String mensaje= sc.nextLine();
            
            while(!"Adios".equals(mensaje)){
                salida.writeUTF(mensaje);
                String mensajeServidor = entrada.readUTF();
                System.out.println(mensajeServidor);
                mensaje= sc.nextLine();
            }
            
            conexion.close();
            entrada.close();
            salida.close();
        } catch (Exception e) {System.out.println("Error");}
    }
}
