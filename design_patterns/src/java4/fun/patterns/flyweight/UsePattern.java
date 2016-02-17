package java4.fun.patterns.flyweight;

/**
 * Classe de testes e exemplo de uso do Pattern Flyweight.
 * 
 *
 */
public class UsePattern {

	public static void main(String[] args) {
		
		RuaFactory.getRua(94010030); // rua 01
		RuaFactory.getRua(94010030);
		RuaFactory.getRua(94010030);
		
		RuaFactory.getRua(94010030);
		RuaFactory.getRua(94010030);
		RuaFactory.getRua(85013031); // rua 02
		
		System.out.println(RuaFactory.getRua(94010030));
		System.out.println("Total de ruas na memoria: "+ RuaFactory.getTotalRuas());
		
	}
	
}
