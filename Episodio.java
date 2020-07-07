public class Episodio {
    private String titulo;
    private String duracao;

    public Episodio(String titulo, String duracao) {
        this.titulo = titulo;
        this.duracao = duracao;
    }
    //get e set
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



   
}