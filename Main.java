public class Main {
    public static void main(String[] args) {

        JanelaComposicao janela = new JanelaComposicao("Cadastrar Animacoes");
        /*
        Leitor leitor = new Leitor();
        int menu;
        Animacao[] animacoes = new Animacao[10];
        int quantAnimacao = 0;
        
        do {
            System.out.println("Escolha uma opção:");
            System.out.println("[1] Cadastrar um Filme");
            System.out.println("[2] Cadastrar um Anime");
            System.out.println("[3] Sair");

            menu = leitor.leInteiro();
        
            switch (menu) {
                case 1:
                    System.out.println("Digite o nome: ");
                    String nome = leitor.leString();
                    System.out.println("Digite qual eh a classificacao indicada: ");
                    String classificacaoIndicativa = leitor.leString();
                    System.out.println("Digite qual eh o estudio: ");
                    String estudio = leitor.leString();
                    System.out.println("Digite a quantidade de genero tem o filme: ");
                    int quantGenero = leitor.leInteiro();
                    String[] genero = new String[quantGenero];
                    for(int i = 0; i < quantGenero; i++){
                        System.out.println("Digite um genero:");
                        genero[i] = leitor.leString();
                    }
                    System.out.println("Digite o ano que o filme foi criado: ");
                    int ano = leitor.leInteiro();
                    System.out.println("Digite a duracao do filme: ");
                    String duracao = leitor.leString();

                    animacoes[quantAnimacao] = new Filme(nome, classificacaoIndicativa, estudio, genero, ano, duracao);
                    quantAnimacao++;
                    break;
            
                case 2:


                    break;

                default:
                    break;
            }
        } while (menu != 5);
        */
    }
}