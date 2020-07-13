import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuBar;
import java.awt.BorderLayout;

public class JanelaComposicao {
    private JFrame janela;
    private JMenuBar barraDeMenu;

    private BotaoMenu botaoAnime;
    private BotaoMenu botaoFilme;

    private JLabel barraDeStatus;

    public JanelaComposicao(String titulo) {
        janela = new JFrame(titulo);
        janela.setLayout(new BorderLayout());

        barraDeMenu = new JMenuBar();

        configurarBotaoAnime();

        configurarBotaoFilme();

        barraDeMenu.add(botaoAnime.getMenu());
        barraDeMenu.add(botaoFilme.getMenu());

        barraDeStatus = new JLabel("Barra de Status");

        janela.add(barraDeStatus, BorderLayout.SOUTH);

        janela.setJMenuBar(barraDeMenu);
        janela.setSize(800, 600);
        janela.setVisible(true);
    }

    private void configurarBotaoAnime() {
        botaoAnime = new BotaoMenu("Anime", 4);
        botaoAnime.adicionarMenuItem("Cadastrar");
        botaoAnime.adicionarMenuItem("Listar");
        botaoAnime.adicionarMenuItem("Atualizar");
        botaoAnime.adicionarMenuItem("Deletar");

        botaoAnime.configurarEventoBotaoMenuItem(0, (informacoesDoEvento) -> {
            barraDeStatus.setText("Cliquei em cadastrar Anime");
            int id = Leitor2.leInteiroDoTeclado("Informe o id do anime");
            String nome = Leitor2.leStringDoTeclado("Digite o nome: ");
            String classificacaoIndicativa = Leitor2.leStringDoTeclado("Digite qual eh a classificacao indicada: ");
            String estudio = Leitor2.leStringDoTeclado("Digite qual eh o estudio: ");
            String genero = Leitor2.leStringDoTeclado("Digite um genero: ");

            Anime anime = new Anime(id, nome, classificacaoIndicativa, estudio, genero);
            AnimeDAO aDao = new AnimeDAO();
            aDao.create(anime);

            int r = Leitor2.leInteiroDoTeclado("Inserir nova Temporada?\n[1] Sim\n[2] Nao");
            while (r != 2) {

                int idTemp = Leitor2.leInteiroDoTeclado("Informe o id da temporada");
                String estacao = Leitor2.leStringDoTeclado("Informe a estaçao da temporada:");
                String dataInicio = Leitor2.leStringDoTeclado("Informe a data de estreia da temporada (dd/mm/aaaa):");
                String dataTermino = Leitor2.leStringDoTeclado("Informe a data de término da temporada (dd/mm/aaaa):");

                Temporada temporada = new Temporada(idTemp, estacao, dataInicio, dataTermino, anime);
                TemporadaDAO tempDao = new TemporadaDAO();
                tempDao.create(temporada);
                r = Leitor2.leInteiroDoTeclado("Inserir nova Temporada?\n[1] Sim\n[2] Nao");

            }

            // int r1 = Leitor2.leInteiroDoTeclado("Inserir novos episódios à
            // Temporada?\n[1] Sim\n[2] Nao");
            // if (r1 == 1) {

            // }else
            // return;

        });

        botaoAnime.configurarEventoBotaoMenuItem(1, (informacoesDoEvento) -> {
            barraDeStatus.setText("Cliquei em listar Anime");
            // codigo de listar o anime [todos]
            AnimeDAO animeDAO = new AnimeDAO();
            animeDAO.readAnime();

        });

        botaoAnime.configurarEventoBotaoMenuItem(2, (informacoesDoEvento) -> {
            barraDeStatus.setText("Cliquei em atualizar Anime");
            // codigo de atualizar anime

        });

        botaoAnime.configurarEventoBotaoMenuItem(3, (informacoesDoEvento) -> {
            barraDeStatus.setText("Cliquei em deletar Anime");
            // codigo de deletar anime

        });
    }

    private void configurarBotaoFilme() {
        botaoFilme = new BotaoMenu("Filme", 4);
        botaoFilme.adicionarMenuItem("Cadastrar");
        botaoFilme.adicionarMenuItem("Listar");
        botaoFilme.adicionarMenuItem("Atualizar");
        botaoFilme.adicionarMenuItem("Deletar");

        botaoFilme.configurarEventoBotaoMenuItem(0, (informacoesDoEvento) -> {
            barraDeStatus.setText("Cliquei em cadastrar Filme");

            int id = Leitor2.leInteiroDoTeclado("Informe o id do filme");
            String nome = Leitor2.leStringDoTeclado("Digite o nome: ");
            String classificacaoIndicativa = Leitor2.leStringDoTeclado("Digite qual eh a classificacao indicada: ");
            String estudio = Leitor2.leStringDoTeclado("Digite qual eh o estudio: ");
            String genero = Leitor2.leStringDoTeclado("Digite um genero: ");
            int ano = Leitor2.leInteiroDoTeclado("Digite o ano que o filme foi criado: ");
            String duracao = Leitor2.leStringDoTeclado("Digite a duracao do filme: ");

            Filme filme = new Filme(id, nome, classificacaoIndicativa, estudio, genero, ano, duracao);
            FilmeDAO filmedao = new FilmeDAO();
            filmedao.create(filme);
        });

        botaoFilme.configurarEventoBotaoMenuItem(1, (informacoesDoEvento) -> {
            barraDeStatus.setText("Cliquei em listar Filme");

            // codigo de listar o filme
            FilmeDAO fdao = new FilmeDAO();
            for (Filme f : fdao.read()) {
                System.out.println(f.toString());
            }
        });

        botaoFilme.configurarEventoBotaoMenuItem(2, (informacoesDoEvento) -> {
            barraDeStatus.setText("Cliquei em atualizar Filme");
            // codigo de atualizar filme

        });

        botaoFilme.configurarEventoBotaoMenuItem(3, (informacoesDoEvento) -> {
            barraDeStatus.setText("Cliquei em deletar Filme");
            // codigo de deletar filme

        });
    }
}