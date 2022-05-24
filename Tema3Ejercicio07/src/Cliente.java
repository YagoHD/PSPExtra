import java.io.*;
import java.net.*;
import java.util.Scanner;

public class Cliente {
    static DataInputStream entrada;
    static DataOutputStream salida;
    static Socket conexion;
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        try{
            conexion = new Socket("localhost",5000);
            entrada = new DataInputStream(conexion.getInputStream());
            salida = new DataOutputStream(conexion.getOutputStream());
            int opcion =0;
            
            do{
            System.out.println("Elige una opcion (1-Sumar, 2-Restar, 3-Multiplicar, 4-Dividir, 5-Salir: )");
            opcion = sc.nextInt();
            
            
            if (opcion==5){
                salida.writeInt(opcion);
                System.out.println("Cliente Cerrado");
                entrada.close();
                salida.close();
                conexion.close();
                break;
            }
            salida.writeInt(opcion);
            
            System.out.println(entrada.readUTF());
            salida.writeInt(sc.nextInt());
            System.out.println(entrada.readUTF());
            salida.writeInt(sc.nextInt());
            String resultado = entrada.readUTF();
            System.out.println(resultado);
            
            }while (opcion!=5); 
            
        }catch(Exception e){System.out.println("Error");}     
    }
}
