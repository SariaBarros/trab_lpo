import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuBar;
import java.awt.BorderLayout;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import java.awt.GridLayout;

public class JanelaComposicao {
    private JFrame janela;
    private JMenuBar barraDeMenu;

    private BotaoMenu botaoAnime;
    private BotaoMenu botaoTemporada;
    private BotaoMenu botaoEpisodio;
    private BotaoMenu botaoFilme;

    private JLabel barraDeStatus;
    private JPanel painel;

    public JanelaComposicao(String titulo) {
        janela = new JFrame(titulo);
        janela.setLayout(new BorderLayout());

        barraDeMenu = new JMenuBar();

        configurarBotaoAnime();
        configurarBotaoTemporada();
        configurarBotaoEpisodio();
        configurarBotaoFilme();

        barraDeMenu.add(botaoAnime.getMenu());
        barraDeMenu.add(botaoTemporada.getMenu());
        barraDeMenu.add(botaoEpisodio.getMenu());
        barraDeMenu.add(botaoFilme.getMenu());

        barraDeStatus = new JLabel("Barra de Status");
        painel = new JPanel(new GridLayout(300, 1));

        janela.add(barraDeStatus, BorderLayout.SOUTH);
        janela.add(painel, BorderLayout.NORTH);

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
            
            String nome = Leitor2.leStringDoTeclado("Digite o nome: ");
            String classificacaoIndicativa = Leitor2.leStringDoTeclado("Digite qual eh a classificacao indicada: ");
            String estudio = Leitor2.leStringDoTeclado("Digite qual eh o estudio: ");
            String genero = Leitor2.leStringDoTeclado("Digite um genero: ");

            Anime anime = new Anime(nome, classificacaoIndicativa, estudio, genero);
            AnimeDAO aDao = new AnimeDAO();
            aDao.create(anime);

            JOptionPane.showMessageDialog(null, "Para um novo Anime, eh preciso cadastrar pelo menos uma Temporada  \nPara adicionar temporadas clique em Temporada > Cadastrar");

        });

        botaoAnime.configurarEventoBotaoMenuItem(1, (informacoesDoEvento) -> {
            barraDeStatus.setText("Cliquei em listar Anime");
            // codigo de listar o anime [todos]
            AnimeDAO animeDAO = new AnimeDAO();
            painel.removeAll();
            for (Animacao a : animeDAO.read()) {
                painel.add(new JLabel(a.toString()));
                
                System.out.println(a.toString());
            
                TemporadaDAO tempDao = new TemporadaDAO();
                for (Temporada t : tempDao.readTemporada((Anime)a)) {      // percorre a lista retornada pelo tempDAO.readTemporada(a)
                    //codigo da interface gráfica para imprimir as temporadas
                    painel.add(new JLabel(t.toString()));
                    
                    System.out.println(t.toString());            
                    
                    EpisodioDAO episodioDao = new EpisodioDAO();
                    for (Episodio e : episodioDao.readEpisodio(t, (Anime)a)) { // percorre a lista retornada pelo episodioDao.readEpisodio(t,a)
                        // codigo da interface gráfica para imprimir os episódios
                        painel.add(new JLabel(e.toString()));
                        
                        System.out.println(e.toString());
                    }                
                }    
            }

        });

        botaoAnime.configurarEventoBotaoMenuItem(2, (informacoesDoEvento) -> {
            barraDeStatus.setText("Cliquei em atualizar Anime");
            
            // codigo de atualizar anime
            int id = Leitor2.leInteiroDoTeclado("Informe o id do Anime que será atualizado: ");
            String nome = Leitor2.leStringDoTeclado("Digite o nome do Anime: ");
            String classificacaoIndicativa = Leitor2.leStringDoTeclado("Digite qual eh a classificacao indicativa: ");
            String estudio = Leitor2.leStringDoTeclado("Digite qual eh o estudio: ");
            String genero = Leitor2.leStringDoTeclado("Digite um genero: ");

            Anime anime = new Anime(id, nome, classificacaoIndicativa, estudio, genero);
            AnimeDAO aDao = new AnimeDAO();
            aDao.update(anime);

        });

        botaoAnime.configurarEventoBotaoMenuItem(3, (informacoesDoEvento) -> {
            barraDeStatus.setText("Cliquei em deletar Anime");
            // codigo de deletar anime
            int id = Leitor2.leInteiroDoTeclado("Informe o id do Anime que será deletado: ");
            Anime anime = new Anime(id, null, null, null, null);
            AnimeDAO aDao = new AnimeDAO();
            aDao.delete(anime);
        });
    }

    private void configurarBotaoTemporada() {
        botaoTemporada = new BotaoMenu("Temporada", 3);
        botaoTemporada.adicionarMenuItem("Cadastrar");
        botaoTemporada.adicionarMenuItem("Atualizar");
        botaoTemporada.adicionarMenuItem("Deletar");

        botaoTemporada.configurarEventoBotaoMenuItem(0, (informacoesDoEvento) -> {
            barraDeStatus.setText("Cliquei em cadastrar Temporada");

            // codigo de cadastrar Temporada
            int numeroTemp = Leitor2.leInteiroDoTeclado("Informe o número da Temporada:");
            String estacao = Leitor2.leStringDoTeclado("Informe a estaçao da temporada:");
            String dataInicio = Leitor2.leStringDoTeclado("Informe a data de estreia da temporada (dd/mm/aaaa):");
            String dataTermino = Leitor2.leStringDoTeclado("Informe a data de término da temporada (dd/mm/aaaa):");
            int fktemp = Leitor2.leInteiroDoTeclado("Informe o id do Anime ao qual a temporada pertence:");

            Anime anime = new Anime(fktemp, null, null, null, null);
            Temporada temporada = new Temporada(numeroTemp, estacao, dataInicio, dataTermino, anime);
            TemporadaDAO tempDao = new TemporadaDAO();
            tempDao.create(temporada);

            JOptionPane.showMessageDialog(null, "Para uma nova Temporada, eh preciso cadastrar pelo menos um Episodio   \nPara adicionar episodios clique em Episodio > Cadastrar");
        });

        botaoTemporada.configurarEventoBotaoMenuItem(1, (informacoesDoEvento) -> {
            barraDeStatus.setText("Cliquei em atualizar Temporada");
            
            // codigo de atualizar temporada
            int id = Leitor2.leInteiroDoTeclado("Informe o id da Temporada que será atualizada:");
            int numeroTemp = Leitor2.leInteiroDoTeclado("Informe o número da Temporada:");
            String estacao = Leitor2.leStringDoTeclado("Informe a estaçao da temporada:");
            String dataInicio = Leitor2.leStringDoTeclado("Informe a data de estreia da temporada (dd/mm/aaaa):");
            String dataTermino = Leitor2.leStringDoTeclado("Informe a data de término da temporada (dd/mm/aaaa):");

            Temporada temp = new Temporada(id, numeroTemp, estacao, dataInicio, dataTermino);
            TemporadaDAO tempDAO = new TemporadaDAO();
            tempDAO.UPDATE(temp);

        });

        botaoTemporada.configurarEventoBotaoMenuItem(2, (informacoesDoEvento) -> {
            barraDeStatus.setText("Cliquei em deletar Temporada");
            // codigo de deletar temporada
            int id = Leitor2.leInteiroDoTeclado("Informe o id da Temporada que será deletada: ");
            Temporada temp = new Temporada(id, 0, null, null, null);
            TemporadaDAO tempDAO = new TemporadaDAO();
            tempDAO.DELETE(temp);
        });
    }

    private void configurarBotaoEpisodio() {
        botaoEpisodio = new BotaoMenu("Episodio", 3);
        botaoEpisodio.adicionarMenuItem("Cadastrar");
        botaoEpisodio.adicionarMenuItem("Atualizar");
        botaoEpisodio.adicionarMenuItem("Deletar");

        botaoEpisodio.configurarEventoBotaoMenuItem(0, (informacoesDoEvento) -> {
            barraDeStatus.setText("Cliquei em cadastrar Episodio");

            // codigo de cadastrar Episodio
            int numeroEp = Leitor2.leInteiroDoTeclado("Informe o numero do episódio:");
            String titulo = Leitor2.leStringDoTeclado("Informe o título do episódio:");
            String duracao = Leitor2.leStringDoTeclado("Informe a duraçao do episodio");
            int fkepTemp = Leitor2.leInteiroDoTeclado("Informe o id da temporada à qual o episodio pertence:");
            int fkepAnime = Leitor2.leInteiroDoTeclado("Informe o id do anime ao qual o episodio pertence:");

            Temporada temp = new Temporada(fkepTemp, 0, null, null, null);      // definindo a fk da tab temporada
            Anime anime = new Anime(fkepAnime, null, null, null, null); // definindo a fk da tab anime
            // criaçao do ep
            Episodio episodio = new Episodio(numeroEp, titulo, duracao, temp, anime);
            EpisodioDAO epDao = new EpisodioDAO();
            epDao.create(episodio);

        });

        botaoEpisodio.configurarEventoBotaoMenuItem(1, (informacoesDoEvento) -> {
            barraDeStatus.setText("Cliquei em atualizar Episodio");
            // codigo de atualizar Episodio
            int id = Leitor2.leInteiroDoTeclado("Informe o id do Episodio que será atualizado: ");
            int numeroEp = Leitor2.leInteiroDoTeclado("Informe o numero do episódio:");
            String titulo = Leitor2.leStringDoTeclado("Informe o título do episódio:");
            String duracao = Leitor2.leStringDoTeclado("Informe a duraçao do episodio");
            
            Episodio episodio = new Episodio(id, numeroEp, titulo, duracao);
            EpisodioDAO epDAO = new EpisodioDAO();
            epDAO.UPDATE(episodio);

        });

        botaoEpisodio.configurarEventoBotaoMenuItem(2, (informacoesDoEvento) -> {
            barraDeStatus.setText("Cliquei em deletar Episodio");
            // codigo de deletar Episodio
            int id = Leitor2.leInteiroDoTeclado("Informe o id do Episodio que será deletado: ");
            Episodio episodio = new Episodio(id, 0, null, null);
            EpisodioDAO epDAO = new EpisodioDAO();
            epDAO.DELETE(episodio);

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

            String nome = Leitor2.leStringDoTeclado("Digite o nome: ");
            String classificacaoIndicativa = Leitor2.leStringDoTeclado("Digite qual eh a classificacao indicada: ");
            String estudio = Leitor2.leStringDoTeclado("Digite qual eh o estudio: ");
            String genero = Leitor2.leStringDoTeclado("Digite um genero: ");
            int ano = Leitor2.leInteiroDoTeclado("Digite o ano que o filme foi criado: ");
            String duracao = Leitor2.leStringDoTeclado("Digite a duracao do filme: ");

            Filme filme = new Filme(nome, classificacaoIndicativa, estudio, genero, ano, duracao);
            FilmeDAO filmedao = new FilmeDAO();
            filmedao.create(filme);
        });

        botaoFilme.configurarEventoBotaoMenuItem(1, (informacoesDoEvento) -> {
            barraDeStatus.setText("Cliquei em listar Filme");
            // codigo de listar o filme
            FilmeDAO fdao = new FilmeDAO();
            painel.removeAll();
            for (Animacao f : fdao.read()) {              
                painel.add(new JLabel(f.toString()));  
                
                System.out.println(f.toString());
            }
        });

        botaoFilme.configurarEventoBotaoMenuItem(2, (informacoesDoEvento) -> {
            barraDeStatus.setText("Cliquei em atualizar Filme");
            // codigo de atualizar filme
            int id = Leitor2.leInteiroDoTeclado("Informe o id do Filme que será atualizado: ");
            String nome = Leitor2.leStringDoTeclado("Digite o nome do filme: ");
            String classificacaoIndicativa = Leitor2.leStringDoTeclado("Informe a classificacao indicativa: ");
            String estudio = Leitor2.leStringDoTeclado("Informe o estudio: ");
            String genero = Leitor2.leStringDoTeclado("Informe o genero: ");
            int ano = Leitor2.leInteiroDoTeclado("Informe o ano do filme: ");
            String duracao = Leitor2.leStringDoTeclado("Informe a duracao do filme: ");

            Animacao filme = new Filme(id, nome, classificacaoIndicativa, estudio, genero, ano, duracao);
            FilmeDAO filmeDAO = new FilmeDAO();
            filmeDAO.update(filme);
        });

        botaoFilme.configurarEventoBotaoMenuItem(3, (informacoesDoEvento) -> {
            barraDeStatus.setText("Cliquei em deletar Filme");
            // codigo de deletar filme
            int id = Leitor2.leInteiroDoTeclado("Informe o id do Filme que será deletado: ");
            Filme filme = new Filme(id, null, null, null, null, 0, null);
            FilmeDAO filmeDAO = new FilmeDAO();
            filmeDAO.delete(filme);
        });
    }
}