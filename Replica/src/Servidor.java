import java.io.*;
import java.net.*;

public class Servidor {
    static DataInputStream entrada;
    static DataOutputStream salida;
    static Socket conexion;
    static ServerSocket servidor;
    
    public static void main(String[] args) {
        try {
            servidor = new ServerSocket(5000);
            System.out.println("Servidor iniciado");
            while(true){
                try {
                    conexion = servidor.accept();
                    System.out.println("Cliente conectado");
                    entrada = new DataInputStream(conexion.getInputStream());
                    salida = new DataOutputStream(conexion.getOutputStream());

                    String mensaje;
                    mensaje = entrada.readUTF();
                    while (!"Adios".equals(mensaje)){
                        salida.writeUTF(mensaje);
                        mensaje = entrada.readUTF();
                    }
                    
                    conexion.close();
                    salida.close();
                    entrada.close();
                } catch (Exception e) {System.out.println("Error entrada/salida");}
            }
        } catch (Exception e) {System.out.println("Error conexion");}
    }
}
