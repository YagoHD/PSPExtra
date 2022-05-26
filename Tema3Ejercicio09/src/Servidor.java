import java.io.*;
import java.net.*;
import java.util.Scanner;

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
                    Scanner sc= new Scanner(System.in);
                    conexion = servidor.accept();
                    System.out.println("--Cliente conectado--");
                    entrada = new DataInputStream(conexion.getInputStream());
                    salida = new DataOutputStream(conexion.getOutputStream());
                    String mensajeEnviado, mensajeReibido;

                    salida.writeUTF("Bienvenido");
                    mensajeReibido = entrada.readUTF();
                    System.out.print("Cliente: ");
                    System.out.println(mensajeReibido);
                    while(!"Adios".equals(mensajeReibido)){
                        System.out.print("Servidor: ");
                        mensajeEnviado = sc.nextLine();
                        salida.writeUTF(mensajeEnviado);
                        mensajeReibido = entrada.readUTF();
                        System.out.print("Cliente: ");
                        System.out.println(mensajeReibido);
                    }
                    entrada.close();
                    salida.close();
                    conexion.close();

                }catch(IOException e){System.out.println("Error entrada/salida");}
            }
        }catch(IOException e){System.out.println("Error");}
    }
}
