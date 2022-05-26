import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;

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
			BufferedReader br_fichero = new BufferedReader(new FileReader("E:\\TRABAJO\\PSPExtra\\Tema3Ejercicio10\\4.txt"));
			while (br_fichero.ready()) {
				char b = (char) br_fichero.read();
				os.write(b);
			}
		} catch (IOException e) {
			e.printStackTrace();
		} 
	}
		
}