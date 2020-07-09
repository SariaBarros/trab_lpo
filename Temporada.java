public class Temporada {
    private String estacao;
    private Data dataInicio;
    private Data dataTermino;
    private Episodio[] episodios;

    private int nEpisodios = 0;

    public Temporada(String estacao, Data dataInicio, Data dataTermino/* , Episodio[] episodios */) {
        setEstacao(estacao);
        setDataInicio(dataInicio);
        setDataTermino(dataTermino);
        //setEpisodios(episodios);
    }
    //get e set
    public String getEstacao() {
        return estacao;
    }

    public void setEstacao(String estacao) {
        this.estacao = estacao;
    }

    public Data getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(Data dataInicio) {
        this.dataInicio = dataInicio;
    }

    public Data getDataTermino() {
        return dataTermino;
    }

    public void setDataTermino(Data dataTermino) {
        this.dataTermino = dataTermino;
    }

    public Episodio[] getEpisodios() {
        return episodios;
    }

    public void setEpisodios(Episodio[] episodios) {    
        this.episodios = episodios;
    }

    public void adicionaEpisodio(Episodio episodio){    //chamada na main: Temporada[i].adicionaEpisodio(novoEpisodio)
        this.episodios[nEpisodios] = episodio;
        nEpisodios++;
    }
}