import java.util.ArrayList;

public class Jogador {

    //Cada jogador tem um nome e seu próprio tabuleiro 10x10
    private String nome;
    private Tabuleiro tabuleiro;
    private ArrayList<int[]> listaJogadas;

    //O objeto jogador é criado recebendo um nome como argumento
    public Jogador(String nome) {
        this.nome = nome;
        this.tabuleiro = new Tabuleiro();
        this.listaJogadas = new ArrayList<>();
    }

    public boolean encontrarTesouro(Tabuleiro tabuleiroInimigo, int linha, int coluna) {
        this.listaJogadas.add(new int[]{linha, coluna});
        return tabuleiroInimigo.getPosicoes()[linha][coluna] != null;
    }

    //Posiciona um tesouro no tabuleiro do jogador e retorna true, se possível, senão retorna false
    public boolean posicionarTesouro(Tesouro tesouro) {
        if(validarPosicoes(tesouro)) {
            this.tabuleiro.posicionarTesouro(tesouro);
            return true;
        }

        return false;
    }

    //Verifica se o tesouro pode ser colocado nessa posição
    private boolean validarPosicoes(Tesouro tesouro) {
        if(tesouro.getLinha() < 0 || tesouro.getLinha() > 9 || tesouro.getColuna() < 0 || tesouro.getColuna() > 9) {
            return false;
        }

        //Se o tabuleiro na linha y e na coluna x tiver valor null, esse espaço está vazio e pode receber um tesouro
        return this.tabuleiro.getPosicoes()[tesouro.getLinha()][tesouro.getColuna()] == null;
    }

    public String getNome() {
        return nome;
    }

    public Tabuleiro getTabuleiro() {
        return tabuleiro;
    }

    public ArrayList<int[]> getListaJogadas() { return this.listaJogadas; }
}
