package java4.fun.patterns.command;

/**
 * Pattern que prove execu��o de um determinado processamento sem conhecer
 * como esse processamento ocorre. A vantagem eh que podemos mudar a execu��o a
 * qualquer momento sem ter de conmhcer como ocorre sua implementa��o. Esse pattern � muito
 * utilizado com EJB 2.0 por exemplo.
 *  
 * 
 *
 */
public interface Command {
	public void execute();
}
