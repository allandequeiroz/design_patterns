package java4.fun.patterns.flyweight;

import java.util.Locale;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Esse é o pattern Flyweight, usamos ele quando temos uma quanditade grande de objetos e
 * não podemos nos dar ao luxo de ficar sempre criando eles novamente.
 * Esse pattern nada mais é fo que uma factory com um pool(cache de dados) onde armazenas as
 * informações. Assim sempre que solicitarmos um objeto que já existe ele pega do pool. 
 * 
 * Poderiamos usar esse pattern em muitos lugares e muitos frameworks usam esse pattern.
 * Uma aplicação é em um processador de texto(Word).
 * 
 * 
 *
 */
public class RuaFactory {

	private static Map<Integer,Rua> pool = new ConcurrentHashMap<Integer, Rua>();
	
	public static Rua getRua(Integer cep){		
		
		// valida se foi informado um cep.
		if (cep==null || cep.intValue()<=0)  
			throw new RuaNotFoundException("A Rua de CEP: " + cep.toString() + ", não foi encontrada! ");
		
		// verifica se a rua já não está no pool, se estiver retorna.
		if (pool.containsKey(cep))
			return pool.get(cep);
		
		
		// aki, estou apenas simulando uma nova rua...
		// poderiamos buscar essa informação de rua em:
		// uim banco de dados ou um web service.
		Rua newRua = new Rua();
		newRua.setCep(cep);
		newRua.setNome("Rua-" + cep);
		newRua.setNumero(cep.intValue() - 100 * 5 / 2);
		newRua.setBairro("Centro");
		newRua.setPais(Locale.getDefault().getCountry());
		newRua.setCidade("BarterTownNº " + newRua.getNumero());
		newRua.setEstado("RS" + + newRua.getNumero());
		
		// Adiciona a nova Rua no pool de ruas.
		pool.put(cep, newRua);
		
		return newRua;
		
	}
	
	
	// Metodo que informa, quantas ruas existem no pool.
	public static Integer getTotalRuas(){
		return pool.size();
	}
	
}
