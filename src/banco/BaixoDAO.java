package banco;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import produtos.Baixo;

/**
 *
 * @author felip
 */
public class BaixoDAO {
    private Connection con = null;

    // METODOS //
    public BaixoDAO() {
        con = ConnectionFactory.getConnection();
    }
    
    public boolean save(Baixo baixo) {
        String sql = "INSERT INTO baixo (marca, modelo, uso, madeiracorpo, madeiraBraco, captacao, tipocorpo, raio, estoque, preco) \n" +
                     "VALUES (?,?,?,?,?,?,?,?,?,?);";
        PreparedStatement stmt = null;
        try {
            stmt = con.prepareStatement(sql);
            stmt.setString(1, baixo.getMarca());
            stmt.setString(2, baixo.getModelo());
            stmt.setString(3, baixo.getEstadoUso());
            stmt.setString(4, baixo.getMadeiraCorpo());
            stmt.setString(5, baixo.getMadeiraBraco());
            stmt.setString(6, baixo.getCaptacao());
            stmt.setInt(7, baixo.getNumCordas());
            stmt.setString(8, baixo.getPassiovoativo());
            stmt.setInt(9, baixo.getEstoque());
            stmt.setDouble(10, baixo.getPreco());
            stmt.executeUpdate();
            return true;
        } catch (SQLException ex) {
            System.err.println("Erro: " + ex);
            return false;
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }
    }
    
    public List<Baixo> encontrar(String modelo) {
        String sql =  "SELECT * FROM baixo";
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<Baixo> baixo = new ArrayList<>();
        if (modelo != null)
            sql = sql + " WHERE modelo LIKE (?) ORDER BY modelo"; //+ ORDER BY nome
        else
            sql = sql + " ORDER BY modelo";
        try {
            stmt = con.prepareStatement(sql);
            if (modelo != null)
                stmt.setString(1, "%" + modelo + "%");
            rs = stmt.executeQuery();

            while (rs.next()) {
                Baixo bass = new Baixo();
                bass.setID((rs.getInt("id")));
                bass.setMarca((rs.getString("marca")));
                bass.setModelo((rs.getString("modelo")));
                bass.setEstadoUso((rs.getString("uso")));
                bass.setMadeiraCorpo((rs.getString("madeiracorpo")));
                bass.setMadeiraBraco((rs.getString("madeiraBraco")));
                bass.setCaptacao((rs.getString("captacao")));
                bass.setNumCordas((rs.getInt("numcordas")));
                bass.setPassiovoativo((rs.getString("passivoativo")));
                bass.setEstoque((rs.getInt("estoque")));
                bass.setPreco((rs.getDouble("preco")));
                baixo.add(bass);
            }
        } catch (SQLException ex) {
            System.err.println("Erro: " + ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }
        return baixo;
    }
}