import java.sql.*;
import javax.swing.JOptionPane;
import java.util.ArrayList;
import java.util.List;

public class FilmeDAO {
    private Connection con;

    public FilmeDAO() {
        this.con = ConexaoSQLite.conectar();

    }

    public void create(Filme f) { // inserção de dados nas tabelas do bd

        PreparedStatement stmt = null;

        try {
            // formação de statements a partir do objeto passado como parâmetro, para
            // executar o sql
            stmt = con.prepareStatement(
                    "INSERT INTO filme (pk_id_filme,nome_filme,classificacaoIndicativa,estudio,genero,ano,duracao)VALUES(?,?,?,?,?,?,?)");
            // a seguir, captura de dados do objeto para o statement
            stmt.setInt(1, f.getId());
            stmt.setString(2, f.getNome());
            stmt.setString(3, f.getClassificacaoIndicativa());
            stmt.setString(4, f.getEstudio());
            stmt.setString(5, f.getGenero());
            stmt.setInt(6, f.getAno());
            stmt.setString(7, f.getDuracao());

            stmt.executeUpdate(); // executa a inserção
            JOptionPane.showMessageDialog(null, "Salvo com sucesso!");

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao salvar! " + e.getMessage());
        } finally {
            ConexaoSQLite.desconectar(con, stmt);
        }
    }

    public List<Filme> read() { // listagem dos filmes
        PreparedStatement stmt = null;
        ResultSet rs = null;

        List<Filme> filmes = new ArrayList<>();

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

                Filme novoFilme = new Filme(id, nome, classificacao, estudio, genero, ano, duracao);
                filmes.add(novoFilme); // add ao array q será retornado
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao salvar! " + e.getMessage());
        } finally {
            ConexaoSQLite.desconectar(con, stmt, rs);
        }
        // array passado para ser listado no codigo da interface gráfica
        return filmes;

    }

    // outros metodos: update(), delete()

    //update
    public void update(Filme f) { 

        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement(
                    "UPDATE filme SET pk_id_filme = ?, nome_filme = ?, classificacaoIndicativa = ?, estudio = ?, genero = ?, ano = ?, duracao = ? WHERE id = ?");
            stmt.setInt(1, f.getId());
            stmt.setString(2, f.getNome());
            stmt.setString(3, f.getClassificacaoIndicativa());
            stmt.setString(4, f.getEstudio());
            stmt.setString(5, f.getGenero());
            stmt.setInt(6, f.getAno());
            stmt.setString(7, f.getDuracao());
            stmt.setInt(8, f.getId()); //identificador do WHERE pra saber qual o filme a ser atualizado

            stmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "Atualizado com sucesso!");

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao atualizar! " + e.getMessage());
        } finally {
            ConexaoSQLite.desconectar(con, stmt);
        }
    }


}