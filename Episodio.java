public class Episodio {
    private int id;
    private int numeroEp;
    private String titulo;
    private String duracao;
    private Temporada fkTemp; // *funcionará como FK da tab Temporada - inserida em EpisodioDAO.create() por
                              // composição
    private Anime fkAnime; // *funcionará como FK da tab Anime - inserida em EpisodioDAO.create() por
                           // composição
    
    //construtor padrão
    public Episodio(int id, int numeroEp, String titulo, String duracao, Temporada fkTemp, Anime fkAnime) {
        setId(id);
        setNumeroEp(numeroEp);
        setTitulo(titulo);
        setDuracao(duracao);
        setFktemp(fkTemp);
        setFkAnime(fkAnime);
    }

    // construtor para o CREATE - sem id
    public Episodio(int numeroEp, String titulo, String duracao, Temporada fkTemp, Anime fkAnime) {
        setNumeroEp(numeroEp);
        setTitulo(titulo);
        setDuracao(duracao);
        setFktemp(fkTemp);
        setFkAnime(fkAnime);
    }

    //construtor para o UPDATE - sem fks
    public Episodio(int id, int numeroEp, String titulo, String duracao) {
        setId(id);
        setNumeroEp(numeroEp);
        setTitulo(titulo);
        setDuracao(duracao);
    }

    // getters e setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    public int getNumeroEp() {
        return numeroEp;
    }

    public void setNumeroEp(int numeroEp) {
        this.numeroEp = numeroEp;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDuracao() {
        return duracao;
    }

    public void setDuracao(String duracao) {
        this.duracao = duracao;
    }

    public Temporada getFktemp() {
        return fkTemp;
    }

    public void setFktemp(Temporada fkTemp) {
        this.fkTemp = fkTemp;
    }

    public Anime getFkAnime() {
        return fkAnime;
    }

    public void setFkAnime(Anime fkAnime) {
        this.fkAnime = fkAnime;
    }

    @Override
    public String toString() {

        return "idE: " + getId() + "       Episodio " + getNumeroEp() + ": " + getTitulo() + "      \nDuraçao: " + getDuracao() + "\n";
    }


}