
public class Jogo {

    private int pontuacao1, pontuacao2; //Pontuação de cada jogador
    private int rodadas; //Rodada atual
    private int tesourosPerdidos1, tesourosPerdidos2; //Número de tesouros que cada jogador já perdeu

    Jogo(){
        this.pontuacao1 = 0;
        this.pontuacao2 = 0;
        this.tesourosPerdidos1 = 0;
        this.tesourosPerdidos2 = 0;
        this.rodadas = 1;
    }

    public void proximaRodada() {
        this.rodadas++;
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

}
