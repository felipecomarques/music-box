package banco;

import static banco.ConnectionFactory.getConnection;
import static banco.ConnectionFactory.getConnectionBD;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class AdmBD {
    public boolean gerarBanco() {
        Connection con = getConnectionBD();
        String sql = "CREATE DATABASE IF NOT EXISTS musicbox";
        PreparedStatement stmt = null;
        try {
            stmt = con.prepareStatement(sql);
            stmt.executeUpdate();
            return true;
        } catch (SQLException ex) {
            System.err.println("Erro: " + ex);
            return false;
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }
    }
    
    public boolean gerarTab(String tabela) {
        Connection con = getConnection();
        String sql2 = tabela;
        PreparedStatement stmt = null;
        try {
            stmt = con.prepareStatement(sql2);
            stmt.executeUpdate();
            return true;
        } catch (SQLException ex) {
            System.err.println("Erro: " + ex);
            return false;
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }
    }
}