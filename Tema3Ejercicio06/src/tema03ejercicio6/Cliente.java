package tema03ejercicio6;
import java.net.*;
import java.io.*;
import java.util.Scanner;

public class Cliente {
    static DataInputStream entrada;
    static DataOutputStream salida;
    static Socket conexion;
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int numero=1;
        try{
            conexion = new Socket ("localhost", 5000);
            entrada = new DataInputStream(conexion.getInputStream());
            salida = new DataOutputStream(conexion.getOutputStream());
            while(numero!=0){
                System.out.println("Introduce el numero: ");
                numero = sc.nextInt();
                salida.writeInt(numero);
                if (numero!=0) System.out.println(entrada.readUTF());
            }
            System.out.println("Cliente cerrado.");
            
            entrada.close();
            salida.close();
            conexion.close();
        }catch(Exception e){
            System.out.println("Error al conectarse");
        }
    }
}
