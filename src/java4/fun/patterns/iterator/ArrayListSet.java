package java4.fun.patterns.iterator;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * O Pattern Iterator já é implementado na API do JDK, sua interface pode ser vista em: java.util.Iterator.
 * Essa classe ArrayListSet faz um implementação de um ArrayList como se fosse um Set(ou sejah sem permitir elementos duplicados).
 * O Pattern iterator garante uma maneira simples e padronizada de iterar uma coleção ou qualquer outra coisa.
 *   
 * 
 * @see java.util.Iterador
 *
 */
public class ArrayListSet implements Iterator {

	private List innerList = new ArrayList();	
	private Iterator innerIterator;
	
	public ArrayListSet() {
		reloadIt();
	}
	
	private void reloadIt(){
		innerIterator = innerList.iterator();
	}
	
	@SuppressWarnings("unchecked")
	public boolean add(Object obj){
		
		if (innerList.contains(obj)){
			return false;
		}
		
		innerList.add(obj);
		return true;
		
	}
	
	public Object get(int index){
		return innerList.get(index);
	}
	
	public Iterator iterator(){
		reloadIt();
		return this;
	}
	
	
	//  METODOS DO CONTRATO DO: Iterator       // 1
	
	public boolean hasNext() {
		return innerIterator.hasNext();
	}
	
	public Object next() {
		return innerIterator.next();
	}
	
	public void remove() {
		innerIterator.remove();
	}
	
}
