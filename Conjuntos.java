import java.util.Scanner;

public class Conjuntos {
    public static final int TAM = 30;
    public static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        int[] conjuntoA = new int[TAM];
        int[] conjuntoB = new int[TAM];
        int qtdA = 0;
        int qtdB = 0;
        int opcao;

        do{
            System.out.println("\n======MENU======");
            System.out.println("1 - Inserir 1 elemento no Conjunto A");
            System.out.println("2 - Inserir 1 elemento no Conjunto B");
            System.out.println("3 - Imprimir  Conjunto A e B");
            System.out.println("4 - Gerar e Imprimir a uniao de A e B");
            System.out.println("5 - Gerar e Imprimir a interseção entre A e B");
            System.out.println("6 - Gerar e Imprimir a diferença entre A e B");
            System.out.println("7 - Gerar e Imprimir a diferença entre A e B");
            System.out.println("0 - Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();
            switch(opcao){
                case 1:
                    System.out.print("Digite o valor para inserir no Conjunto A: ");
                    qtdA = inserirElemento(conjuntoA, qtdA);
                    break;
                case 2:
                    System.out.print("Digite o valor para inserir no Conjunto B: ");
                    qtdB = inserirElemento(conjuntoB, qtdB);
                    break;
                case 3:
                    System.out.print("\nConjunto A = ");
                    imprimir(conjuntoA, qtdA);
                    System.out.print("\nConjunto B = ");
                    imprimir(conjuntoB, qtdB);
                    break;
                case 4:
                    int[] vetorUniao = gerarUniao(conjuntoA, qtdA, conjuntoB, qtdB);
                    System.out.print("\nUniao de A e B = ");
                    imprimir(vetorUniao,vetorUniao.length);
                    break;
                case 5:
                    int[] vetorIntersecao = gerarIntersecao(conjuntoA, qtdA, conjuntoB, qtdB);
                    System.out.print("\nInterseção de A e B = ");
                    imprimir(vetorIntersecao, vetorIntersecao.length);
                    break;
                case 6:
                    int[] diferencaAB = diferenca(conjuntoA, qtdA, conjuntoB, qtdB);
                    System.out.print("Diferença de A e B = ");
                    imprimir(diferencaAB, diferencaAB.length);
                    break;
                case 7:
                    int[] diferencaBA = diferenca(conjuntoB, qtdB, conjuntoA, qtdA);
                    System.out.print("Diferença de B e A = ");
                    imprimir(diferencaBA, diferencaBA.length);
                    break;
                case 0:
                    System.out.println("Encerrando o programa...");
                    break;
                default:
                    System.out.println("Opção invalida!");
            }
        } while (opcao!=0);
    }

    public static int inserirElemento(int[] v, int qtd){
        if(qtd < v.length){
            int valor = scanner.nextInt();
            for(int i = 0; i < qtd; i++){
                if(v[i] == valor){
                    System.out.println("Nao é permitido inserir numeros repetidos.");
                    return qtd;
                }
            }

            v[qtd] = valor;
            qtd++;
            return qtd;

        } else {
            System.out.println("Vetor cheio! Impossivel inserir novos valores.");
            return qtd;
        }
    }

    public static void imprimir(int[] v, int qtd){
        System.out.print("{");
        if(qtd>0){
            System.out.print(" " + v[0]);
        }
        for (int i = 1; i < qtd; i++) {
             System.out.print(", " + v[i]);
        }
        System.out.print(" }");
    }

    public static int[] gerarUniao(int[] va, int qtdA, int[] vb, int qtdB){
        int[] vTemp = new int[qtdA + qtdB];
        int k = 0;
        for (int i = 0; i < qtdA; i++) {
            vTemp[k++] = va[i];
        }
        for (int i = 0; i < qtdB; i++) {
            if(buscaSequencial(vTemp, k, vb[i]) == -1){
                vTemp[k++] = vb[i];
            }
        }
        int[] result = new int[k];
        for(int i = 0; i < k; i++){
            result[i] = vTemp[i];
        }
        return result;
    }

    public static int[] gerarIntersecao(int[] va, int qtdA, int[] vb, int qtdB){
        int[] vTemp = new int[qtdA + qtdB];
        int k = 0;

        for (int i = 0; i < qtdA; i++) {
            if(buscaSequencial(vb, qtdB, va[i]) != -1){
                vTemp[k++] = va[i];
            }
        }
        int[] result = new int[k];
        for(int i = 0; i < k; i++){
            result[i] = vTemp[i];
        }
        return result;
    }
    public static int[] diferenca(int[] va, int qtdA, int[] vb, int qtdB){
        int[] vTemp = new int[qtdA];
        int k = 0;

        for (int i = 0; i < qtdA; i++) {
            if(buscaSequencial(vb, qtdB, va[i]) == -1){
                vTemp[k++] = va[i];
            }
        }
        int[] result = new int[k];
        for(int i = 0; i < k; i++){
            result[i] = vTemp[i];
        }
        return result;
    }

    public static int buscaSequencial(int[] v, int tam, int x) {
        for (int i = 0; i < tam; i++) {
            if (v[i] == x) {
                return i;
            }
        }
        return -1;
    }
}
