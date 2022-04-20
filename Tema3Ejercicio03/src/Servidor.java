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
                DataInputStream entrada;
		DataOutputStream salida;
                
                try{
			servidor=new ServerSocket(5000);
		}catch (IOException ioe){
			System.err.println("Error al abrir el socket del servidor: "+ioe);
			System.exit(-1);
		}
		long entradaNumero;
		long salidaNumero;
		//Bucle infinito
		while(true){
			try{
				//Esperamos a que alguien se conecte a nuestro socket
				Socket sck=servidor.accept();
				//Extraemos los streams de entrada y salida
				entrada=new DataInputStream(sck.getInputStream());
				salida=new DataOutputStream(sck.getOutputStream());
				//podemos extraer información del socket
				//Nº de puerto remoto
				int puerto=sck.getPort();
				//dirección Internet remota
				InetAddress direcc=sck.getInetAddress();
				//Leemos datos de la petición
				entradaNumero=entrada.readInt();
				//Calculamos resultado
				salidaNumero= (entradaNumero*entradaNumero);
				//Escribimos el resultado
				salida.writeLong(salidaNumero);
				//Cerramos los streams
				entrada.close();
				salida.close();
				sck.close();
				//Registramos en salida estandar
				System.out.println("Cliente = "+direcc+":"+puerto+"\tEntrada = "+
						entradaNumero+"\tSalida = "+salidaNumero);
			}catch (IOException e){
				System.err.println("Se ha producido la excepción: "+e);
			}
		}
	}
}