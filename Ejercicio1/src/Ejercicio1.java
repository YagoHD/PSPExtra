import java.util.Scanner;

public class Ejercicio1 extends Thread{
    private static int x,y,z,a,b;
    private int operacion;
    
    public Ejercicio1(int operacion){
        this.operacion=operacion;
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.println("Dame el valot de y: ");y=sc.nextInt();
        System.out.println("Dame el valot de a: ");a=sc.nextInt();
        System.out.println("Dame el valot de b: ");b=sc.nextInt();
        
        Ejercicio1 h1 = new Ejercicio1(1);
        Ejercicio1 h2 = new Ejercicio1(2);
        
        h1.start();h2.start();
        
        try {h1.join();h2.join();} catch (InterruptedException e) {};
        
        System.out.println("Programa FINALIZADO");
    }
    public void run(){
        switch (operacion) {
            case 1:
                x=y+1;
                System.out.println("El valor de x es: "+x);
                y=x*2;
                System.out.println("El valor de y es: "+y);
                break;
            case 2:
                z=a+b;
                System.out.println("El valor de z es: "+z);
                break;
        }
    }
}
