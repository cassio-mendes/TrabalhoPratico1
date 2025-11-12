
public class Jogo {

    public int pontuacao1 = 0, pontuacao2 = 0;
    public int rodadas;

    Jogo(int pont1, int pont2){
        this.pontuacao1 = pont1;
        this.pontuacao2 = pont2;
        this.rodadas = 20;
    }

    public boolean alternarPartidas(){
        while (rodadas > 0){
            for(int i = rodadas; i >= 0; i--){
                if(i % 2 == 0){
                    //jogador1 joga
                } else {
                    //jogador2 joga
                }
            }
        }
    }

}
