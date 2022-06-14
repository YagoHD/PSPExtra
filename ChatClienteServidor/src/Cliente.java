import java.io.*;
import java.net.*;
import java.util.Scanner;

public class Cliente {
    static DataInputStream entrada;
    static DataOutputStream salida;
    static Socket conexion;
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String mensajeRecibido, mensajeEnviado;
        try {
            conexion = new Socket("localhost", 5000);
            entrada = new DataInputStream(conexion.getInputStream());
            salida = new DataOutputStream(conexion.getOutputStream());
            
            System.out.println("Servidor: Bienvenido");
            System.out.print("Cliente: ");
            mensajeEnviado = sc.nextLine();
            salida.writeUTF(mensajeEnviado);
            while(!"Adios".equals(mensajeEnviado)){
                System.out.print("Servidor: ");
                mensajeRecibido = entrada.readUTF();
                System.out.println(mensajeRecibido);
                System.out.print("Cliente: ");
                mensajeEnviado = sc.nextLine();
                salida.writeUTF(mensajeEnviado);
            }
            entrada.close();
            salida.close();
            conexion.close();
        } catch (Exception e) {System.out.println("Error");}
    }
}
