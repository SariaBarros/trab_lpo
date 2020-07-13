public class Episodio {
    private int id;
    private String titulo;
    private String duracao;
    private Temporada fkTemp; // **funcionará como FK - inserida em EpisodioDAO.create() por composição

    public Episodio(int id, String titulo, String duracao, Temporada fkTemp) {
        setId(id);
        setTitulo(titulo);
        setDuracao(duracao);
        setFktemp(fkTemp);
    }

    // getters e setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    @Override
    public String toString() {

        return "Episodio [" + getId() + "]: " + getTitulo() + "\nDuraçao: " + getDuracao() + "\n";
    }

}