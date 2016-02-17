package java4.fun.patterns.builder;

import java.util.List;

public class PessoaRica extends Pessoa{

	String idClubeDeGolf;
	
	public PessoaRica(List<String> filhos){
		this.filhos = filhos;
	}
	
	List<String> filhos;

	public List<String> getFilhos() {
		return filhos;
	}

	public void setFilhos(List<String> filhos) {
		this.filhos = filhos;
	}
	
	@Override
	public String toString() {
		return super.toString() + filhos.toString();
	}
	
}
