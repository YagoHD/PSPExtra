import java.util.Scanner;

public class Ejercicio2 extends Thread {
    private static int x,y,a,z,b;
    private int operacion;
    
    public Ejercicio2(int operacion){
        this.operacion = operacion;
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Introducimos el valor de y: ");
        y=sc.nextInt();
        System.out.println("Introduce el valor de a: ");
        a=sc.nextInt();
        System.out.println("Introduce el valor de b: ");
        b=sc.nextInt();
        
        Ejercicio2 h1 = new Ejercicio2(1);
        Ejercicio2 h2 = new Ejercicio2(2);
        
        h1.start();
        h2.start();
        
        try{h1.join();h2.join();}catch(InterruptedException e){};
        System.out.println("El programa a finalizado");
    }
    
    public void run (){
        switch (operacion) {
            case 1:
                x=y+1;
                System.out.println("El valor de x="+x);
                y=x*2;
                System.out.println("El valor de y="+y);
                break;
            case 2:
                z=a+b;
                System.out.println("El valor de z="+z);
                break;
        }
    }
}
