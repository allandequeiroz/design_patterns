package java4.fun.patterns.proxy;

/**
 * 
 * Pattern Proxy. Esse pattern é muito util e utilizado em diversas tenologias e frameworks como por exemplo
 * EJB e Hibernate.
 * 
 * Ele representa objetos que são dificeis ou que tem um custo muito alto de se duplicar. Como um objeto grande em memoria
 * ou uma conexão de rede.
 * 
 * Deve ser usado em situações em que multiplas copias de um objeto complexo devem existir. Muitos proxies são criados mas
 * na verdade apontam para uma unica intancia.
 * 
 * Exemplos de proxy:
 * 
 *  Remoto				: Prove Referencias a um objeto remoto que está em outra maquina que está em um endereço de memoria diferente.
 *  Virtual proxy		: Premite a criação de objetos em memoria quando somente é restritamente necessario base de: Lazy evaluation.
 *  Proteção proxy		: Prove niveis de acesso de seguranã a um objeto.
 *  Cache proxy			: Prove um armazenamento temporario de um resultado de multiplas operações que os clientes podem compartilhar, base de: Memoization.
 *  Sincronização proxy : Prove controle de acesso concorente sobre objetos desincronizados. 
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
