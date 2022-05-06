import java.io.*;
import java.net.*;

public class Servidor {
    static DataInputStream entrada;
    static DataOutputStream salida;
    static ServerSocket servidor;
    static Socket conexion;
    
    public static void main(String args[]) {
		
	int a,b,p,mcd;
        try{
            servidor= new ServerSocket(5000);
            System.out.println("Servidor iniciado");
            conexion=servidor.accept();
            entrada=new DataInputStream(conexion.getInputStream());
            salida= new DataOutputStream(conexion.getOutputStream());
            do{
                salida.writeUTF("Introduce el primer numero: ");
                a=entrada.readInt();
                salida.writeUTF("Introduce el segundo numero: ");
                b=entrada.readInt();
                if(a!=0){
                    p=a*b;
                    mcd=a;
                    while(mcd!=b){
                        if(mcd>b){
                            mcd=mcd-b;
                        }else{b=b-mcd;}
                    
                    }
                    
                    salida.writeUTF("El minimo comun divisor es: "+mcd);
                    
                    }
            }while(a!=0);
            
                System.out.println("Servidor cerrado");
                entrada.close();
                salida.close();
                conexion.close();
                servidor.close();
                
            }catch(Exception e){}
        }
    
}
