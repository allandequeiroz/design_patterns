package java4.fun.patterns.composite;

import java.util.Enumeration;
import java.util.Vector;

public interface Empregavel {

	public abstract void addSubordinado(Empregado e);

	public abstract void removeSubordinado(Empregavel e);

	public abstract Enumeration<Empregado> elements();

	public abstract Vector<Empregado> getSubordinados();

	public abstract Double getTotalSalarios();

	public abstract String getCargo();

	public abstract void setCargo(String cargo);

	public abstract String getNome();

	public abstract void setNome(String nome);

	public abstract Double getSalario();

	public abstract void setSalario(Double salario);

	public abstract int hashCode();

	public abstract boolean equals(Object obj);

	public abstract String toString();

}