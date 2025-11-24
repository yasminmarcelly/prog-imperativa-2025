import java.util.Scanner;

public class Main {
    public static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        Produto[] produto = new Produto[50];
        int opcao, qtd = 0;

        do {
            System.out.println("1 - Cadastrar Produto");
            System.out.println("2 - Listar Produto");
            System.out.println("3 - Filtrar p/ categoria");
            System.out.println("4 - Ordenar");
            System.out.println("5 - Remover elemento");
            System.out.println("6 - Atualizar preco");
            System.out.println("7 - Listagem c subtotal do valor em estoque por categoria");
            System.out.println("0 - Sair");
            opcao = sc.nextInt();
            sc.nextLine();

            switch (opcao) {
                case 1:
                    qtd = cadastrarProduto(produto, qtd);
                    break;
                case 2:
                    imprimirProduto(produto, qtd);
                    break;
                case 3:
                    filtrarPorCategoria(produto, qtd);
                    break;
                case 4:
                    insertionSortOrdenar(produto, qtd);
                    break;
                case 5:
                    qtd = removerProduto(produto, qtd);
                    break;
                case 6:
                    atualizarPreco(produto, qtd);
                    break;
                case 7:
                    subtotalPorCategoria(produto, qtd);
                    break;

            }
        } while (opcao != 0);
    }

    public static int cadastrarProduto(Produto[] v, int qtd) {
        if (qtd >= v.length) {
            System.out.println("Vetor cheio! Impossivel cadastrar novo produto.");
            return qtd;
        }

        v[qtd] = new Produto();

        System.out.println("Nome: ");
        v[qtd].nome = sc.nextLine();
        System.out.println("Categoria: ");
        v[qtd].categoria = sc.nextLine();
        System.out.println("Quantidade estoque: ");
        v[qtd].qtdEstq = sc.nextInt();
        System.out.println("Valor unitario: ");
        v[qtd].precoUnit = sc.nextDouble();
        System.out.println("Quantidade min em estoque: ");
        v[qtd].qtdMin = sc.nextInt();
        sc.nextLine();

        qtd++;
        return qtd;
    }

    public static void imprimirProduto(Produto[] v, int qtd) {
        if (qtd == 0) {
            System.out.println("Estoque vazio! Nenhum produto cadastrado.");
            return;
        }
        for (int i = 0; i < qtd; i++) {
            System.out.printf("%s, %s, %d, %.2f, %d\n",
                    v[i].nome,
                    v[i].categoria,
                    v[i].qtdEstq,
                    v[i].precoUnit,
                    v[i].qtdMin);
        }
    }

    public static void filtrarPorCategoria(Produto[] v, int qtd) {
        System.out.println("Digite a categoria que deseja filtrar: ");
        String categoria = sc.nextLine();

        for (int i = 0; i < qtd; i++) {
            if (v[i].categoria.equalsIgnoreCase(categoria)) {
                System.out.printf("%s, %d, %.2f, %d\n",
                        v[i].nome,
                        v[i].qtdEstq,
                        v[i].precoUnit,
                        v[i].qtdMin);
            } else {
                System.out.println("Nenhum produto encontrado nessa categoria");
            }
        }

    }

    public static void insertionSortOrdenar(Produto[] v, int qtd) {
        for (int i = 1; i < qtd; i++) {
            Produto atual = v[i];
            int j = i - 1;

            while (j >= 0 && v[j].nome.compareTo(atual.nome) > 0) {
                v[j + 1] = v[j];
                j--;
            }
            v[j + 1] = atual;
        }
        System.out.println("Produtos ordenados.");
    }

    public static int removerProduto(Produto[] v, int qtd) {
        System.out.println("Nome do produto que deseja remover: ");
        String nome = sc.nextLine();

        int pos = buscarProduto(v, qtd, nome);

        if (pos == -1) {
            System.out.println("Produto nao existe");
            return qtd;
        }

        for (int i = pos; i < qtd - 1; i++) {
            v[i] = v[i + 1];
        }

        System.out.println("Produto removido");
        return qtd - 1;
    }

    public static int buscarProduto(Produto[] v, int qtd, String nomeProd) {
        for (int i = 0; i < qtd; i++) {
            if (v[i].nome.equalsIgnoreCase(nomeProd)) {
                return i;
            }
        }
        return -1;
    }

    public static void atualizarPreco(Produto[] v, int qtd) {
        System.out.println("Digite o produto que queira atualizar o valor: ");
        String nome = sc.nextLine();

        int pos = buscarProduto(v, qtd, nome);

        if (pos == -1) {
            System.out.println("Produto nao existe");
            return;
        }

        System.out.println("Digite o novo valor: ");
        v[pos].precoUnit = sc.nextDouble();
        sc.nextLine();
        System.out.println("Valor atualizado");
    }

    //Resolucao IA
    public static void subtotalPorCategoria(Produto[] v, int qtd) {

        if (qtd == 0) {
            System.out.println("Nenhum produto cadastrado.");
            return;
        }

        // 1) Criar vetor de categorias (sem repetição)
        String[] categorias = new String[qtd];
        int qtdCat = 0;

        for (int i = 0; i < qtd; i++) {
            String cat = v[i].categoria;
            boolean existe = false;

            for (int j = 0; j < qtdCat; j++) {
                if (categorias[j].equalsIgnoreCase(cat)) {
                    existe = true;
                    break;
                }
            }

            if (!existe) {
                categorias[qtdCat] = cat;
                qtdCat++;
            }
        }

        // 2) Ordenar categorias pelo nome (insertion sort)
        for (int i = 1; i < qtdCat; i++) {
            String atual = categorias[i];
            int j = i - 1;

            while (j >= 0 && categorias[j].compareToIgnoreCase(atual) > 0) {
                categorias[j + 1] = categorias[j];
                j--;
            }
            categorias[j + 1] = atual;
        }

        // 3) Para cada categoria ordenada → listar produtos + subtotal
        for (int i = 0; i < qtdCat; i++) {

            String categoriaAtual = categorias[i];
            System.out.println("\nCategoria: " + categoriaAtual);

            // Criar vetor temporário com produtos dessa categoria
            Produto[] aux = new Produto[qtd];
            int k = 0;

            for (int j = 0; j < qtd; j++) {
                if (v[j].categoria.equalsIgnoreCase(categoriaAtual)) {
                    aux[k] = v[j];
                    k++;
                }
            }

            // Ordenar produtos dessa categoria por nome
            for (int x = 1; x < k; x++) {
                Produto atual = aux[x];
                int y = x - 1;

                while (y >= 0 && aux[y].nome.compareToIgnoreCase(atual.nome) > 0) {
                    aux[y + 1] = aux[y];
                    y--;
                }
                aux[y + 1] = atual;
            }

            // Listar produtos + calcular subtotal
            double subtotal = 0;

            for (int x = 0; x < k; x++) {
                Produto p = aux[x];
                System.out.printf(" - %s | qtd: %d | valor: %.2f\n",
                        p.nome, p.qtdEstq, p.precoUnit);

                subtotal += p.precoUnit * p.qtdEstq;
            }

            System.out.printf("Subtotal da categoria %s: R$ %.2f\n", categoriaAtual, subtotal);
        }
    }

}
