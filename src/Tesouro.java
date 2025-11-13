
public class Tesouro {

    //Cada tesouro tem sua cor, que será seu identificador no mapa, e sua posição no tabuleiro
    private String cor;
    private int x, y; //x é a coluna e y é a linha
    private int valorPontos;
    private String identificador;

    //O objeto tesouro é criado recebendo cor, x e y como argumentos
    public Tesouro(String cor, int x, int y, int valorPontos) {
        this.cor = cor;
        this.x = x;
        this.y = y;
        this.valorPontos = valorPontos;
        this.identificador = String.valueOf(this.cor.charAt(0));
    }

    public String getCor() {
        return cor;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getValorPontos() {
        return valorPontos;
    }

    public String getIdentificador() {
        return identificador;
    }
}
