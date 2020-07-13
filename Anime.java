public class Anime extends Animacao {
    
    //private int nTemporadas;

    public Anime(int id, String nome, String classificacaoIndicativa, String estudio, String genero/*,  Temporada[] temporada */) {
        super(id, nome, classificacaoIndicativa, estudio, genero);
        //setTemporada(temporada);
    }
    
    @Override
    public String toString() {
        return "id: " + getId() + "      Anime: " + getNome() + "\nClassificaçao indicativa: "
                + getClassificacaoIndicativa() + "\nEstudio: " + getEstudio() + "\nGenero: " + getGenero() + "\n";
    }

}