public class Filme extends Animacao { 
    
    private int ano;
    private String duracao;

    //construtor para o CREATE - sem id
    public Filme(String nome, String classificacaoIndicativa, String estudio, String genero, int ano,
            String duracao) {
        super(nome, classificacaoIndicativa, estudio, genero);
        setAno(ano);
        setDuracao(duracao);
    }

    //construtor padrão
    public Filme(int id, String nome, String classificacaoIndicativa, String estudio, String genero, int ano,
            String duracao) {
        super(id, nome, classificacaoIndicativa, estudio, genero);
        setAno(ano);
        setDuracao(duracao);
    }
    
    //getters e setters    
    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        if(ano > 0)
            this.ano = ano;
    }

    public String getDuracao() {
        return duracao;
    }

    public void setDuracao(String duracao) {
        this.duracao = duracao;
    }

    @Override
    public String toString() {
        return "idF: " + getId() + "        Filme: " + getNome() + "      \nClassificaçao indicativa: "
                + getClassificacaoIndicativa() + "      \nEstudio: " + getEstudio() + "      \nGenero: " + getGenero()
                + "      \nAno de lançamento: " + getAno() + "      \nDuraçao: " + getDuracao() + "\n";
    } 
}