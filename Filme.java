public class Filme extends Animacao { 
    private int ano;
    private String duracao;

    public Filme(String nome, String classificacaoIndicativa, String estudio, String[] genero, int ano,
            String duracao) {
        super(nome, classificacaoIndicativa, estudio, genero);
        setAno(ano);
        setDuracao(duracao);
    }
    //get e set
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

    
    
}