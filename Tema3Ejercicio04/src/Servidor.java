import java.io.*;
import java.net.*;

public class Servidor {
    private static int PUERTO = 5000;
    
    public static void main (String args[]){
        DataInputStream entrada;
        DataOutputStream salida;
        Socket conexion;
        ServerSocket servidor;
        int numero = 1;
        long numeroFactorial = 0;
        
        try{
            servidor = new ServerSocket(PUERTO);
            System.out.println("Esperando una conexion...");
        
            while(numero!=0){
                conexion = servidor.accept();
                System.out.println("Cliente conectado");
                entrada = new DataInputStream(conexion.getInputStream());
                salida = new DataOutputStream(conexion.getOutputStream());

                salida.writeUTF("Introduce un numero para calcular su factorial: ");
                numero = entrada.readInt();
                numeroFactorial = factorial(numero);

                salida.writeUTF("El factorial del numero :"+ numero+" es: "+ numeroFactorial);
            }
            System.out.println("Servidor cerrado");
        }catch(Exception e){
            System.out.println("Error");
        }  
    }
    
    //**************CLASES**************       
        public static long factorial(long numero){
        if (numero==0){
            
            System.out.println("Cliente desconectado");
            return 1;
        }else
            return numero * factorial(numero-1);
    }
}

