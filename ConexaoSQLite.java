import java.sql.*;

public class ConexaoSQLite {

    /* Conecta a um banco de dados (cria o banco se ele não existir) */

    public static Connection conectar() {

        try {

            Class.forName("org.sqlite.JDBC");
            return DriverManager.getConnection("jdbc:sqlite:test.db");

        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException("Erro na conexao: ", e);
        }
        // System.out.println("conectou!!!");
    }

    // sobrecarga nos metodos de desconexao - usados de acordo com o q precisa ser
    // passado nos prm
    public static void desconectar(Connection con) {
        try {
            if (con != null) {
                con.close();
            }

        } catch (SQLException e) {
            throw new RuntimeException("Erro na desconexao: ", e);
        }
        // System.out.println("desconectou!!!");
    }

    public static void desconectar(Connection con, PreparedStatement stmt) {
        desconectar(con);

        try {
            if (stmt != null)
                stmt.close();

        } catch (SQLException e) {
            throw new RuntimeException("Erro na desconexao: ", e);
        }
        // System.out.println("desconectou!!!");
    }

    public static void desconectar(Connection con, PreparedStatement stmt, ResultSet rs) {
        desconectar(con, stmt);

        try {
            if (rs != null)
                rs.close();

        } catch (SQLException e) {
            throw new RuntimeException("Erro na desconexao: ", e);
        }
    }

}
