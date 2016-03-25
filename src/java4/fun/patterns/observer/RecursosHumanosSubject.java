package java4.fun.patterns.observer;

import java.util.ArrayList;
import java.util.List;

/**
 * Implementação de Subject para um setor de RH que pretende aumentar o salario dos funcários.
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
		
		/* Notifica todos que estão interresandos nessa mudança. */
		for(Observer obs : observers){
			obs.reciveNotify(valor);
		}
		
	}
	
}
