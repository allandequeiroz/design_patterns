package java4.fun.patterns.flyweight;

/**
 * Pojo que representa a entidade Rua.
 * Neste exemplo simboliza a locilização de um enrtegreço.
 * 
 * 
 *
 */
public class Rua {

	private String nome;
	private Integer numero;
	private String bairro;
	private String cidade;
	private String estado;
	private String pais;
	private Integer cep;
	
	public Rua() {}	

	public Rua(String nome,Integer  numero, String bairro, String cidade, String estado, String pais, Integer cep) {
		super();
		this.nome = nome;
		this.numero = numero;
		this.bairro = bairro;
		this.cidade = cidade;
		this.estado = estado;
		this.pais = pais;
		this.cep = cep;
	}



	public String getBairro() {
		return bairro;
	}
	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getCidade() {
		return cidade;
	}
	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}

	public Integer getNumero() {
		return numero;
	}
	public void setNumero(Integer numero) {
		this.numero = numero;
	}

	public String getPais() {
		return pais;
	}
	public void setPais(String pais) {
		this.pais = pais;
	}	
	
	public Integer getCep() {
		return cep;
	}
	public void setCep(Integer cep) {
		this.cep = cep;
	}
		

	@Override
	public int hashCode() {
		final int PRIME = 31;
		int result = 1;
		result = PRIME * result + ((bairro == null) ? 0 : bairro.hashCode());
		result = PRIME * result + ((cep == null) ? 0 : cep.hashCode());
		result = PRIME * result + ((cidade == null) ? 0 : cidade.hashCode());
		result = PRIME * result + ((estado == null) ? 0 : estado.hashCode());
		result = PRIME * result + ((nome == null) ? 0 : nome.hashCode());
		result = PRIME * result + ((numero == null) ? 0 : numero.hashCode());
		result = PRIME * result + ((pais == null) ? 0 : pais.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		final Rua other = (Rua) obj;
		if (bairro == null) {
			if (other.bairro != null)
				return false;
		} else if (!bairro.equals(other.bairro))
			return false;
		if (cep == null) {
			if (other.cep != null)
				return false;
		} else if (!cep.equals(other.cep))
			return false;
		if (cidade == null) {
			if (other.cidade != null)
				return false;
		} else if (!cidade.equals(other.cidade))
			return false;
		if (estado == null) {
			if (other.estado != null)
				return false;
		} else if (!estado.equals(other.estado))
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		if (numero == null) {
			if (other.numero != null)
				return false;
		} else if (!numero.equals(other.numero))
			return false;
		if (pais == null) {
			if (other.pais != null)
				return false;
		} else if (!pais.equals(other.pais))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Rua: " + nome + " número: " + numero + " cep: " + cep + 
		", " + cidade +  " - " + estado + " : " + pais;	
	}
	
}
