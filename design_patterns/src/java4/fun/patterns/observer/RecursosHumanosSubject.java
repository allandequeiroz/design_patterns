package java4.fun.patterns.observer;

import java.util.ArrayList;
import java.util.List;

/**
 * Implementa��o de Subject para um setor de RH que pretende aumentar o salario dos func�rios.
 * 
 *
 */
public class RecursosHumanosSubject implements Subject {	
	
	private Integer salarioBase;
	
	public RecursosHumanosSubject() {}
	
	public RecursosHumanosSubject(Integer salarioBase) {
		this.salarioBase = salarioBase;	
	}
	
	/* efetua hold dos Observers */
	private List<Observer> observers = new ArrayList<Observer>();

	/* registra os observers */
	public void registerInterest(Observer ob) {
		observers.add(ob);
	}	
	
	
	public void aplicaAumento(Integer valor){

		/* efetua o aumento de fato */
		salarioBase = salarioBase.intValue() + valor.intValue();
		
		/* Notifica todos que est�o interresandos nessa mudan�a. */
		for(Observer obs : observers){
			obs.reciveNotify(valor);
		}
		
	}
	
}
