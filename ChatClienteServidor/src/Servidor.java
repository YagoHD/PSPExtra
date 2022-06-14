import java.io.*;
import java.net.*;
import java.util.Scanner;

public class Servidor {
    static DataInputStream entrada;
    static DataOutputStream salida;
    static Socket conexion;
    static ServerSocket servidor;
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String mensajeRecibido, mensajeEnviado;
        try {
            servidor = new ServerSocket(5000);
            System.out.println("Setvidor Iniciado");
            while(true){
                try {
                    conexion = servidor.accept();
                    entrada = new DataInputStream(conexion.getInputStream());
                    salida = new DataOutputStream(conexion.getOutputStream());
                    
                    mensajeRecibido = entrada.readUTF();
                    while(!"Adios".equals(mensajeRecibido)){
                        System.out.print("Cliente: ");
                        System.out.println( mensajeRecibido);
                        System.out.print("Servidor: ");
                        mensajeEnviado = sc.nextLine();
                        salida.writeUTF(mensajeEnviado);
                        mensajeRecibido = entrada.readUTF();
                    }
                    System.out.println("Cliente desconectado");
                    entrada.close();
                    salida.close();
                    conexion.close();
                } catch (Exception e) {System.out.println("Error netrada/salida");}
            }
        } catch (Exception e) {System.out.println("Error");}
    }
}
