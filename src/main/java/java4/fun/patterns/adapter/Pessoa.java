package java4.fun.patterns.adapter;


/**
 * Interface Pessoa, coisa que uma implementação de pessoa deve fazer.
 */
public interface Pessoa {

	void setNomePessoa(String nome);
	void setIdadePessoa(int idade);
	void setTelefonePessoa(String telefone);
	
	String getNomePessoa();
	int getIdadePessoa();
	String getTelefonePessoa();
	
	String toString();
	
}
