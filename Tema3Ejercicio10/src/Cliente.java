import java.io.*;
import java.net.*;

public class Cliente {
    static DataInputStream entrada;
    static DataOutputStream salida;
    static Socket conexion;
	public static void main(String[] args) {
		
		try {
			String id_fichero = "4";
			conexion = new Socket("localhost", 5000);
			entrada = new DataInputStream(conexion.getInputStream());
                        salida = new DataOutputStream(conexion.getOutputStream());
                        
                        
			//Crea un PrintWriter a partir de un OutputStream que ya existe
			PrintWriter pw = new PrintWriter(salida, true);
			System.out.println("Descargando fichero "+id_fichero);
			
			pw.println(id_fichero);
			BufferedReader br = new BufferedReader(new InputStreamReader(entrada));
			char buffer[] = new char[1]; 
			while (br.read(buffer) != -1) {
				System.out.print(buffer[0]);   
			}
                        
			conexion.close();
                        entrada.close();
                        salida.close();
		} catch (IOException e) {e.printStackTrace();}
	}
}