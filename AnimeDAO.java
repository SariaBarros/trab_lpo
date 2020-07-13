import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class AnimeDAO {
    private Connection con;

    public AnimeDAO() {
        this.con = ConexaoSQLite.conectar();
    }

    public void create(Anime a) {

        PreparedStatement stmt = null;

        try {
            // formação de statements para executar sql
            stmt = con.prepareStatement(
                    "INSERT INTO anime (pk_id_anime,nome_anime,classificacaoIndicativa_anime,estudio_anime,genero_anime)VALUES(?,?,?,?,?)");
            stmt.setInt(1, a.getId());
            stmt.setString(2, a.getNome());
            stmt.setString(3, a.getClassificacaoIndicativa());
            stmt.setString(4, a.getEstudio());
            stmt.setString(5, a.getGenero());

            stmt.executeUpdate(); // executa a inserção
            JOptionPane.showMessageDialog(null, "Salvo com sucesso!");

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao salvar!" + e);
        } finally {
            ConexaoSQLite.desconectar(con, stmt);
        }

    }

    public void readAnime() {
        PreparedStatement stmtAnime = null;
        ResultSet rsAnime = null;

        List<Anime> animes = new ArrayList<>();

        try {
            stmtAnime = con.prepareStatement("SELECT * FROM anime");
            rsAnime = stmtAnime.executeQuery();

            while (rsAnime.next()) { // percorre as tabelas que atendem à consulta acima
                int idAnime = rsAnime.getInt("pk_id_anime");
                String nome = rsAnime.getString("nome_anime");
                String classificacao = rsAnime.getString("classificacaoIndicativa_anime");
                String estudio = rsAnime.getString("estudio_anime");
                String genero = rsAnime.getString("genero_anime");

                Anime novoAnime = new Anime(idAnime, nome, classificacao, estudio, genero);
                animes.add(novoAnime); // add ao array de animes q será percorrido no primeiro laço

                // imprimindo a tabela de animes
                for (Anime a : animes) {
                    System.out.println(a.toString());

                    // imprimindo as temporadas
                    TemporadaDAO tempDao = new TemporadaDAO();
                    for (Temporada t : tempDao.readTemporada(a)) { // percorre a lista retornada pelo
                                                                   // tempDAO.readTemporada(a)
                        System.out.println(t.toString());

                        // imprimindo os episódios
                        /*
                         * EpisodioDAO episodioDao = new EpisodioDAO(); for (Episodio e :
                         * episodioDao.readEpisodio(t)) { System.out.println(e.toString()); }
                         */

                    }

                }

            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao salvar! " + e.getMessage());
        } finally {
            ConexaoSQLite.desconectar(con, stmtAnime, rsAnime);
        }
        // array passado para ser listado no codigo da interface gráfica
        // return animes;
    }
    // outros metodos: update(), delete()
}