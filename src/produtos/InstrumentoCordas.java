package produtos;

public class InstrumentoCordas {
	private String marca;
	private String modelo;
	private String estadoUso;
	private String madeiraCorpo;
	private String madeiraBraco;
	private int estoque;
	private double preco;
	
	
	// MÉTODOS //
	public void ReproduzirDemo() {
		
	}
	
	// GET E SET //
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