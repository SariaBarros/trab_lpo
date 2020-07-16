
public class Temporada {

    private int id;
    private String estacao;
    private String dataInicio;
    private String dataTermino;

    private Anime fkAnime; // **funcionará como FK - inserida em TemporadaDAO.create() por composição

    public Temporada(int id, final String estacao, String dataInicio, String dataTermino, Anime fkAnime) {
        setId(id);
        setEstacao(estacao);
        setDataInicio(dataInicio);
        setDataTermino(dataTermino);
        setFkanime(fkAnime);
    }

    // getters e setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(String dataInicio) {
        this.dataInicio = dataInicio;
    }

    public String getDataTermino() {
        return dataTermino;
    }

    public void setDataTermino(String dataTermino) {
        this.dataTermino = dataTermino;
    }

    public String getEstacao() {
        return estacao;
    }

    public void setEstacao(final String estacao) {
        this.estacao = estacao;
    }

    public Anime getFkanime() {
        return fkAnime;
    }

    public void setFkanime(Anime fkAnime) {
        this.fkAnime = fkAnime;
    }

    @Override
    public String toString() {
        return "Temporada [" + getId() + "]      \nEstaçao: " + getEstacao() + "      \nData de início: " + getDataInicio()
                + "      \nData de término: " + getDataTermino();
    }

}