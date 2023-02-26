package produtos;

import banco.BaixoDAO;
import javax.swing.JOptionPane;

public class Baixo extends InstrumentoCordas {

    private int numCordas;
    private String passiovoativo;

    public boolean cadastrar(String marca, String modelo, String uso, String madeiracorpo,
            String madeiraBraco, String captacao, int numcord,
            String passativo, int estoque, double preco) {
        BaixoDAO bassDAO = new BaixoDAO();
        super.cadastrar(marca, modelo, uso, madeiracorpo, madeiraBraco, captacao, estoque, preco);
        setNumCordas(numcord);
        setPassiovoativo(passativo);
        if (bassDAO.save(this)) {
            JOptionPane.showMessageDialog(null, "Salvo com sucesso!");
            return true;
        } else {
            JOptionPane.showMessageDialog(null, "Erro ao salvar");
            return false;
        }
    }

    public boolean editar(int id, String marca, String modelo, String uso, String madeiracorpo,
            String madeiraBraco, String captacao, int numcord,
            String passativo, int estoque, double preco) {
        BaixoDAO bassDAO = new BaixoDAO();
        super.editar(id, marca, modelo, uso, madeiracorpo, madeiraBraco, captacao, estoque, preco);
        setNumCordas(numcord);
        setPassiovoativo(passativo);
        if (bassDAO.edicao(this)) {
            JOptionPane.showMessageDialog(null, "Editado com sucesso!");
            return true;
        } else {
            JOptionPane.showMessageDialog(null, "Erro ao editar");
            return false;
        }
    }

    @Override
    public boolean deletar(int id) {
        BaixoDAO bassDAO = new BaixoDAO();
        super.deletar(id);
        if (bassDAO.delete(this)) {
            JOptionPane.showMessageDialog(null, "Deletado com sucesso!");
            return true;
        } else {
            JOptionPane.showMessageDialog(null, "Erro ao deletar");
            return false;
        }
    }

    public int getNumCordas() {
        return numCordas;
    }

    public void setNumCordas(int numCordas) {
        this.numCordas = numCordas;
    }

    public String getPassiovoativo() {
        return passiovoativo;
    }

    public void setPassiovoativo(String passiovoativo) {
        this.passiovoativo = passiovoativo;
    }

}
