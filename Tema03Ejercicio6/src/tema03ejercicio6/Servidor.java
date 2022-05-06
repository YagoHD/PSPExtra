package tema03ejercicio6;

import java.lang.Math;
import java.net.*;
import java.io.*;

public class Servidor {

    static DataInputStream entrada;
    static DataOutputStream salida;
    static ServerSocket servidor;
    static Socket conexion;

    public static void main(String[] args) {
        int numeroIntroducido, numeroAleatorio;

        try {
            servidor = new ServerSocket(5000);
            System.out.println("-----Servidor iniciado-----");
            while (true) {
                try {
                    conexion = servidor.accept();
                    entrada = new DataInputStream(conexion.getInputStream());
                    salida = new DataOutputStream(conexion.getOutputStream());
                    numeroAleatorio = (int) (Math.random() * 1000 + 1);
                    System.out.println(numeroAleatorio);
                    numeroIntroducido = entrada.readInt();
                    while (numeroIntroducido != 0) {
                        System.out.println("El cliente ha mandado el numero: " + numeroIntroducido);
                        if (numeroIntroducido > numeroAleatorio) {
                            salida.writeUTF("El numero es menor que el tuyo");
                        } else if (numeroIntroducido < numeroAleatorio) {
                            salida.writeUTF("El numero es mayor que el tuyo");
                        } else {
                            salida.writeUTF("Has acertado!!!");
                            numeroAleatorio = (int) (Math.random() * 1000 + 1);
                            System.out.println(numeroAleatorio);
                        }
                        numeroIntroducido = entrada.readInt();
                    }
                    entrada.close();
                    salida.close();
                    conexion.close();
                } catch (Exception e) {
                    System.out.println("Conexion error");
                }

            }

        } catch (Exception e) {
            System.out.println("Error al inicializar el servidor");
        }
    }
}
