package java4.fun.patterns.bridge;

/**
 * Interface que define oque uma IList deve fazer.
 * 
 *
 */
public interface IList {

	 public void addItem(String item);
	 public void addItem(String item, int position);
	 public void removeItem(String item);
	 public int getNumberOfItems();
	 public String getItem(int index);
	 public boolean supportsOrdering();
	
}
