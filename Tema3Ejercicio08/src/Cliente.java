import java.io.*;
import java.net.*;
import java.util.Scanner;

public class Cliente {
    static DataInputStream entrada;
    static DataOutputStream salida;
    static Socket conexion;
    
    public static void main(String[] args) {
        try {
            Scanner sc = new Scanner(System.in);
            conexion = new Socket("localhost", 5000);
            System.out.println("Conectado al servidor");
            entrada = new DataInputStream(conexion.getInputStream());
            salida = new DataOutputStream(conexion.getOutputStream());
            
            System.out.println("Escribe mensajes el servidor de los mandara de vuelta, para salir escribe Adios");
            String mensajeEnviado;
            mensajeEnviado=sc.nextLine();
            salida.writeUTF(mensajeEnviado);
            
            while(!"Adios".equals(mensajeEnviado) ){
                System.out.println(entrada.readUTF());
                mensajeEnviado=sc.nextLine();
                salida.writeUTF(mensajeEnviado);
            }
            
        } catch (IOException e) {System.out.println("Error");
        }
    }
}
