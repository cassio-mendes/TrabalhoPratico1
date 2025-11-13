import java.util.Scanner;

public class Main {

    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("-----BEM VINDO à CAÇA AO TESOURO!!!-----");
        System.out.println("     Quais os jogadores de hoje?");
        String nome1 = scanner.next();
        String nome2 = scanner.next();

        Jogador jogador1 = new Jogador(nome1);
        Jogador jogador2 = new Jogador(nome2);

        int opcao;
        do {
            mostrarMenuInicial(nome1, nome2);
            opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    jogar(jogador1, jogador2);
                    break;

                case 2:
                    mostrarRegras();
                    break;

                case 3:
                    System.exit(0);
                    break;

                default:
                    System.out.println("Opção inválida... Tente de novo!");
            }
        } while(opcao != 1);
    }

    private static void mostrarMenuInicial(String nome1, String nome2) {
        System.out.printf("\n-----%s e %s, escolham uma opção para prosseguir-----\n", nome1, nome2);
        System.out.println("1 - Jogar");
        System.out.println("2 - Regras");
        System.out.println("3 - SAIR");
        System.out.print("Digite aqui: ");
    }

    private static void mostrarRegras() {
        System.out.println("""
                \nNo início da partida, cada jogador irá informar as posições dos seus 8 tesouros no
                tabuleiro 10x10. Deve-se informar a linha e a coluna do tesouro, que vão de 0 a 9. O jogo terá um total
                de 20 rodadas, 10 para cada jogador. A cada rodada, vocês devem tentar adivinhar onde está o tesouro do
                adversário, informando uma coordenada (linha e coluna) válida. Existem 3 tipos de tesouros:
                Amarelos - 4 pontos; Laranjas - 6 pontos; Vermelhos: 10 pontos. Cada jogador terá 3 Laranjas, representados
                pela letra 'L'; 3 Amarelos, de letra 'A'; e 2 Vermelhos, de letra 'V'. O jogo termina quando todos os
                tesouros de um jogador forem encontrados, ou depois de se passarem as 20 rodadas. Neste caso, vence
                quem acumular mais pontos.""");
    }

    private static void mostrarMenuJogo() {
        System.out.println();
    }

    private static void mostrarTabuleiros(Jogador jogador1, Jogador jogador2) {
        System.out.println("----- TABULEIROS -----\n");

        System.out.println("    " + jogador1.getNome());
        imprimirMatriz(jogador1); //Tabuleiro jogador1

        System.out.println("\n    " + jogador2.getNome());
        imprimirMatriz(jogador2); //Tabuleiro jogador2
    }

    private static void imprimirMatriz(Jogador jogador) {
        final int TAMANHO_TABULEIRO = jogador.getTabuleiro().getPosicoes().length;

        for (int i = 0; i < TAMANHO_TABULEIRO; i++) {
            for (int j = 0; j < TAMANHO_TABULEIRO; j++) {
                System.out.print(jogador.getTabuleiro().getPosicoes()[i][j].getIdentificador() + " ");
            }

            System.out.println();
        }
    }

    private static void jogar(Jogador jogador1, Jogador jogador2) {
        System.out.println("-----PREENCHENDO TABULEIROS-----");
        preencherTabuleiro(jogador1);
        preencherTabuleiro(jogador2);

        System.out.println("-----COMEÇANDO O JOGO-----");
        Jogo jogo = new Jogo();


    }

    private static void preencherTabuleiro(Jogador jogador) {
        System.out.println("\nJogador " + jogador.getNome() + ", informe as coordenadas dos seus tesouros:");

        System.out.print("AMARELOS (4 pontos cada):");
        for (int i = 0; i < 3; i++) {
            inserirTesouro(jogador, "Amarelo", 4);
            if(i != 2) { System.out.println("Tesouro posicionado! Insira os valores do próximo"); }
        }

        System.out.println("\nLARANJAS (6 pontos cada):");
        for (int i = 0; i < 3; i++) {
            inserirTesouro(jogador, "Laranja", 6);
            if(i != 2) { System.out.println("Tesouro posicionado! Insira os valores do próximo"); }
        }

        System.out.println("\nVERMELHOS (10 pontos cada):");
        for (int i = 0; i < 2; i++) {
            inserirTesouro(jogador, "Vermelho", 10);
            if(i != 1) { System.out.println("Tesouro posicionado! Insira os valores do próximo"); }
        }
    }

    private static void inserirTesouro(Jogador jogador, String cor, int valorPontos) {
        boolean posicionou;
        do {
            System.out.print("Linha (0 a 9): ");
            int linha = scanner.nextInt();

            System.out.print("Coluna (0 a 9): ");
            int coluna = scanner.nextInt();

            posicionou = jogador.posicionarTesouro(new Tesouro(cor, coluna, linha, valorPontos));

            if(!posicionou) {
                System.out.println("\nERRO: insira coordenadas válidas! Dois tesouros não podem ocupar o mesmo espaço\n");
            }
        } while(!posicionou);
    }

}