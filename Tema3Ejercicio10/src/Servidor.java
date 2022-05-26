import java.io.*;
import java.net.*;

public class Servidor {
	public static void main(String[] args) {
		try {
		ServerSocket serverSocket = new ServerSocket();
		InetSocketAddress addr = new InetSocketAddress("localhost", 5555);
		serverSocket.bind(addr);
		while (true) {
			Socket newSocket = serverSocket.accept();
			procesarCliente(newSocket);
			newSocket.close();
		}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public static void procesarCliente(Socket socket) {
		try {
			InputStream is = socket.getInputStream();
			OutputStream os = socket.getOutputStream();
			BufferedReader br_socket = new BufferedReader(new InputStreamReader(is));
			String id_fichero = br_socket.readLine();
			BufferedReader br_fichero = new BufferedReader(new FileReader("E:\\TRABAJO\\PSPExtra\\Tema3Ejercicio10\\fw.txt"));
			while (br_fichero.ready()) {
				char b = (char) br_fichero.read();
				os.write(b);
			}
		} catch (IOException e) {
			e.printStackTrace();
		} 
	}		
}