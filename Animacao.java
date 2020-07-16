public abstract class Animacao {
    final int TAM_INICIAL = 50;
    private int id;
    private String nome;
    private String classificacaoIndicativa;
    private String estudio;
    private String genero;
    private int capacidade = TAM_INICIAL;

    public Animacao(int id, String nome, String classificacaoIndicativa, String estudio, String genero) {
        setId(id);
        setNome(nome);
        setClassificacaoIndicativa(classificacaoIndicativa);
        setEstudio(estudio);
        setGenero(genero);
    }
    
    //getters e setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
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

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }
    
    public void adicionaAnimacao(Animacao a[], int n, Animacao novo) {
        if (a.length == capacidade)
            this.expandeVetorAnimacao(a);

        a[n] = novo;
    }

    public void expandeVetorAnimacao(Animacao novo[]) {
        Animacao novoVetor[] = new Animacao[capacidade * 2];

        for (int i = 0; i < novo.length; i++)
            novoVetor[i] = novo[i];

        novo = novoVetor;
        capacidade = novoVetor.length;
    }
}