public class Anime extends Animacao {

    // private int nTemporadas = 0;

    public Anime(int id, String nome, String classificacaoIndicativa, String estudio, String genero) {
        super(id, nome, classificacaoIndicativa, estudio, genero);
    }

    // construtor sobrecarregado usado para objetos
    // auxiliares no cadastro de animaçoes
    public Anime(int fk) {
        super(fk, null, null, null, null);
    }

    @Override
    public String toString() {
        return "id: " + getId() + "      Anime: " + getNome() + "\nClassificaçao indicativa: "
                + getClassificacaoIndicativa() + "\nEstudio: " + getEstudio() + "\nGenero: " + getGenero() + "\n";
    }
}