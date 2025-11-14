
public class Tesouro {

    //Cada tesouro tem sua cor, que será seu identificador no mapa, e sua posição no tabuleiro
    private String cor;
    private int linha, coluna;
    private int valorPontos;
    private String identificador;
    private boolean encontrado; //Indica se o tesouro já foi encontrado ou não

    //O objeto tesouro é criado recebendo cor, x e y como argumentos
    public Tesouro(String cor, int linha, int coluna, int valorPontos) {
        this.cor = cor;
        this.linha = linha;
        this.coluna = coluna;
        this.valorPontos = valorPontos;
        this.identificador = String.valueOf(this.cor.charAt(0));
        this.encontrado = false;
    }

    public String getCor() {
        return this.cor;
    }

    public int getLinha() {
        return this.linha;
    }

    public int getColuna() {
        return this.coluna;
    }

    public int getValorPontos() {
        return this.valorPontos;
    }

    public String getIdentificador() {
        return this.identificador;
    }

    public boolean getEncontrado() { return this.encontrado; }

    public void setEncontrado(boolean encontrado) { this.encontrado = encontrado; }
}
