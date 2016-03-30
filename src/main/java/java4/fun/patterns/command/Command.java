package java4.fun.patterns.command;

/**
 * Pattern que prove execução de um determinado processamento sem conhecer
 * como esse processamento ocorre. A vantagem eh que podemos mudar a execução a
 * qualquer momento sem ter de conmhcer como ocorre sua implementação. Esse pattern é muito
 * utilizado com EJB 2.0 por exemplo.
 *  
 * 
 *
 */
public interface Command {
	public void execute();
}
