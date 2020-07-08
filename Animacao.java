public abstract class Animacao {
    private String nome;
    private String classificacaoIndicativa;
    private String estudio;
    private String[] genero;

    public Animacao(String nome, String classificacaoIndicativa, String estudio, String[] genero) {
        setNome(nome);
        setClassificacaoIndicativa(classificacaoIndicativa);
        setEstudio(estudio);
        setGenero(genero);
    }

    public boolean buscarTitulo(String nome) { //da pra melhor essa busca 
        if(getNome().equals(nome))
            return true;
        else
            return false;

    }

    //get e set
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getClassificacaoIndicativa() {
        return classificacaoIndicativa;
    }

    public void setClassificacaoIndicativa(String classificacaoIndicativa) {
        this.classificacaoIndicativa = classificacaoIndicativa;
    }

    public String getEstudio() {
        return estudio;
    }

    public void setEstudio(String estudio) {
        this.estudio = estudio;
    }

    public String[] getGenero() {
        return genero;
    }

    public void setGenero(String[] genero) {
        this.genero = genero;
    }
}