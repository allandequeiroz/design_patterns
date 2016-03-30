package java4.fun.patterns.composite;

import java.util.Enumeration;
import java.util.Vector;

/**
 * Pattern Composite. Representa um unico objeto ou uma coleção de objetos.
 * Podemos usar esse pattern para repreesenatr hierarquias e estruturas de dados.
 * É uma estrutura de arvore, melhorada.  
 *  As aplicações para esses pattern são as mais variadas.
 *  
 * 
 *
 */
public class Empregado implements Empregavel {

	private String nome;
	private String cargo;
	private Double salario;
	private Vector<Empregado> subordinados;
	
	public Empregado() {
		subordinados = new Vector<Empregado>();
	}	
	
	public Empregado(String nome, String cargo, Double salario) {
		super();
		this.nome = nome;
		this.cargo = cargo;
		this.salario = salario;
		subordinados = new Vector<Empregado>();
	}

	
	// metodos para os subordinados.
	
	public void addSubordinado(Empregado e){
		subordinados.add(e);
	}
	
	public void removeSubordinado(Empregavel e){
		subordinados.remove(e);
	}
	
	public Enumeration<Empregado> elements(){
		return subordinados.elements();
	}
	
	public Vector<Empregado> getSubordinados(){
		return subordinados;
	}
	
	public Double getTotalSalarios(){
		
		double salarios = 0 ;
		for(int i=0;i<subordinados.size();i++){
			salarios += subordinados.elementAt(i).getSalario();
		}
		return salarios;
	}
	
	
	// getters and  setters

	public String getCargo() {
		return cargo;
	}
	public void setCargo(String cargo) {
		this.cargo = cargo;
	}
	
	public String getNome() {
		return nome;
	}	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	
	public Double getSalario() {
		return salario;
	}	
	
	public void setSalario(Double salario) {
		this.salario = salario;
	}
	
	
	
	// toString , equals ands hashCode

	
	@Override
	public int hashCode() {
		final int PRIME = 31;
		int result = 1;
		result = PRIME * result + ((cargo == null) ? 0 : cargo.hashCode());
		result = PRIME * result + ((nome == null) ? 0 : nome.hashCode());
		result = PRIME * result + ((salario == null) ? 0 : salario.hashCode());
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
		final Empregado other = (Empregado) obj;
		if (cargo == null) {
			if (other.cargo != null)
				return false;
		} else if (!cargo.equals(other.cargo))
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		if (salario == null) {
			if (other.salario != null)
				return false;
		} else if (!salario.equals(other.salario))
			return false;
		return true;
	}	
	
	
	@Override
	public String toString() {
		return "Nome:  " + nome + " cargo: " + cargo + " salario: "  + salario; 
	}
	
}
