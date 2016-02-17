package java4.fun.patterns.factory;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Pattern Factory (+ Demannd caching): é uma fabrica que fabrica objetos e encapsula a regra de criação de objetos e prove
 * desacoplamento. Este patterm esta sempre associado a uma Interface. Poderiamos desligar o Demannd caching tirando os metodos 
 * [getOnCache e setOnCache] que são os responsaveis pela manipulação de cache por demanda! <BR> 
 * Podemos utilizar esse pattern com acesso a camada de persistencia por exemplo caso a aplicação seja
 * uma parte Hibernate outra JDBC e até outras formas de persistencia. 
 * <BR>
 * OBS: nesse pattern internamente para aplicar o lazy caching poderiamos aplicar o pattern Chain of Responsabiliy.
 * 
 * 
 *
 */
public class Factory {

	/* AKI REGISTRAMOS TODOS OS ESTILOS SUPORTADOS PELA FACTORY! */
	public static final String SAMBA    = "org.diegopacheco.patterns.factory.PessoaBrazil";
	public static final String ROCK     = "org.diegopacheco.patterns.factory.PessoaENG";
	public static final String COUNTRY  = "org.diegopacheco.patterns.factory.PessoaEUA";	
		
	public Pessoa buildPessoa(String style){
		try {
			
			Object obj = null;
			
			if (style.equals(SAMBA)){	
				
				if (containsOnCache(SAMBA)){ 
					return getOnCache(SAMBA);
				}else{
					 obj = Class.forName(SAMBA).newInstance();
					 setOnCache(SAMBA,(Pessoa)obj);
				}
				
				return (Pessoa) obj;
			}
			
			
			if (style.equals(ROCK)){	
				
				if (containsOnCache(ROCK)){ 
					return getOnCache(ROCK);
				}else{
					 obj = Class.forName(ROCK).newInstance();
					 setOnCache(ROCK,(Pessoa)obj);
				}
				
				return (Pessoa) obj;
			}
			
			
			if (style.equals(COUNTRY)){	
				
				if (containsOnCache(COUNTRY)){ 
					return getOnCache(COUNTRY);
				}else{
					 obj = Class.forName(COUNTRY).newInstance();
					 setOnCache(COUNTRY,(Pessoa)obj);
				}
				
				return (Pessoa) obj;
			}
			
		}
		catch (Throwable t) {
			t.printStackTrace();			
		}		
		
		throw new IllegalArgumentException("Estilo não suportado! Estilo: " + style);	
	
	}
	
	
	/* AKI TEMOS OS METODOS A VARIAVEL HOLDER(demanndCache) REFERENTE AO DEMANND CACHING! */
	private Map<String,Pessoa> demanndCache = new ConcurrentHashMap<String, Pessoa>();
	
	private boolean containsOnCache(String key){
		return demanndCache.containsKey(key);
	}	
	private Pessoa getOnCache(String key){
		return demanndCache.get(key);
	}	
	private void setOnCache(String key,Pessoa value){
		demanndCache.put(key, value);
	}

	
}
