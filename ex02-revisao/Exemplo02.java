public class Exemplo02 {
    public static void main(String[] args) {
        int num =0;
        
        System.out.println("Todos");
        for (int i = 1; i <= 100; i++) {
            System.out.print(i + ",");
        }
        System.out.println("\nImpares");
        for (int i = 1; i < 100; i+=2) {
            System.out.print(i + ",");
        }
        System.out.println("\nPares");
        for (int i = 2; i <= 100; i+=2) {
            System.out.print(i + ",");
        }
         System.out.println("\nMultiplos de 3");
         if(num%3==0){
            for ( num = 3; num < 100; num+=3) {
                System.out.print(num + ",");
            }
        }
    }  
}

