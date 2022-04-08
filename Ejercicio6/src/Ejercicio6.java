import java.util.Scanner;

public class Ejercicio6 extends Thread {
    private static float a,x,b,y,z,c,d;
    private final int operacion;

    public Ejercicio6(int operacion) {
        this.operacion=operacion;
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Dame el valor de x: ");
        x=sc.nextFloat();
        System.out.println("Dame el valor de y: ");
        y=sc.nextFloat();
        System.out.println("Dame el valor de z: ");
        z=sc.nextFloat();
        
        Ejercicio6 h1 = new Ejercicio6(1);
        Ejercicio6 h2 = new Ejercicio6(2);
        
        h1.start();h2.start();
        
        try { h1.join();h2.join();} catch (Exception e) {}
        
        d=a+c;
        System.out.println("El valor de d es: "+d);
    }
    
    public void run(){
        switch (operacion) {
            case 1:
                a=2*x;
                System.out.println("El valor de a es: "+a);
                break;
            case 2:
                b=y-z;
                System.out.println("El valor de b es: "+b);
                c=b/3;
                System.out.println("El valor de c es: "+c);
                break;
        }
    }
}
