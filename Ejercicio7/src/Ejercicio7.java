import java.util.Scanner;

public class Ejercicio7 extends Thread{
    private static int a,x,y,b,z,c,w;
    private final int operacion;

    public Ejercicio7(int operacion) {
        this.operacion = operacion;
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Dame el valor de x: ");
        x=sc.nextInt();
        System.out.println("Dame el valor de y: ");
        y=sc.nextInt();
        System.out.println("Dame el valor de z: ");
        z=sc.nextInt();
        
        Ejercicio7 h1 = new Ejercicio7(1);
        Ejercicio7 h2 = new Ejercicio7(2);
        
        h1.start();h2.start();
        
        try {h1.join();h2.join();} catch (Exception e) {}
        
        c=a-b;
        System.out.println("El valor de c es: "+c);
        w=c+1;
        System.out.println("El valor de w es: "+w);
    }
    
    public void run(){
        switch (operacion) {
            case 1:
                a=x+y;
                System.out.println("El valor de a es: "+a);
                break;
            case 2:
                b=z-1;
                System.out.println("El valor de b es: "+b);
                break;
        }
    }
    
}
