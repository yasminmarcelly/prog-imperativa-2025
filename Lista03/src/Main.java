import java.util.Scanner;

public class Main {
    public static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {

    }

    public static int buscarPessoa(Pessoa[] v, int qtd, String nome) {
        for (int i = 0; i < qtd; i++) {
            if (v[i].nome.equalsIgnoreCase(nome)) {
                return i;
            }
        }
        return -1;
    }

    public static int cadastrarPessoa(Pessoa[] v, int qtd) {
        if (qtd == v.length) {
            System.out.println("Vetor cheio! Impossivel inserir novos valores.");
            return qtd;
        }
        Pessoa p = new Pessoa();

        System.out.print("Digite o nome: ");
        String nome = scanner.nextLine();
        while (buscarPessoa(v, qtd, nome) == 1) {
            System.out.println("Nome já cadastrado! Digite outro.");
            nome = scanner.nextLine();
        }
        p.nome = nome;

        System.out.print("Digite a idade: ");
        p.idade = scanner.nextInt();

        System.out.print("Digite o peso: ");
        p.peso = scanner.nextDouble();

        System.out.print("Digite a altura: ");
        p.altura = scanner.nextDouble();
        scanner.nextLine();

        v[qtd] = p;
        qtd++;
        return qtd;
    }

    public static double calcularIMC(Pessoa p) {
        double imc = p.peso / (p.altura * p.altura);
        return imc;
    }

    public static void imprimirPessoas(Pessoa[] v, int qtd) {
        if (qtd == 0) {
            System.out.println("Nenhuma pessoa cadastrada!");
        }

        for (int i = 0; i < qtd; i++) {
            double imc = calcularIMC(v[i]);

            System.out.println("Pessoa " + (i + 1));
            System.out.println("Nome: " + v[i].nome);
            System.out.println("Idade: " + v[i].idade);
            System.out.println("Peso: " + v[i].peso);
            System.out.println("Altura: " + v[i].altura);
            System.out.printf("IMC: %.2f", imc);
        }
    }

    public static int maisVelhaIMCMagreza(Pessoa[] v, int qtd) {
        int maisVelho = -1;
        int posicao = -1;

        for (int i = 0; i < qtd; i++) {
            double imc = calcularIMC(v[i]);

            if (imc < 18.5) {
                if (v[i].idade > maisVelho) {
                    maisVelho = v[i].idade;
                    posicao = i;
                }
            }
        }
        return posicao;
    }
    
// Resolução IA
    public static void insertionSortPorNome(Pessoa[] v, int qtd) {
        for (int i = 1; i < qtd; i++) {
            Pessoa atual = v[i];
            int j = i - 1;

            while (j >= 0 && v[j].nome.compareToIgnoreCase(atual.nome) > 0) {
                v[j + 1] = v[j];
                j--;
            }

            v[j + 1] = atual;
        }
    }

}

