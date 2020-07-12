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
        botaoAnime = new BotaoMenu("Anime", 1);   
        botaoAnime.adicionarMenuItem("Cadastrar");

        botaoAnime.configurarEventoBotaoMenuItem(0, (informacoesDoEvento) -> {
                barraDeStatus.setText("Cliquei em cadastrar Anime"); 
            }
        );
    }

    private void configurarBotaoFilme() {
        botaoFilme = new BotaoMenu("Filme", 1);   
        botaoFilme.adicionarMenuItem("Cadastrar");

        botaoFilme.configurarEventoBotaoMenuItem(0, (informacoesDoEvento) -> {
                barraDeStatus.setText("Cliquei em cadastrar Filme");
                
            }
        );
    }
}