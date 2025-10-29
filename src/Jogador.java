
public class Jogador {

    //Cada jogador tem um nome e seu próprio tabuleiro 10x10
    private String nome;
    private Tabuleiro tabuleiro;

    //O objeto jogador é criado recebendo um nome como argumento
    public Jogador(String nome) {
        this.nome = nome;
        this.tabuleiro = new Tabuleiro();
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
        if(tesouro.getX() < 0 || tesouro.getX() > 9 || tesouro.getY() < 0 || tesouro.getY() > 9) {
            return false;
        }

        Tesouro[][] matrizTabuleiro = this.tabuleiro.getPosicoes();
        boolean podePosicionar = true;

        for (int i = 0; i < matrizTabuleiro.length; i++) {
            for (int j = 0; j < matrizTabuleiro[0].length; j++) {
                if(matrizTabuleiro[i][j] != null) { //Já existe um tesouro nessa posição
                    podePosicionar = false;
                    break;
                }
            }

            if(podePosicionar) {break;}
        }

        return podePosicionar;
    }

}
