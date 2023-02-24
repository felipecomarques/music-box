package banco;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import produtos.Guitarra;

/*
SOBRE ESSA CLASSE: 
DAO é um padrão de projetos onde um objeto que provê uma interface que abstrai o acesso 
a dados e lê e grava a partir da origem de dados. Basicamente, nessa classe você irá 
inserir o código do SQL para quer sejá executado no banco de dados. 

É importante usar o PreparedStatement, caso contrário o código estará
vunerável (MySQL Injection). Além do PreparedStatement, também é bom saber o que é um
ResultSet. No final de cada método, é necessário fechar a conexão com o banco de dados.

OBS.: Se você não sabe o que está fazendo, não altere muito o DAO. Isso pode
causar erros futuros.
 */

public class GuitarraDAO {
    // ATRIBUTOS //
    private Connection con = null;

    // METODOS //
    public GuitarraDAO() {
        con = ConnectionFactory.getConnection();
    }
    
    public boolean save(Guitarra guita) {
        String sql = "INSERT INTO guitarra (marca, modelo, uso, madeiracorpo, madeiraBraco, captacao, tipocorpo, raio, estoque, preco) \n" +
                     "VALUES (?,?,?,?,?,?,?,?,?,?);";
        PreparedStatement stmt = null;
        try {
            stmt = con.prepareStatement(sql);
            stmt.setString(1, guita.getMarca());
            stmt.setString(2, guita.getModelo());
            stmt.setString(3, guita.getEstadoUso());
            stmt.setString(4, guita.getMadeiraCorpo());
            stmt.setString(5, guita.getMadeiraBraco());
            stmt.setString(6, guita.getCaptacao());
            stmt.setString(7, guita.getTipocorpo());
            stmt.setDouble(8, guita.getRaio());
            stmt.setInt(9, guita.getEstoque());
            stmt.setDouble(10, guita.getPreco());
            stmt.executeUpdate();
            return true;
        } catch (SQLException ex) {
            System.err.println("Erro: " + ex);
            return false;
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }
    }
    
    public List<Guitarra> encontrar(String modelo) {
        String sql =  "SELECT * FROM guitarra";
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<Guitarra> guitarra = new ArrayList<>();
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
                Guitarra gui = new Guitarra();
                gui.setID((rs.getInt("id")));
                gui.setMarca((rs.getString("marca")));
                gui.setModelo((rs.getString("modelo")));
                gui.setEstadoUso((rs.getString("uso")));
                gui.setMadeiraCorpo((rs.getString("madeiracorpo")));
                gui.setMadeiraBraco((rs.getString("madeiraBraco")));
                gui.setCaptacao((rs.getString("captacao")));
                gui.setTipocorpo((rs.getString("tipocorpo")));
                gui.setRaio((rs.getDouble("raio")));
                gui.setEstoque((rs.getInt("estoque")));
                gui.setPreco((rs.getDouble("preco")));
                guitarra.add(gui);
            }
        } catch (SQLException ex) {
            System.err.println("Erro: " + ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }
        return guitarra;
    }
}
