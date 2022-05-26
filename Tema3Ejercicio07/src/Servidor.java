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
            System.out.println("Esperando una conexion");
            
            while(true){
            conexion = servidor.accept();
            System.out.println("Cliente conectado");
            entrada = new DataInputStream(conexion.getInputStream());
            salida = new DataOutputStream(conexion.getOutputStream());
            
            int numeroRecibido=0,a,b, resultado; 
            
            while(numeroRecibido!=5){
            numeroRecibido= entrada.readInt();
            switch (numeroRecibido) {
                case 1:
                    salida.writeUTF("Escribe el primer numero: ");
                    a=entrada.readInt();
                    salida.writeUTF("Escribe el segundo numero: ");
                    b=entrada.readInt();
                    resultado = a+b;
                    salida.writeUTF("El resultado es: "+resultado);
                    break;
                case 2:
                    salida.writeUTF("Escribe el primer numero: ");
                    a=entrada.readInt();
                    salida.writeUTF("Escribe el segundo numero: ");
                    b=entrada.readInt();
                    resultado = a-b;
                    salida.writeUTF("El resultado es: "+resultado);
                    break;
                case 3:
                    salida.writeUTF("Escribe el primer numero: ");
                    a=entrada.readInt();
                    salida.writeUTF("Escribe el segundo numero: ");
                    b=entrada.readInt();
                    resultado = a*b;
                    salida.writeUTF("El resultado es: "+resultado);
                    break;
                case 4:
                    salida.writeUTF("Escribe el primer numero: ");
                    a=entrada.readInt();
                    salida.writeUTF("Escribe el segundo numero: ");
                    b=entrada.readInt();
                    resultado = a/b;
                    salida.writeUTF("El resultado es: "+resultado);
                    break;
                case 5:
                    System.out.println("Cliente desconectado");
                    entrada.close();
                    salida.close();
                    conexion.close();
                    break;
                default:
                    salida.writeUTF("Introduce un numero valido.");
                    System.out.println("Introduce un numero valido.");
                    break;
            }
            }
           
            }
        }catch(IOException e){System.out.println("Error");}
    }
}
