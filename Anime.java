public class Anime extends Animacao {
    
    //private int nTemporadas;

    public Anime(String nome, String classificacaoIndicativa, String estudio, String genero/*,  Temporada[] temporada */) {
        super(nome, classificacaoIndicativa, estudio, genero);
        //setTemporada(temporada);
    }
    
    @Override
    public String toString() {
        return "id: " + getId() + "      Anime: " + getNome() + "\nClassificaçao indicativa: "
                + getClassificacaoIndicativa() + "\nEstudio: " + getEstudio() + "\nGenero: " + getGenero() + "\n";
    }

}