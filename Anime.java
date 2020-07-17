public class Anime extends Animacao {

    //construtor para o CREATE e UPDATE - sem id
    public Anime(String nome, String classificacaoIndicativa, String estudio, String genero) {
        super(nome, classificacaoIndicativa, estudio, genero);
    }
    
    //contrutor padrão
    public Anime(int id, String nome, String classificacaoIndicativa, String estudio, String genero) {
        super(id, nome, classificacaoIndicativa, estudio, genero);
    }

    // construtor usado para objetos auxiliares no cadastro de animaçoes
    public Anime(int fk) {
        super(fk, null, null, null, null);
    }

    @Override
    public String toString() {
        return "idA: " + getId() + "        Anime: " + getNome() + "      \nClassificaçao indicativa: "
                + getClassificacaoIndicativa() + "      \nEstudio: " + getEstudio() + "      \nGenero: " + getGenero() + "\n";
    }
}