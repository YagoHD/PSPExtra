import java.util.Scanner;

public class Ejercicio10 extends Thread {
    private static int a,x,m,b,n,c,y,z;
    private final int operacion;
    
    public Ejercicio10(int operacion){
        this.operacion=operacion;
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Dame el valor de x:");
        x=sc.nextInt();
        System.out.println("Dame el valor de b:");
        b=sc.nextInt();
        System.out.println("Dame el valor de c: ");
        c=sc.nextInt();
        
        Ejercicio10 h1 = new Ejercicio10(1);
        Ejercicio10 h2 = new Ejercicio10(2);
        
        h1.start();h2.start();
        
        try { h1.join();h2.join();} catch (Exception e) {}
        y=m+n;
        System.out.println("El valor de y es: "+y);
        z=m-n;
        System.out.println("El valor de z es: "+z);
        
    }
    
    public void run(){
        switch (operacion) {
            case 1:
                a=x*x;
                System.out.println("El valor de a es: "+a);
                m=a*b;
                System.out.println("El valor de a es: "+m);
                break;
            case 2:
                n=c*x;
                System.out.println("El valor de n es: "+n);
                break;
        }
    }
}
