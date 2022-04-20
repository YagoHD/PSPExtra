import java.io.*;
import java.net.*;

public class Servidor {
	public static void main(String args[]) {
		//Primero indicamos la dirección IP local
		try{
			System.out.println("LocalHost = "+InetAddress.getLocalHost().toString());
		}catch (UnknownHostException uhe){
			System.err.println("No puedo saber la dirección IP local: "+uhe);
		}
		//abrimos un socket de servidor en el puerto 1234
		ServerSocket servidor = null;
		try{
			servidor=new ServerSocket(5000);
		}catch (IOException ioe){
			System.err.println("Error al abrir el socket del servidor: "+ioe);
			System.exit(-1);
		}
		long entrada;
		long salida;
		//Bucle infinito
		while(true){
			try{
				//Esperamos a que alguien se conecte a nuestro socket
				Socket sck=servidor.accept();
				//Extraemos los streams de entrada y salida
				DataInputStream dis=new DataInputStream(sck.getInputStream());
				DataOutputStream dos=new DataOutputStream(sck.getOutputStream());
				//podemos extraer información del socket
				//Nº de puerto remoto
				int puerto=sck.getPort();
				//dirección Internet remota
				InetAddress direcc=sck.getInetAddress();
				//Leemos datos de la petición
				entrada=dis.readInt();
				//Calculamos resultado
				salida= (entrada*entrada);
				//Escribimos el resultado
				dos.writeLong(salida);
				//Cerramos los streams
				dis.close();
				dos.close();
				sck.close();
				//Registramos en salida estandar
				System.out.println("Cliente = "+direcc+":"+puerto+"\tEntrada = "+
						entrada+"\tSalida = "+salida);
			}catch (IOException e){
				System.err.println("Se ha producido la excepción: "+e);
			}
		}
	}
}