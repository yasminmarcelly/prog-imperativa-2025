import java.util.Scanner;

public class Caderno {
    public static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        int[] vetor1 = new int[10];
        int[] vetor2 = new int[10];
        int[] vetorResult;
        int qtd1 = 0;
        int qtd2 = 0;
        int pos;
        int opcao, item;

        do{
            System.out.println("\n======MENU======");
            System.out.println("1 - Inserir 1 elemento no Vetor 1");
            System.out.println("2 - Inserir 1 elemento no Vetor 2");
            System.out.println("3 - Imprimir  Conjunto A e B");
            System.out.println("4 - Somar Vetores");
            System.out.println("5 - Remover todos os elementos repetidos");
            System.out.println("6 - Ordenar vetor forma crescente");
            System.out.println("7 - Ordenar vetor forma decrescente");
            System.out.println("8 - Imprimir duplicados");
            System.out.println("0 - Sair");
            System.out.print("Escolha uma " + "opção: ");
            opcao = scanner.nextInt();
            switch(opcao){
                case 1:
                    System.out.println("VETOR UM");
                    qtd1 = preencherVetor(vetor1, qtd1);
                    break;
                case 2:
                    System.out.println("VETOR DOIS");
                    qtd2 = preencherVetor(vetor2, qtd2);
                    break;
                case 3:
                    System.out.print("\nVETOR UM = ");
                    imprimir(vetor1, qtd1);
                    System.out.print("\nVETOR DOIS = ");
                    imprimir(vetor2, qtd2);
                    break;
                case 4:
                    vetorResult = somarVetores(vetor1, qtd1, vetor2, qtd2);

                    if(vetorResult != null){
                        System.out.print("\nSoma de 1 e 2 = ");
                        imprimir(vetorResult,vetorResult.length);
                    }
                    break;
                case 5:
                    System.out.println("Digite o numero que deseja remover");
                    item = scanner.nextInt();

                    int tamanhoAntes = qtd1;
                    int novoTamanho = removerTodos(vetor1, qtd1, item);

                    if (novoTamanho != tamanhoAntes) {
                        System.out.println("Vetor sem repetidos:");
                        imprimir(vetor1, novoTamanho);
                    } else {
                        System.out.println("Nenhum elemento foi removido — o valor não foi encontrado no vetor.");
                    }
                    qtd1 = novoTamanho;
                    break;
                case 6:
                    insercaoDireta(vetor1, qtd1);
                    imprimir(vetor1,qtd1);
                    break;
                case 7:
                    System.out.println("Vetor em ordem decrescente");
                    vetor1 = inverter(vetor1, qtd1);
                    imprimir(vetor1, qtd1);
                    break;
                case 8:
                    System.out.println("TABELA DUPLICADOS");
                    imprimirDuplicados(vetor1, qtd1);
                    break;
                case 0:
                    System.out.println("Encerrando o programa...");
                    break;
                default:
                    System.out.println("Opção invalida!");
            }
        } while (opcao!=0);

    }

    public static void imprimirDuplicados(int [] v, int tam){
        int qtd = 1;
        insercaoDireta(v,tam);
        System.out.println("NUM | QTD");
        for(int i = 1; i < tam; i++) {
            if(v[i - 1] == v[i] ){
                qtd++;
            }
            else{
                System.out.println(v[i - 1] + " | " + qtd);
                qtd = 1;
            }
        }
        System.out.println(v[tam - 1] + " | " + qtd);
    }

    public static void insercaoDireta(int [] v, int qtd){
        int j;
        int chave;
        for(int i = 1; i <= qtd - 1; i++){
            chave = v[i];
            j = i - 1;
            while (j >= 0 && v[j] > chave){
                v[j + 1] = v[j];
                j = j - 1;
            }
            v[j + 1] = chave;
        }
    }

    public static int[] inverter(int[] v, int qtd){
        insercaoDireta(v,qtd);
        int[] invertido = new int[qtd];
        for(int i = 0; i < qtd; i ++){
            invertido[i] = v[qtd - 1 - i];
        }
        return invertido;
    }


    public static int preencherVetor(int[] v, int qtd){
        if(qtd >v.length){
            System.out.println("Vetor cheio! Proibido inserir novos valores.");
            return qtd;
        } else {
            System.out.println("Digite o valor que deseja inserir no vetor: ");
            v[qtd] = scanner.nextInt();
            qtd++;
        }
        return qtd;
    }

    public static void imprimir(int[] v, int qtd){
        System.out.print("{");
        if(qtd == 0){
            System.out.print(" VAZIO");
        }
        else if(qtd>0){
            System.out.print(" " + v[0]);
        } for (int i = 1; i < qtd; i++){
            System.out.print(", " + v[i]);
        }
        System.out.println(" }");
    }

    public static int[] somarVetores(int[] vetor1,int qtd1,int[] vetor2,int qtd2) {
        int[] novoVetor = new int[qtd1];
        if(qtd1 != qtd2){
            System.out.println("ERRO! Vetores precisam ser do mesmo tamanho.");
            return null;
        }
        for(int i = 0;i < qtd1; i++){
            novoVetor[i] = vetor1[i] + vetor2[i];
        }
        return novoVetor;
    }

    public static int removerTodos(int[] vetor, int tam, int valor){
        int novoTam = 0;
        for (int i = 0; i < tam; i++) {
            if(vetor[i] != valor) {
                vetor[novoTam] = vetor[i];
                novoTam++;
            }
        }
        return novoTam;
    }

    public static int buscaSequencial(int[] vetor, int qtd, int valor){
        for(int i = 0; i < qtd; i++){
            if(vetor[i] == valor){
                return i;
            }
        }
        return -1;
    }

}
