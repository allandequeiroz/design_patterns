package java4.fun.patterns.observer;

public class AcionistasObserver implements Observer {
	public void reciveNotify(Object obj) {
		System.out.println("Nos acionistas vamos ter que sair desse imvestimento por que o salario subio tanto" + obj);
	}
}
