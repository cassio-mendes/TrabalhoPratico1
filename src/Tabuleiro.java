
public class Tabuleiro {

    //Cada tabuleiro possui uma matriz que mostra as posições dos tesouros e espaços vazios
    private Tesouro[][] posicoes;

    //O objeto tabuleiro é criado sem receber argumentos
    public Tabuleiro() {
        this.posicoes = new Tesouro[10][10]; //As posições vazias terão o valor null
    }

    //Posiciona o tesouro na posição correta
    public void posicionarTesouro(Tesouro tesouro) {
        this.posicoes[tesouro.getY()][tesouro.getX()] = tesouro;
    }

    public Tesouro[][] getPosicoes() {
        return posicoes;
    }
}
