
public class Tesouro {

    //Cada tesouro tem sua cor, que será seu identificador no mapa, e sua posição no tabuleiro
    private String cor;
    private int linha, coluna;
    private int valorPontos;
    private String identificador;

    //O objeto tesouro é criado recebendo cor, x e y como argumentos
    public Tesouro(String cor, int linha, int coluna, int valorPontos) {
        this.cor = cor;
        this.linha = linha;
        this.coluna = coluna;
        this.valorPontos = valorPontos;
        this.identificador = String.valueOf(this.cor.charAt(0));
    }

    public String getCor() {
        return cor;
    }

    public int getLinha() {
        return linha;
    }

    public int getColuna() {
        return coluna;
    }

    public int getValorPontos() {
        return valorPontos;
    }

    public String getIdentificador() {
        return identificador;
    }
}
