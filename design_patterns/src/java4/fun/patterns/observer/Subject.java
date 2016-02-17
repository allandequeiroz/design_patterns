package java4.fun.patterns.observer;

/**
 * Pattern Observer � dividido em duas partes observeador(Observer) e observado(Subject).
 * o Subject registra todos Observers que tem interrese naquele Subject e quando determinada a��o ocorrer
 * ele notifica todos os observers que est�o registras com interrese nesse subject. Esse pattern pode ser usado para tratamento de eventos 
 * em interfaces graficas pro exemplo ou para multiplas a��es que devem ser tomadas por diferentes classes.
 *  
 * .
 *
 */
public interface Subject {
	public void registerInterest(Observer ob);
}
