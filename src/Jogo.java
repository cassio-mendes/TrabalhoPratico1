
public class Jogo {

    public int pontuacao1 = 0, pontuacao2 = 0;
    public int rodadas = 20;

    Jogo(int pont1, int pont2, int rod){
        this.pontuacao1 = pont1;
        this.pontuacao2 = pont2;
        this.rodadas = rod;
    }

    public boolean alternarPartidas(){
        while (rodadas > 0){
            for(int jogador = 1; jogador <= 2; jogador++){
                if(rodadas = 0){
                    break;
                }
                Main main = new Main();
                main.jogar(/* colocar um jogador só aqui, e ir alternando com o for */);
            }
        }
    }

}
