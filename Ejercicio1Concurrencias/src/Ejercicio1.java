import java.util.Scanner;

public class Ejercicio1 extends Thread{
    //CREAMOS LAS VARIABLES DE LA SECUENCIA
    private static int a,x,y,b,z,c,w,t;
    private int operacion;
    //CREAMOS LA OPERACION FIO
    public Ejercicio1(int operacion){
        this.operacion = operacion;
    }
    
        public static void main(String[] args) {
            Scanner sc=new Scanner (System.in);
            System.out.println("Introduce el valor de x:");
            x=sc.nextInt();
            System.out.println("Introduce el valor de y:");
            y=sc.nextInt();
            System.out.println("Introduce el valor de z:");
            z=sc.nextInt();
            
            
            Ejercicio1 h1 = new Ejercicio1(1);
            Ejercicio1 h2 = new Ejercicio1(2);
            Ejercicio1 h3 = new Ejercicio1(3);
            Ejercicio1 h4 = new Ejercicio1(4);
            
            h1.start();
            h2.start();
            try{ h1.join(); h2.join(); }catch(InterruptedException e){};
            c = a+b;
            System.out.println("c vale: "+ c);
            
            h3.start();
            h4.start();
            try{ h3.join(); h4.join(); }catch(InterruptedException e){};
            
            System.out.println("El programa ha terminado");
        }
        
        public void run(){
            switch (operacion) {
                case 1:
                    a=x+y;
                    System.out.println("a vale: "+ a);
                    x=x+3;
                    System.out.println("x vale: "+x);
                    break;
                    
                case 2:
                    b=z-1;
                    System.out.println("b vale: "+ b);
                    break;
                    
                case 3:
                    w=c+x;
                    System.out.println("w vale: "+ w);
                    break;
                    
                case 4:
                    t=c+2*x;
                    System.out.println("t cale: "+ t);
                    break;
            }
        }
}
