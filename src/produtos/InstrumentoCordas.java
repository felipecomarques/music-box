package produtos;

import javax.swing.JOptionPane;

abstract class InstrumentoCordas {

    // Atriubtos com private para encapsulamento
    private int ID;
    private String marca;
    private String modelo;
    private String estadoUso;
    private String madeiraCorpo;
    private String madeiraBraco;
    private String captacao;
    private int estoque;
    private double preco;

    // MÉTODOS //
    public boolean cadastrar (String marca, String modelo, String uso, String madeiracorpo, 
            String madeiraBraco, String captacao, int estoque, double preco) {
        setMarca(marca);
        setModelo(modelo);
        setEstadoUso(uso);
        setMadeiraBraco(madeiraBraco);
        setMadeiraCorpo(madeiracorpo);
        setCaptacao(captacao);
        setEstoque(estoque);
        setPreco(preco);
        return true;
    }
    public boolean editar(int id, String marca, String modelo, String uso, String madeiracorpo,
            String madeiraBraco, String captacao, int estoque, double preco) {
        setID(id);
        setMarca(marca);
        setModelo(modelo);
        setEstadoUso(uso);
        setMadeiraBraco(madeiraBraco);
        setMadeiraCorpo(madeiracorpo);
        setCaptacao(captacao);
        setEstoque(estoque);
        setPreco(preco);
        return true;
    }
    
    public boolean deletar(int id) {
        setID(id);
        return true;
    }
    
    public void vender(int id){
        setID(id);
    }
    
    // GET E SET
    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getCaptacao() {
        return captacao;
    }

    public void setCaptacao(String captacao) {
        this.captacao = captacao;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getEstadoUso() {
        return estadoUso;
    }

    public void setEstadoUso(String estadoUso) {
        this.estadoUso = estadoUso;
    }

    public String getMadeiraCorpo() {
        return madeiraCorpo;
    }

    public void setMadeiraCorpo(String madeiraCorpo) {
        this.madeiraCorpo = madeiraCorpo;
    }

    public String getMadeiraBraco() {
        return madeiraBraco;
    }

    public void setMadeiraBraco(String madeiraBraco) {
        this.madeiraBraco = madeiraBraco;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public int getEstoque() {
        return estoque;
    }

    public void setEstoque(int estoque) {
        this.estoque = estoque;
    }

}
