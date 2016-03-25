package java4.fun.patterns.builder;

import java.util.List;

public class PessoaPobre extends Pessoa{	
	
	String idBolsaFamilia;
	
	public PessoaPobre(List<String> filhos){
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
