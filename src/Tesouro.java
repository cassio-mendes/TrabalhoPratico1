
public class Tesouro {

    //Cada tesouro tem sua cor, que será seu identificador no mapa, e sua posição no tabuleiro
    private char cor;
    private int x, y; //x é a coluna e y é a linha

    //O objeto tesouro é criado recebendo cor, x e y como argumentos
    public Tesouro(char cor, int x, int y) {
        this.cor = cor;
        this.x = x;
        this.y = y;
    }

    public char getCor() {
        return cor;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}
