import java.util.Scanner;

public class Main {

    static Scanner scanner = new Scanner(System.in);
    static Jogo jogo = new Jogo();

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
                    iniciarJogo(jogador1, jogador2);
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

    private static void mostrarTabuleiros(Jogador jogador1, Jogador jogador2) {
        System.out.println("----- TABULEIROS -----\n");

        System.out.println("    " + jogador1.getNome());
        imprimirMatriz(jogador1); //Tabuleiro jogador1

        System.out.println("\n    " + jogador2.getNome());
        imprimirMatriz(jogador2); //Tabuleiro jogador2
    }

    private static void imprimirMatriz(Jogador jogador) {
        Tesouro[][] tabuleiro = jogador.getTabuleiro().getPosicoes();
        final int TAMANHO_TABULEIRO = jogador.getTabuleiro().getPosicoes().length;

        for (int i = 0; i < TAMANHO_TABULEIRO; i++) {
            for (int j = 0; j < TAMANHO_TABULEIRO; j++) {
                if(tabuleiro[i][j] == null) {
                    System.out.print("# ");
                } else {
                    System.out.print(tabuleiro[i][j].getIdentificador() + " ");
                }
            }

            System.out.println();
        }
    }

    private static void iniciarJogo(Jogador jogador1, Jogador jogador2) {
        System.out.println("-----PREENCHENDO TABULEIROS-----");
        preencherTabuleiro(jogador1, 1);
        preencherTabuleiro(jogador2, 2);

        System.out.println("-----COMEÇANDO O JOGO-----\n");
        Jogador jogadorAtual, outroJogador;

        //Laço só se encerra quando o jogo acabar
        while(jogo.getRodadas() < 21 || jogo.getTesourosPerdidos1() < 8 || jogo.getTesourosPerdidos2() < 8) {

            //Se a rodada atual for par, vez do jogador2; do contrário, vez do jogador1
            if(jogo.getRodadas() % 2 == 0) {
                jogadorAtual = jogador2;
                outroJogador = jogador1;
            } else {
                jogadorAtual = jogador1;
                outroJogador = jogador2;
            }

            jogar(jogadorAtual, outroJogador);
        }
    }

    private static void jogar(Jogador jogadorAtual, Jogador outroJogador) {
        System.out.println("-----VEZ DE " + jogadorAtual.getNome() + "-----\n");
        mostrarTabuleiros(jogadorAtual, outroJogador);

        System.out.printf("\n%s, Informe as coordenadas do tesouro do %s\n",
                jogadorAtual.getNome(), outroJogador.getNome());

        int linha, coluna;
        boolean valoresValidos;

         do {
            System.out.print("Linha (0 a 9): ");
            linha = scanner.nextInt();

            System.out.print("Coluna (0 a 9): ");
            coluna = scanner.nextInt();

            valoresValidos = !(linha < 0 || linha > 9 || coluna < 0 || coluna > 9);
            if(!valoresValidos) { System.out.println("Coordenadas inválidas, tente de novo!\n"); }

        } while(!valoresValidos);

        if(jogadorAtual.encontrarTesouro(linha, coluna)) { //Achou um tesouro
            Tesouro tesouroEncontrado = outroJogador.getTabuleiro().getPosicoes()[linha][coluna];

            System.out.println("\nPARABÉNS!! " + jogadorAtual.getNome() + " achou um tesouro " +
                    tesouroEncontrado.getCor() + "!!");

            System.out.println(jogadorAtual.getNome() + " recebeu " + tesouroEncontrado.getValorPontos() + " pontos!!");
        } else {


        }
    }

    private static void preencherTabuleiro(Jogador jogador, int numerojogador) {
        System.out.println("\nJogador " + jogador.getNome() + ", informe as coordenadas dos seus tesouros:");

        System.out.print("AMARELOS (4 pontos cada):");
        for (int i = 0; i < 3; i++) {
            inserirTesouro(jogador, numerojogador, "Amarelo", 4);
            if(i != 2) { System.out.println("Tesouro posicionado! Insira os valores do próximo"); }
        }

        System.out.println("\nLARANJAS (6 pontos cada):");
        for (int i = 0; i < 3; i++) {
            inserirTesouro(jogador, numerojogador, "Laranja", 6);
            if(i != 2) { System.out.println("Tesouro posicionado! Insira os valores do próximo"); }
        }

        System.out.println("\nVERMELHOS (10 pontos cada):");
        for (int i = 0; i < 2; i++) {
            inserirTesouro(jogador, numerojogador, "Vermelho", 10);
            if(i != 1) { System.out.println("Tesouro posicionado! Insira os valores do próximo"); }
        }
    }

    private static void inserirTesouro(Jogador jogador, int numerojogador, String cor, int valorPontos) {
        boolean posicionou;
        do {
            System.out.print("Linha (0 a 9): ");
            int linha = scanner.nextInt();

            System.out.print("Coluna (0 a 9): ");
            int coluna = scanner.nextInt();

            posicionou = jogador.posicionarTesouro(new Tesouro(cor, linha, coluna, valorPontos));
            if(numerojogador == 1) {

            }

            if(!posicionou) {
                System.out.println("\nERRO: insira coordenadas válidas! Dois tesouros não podem ocupar o mesmo espaço\n");
            }
        } while(!posicionou);
    }

}