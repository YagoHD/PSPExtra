import java.io.*;
import java.net.*;

public class Servidor {
    static DataInputStream entrada;
    static DataOutputStream salida;
    static Socket conexion;
    static ServerSocket servidor;
    
    public static void main(String[] args) {
        int indice = 0, numero1, numero2, resultado;
        
        try {
            servidor = new ServerSocket(5000);
            System.out.println("Servidor Iniciado");
            
            while(true){
                try {
                    conexion = servidor.accept();
                    System.out.println("Cliente conectado");
                    entrada = new DataInputStream(conexion.getInputStream());
                    salida = new DataOutputStream(conexion.getOutputStream());

                    indice = entrada.readInt();
                    while (indice != 5){
                        switch (indice) {
                            case 1:
                                salida.writeUTF("Introduce los valores del Primer y segundo numero: ");
                                numero1 = entrada.readInt();
                                numero2 = entrada.readInt();
                                resultado = numero1 + numero2;
                                salida.writeInt(resultado);
                                break;
                            case 2:
                                salida.writeUTF("Introduce los valores del Primer y segundo numero: ");
                                numero1 = entrada.readInt();
                                numero2 = entrada.readInt();
                                resultado = numero1 - numero2;
                                salida.writeInt(resultado);
                                break;
                            case 3:
                                salida.writeUTF("Introduce los valores del Primer y segundo numero: ");
                                numero1 = entrada.readInt();
                                numero2 = entrada.readInt();
                                resultado = numero1 * numero2;
                                salida.writeInt(resultado);
                                break;
                            case 4:
                                salida.writeUTF("Introduce los valores del Primer y segundo numero: ");
                                numero1 = entrada.readInt();
                                numero2 = entrada.readInt();
                                resultado = numero1 / numero2;
                                salida.writeInt(resultado);
                                break;
                        }
                        indice = entrada.readInt();
                    }
                    entrada.close();
                    salida.close();
                    conexion.close();
                    System.out.println("Cliente desconectado");
                } catch (Exception e) {System.out.println("Error");}
            }
        } catch (Exception e) {System.out.println("Error");}
    }
}
