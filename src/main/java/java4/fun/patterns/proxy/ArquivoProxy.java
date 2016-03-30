package java4.fun.patterns.proxy;

/**
 * 
 * Pattern Proxy. Esse pattern � muito util e utilizado em diversas tenologias e frameworks como por exemplo
 * EJB e Hibernate.
 * 
 * Ele representa objetos que s�o dificeis ou que tem um custo muito alto de se duplicar. Como um objeto grande em memoria
 * ou uma conex�o de rede.
 * 
 * Deve ser usado em situa��es em que multiplas copias de um objeto complexo devem existir. Muitos proxies s�o criados mas
 * na verdade apontam para uma unica intancia.
 * 
 * Exemplos de proxy:
 * 
 *  Remoto				: Prove Referencias a um objeto remoto que est� em outra maquina que est� em um endere�o de memoria diferente.
 *  Virtual proxy		: Premite a cria��o de objetos em memoria quando somente � restritamente necessario base de: Lazy evaluation.
 *  Prote��o proxy		: Prove niveis de acesso de seguran� a um objeto.
 *  Cache proxy			: Prove um armazenamento temporario de um resultado de multiplas opera��es que os clientes podem compartilhar, base de: Memoization.
 *  Sincroniza��o proxy : Prove controle de acesso concorente sobre objetos desincronizados. 
 * 
 * 
 *
 */
public class ArquivoProxy implements Arquivo {

	private String path;
	private ArquivoReal ar;
	
	public ArquivoProxy(String path) {
		this.path = path;
	}
	
	public void mostrarArquivo() {
		
		if (ar==null){
			ar = new ArquivoReal(path); /* Carrega o arquivo somente por demanda. */
		}
		
		ar.mostrarArquivo();
		
	}
	
}
