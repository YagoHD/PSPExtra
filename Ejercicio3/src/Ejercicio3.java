import java.util.Scanner;

public class Ejercicio3 extends Thread {
    private static int cuad, x, m1, a, m2, b, z, y, c;
    private int operacion;
    
    public Ejercicio3(int operacion){
        this.operacion=operacion;
    }
    
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        
        System.out.println("Introduce el valor de x: ");
        x=sc.nextInt();
        System.out.println("Introduce el valor de a: ");
        a=sc.nextInt();
        System.out.println("Introduce el valor de b: ");
        b=sc.nextInt();
        System.out.println("Introduce el valor de c: ");
        c=sc.nextInt();
        
        Ejercicio3 h1 = new Ejercicio3(1);
        Ejercicio3 h2 = new Ejercicio3(2);
        
        h1.start();
        h2.start();
        
        try {h1.join();h2.join();} catch (Exception e) {}
        
        z=m1+m2;
        System.out.println("el valor de z es: "+z);
        y=z+c;
        System.out.println("el valor de y es: "+y);
        
        
    }
    public void run(){
        switch (operacion) {
            case 1:
                cuad=x*x;
                System.out.println("El valor de a es: "+a);
                m1=a*cuad;
                System.out.println("El valor de m1 es: "+m1);
                break;
            case 2:
                m2=b*x;
                System.out.println("El valor de m2 es: "+m2);
                break;
        }
    }  
}
