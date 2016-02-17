package java4.fun.patterns.adapter;

/**
 * Interface que define o comportamento que Pessoa deveria ter.
 */
public interface Contrato {
	
	void setNome(String nome);
	void setIdade(int idade);
	void setTelefone(String telefone);
	
	String getNome();
	int getIdade();
	String getTelefone();
	
	String toString();
	
}
