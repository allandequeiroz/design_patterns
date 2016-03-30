package java4.fun.patterns.iterator;

import java.util.Iterator;

/**
 * Classe de teste e exemplo de uso do Pattern Iterator. 
 * 
 *
 */
public class UsePattern {
	
	public static void main(String[] args) {
		
		ArrayListSet als = new ArrayListSet();
		
		als.add("Diego");
		als.add("Bruna");
		als.add("Crom");
		als.add("Locke");
		als.add("Locke");
		als.add("Locke");
		
		Iterator it = als.iterator();		
		while(it.hasNext()){
			System.out.println(it.next());
		}
		
	}
	
}
