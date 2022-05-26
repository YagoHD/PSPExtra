import java.io.*;
import java.net.*;
import java.util.Scanner;

public class Cliente {
    static DataInputStream entrada;
    static DataOutputStream salida;
    static Socket conexion;
    
    public static void main(String[] args) {
        try{
            conexion = new Socket("localhost",5000);
            entrada = new DataInputStream(conexion.getInputStream());
            salida = new DataOutputStream(conexion.getOutputStream());
            
            Scanner sc= new Scanner(System.in);
            String mensajeEnviado, mensajeRecibido;
            System.out.print("Servidor: ");
            System.out.println(entrada.readUTF());
            System.out.print("Cliente: ");
            mensajeEnviado = sc.nextLine();
            do{
            salida.writeUTF(mensajeEnviado);
            System.out.print("Servidor: ");
            System.out.println(entrada.readUTF());
            System.out.print("Cliente: ");
            mensajeEnviado = sc.nextLine();
            }while (!"Adios".equals(mensajeEnviado));
            salida.writeUTF(mensajeEnviado);
            entrada.close();
            salida.close();
            conexion.close();
        }catch(IOException e){System.out.println("Error");}
    }
}
