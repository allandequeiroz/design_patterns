package java4.fun.patterns.adapter;


/**
 * Implementação da Interface Pessoa.
 */
public class PessoaImpl implements Pessoa {
	
	private int idadePessoa;
	private String nomePessoa;
	private String telefonePessoa;
	
	public int getIdadePessoa() {
		return idadePessoa;
	}
	public void setIdadePessoa(int idadePessoa) {
		this.idadePessoa = idadePessoa;
	}
	
	public String getNomePessoa() {
		return nomePessoa;
	}
	public void setNomePessoa(String nomePessoa) {
		this.nomePessoa = nomePessoa;
	}
	
	public String getTelefonePessoa() {
		return telefonePessoa;
	}
	public void setTelefonePessoa(String telefonePessoa) {
		this.telefonePessoa = telefonePessoa;
	}	
	
	public String toString() {	
		return this.idadePessoa + " " + this.nomePessoa + " " +
				this.telefonePessoa;
	}
	

}
