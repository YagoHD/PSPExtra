import java.util.Scanner;

public class Ejercicio5 extends Thread{
   private static int x,A,B,y,C,D,z;
   private int operacion;
   
   public Ejercicio5(int operacion){
       this.operacion = operacion;
   }
   
        public static void main(String[] args) {
            Scanner sc= new Scanner(System.in);
            System.out.println("Introduce el valor de A: ");
            A=sc.nextInt();
            System.out.println("Introduce el valor de B: ");
            B=sc.nextInt();
            System.out.println("Introduce el valor de C: ");
            C=sc.nextInt();
            System.out.println("Introduce el valor de D: ");
            D=sc.nextInt();
            
            
            Ejercicio5 h1 = new Ejercicio5(1);
            Ejercicio5 h2 = new Ejercicio5(2);
            
            h1.start();
            h2.start();
            
            try {h1.join();h2.join();} catch (Exception e) {}
            
            z=x+y;
            System.out.println("El valot de z es de: "+z);
            
        }
    
        public void run(){
            switch (operacion) {
                case 1:
                    x=(A+B)*(A-B);
                    System.out.println("El valor de x es: "+x);
                    break;
                case 2:
                    y=(C-D)*(C+D);
                    System.out.println("El valor de y es: "+y);
                    break;
            }
        }
}
