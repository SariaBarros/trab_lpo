public class Anime extends Animacao {
    private Temporada[] temporada;

    private int nTemporadas = 0;

    public Anime(String nome, String classificacaoIndicativa, String estudio, String[] genero/*,  Temporada[] temporada */) {
        super(nome, classificacaoIndicativa, estudio, genero);
        //setTemporada(temporada);
    }
    //get e set
    public Temporada[] getTemporada() {
        return temporada;
    }

    public void setTemporada(Temporada[] temporada) {
        this.temporada = temporada;
    }
    
    public void adicionaTemporada(Temporada temporada) { // chamada na main: Anime[i].adicionaTemporada(novaTemporada);
        this.temporada[nTemporadas] = temporada;
        nTemporadas++;
    }

}