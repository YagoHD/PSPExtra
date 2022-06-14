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
            while (true) {
                conexion = servidor.accept();
                try {
                    entrada = new DataInputStream(conexion.getInputStream());
                    salida = new DataOutputStream(conexion.getOutputStream());
                    BufferedReader br_socket = new BufferedReader(new InputStreamReader(entrada));
                    String id_fichero = br_socket.readLine();
                    BufferedReader br_fichero = new BufferedReader(new FileReader("E:\\TRABAJO\\PSPExtra\\Tema3Ejercicio10\\fw.txt"));
                    
                    while (br_fichero.ready()) {
                        char b = (char) br_fichero.read();
                        salida.write(b);
                    }
                } catch (IOException e) {e.printStackTrace();}
                
                entrada.close();
                salida.close();
                conexion.close();
            }
        } catch (IOException e) {e.printStackTrace();}
    }

    
}
