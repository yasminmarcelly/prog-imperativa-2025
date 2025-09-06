import java.util.Scanner;

public class Exe01 {
    public static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        int[] vetorA = new int[5];   
        int[] vetorB = new int[5];  
        int[] vetorSoma = new int[5];
        preencherVetor01(vetorA);
        System.out.println("-------------------");
        preencherVetor02(vetorB);
        
        System.out.println("\nResultado vetor A " );
        for (int i = 0; i < vetorA.length; i+=1){
            System.out.print(vetorA[i] + " ");
        }

        System.out.println("\nResultado vetor B " );
        for (int i = 0; i < vetorB.length; i+=1){
            System.out.print(vetorB[i] + " ");
        }
        somarVetores(vetorA, vetorB, vetorSoma);
        System.out.println("\nResultado vetor Soma " );
        for (int i = 0; i < vetorSoma.length; i+=1){
            System.out.print(vetorSoma[i] + " ");
        }
        
        
    }

    public static void preencherVetor01(int[] a) {
        for (int i = 0; i < a.length; i+=1) {
            System.out.print("Digite o " + (i + 1) + "º numero: ");
            a[i] = scanner.nextInt();
        }
    }

     public static void preencherVetor02(int[] b) {
        for (int i = 0; i < b.length; i+=1) {
            System.out.print("Digite o " + (i + 1) + "º numero: ");
            b[i] = scanner.nextInt();
        }
    }

    public static int[] somarVetores(int[] a, int[] b, int[] c){
        for (int i = 0; i < a.length; i+=1) {
            c[i] = a[i] + b[i];
        }
        return c;
    }
    
}
