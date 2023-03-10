package produtos;

import banco.GuitarraDAO;
import javax.swing.JOptionPane;

public class Guitarra extends InstrumentoCordas {

    private double raio;
    private String tipocorpo;
    
    /*
    polimorfismo - o mesmo método cadastrar da superclasse, porém irá ter um resultado diferente
    pois a classe filho guitarra possui mais atributos para cadastrar, deletar e etc
    */
    public boolean cadastrar(String marca, String modelo, String uso, String madeiracorpo, 
            String madeiraBraco, String captacao, double raio,
            String tipocorpo, int estoque, double preco) {
        GuitarraDAO guiDAO = new GuitarraDAO();
        super.cadastrar(marca, modelo, uso, madeiracorpo, madeiraBraco, captacao, estoque, preco);
        setRaio(raio);
        setTipocorpo(tipocorpo);
        if (guiDAO.save(this)) {
            JOptionPane.showMessageDialog(null, "Salvo com sucesso!");
            return true;
        } else {
            JOptionPane.showMessageDialog(null, "Erro ao salvar");
            return false;
        }
    }
    public boolean editar(int id, String marca, String modelo, String uso, String madeiracorpo, 
            String madeiraBraco, String captacao, double raio,
            String tipocorpo, int estoque, double preco) {
        GuitarraDAO guiDAO = new GuitarraDAO();
        super.editar(id, marca, modelo, uso, madeiracorpo, madeiraBraco, captacao, estoque, preco);
        setRaio(raio);
        setTipocorpo(tipocorpo);
        if (guiDAO.edicao(this)) {
            JOptionPane.showMessageDialog(null, "Editado com sucesso!");
            return true;
        } else {
            JOptionPane.showMessageDialog(null, "Erro ao editar");
            return false;
        }
    }
    
    public void vender(int id){
        GuitarraDAO guiDAO = new GuitarraDAO();
        setID(id);
        if (guiDAO.venda(this))
            JOptionPane.showMessageDialog(null, "Vendido com sucesso!");            
        else
            JOptionPane.showMessageDialog(null, "Erro ao vender");
    }
    
    @Override
    public boolean deletar(int id) {
        GuitarraDAO guiDAO = new GuitarraDAO();
        super.deletar(id);
        if (guiDAO.delete(this)) {
            JOptionPane.showMessageDialog(null, "Deletado com sucesso!");
            return true;
        } else {
            JOptionPane.showMessageDialog(null, "Erro ao deletar");
            return false;
        }
    }

    public double getRaio() {
        return raio;
    }

    public void setRaio(double raio) {
        this.raio = raio;
    }

    public String getTipocorpo() {
        return tipocorpo;
    }

    public void setTipocorpo(String tipocorpo) {
        this.tipocorpo = tipocorpo;
    }

}
