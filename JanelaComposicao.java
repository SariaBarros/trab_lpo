import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JMenu;

public class JanelaComposicao {
    private JFrame janela;
    private JMenuBar barraDeMenu;
    private JMenu menuAnime;
    private JMenuItem menuAnimeCadastrar;
    private JMenu menuFilme;
    private JMenuItem menuFilmeCadastrar;

    public JanelaComposicao(String titulo) {
        janela = new JFrame(titulo);
        barraDeMenu = new JMenuBar();

        menuAnime = new JMenu("Anime");
        menuAnimeCadastrar = new JMenuItem("Cadastrar");

        menuFilme = new JMenu("Filme");
        menuFilmeCadastrar = new JMenuItem("Cadastrar");

        barraDeMenu.add(menuAnime);
        menuAnime.add(menuAnimeCadastrar);

        barraDeMenu.add(menuFilme);
        menuFilme.add(menuFilmeCadastrar);

        janela.setJMenuBar(barraDeMenu);
        janela.setSize(800, 600);
        janela.setVisible(true);
    }
}