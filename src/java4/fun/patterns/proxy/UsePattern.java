package java4.fun.patterns.proxy;

import java.util.ArrayList;
import java.util.List;

/**
 * Classe de testes e exemplo de uso do pattern Proxy.
 * 
 *
 */
public class UsePattern {
	
	public static void main(String[] args) {
		
		List<Arquivo> arquivos = new ArrayList<Arquivo>();
		
		arquivos.add(new ArquivoProxy("arquivoTXT.txt"));
		arquivos.add(new ArquivoProxy("arquivoTXT2.txt"));
		arquivos.add(new ArquivoProxy("arquivoTXT3.txt"));
		
		System.out.println("\n");
		
		/* Mostra todos os arquivos. 
		 * Carrega os arquivos por demanda, nesse caso solicita todos os arquivos.
		 * */
		for(Arquivo arq: arquivos){
			arq.mostrarArquivo();
		}
		
		/* Agora ele não cria mais nehum arquivo pois ele jah carregou pra memoria. 
		 * Temos um ganho de tempo de processamento.
		 * */
		for(Arquivo arq: arquivos){
			arq.mostrarArquivo();
		}
		
	}
	
}
