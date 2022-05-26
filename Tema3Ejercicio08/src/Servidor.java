import java.io.*;
import java.net.*;

public class Servidor {
    static  DataInputStream entrada;
    static  DataOutputStream salida;
    static Socket conexion;
    static ServerSocket servidor;
    
    public static void main(String[] args) {
        String mensaje;
        try {
            servidor = new ServerSocket(5000);
            System.out.println("-----Servidor iniciado-----");
            while (true) {
                try {
                    conexion = servidor.accept();
                    entrada = new DataInputStream(conexion.getInputStream());
                    salida = new DataOutputStream(conexion.getOutputStream());
                   
                    mensaje=entrada.readUTF();
                    while (!"Adios".equals(mensaje)) {
                        salida.writeUTF(mensaje);
                        mensaje=entrada.readUTF();
                        
                    }
                    entrada.close();
                    salida.close();
                    conexion.close();
                } catch (Exception e) {
                    System.out.println("Conexion error");
                }

            }
        } catch (IOException e) {System.out.println("Error");
        }
    }
}
