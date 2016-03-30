package java4.fun.patterns.observer;

public class MercadoObserver implements Observer {
	
	public void reciveNotify(Object obj) {
		System.out.println("O Mercado está interessado nessa empresa pois o salario subio de novo!!!" + obj);
	}
	
}
