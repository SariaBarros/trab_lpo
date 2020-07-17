import java.sql.*;
import javax.swing.JOptionPane;
import java.util.ArrayList;
import java.util.List;

public class TemporadaDAO {

    private Connection con;

    public TemporadaDAO() {
        this.con = ConexaoSQLite.conectar();
    }

    //cadastrar
    public void create(Temporada t) {

        PreparedStatement stmt = null;

        try {
            // formação de statements a partir do objeto passado como parâmetro, para
            // executar o sql
            stmt = con.prepareStatement(
                    "INSERT INTO temporada (numeroTemp,estacao_temp,dataInicio,dataTermino,fk_anime_id)VALUES(?,?,?,?,?)");
            // a seguir, captura de dados do objeto para o statement
            stmt.setInt(1, t.getNumeroTemp());
            stmt.setString(2, t.getEstacao());
            stmt.setString(3, t.getDataInicio());
            stmt.setString(4, t.getDataTermino());
            stmt.setInt(5, t.getFkanime().getId()); // inserção da fk com valor igual ao id do respectivo anime -> veja
                                                    // classe Temporada.java**

            stmt.executeUpdate(); // executa a inserção
            JOptionPane.showMessageDialog(null, "Salvo com sucesso!");

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao salvar! " + e.getMessage());
        } finally {
            ConexaoSQLite.desconectar(con, stmt);
        }
    }

    // listar
    public List<Temporada> readTemporada(int fkAnime) { // retorna um array de temporadas que sao listadas no read() de
                                                        // AnimeDAO
        PreparedStatement stmt = null;
        ResultSet rs = null;

        List<Temporada> temporadas = new ArrayList<>();

        try {
            // consulta INNER JOIN: retorna a linha da tabela temporada que possui a
            // fk.temporada == id.temporada AND fk.anime == id.anime
            stmt = con.prepareStatement("SELECT * FROM temporada");
                    //"SELECT * FROM temporada INNER JOIN anime ON temporada.fk_anime_id = anime.pk_id_anime"
            rs = stmt.executeQuery();

            while (rs.next()) { // percorre as tabelas que atendem à consulta acima
                
                if(rs.getInt("fk_anime_id") == fkAnime){            // seleciona os temporadas pela fk de ep
                    int idTemp = rs.getInt("pk_id_temp");
                    int numeroTemp = rs.getInt("numeroTemp");
                    String estacao = rs.getString("estacao_temp");
                    String dataInicio = rs.getString("dataInicio");
                    String dataTermino = rs.getString("dataTermino");
                    
                    Temporada novaTemp = new Temporada(idTemp, numeroTemp, estacao, dataInicio, dataTermino);
                    temporadas.add(novaTemp); // add ao array q será retornado para read() de AnimeDAO
                }
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao listar! " + e.getMessage());
        } finally {
            ConexaoSQLite.desconectar(con, stmt, rs);
        }
        // array retornado à listagem dos Animes
        return temporadas;

    }

    //update:
    public void UPDATE(Temporada t) {

        PreparedStatement stmt = null;

        try {

            stmt = con.prepareStatement(
                    "UPDATE temporada SET numeroTemp = ?, estacao_temp = ?, dataInicio = ?, dataTermino = ?, fk_anime_id = ? WHERE  pk_id_temp = ?");
            
            stmt.setInt(1, t.getNumeroTemp());
            stmt.setString(2, t.getEstacao());
            stmt.setString(3, t.getDataInicio());
            stmt.setString(4, t.getDataTermino());
            stmt.setInt(5, t.getFkanime().getId()); 
            stmt.setInt(6, t.getId());

            stmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "Atualizado com sucesso!");

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao atualizar! " + e.getMessage());
        } finally {
            ConexaoSQLite.desconectar(con, stmt);
        }
    }

    //delete

    public void DELETE(Temporada t) {

        PreparedStatement stmt = null;

        try {
           
            stmt = con.prepareStatement("DELETE FROM temporada WHERE pk_id_temp = ?");
            stmt.setInt(1, t.getId());

            stmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "Excluído com sucesso!");

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao Excluir! " + e.getMessage());
        } finally {
            ConexaoSQLite.desconectar(con, stmt);
        }
    }
}