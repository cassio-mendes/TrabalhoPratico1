import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

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

    //pq que o parâmetro tem os dois jogadores? tô tentando fazer uma 
    //ordenção de jogadas em jogo! dps dá uma olhada pfvr
    private static void jogar(Jogador jogador1, Jogador jogador2) {

    }

}