
public class Temporada {

    private int id;
    private int numeroTemp; 
    private String estacao;
    private String dataInicio;
    private String dataTermino;

    private Anime fkAnime; // **funcionará como FK - inserida em TemporadaDAO.create() por composição

    // construtor padrão
    public Temporada(int id, int numeroTemp, String estacao, String dataInicio, String dataTermino, Anime fkAnime) {
        setId(id);
        setNumeroTemp(numeroTemp);
        setEstacao(estacao);
        setDataInicio(dataInicio);
        setDataTermino(dataTermino);
        setFkanime(fkAnime);
    }
    
    // construtor para o CREATE - sem id
    public Temporada(int numeroTemp, String estacao, String dataInicio, String dataTermino, Anime fkAnime) {
        setNumeroTemp(numeroTemp);
        setEstacao(estacao);
        setDataInicio(dataInicio);
        setDataTermino(dataTermino);
        setFkanime(fkAnime);
    }

    // construtor para o UPDATE - sem fk
    public Temporada(int id, int numeroTemp, String estacao, String dataInicio, String dataTermino) {
        setId(id);
        setNumeroTemp(numeroTemp);
        setEstacao(estacao);
        setDataInicio(dataInicio);
        setDataTermino(dataTermino);
    }

    // getters e setters
    public int getId() {
        return id;
    }
    
    public void setId(int id) {
        this.id = id;
    }
    
    public int getNumeroTemp() {
        return numeroTemp;
    }

    public void setNumeroTemp(int numeroTemp) {
        this.numeroTemp = numeroTemp;
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

    public void setEstacao(String estacao) {
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
        return "idT: " + getId() + "" + "       Temporada [" + getNumeroTemp() + "]  Estaçao: " + getEstacao() + "      \nData de início: " + getDataInicio()
                + "      \nData de término: " + getDataTermino();
    }


}