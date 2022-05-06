import java.io.*;
import java.net.*;
import java.util.Scanner;

public class Cliente {
    static DataInputStream entrada;
    static DataOutputStream salida;
    static Socket conexion;
    
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int a,b;
        try{
            try{
                conexion = new Socket("localhost", 5000);
                
            }catch(Exception e){
                System.out.println("conexion denegada");
            }
            entrada = new DataInputStream(conexion.getInputStream());
            salida = new DataOutputStream(conexion.getOutputStream());
            do{
                System.out.println("Introduce el primer nº: ");
                a=sc.nextInt();
                salida.writeInt(a);
                System.out.println("Introduce el segundo nª: ");
                b=sc.nextInt();
                salida.writeInt(b);
                if(a!=0){
                    
                    System.out.println("El mcd de estos nºs es: " + entrada.readInt());
                    
                }
            }while(a!=0);
            sc.close();
            entrada.close();
            salida.close();
            conexion.close();
            
        }catch(Exception e){}
    }
    
}
