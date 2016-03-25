package java4.fun.patterns.observer;

public class FuncionariosObserver implements Observer {
	public void reciveNotify(Object obj) {
		System.out.println("Nos funcionarios estamos felizes com o novo aumento de: " + obj);
	}
}
