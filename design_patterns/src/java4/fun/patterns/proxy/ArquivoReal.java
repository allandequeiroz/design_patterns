package java4.fun.patterns.proxy;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * Implementação concreta de um Arquivo.
 * No exemplo o ArquivoReal implementa a busca de um arquivo e disco e sua leitura por completo.
 * 
 * 
 *
 */
public class ArquivoReal implements Arquivo {
	
	private static String BASE;	
	private static String BASE_PATH;
	
	static{
		try {
			BASE = new File(".").getCanonicalPath();
			BASE_PATH = BASE + "/src/org/diegopacheco/patterns/proxy/";			
		} catch (Throwable t) {		
			throw new RuntimeException(t);			
		}		
	}	
	
	
	
	private String path = "";
	
	public ArquivoReal(String path) {
		this.path = path;
		System.out.println("Caregando Arquivo: " + path);
	}
	
	public void mostrarArquivo() {
		System.out.println("Mostrando Arquivo: " + path);
		
		try {
			BufferedReader br = new BufferedReader(new FileReader(BASE_PATH + path));
			String buffer = null;
			
			while( (buffer = br.readLine()) != null){
				System.out.println(buffer);
			}
			
			br.close();
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
}
