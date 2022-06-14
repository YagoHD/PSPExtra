import java.util.Scanner;
import java.io.*;
import java.net.*;

public class Cliente {
    static DataInputStream entrada;
    static DataOutputStream salida;
    static Socket conexion;
    
    public static void main(String[] args) {
        try {
            conexion = new Socket("localhost",5000);
            System.out.println("CONECTADO AL SERVIDOR");
            entrada = new DataInputStream(conexion.getInputStream());
            salida = new DataOutputStream(conexion.getOutputStream());
            Scanner sc = new Scanner(System.in);
            int x0=0,x1=0,y0=0,y1=0;
            while(x0!=999 && x1!=999 && y0!=999 && y1!=999 ){
                System.out.println("Introduce los valores  x0, x1, y0, y1 en el orden dado: ");
                x0=sc.nextInt();x1=sc.nextInt();y0=sc.nextInt();y1=sc.nextInt();
                salida.writeInt(x0);salida.writeInt(x1);salida.writeInt(y0);salida.writeInt(y1);
                
                if(x0!=999 && x1!=999 && y0!=999 && y1!=999){
                    System.out.println(entrada.readUTF());
                }
            }
            conexion.close();
            salida.close();
            entrada.close();
        } catch (Exception e) {System.out.println("Error de conexion");}
    }
}
