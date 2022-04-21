import java.util.Scanner;

public class Ejercicio3Funcion extends Thread{
    private static int a,b,c,d,g,w,e;
    private static double f;
    private int operacion;
    
    public Ejercicio3Funcion(int operacion){
        this.operacion=operacion;
    }
    
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        System.out.println("Introduce el valor de b: ");
        b=sc.nextInt();
        System.out.println("Introduce el valor de c: ");
        c=sc.nextInt();
        System.out.println("Introduce el valor de e: ");
        e=sc.nextInt();
        System.out.println("Introduce el valor de w: ");
        w=sc.nextInt();
        
        Ejercicio3Funcion h1 = new Ejercicio3Funcion(1);
        Ejercicio3Funcion h2 = new Ejercicio3Funcion(2);
        Ejercicio3Funcion h3 = new Ejercicio3Funcion(3);
        
        h1.start();
        h2.start();
        h3.start();
        
        try { h1.join();h2.join();h3.join();} catch (Exception e) {}
        
        
        System.out.printf("S4: g = funcion(a (%d), d (%d), f (%f))\n", a, d, f);
        f=java.lang.Math.sin(w);
        System.out.println("El valor de f es: "+f);
        
    }
    public void run(){
        switch (operacion) {
            case 1:
                a=b+c;
                System.out.println("El valor de a es: "+a);
                break;
            case 2:
                d=b+e;
                System.out.println("El valor de d es: "+d);
                break;
            case 3:
                f=c+e;
                System.out.println("El valor de f es: " +f);
                break;
        }
    }
}
