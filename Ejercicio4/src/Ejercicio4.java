import java.util.Scanner;

public class Ejercicio4 extends Thread{
    private static double u, a, b, v, c, w, d, x;
    private int operacion;
    
    public  Ejercicio4(int operacion){
        this.operacion=operacion;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Dame el valor de a: ");
        a=sc.nextDouble();
        System.out.println("Dame el valor de b: ");
        b=sc.nextDouble();
        System.out.println("Dame el valor de c: ");
        c=sc.nextDouble();
        System.out.println("Dame el valor de d: ");
        d=sc.nextDouble();
        
        Ejercicio4 h1 = new Ejercicio4(1);
        Ejercicio4 h2 = new Ejercicio4(2);
        
        u=a*b;
        System.out.println("El valor de u es: "+u);
        
        h1.start();
        h2.start();
        
        try {h1.join();h2.join();} catch (Exception e) {}
        
        x=v/w;
        System.out.println("El valor de x es: "+x);
    }
    
    public void run(){
        switch (operacion) {
            case 1:
                v=u+c;
                System.out.println("El valor de v es: "+v);
                break;
            case 2:
                w=u-d;
                System.out.println("El valor de w es: "+w);
                break;
        }
    }
}
