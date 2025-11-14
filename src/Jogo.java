
public class Jogo {

    private int pontuacao1, pontuacao2; //Pontuação de cada jogador
    private int rodadas; //Rodada atual
    private int tesourosPerdidos1, tesourosPerdidos2; //Número de tesouros que cada jogador já perdeu

    //Matrizes com as coordenadas dos tesouros dos jogadores
    private int[][] tesourosEncontrados1;
    private int[][] tesourosEncontrados2;

    Jogo(){
        this.pontuacao1 = 0;
        this.pontuacao2 = 0;
        this.tesourosPerdidos1 = 0;
        this.tesourosPerdidos2 = 0;
        this.rodadas = 1;

        //Cada linha é um tesouro diferente -> 0 a 2 são os amarelos, 4 a 5 os laranjas, 6 e 7 os vermelhos
        //As duas primeiras colunas são a linha e a coluna do tesouro no tabuleiro
        //A terceira coluna indica se esse tesouro já foi encontrado: 1 para encontrado e 0 para ainda oculto
        this.tesourosEncontrados1 = new int[8][3];
        this.tesourosEncontrados2 = new int[8][3];
    }

    public void proximaRodada() {
        this.rodadas++;
    }

    public void inserirCoordTesouro1(int linha, int coluna) {

    }

    public void inserirCoordTesouro2(int linha, int coluna) {

    }

    public int getPontuacao1() {
        return pontuacao1;
    }

    public int getPontuacao2() {
        return pontuacao2;
    }

    public int getRodadas() {
        return rodadas;
    }

    public int getTesourosPerdidos1() {
        return tesourosPerdidos1;
    }

    public int getTesourosPerdidos2() {
        return tesourosPerdidos2;
    }

    public int[][] getTesourosEncontrados1() {
        return tesourosEncontrados1;
    }

    public int[][] getTesourosEncontrados2() {
        return tesourosEncontrados2;
    }
}
