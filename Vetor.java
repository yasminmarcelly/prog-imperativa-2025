import java.util.Scanner;

public class Vetor {

    static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        int[] vetor = new int[10];
        preencherVetorDigitacaoSemRepeticao(vetor);

        System.out.println("Resultado vetor:");
        for (int i = 0; i < vetor.length; i+=1) {
            System.out.print(vetor[i] + " ");
        }
        
    }
    

    public static int buscaSequencial(int[] v, int tam, int x) {
        for (int i = 0; i < tam; i+=1) {
            if (v[i] == x) {
                return i;
            }
        }
        return -1;
    }

    public static void preencherVetorDigitacaoSemRepeticao(int[] v) {
        for (int i = 0; i < v.length; i+=1) {
            int num;
            int posicaoRepetida;

            do {
                System.out.print("Digite o " + (i + 1) + "º numero: ");
                num = input.nextInt();
                posicaoRepetida = buscaSequencial(v, i, num);

                if (posicaoRepetida != -1) {
                    System.out.println("Numero repetido! Digite outro valor");
                }
            } while (posicaoRepetida != -1);

            v[i] = num;
        }
    }
}
