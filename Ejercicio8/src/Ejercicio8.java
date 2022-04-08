import java.util.Scanner;

public class Ejercicio8 extends Thread{
    private static int a,x,y,b,c,d,e,f;
    private final int operacion;

    public Ejercicio8(int operacion) {
        this.operacion = operacion;
    }
    
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        System.out.println("Dame el valor de x: ");
        x=sc.nextInt();
        System.out.println("Dame el valor de y: ");
        y=sc.nextInt();
        
        Ejercicio8 h1 = new Ejercicio8(1);
        Ejercicio8 h2 = new Ejercicio8(2);
        Ejercicio8 h3 = new Ejercicio8(3);
        Ejercicio8 h4 = new Ejercicio8(4);
        Ejercicio8 h5 = new Ejercicio8(5);
        
        h1.start();h2.start();h3.start();h4.start();h5.start();
        
        try {h1.join();h2.join();h3.join();h4.join();h5.join();} catch (Exception e) {}
        
        f=d-e;
        System.out.println("El valor de f es de: "+f);
    }
    
    public void run(){
        switch (operacion) {
            case 1:
                a=x+y;
                System.out.println("El valor de a es: "+a);
                break;
            case 2:
                b=x-y;
                System.out.println("El valor de b es: "+b);
                break;
            case 3:
                c=x*y;
                System.out.println("El valor de c es: "+c);
                break;
            case 4:
                d=a+b+c;
                System.out.println("El valor de d es: "+d);
                break;
            case 5:
                e=a*b*c;
                System.out.println("El valor de e es de: "+e);
                break;
        }
    }
}
