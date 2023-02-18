package funcionarios;

public abstract class Funcionario {
	private String nome;
	private String CPF;
	private double salario;
	private int idade;
	private String login;
	
	
	// MÉTODOS //
	public void IniciarTrabalho() {
		
	}
	
	public void TerminarTrabalho() {
		
	}
	
	public void Cadastrar() {
		
	}
	
	// GET E SET //
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCPF() {
		return CPF;
	}

	public void setCPF(String cPF) {
		CPF = cPF;
	}

	public double getSalario() {
		return salario;
	}

	public void setSalario(double salario) {
		this.salario = salario;
	}

	public int getIdade() {
		return idade;
	}

	public void setIdade(int idade) {
		this.idade = idade;
	}
	
	
}
