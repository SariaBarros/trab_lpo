import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class AnimeDAO implements OperacoesCRUD{
    final int MAX = 50;
    private Connection con;

    public AnimeDAO() {
        this.con = ConexaoSQLite.conectar();
    }

    //cadastrar
    @Override
    public void create(Animacao anime) {

        PreparedStatement stmt = null;
        Anime a = (Anime)anime;

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

    // listar
    @Override
    public List<Animacao> read() {
        PreparedStatement stmtAnime = null;
        ResultSet rsAnime = null;

        List<Animacao> animacaoA = new ArrayList<>();
        Animacao novo[] = new Animacao[MAX];
        int n = 0;

        try {
            stmtAnime = con.prepareStatement("SELECT * FROM anime");
            rsAnime = stmtAnime.executeQuery();

            while (rsAnime.next()) { // percorre as tabelas que atendem à consulta acima
                int idAnime = rsAnime.getInt("pk_id_anime");
                String nome = rsAnime.getString("nome_anime");
                String classificacao = rsAnime.getString("classificacaoIndicativa_anime");
                String estudio = rsAnime.getString("estudio_anime");
                String genero = rsAnime.getString("genero_anime");

                //polimorfismo
                novo[n] = new Anime(idAnime, nome, classificacao, estudio, genero);
                Anime novoAnime = (Anime)novo[n];
                novo[n].adicionaAnimacao(novo, n, novoAnime);

                animacaoA.add(novoAnime); // add ao array de animes q será percorrido no primeiro laço
                n++;
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao listar! " + e.getMessage());
        } finally {
            ConexaoSQLite.desconectar(con, stmtAnime, rsAnime);
        }
        // array passado para ser listado no codigo da interface gráfica
        return animacaoA;
    }

    //update
    @Override
    public void update(Animacao anime) {

        PreparedStatement stmt = null;
        Animacao a = (Animacao)anime;

        try {
            // formação de statements para executar sql
            stmt = con.prepareStatement(
                    "UPDATE anime SET pk_id_anime = ?, nome_anime = ?, classificacaoIndicativa_anime = ?, estudio_anime = ?, genero_anime = ? WHERE id = ?");
            stmt.setInt(1, a.getId());
            stmt.setString(2, a.getNome());
            stmt.setString(3, a.getClassificacaoIndicativa());
            stmt.setString(4, a.getEstudio());
            stmt.setString(5, a.getGenero());
            stmt.setInt(6, a.getId());

            stmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "Atualizado com sucesso!");

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao Atualizar!" + e);
        } finally {
            ConexaoSQLite.desconectar(con, stmt);
        }

    }

    //delete:
    @Override
    public void delete(Animacao anime) {

        PreparedStatement stmt = null;
        Animacao a = (Animacao) anime;

        try {
            stmt = con.prepareStatement(
                    "DELETE FROM anime WHERE id = ?");
            stmt.setInt(1, a.getId());

            stmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "Excluído com sucesso!");

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao excluir!" + e);
        } finally {
            ConexaoSQLite.desconectar(con, stmt);
        }

    }
}