
public class Remover {
    public static void main(String[] args) {
        int[] vetor = {1, 2, 3, 2, 5, 2, 2, 4, 2};
        int tam = 9;
        int valor = 2;
        System.out.print("Original: ");
        imprimir(vetor, tam);

        tam = removerTodos(vetor, tam, valor); // Atualiza tam com o novo tamanho

        System.out.print("\nApós remover " + valor + ": ");
        imprimir(vetor, tam);
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
    //codigo removerTodos Professor
    public static int removerTodos(int[] v, int tam, int x){
        int desl = 0;
        for (int i = 0; i < tam; i++){
            if(v[i] == x){
                desl++;
            } else {
                v[i - desl] = v[i];
            }
        }
        return tam - desl;
    }

    //codigo removerTodos Copilot

    public static int removerTodos2(int[] v, int tam, int x){
        int novoTam = 0;
        for (int i = 0; i < tam; i++) {
            if(v[i] != x) {
                v[novoTam] = v[i];
                novoTam++;
            }
        }
        return novoTam;
    }
}
