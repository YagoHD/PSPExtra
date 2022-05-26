import java.io.*;
import java.net.*;

public class Cliente {
	public static void main(String[] args) {
		
		try {
			String id_fichero = "4";
			Socket clientSocket = new Socket();
			InetSocketAddress addr = new InetSocketAddress("localhost", 5555);
			clientSocket.connect(addr);
			InputStream is = clientSocket.getInputStream();
			OutputStream os = clientSocket.getOutputStream();
			//Crea un PrintWriter a partir de un OutputStream que ya existe
			PrintWriter pw = new PrintWriter(os, true);
			System.out.println("Descargando fichero "+id_fichero);
			
			pw.println(id_fichero);
			BufferedReader br = new BufferedReader(new InputStreamReader(is));
			char buffer[] = new char[1]; 
			while (br.read(buffer) != -1) {
				System.out.print(buffer[0]);   
			}

			clientSocket.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}