import java.util.Scanner;

public class Ejercicio9 extends Thread{
    private static int a,x,y,b,c,d,e;
    private final int operacion;

    public Ejercicio9(int operacion){
        this.operacion=operacion;
    }

    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        System.out.println("Dame el valor de x: ");
        x=sc.nextInt();
        System.out.println("Dame el valor de y: ");
        y=sc.nextInt();
        
        Ejercicio9 h1 = new Ejercicio9(1);
        Ejercicio9 h2 = new Ejercicio9(2);
        
        h1.start();h2.start();
        
        try {h1.join();h2.join();} catch (Exception e) {}
        
        e=b+d;
        System.out.println("El valor de e es: "+e); 
    }
    
    public void run(){
        switch (operacion) {
            case 1:
                a=x+y;
                System.out.println("El valor de a es: "+a);
                b=a+3;
                System.out.println("El valor de b es: "+b);
                break;
            case 2:
                c=x*y;
                System.out.println("El valor de c es: "+c);
                d=c+8;
                System.out.println("El valor de d es: "+d);
                break;
        }
    }
}
