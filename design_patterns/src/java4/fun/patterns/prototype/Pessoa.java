package java4.fun.patterns.prototype;

/**
 * Esse Pattern serve para criarmos uma copia identica de um Objeto.
 * A Classe java.lang.Object já implementa a interface Cloneable que descreve tal funcionalidade.
 * Podemos implementar a interface diratamente como no caso de Pessoa para configurarmos oque será
 * clonado e oque não, que é o caso do cartão de credito! 
 * Esse pattern pode ser usado em interfaces graficas, ou nos casos que não queremos que os atribitos de 
 * um objeto não sejah modificado ao ser passado para um metodo(por exemplo) ai fazemos um clone do objeto.
 *  
 * 
 *
 */
public class Pessoa implements Cloneable {

	private String nome = "";
	private String endereco = "";
	private String senhaDoCartaoDeCredito = "";
	private int idade = 0;
	
	public Pessoa() {}
	
	public Pessoa(String nome, String endereco, int idade) {
		super();
		this.nome = nome;
		this.endereco = endereco;
		this.idade = idade;
	}


	public String getEndereco() {
		return endereco;
	}
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public int getIdade() {
		return idade;
	}
	public void setIdade(int idade) {
		this.idade = idade;
	}

	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}	

	public String getSenhaDoCartaoDeCredito() {
		return senhaDoCartaoDeCredito;
	}
	public void setSenhaDoCartaoDeCredito(String senhaDoCartaoDeCredito) {
		this.senhaDoCartaoDeCredito = senhaDoCartaoDeCredito;
	}	
	
	
	/**
	 * Metodo que efetua o Clone do Objeto.
	 */
	protected Object clone() throws CloneNotSupportedException {
		
		Pessoa newPessoa = new Pessoa();
		newPessoa.setNome(this.getNome());
		newPessoa.setEndereco(this.getEndereco());
		newPessoa.setIdade(this.getIdade());
		newPessoa.setSenhaDoCartaoDeCredito("###########");
		
		return newPessoa;
	}
	
	
	public String toString() {		
		return "Nome: " + this.getNome() + " Endereço: " + 
				this.getEndereco() + " Idade: " + this.getIdade() + 
				" SenhaDoCartão: " + this.getSenhaDoCartaoDeCredito();
	}
	
}
