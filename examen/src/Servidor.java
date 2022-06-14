import java.io.*;
import java.net.*;

public class Servidor {
    static DataInputStream entrada;
    static DataOutputStream salida;
    static Socket conexion;
    static ServerSocket servidor;
    
    public static void main(String[] args) {
        try {
            servidor = new ServerSocket(5000);
            System.out.println("SERVIDOR INICIADO");
            while(true){
                try {
                    conexion = servidor.accept();
                    System.out.println("CLIENTE CONECTADO");
                    entrada = new DataInputStream(conexion.getInputStream());
                    salida = new DataOutputStream(conexion.getOutputStream());
                    int x0=0,x1=0,y0=0,y1=0;
                    while(x0!=999 && x1!=999 && y0!=999 && y1!=999 ){
                        x0=entrada.readInt();x1=entrada.readInt();y0=entrada.readInt();y1=entrada.readInt();
                        if(x0!=999 && x1!=999 && y0!=999 && y1!=999 ){
                            if(x0==x1 && x0==y0 && x0==y1){
                                salida.writeUTF("Es un punto!!");
                            }else if (y0==y1 && x0!=x1){
                                salida.writeUTF("Es una linea horiozntal!!");
                            }else if(x0==x1 && y0!=y1){
                                salida.writeUTF("Es una linea vertival!!");  
                            }else if(x0!=x1 && y0!=y1){
                                salida.writeUTF("Es un rectangulo!!");    
                            }else{
                                salida.writeUTF("Linea doblada");
                            }
                        }
                    }
                    conexion.close();
                    salida.close();
                    entrada.close();
                } catch (Exception e) {System.out.println("Error e/s");}
            }
        } catch (Exception e) {System.out.println("Error de conexion");}
    }
}
