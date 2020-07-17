import java.sql.*;
import javax.swing.JOptionPane;
import java.util.ArrayList;
import java.util.List;

public class FilmeDAO implements OperacoesCRUD{
    final int MAX = 50;
    private Connection con;

    public FilmeDAO() {
        this.con = ConexaoSQLite.conectar();

    }

    //cadastrar
    @Override
    public void create(Animacao filme) { // inserção de dados nas tabelas do bd

        PreparedStatement stmt = null;
        Filme f = (Filme)filme;

        try {

            // formação de statements a partir do objeto passado como parâmetro, para
            // executar o sql
            stmt = con.prepareStatement(
                    "INSERT INTO filme (nome_filme,classificacaoIndicativa,estudio,genero,ano,duracao)VALUES(?,?,?,?,?,?)");
            // a seguir, captura de dados do objeto para o statement
            stmt.setString(1, f.getNome());
            stmt.setString(2, f.getClassificacaoIndicativa());
            stmt.setString(3, f.getEstudio());
            stmt.setString(4, f.getGenero());
            stmt.setInt(5, f.getAno());
            stmt.setString(6, f.getDuracao());

            stmt.executeUpdate(); // executa a inserção
            JOptionPane.showMessageDialog(null, "Salvo com sucesso!");

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao salvar! " + e.getMessage());
        } finally {
            ConexaoSQLite.desconectar(con, stmt);
        }
    }

    //listar
    @Override
    public List<Animacao> read() { // listagem dos filmes
        PreparedStatement stmt = null;
        ResultSet rs = null;

        List<Animacao> animacaoF = new ArrayList<>();
        Animacao novo[] = new Animacao[MAX];
        int n = 0;

        try {
            stmt = con.prepareStatement("SELECT * FROM filme");
            rs = stmt.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("pk_id_filme");
                String nome = rs.getString("nome_filme");
                String classificacao = rs.getString("classificacaoIndicativa");
                String estudio = rs.getString("estudio");
                String genero = rs.getString("genero");
                int ano = rs.getInt("ano");
                String duracao = rs.getString("duracao");

                //polifmorfismo
                novo[n] = new Filme(id, nome, classificacao, estudio, genero, ano, duracao);
                Filme novoFilme = (Filme)novo[n];
                novo[n].adicionaAnimacao(novo, n, novoFilme);

                animacaoF.add(novoFilme);    // add ao array q será retornado
                n++;                
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao Listar! " + e.getMessage());
        } finally {
            ConexaoSQLite.desconectar(con, stmt, rs);
        }
        // array passado para ser listado no codigo da interface gráfica

        return animacaoF;
    }

    //update
    @Override
    public void update(Animacao filme) { 

        PreparedStatement stmt = null;
        Filme f = (Filme)filme;

        try {
            stmt = con.prepareStatement(
                    "UPDATE filme SET nome_filme = ?, classificacaoIndicativa = ?, estudio = ?, genero = ?, ano = ?, duracao = ? WHERE pk_id_filme = ?");
            
            stmt.setString(1, f.getNome());
            stmt.setString(2, f.getClassificacaoIndicativa());
            stmt.setString(3, f.getEstudio());
            stmt.setString(4, f.getGenero());
            stmt.setInt(5, f.getAno());
            stmt.setString(6, f.getDuracao());
            stmt.setInt(7, f.getId()); //identificador do WHERE pra saber qual o filme a ser atualizado

            stmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "Atualizado com sucesso!");

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao atualizar! " + e.getMessage());
        } finally {
            ConexaoSQLite.desconectar(con, stmt);
        }
    }

    //delete:
    @Override
    public void delete(Animacao filme) { 

        PreparedStatement stmt = null;
        Filme f = (Filme) filme;

        try {
            stmt = con.prepareStatement("DELETE FROM filme WHERE pk_id_filme = ?");
            stmt.setInt(1, f.getId()); //identificador do WHERE pra saber qual o filme a ser deletado

            stmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "Excluído com sucesso!");

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao excluir! " + e.getMessage());
        } finally {
            ConexaoSQLite.desconectar(con, stmt);
        }
    }

}