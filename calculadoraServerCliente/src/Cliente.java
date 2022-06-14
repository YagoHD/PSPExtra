import java.io.*;
import java.net.*;
import java.util.Scanner;

public class Cliente {
    static DataInputStream entrada;
    static DataOutputStream salida;
    static Socket conexion;
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int indice = 0,numero1,numero2,resultado;
        try {
            conexion = new Socket("localhost",5000);
            entrada = new DataInputStream(conexion.getInputStream());
            salida = new DataOutputStream(conexion.getOutputStream());
            
            System.out.println("Introduce opcion (1-Sumar, 2-Restar, 3-Multiplicar, 4-Dividir, 5-Salir)");
            indice = sc.nextInt();
            
            salida.writeInt(indice);
            while(indice!=5){
                System.out.println(entrada.readUTF());
                numero1 = sc.nextInt();
                numero2 = sc.nextInt();
                salida.writeInt(numero1);
                salida.writeInt(numero2);
                resultado = entrada.readInt();
                System.out.println("El resultado es " + resultado);
                System.out.println("Introduce opcion (1-Sumar, 2-Restar, 3-Multiplicar, 4-Dividir, 5-Salir)");
                indice = sc.nextInt();
                salida.writeInt(indice);
            }
            conexion.close();
            salida.close();
            entrada.close();
        } catch (Exception e) {System.out.println("Error");}
    }
}
