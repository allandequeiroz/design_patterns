package java4.fun.patterns.observer;

/**
 * Pattern Observer é dividido em duas partes observeador(Observer) e observado(Subject).
 * o Subject registra todos Observers que tem interrese naquele Subject e quando determinada ação ocorrer
 * ele notifica todos os observers que estão registras com interrese nesse subject. Esse pattern pode ser usado para tratamento de eventos 
 * em interfaces graficas pro exemplo ou para multiplas ações que devem ser tomadas por diferentes classes.
 *  
 * .
 *
 */
public interface Subject {
	public void registerInterest(Observer ob);
}
