import java.sql.*;

public class ConexaoSQLite {

    private Connection conexao;

    public boolean conectar() {

        try {
            // Class.forName("org.sqlite.JDBC");
            this.conexao = DriverManager.getConnection("jdbc:sqlite:test.bd");

        } catch (SQLException e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            return false;
        }

        System.out.println("conectou ao bd!");

        return true;
    }

    public boolean desconectar() {

        try {
            if (this.conexao.isClosed() == false) {
                this.conexao.close();
            }

        } catch (SQLException e) {

            System.err.println(e.getMessage());
            return false;
        }
        System.out.println("desconectou do bd!");
        return true;
    }

    // Criar os statements para nossos sqls executados
    public Statement criarStatement() {

        try {
            return this.conexao.createStatement();
        } catch (SQLException e) {
            return null;
        }
    }

    public Connection getConexao() {
        return this.conexao;
    }

}
