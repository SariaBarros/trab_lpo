import java.sql.*;

import javax.swing.JOptionPane;

public class FilmeDAO {

    public void create(Filme f) { // ou (Filme f)

        Connection con = ConexaoSQLite.conectar();
        PreparedStatement stmt = null;

        try {
            // formação de statements para executar sql
            stmt = con.prepareStatement(
                    "INSERT INTO filme (nome_filme,classificacaoIndicativa,estudio,genero,ano,duracao)VALUES(?,?,?,?,?,?)");
            stmt.setString(1, f.getNome());
            stmt.setString(2, f.getClassificacaoIndicativa());
            stmt.setString(3, f.getEstudio());
            stmt.setString(4, f.getGenero());
            stmt.setInt(5, f.getAno());
            stmt.setString(6, f.getDuracao());

            stmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "Salvo com sucesso!");

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao salvar!" + e);
        } finally {
            ConexaoSQLite.desconectar(con, stmt);
        }

    }

    // outros metodos: read(), update(), delete()

}