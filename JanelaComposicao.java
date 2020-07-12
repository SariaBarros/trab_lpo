import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import java.awt.event.ActionListener;
import javax.swing.JMenu;
import java.awt.BorderLayout;

public class JanelaComposicao {
    private JFrame janela;
    private JMenuBar barraDeMenu;
    
    private JMenu menuAnime;
    private JMenuItem menuAnimeCadastrar;

    private JMenu menuFilme;
    private JMenuItem menuFilmeCadastrar;

    private JLabel barraDeStatus;

    public JanelaComposicao(String titulo) {
        janela = new JFrame(titulo);
        janela.setLayout(new BorderLayout());

        barraDeMenu = new JMenuBar();
        menuAnime = new JMenu("Anime");
        menuAnimeCadastrar = new JMenuItem("Cadastrar");
        menuAnime.add(menuAnimeCadastrar);

        menuFilme = new JMenu("Filme");
        menuFilmeCadastrar = new JMenuItem("Cadastrar");
        menuFilme.add(menuFilmeCadastrar);

        barraDeMenu.add(menuAnime);
        barraDeMenu.add(menuFilme);

        //Tratando o evento de clicar em MenuFilme->Cadastrar
        ActionListener ouvidoDoFilmeCadastrar = (informacoesDoEvento) -> {
                barraDeStatus.setText("Cliquei em cadastrar Filme");
        };

        //Tratando o evento de clicar em MenuAnime->Cadastrar
        ActionListener ouvidoDoAnimeCadastrar = (informacoesDoEvento) -> {
                barraDeStatus.setText("Cliquei em cadastrar Anime");
        };

        menuFilmeCadastrar.addActionListener(ouvidoDoFilmeCadastrar); 
        menuAnimeCadastrar.addActionListener(ouvidoDoAnimeCadastrar);

        barraDeStatus = new JLabel("Barra de Status");

        janela.add(barraDeStatus, BorderLayout.SOUTH);

        janela.setJMenuBar(barraDeMenu);
        janela.setSize(800, 600);
        janela.setVisible(true);
    }
}