import java.io.*;
import java.net.*;
import java.util.Scanner;

public class Cliente {
    public static void main(String[] args) {
        //Leemos el primer parámetro, donde debe ir la dirección IP del servidor
        InetAddress HOST=null;
        try{
            HOST = InetAddress.getByName("localhost");
            System.out.println(HOST);
        }catch (UnknownHostException uhe){
            System.out.println("HOST no encontrado" + uhe);
            System.exit(-1);
        }
        //Puerto que hemos usado para el servidor INICIALIZAMOS DATAINPUTS y SOCKET
        final int PUERTO = 5000;
        DataInputStream entrada;
        DataOutputStream salida;
        Socket conexion=null;
        try{
            System.out.println("Introduce el numero a averiguar el cuadrado: ");
            Scanner sc= new Scanner(System.in);
            int numero = sc.nextInt();
            //creamos el socket
            conexion = new Socket(HOST,PUERTO);
            //Extraemos los streams de entrada y salida
            entrada = new DataInputStream(conexion.getInputStream());
            salida = new DataOutputStream(conexion.getOutputStream());
            //Introducimos el numeor anteriormente pedido
            salida.writeInt(numero);
            //Leemos el resultado final
            long resultado = entrada.readLong();
            //Mostramos en pantalla
            System.out.println("Solicitud: "+numero+"\tResultado: "+resultado);
            //y cerramos los streams y el socket
            entrada.close();
            salida.close();
        }catch(IOException e){
            System.err.println("Se ha producido la excepcion: "+e);
        }
        try{
            if (conexion!=null) conexion.close();
        }catch(IOException ioe){
            System.err.println("Error al cerrar el socket: "+ioe);
        }
    }
}
