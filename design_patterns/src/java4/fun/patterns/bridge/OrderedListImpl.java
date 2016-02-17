package java4.fun.patterns.bridge;

import java.util.ArrayList;

/**
 * Implementação de IList, ordenada!
 * 
 *
 */
class OrderedListImpl implements IList{
    private ArrayList items = new ArrayList();
    
    @SuppressWarnings("unchecked")
	public void addItem(String item){
        if (!items.contains(item)){
            items.add(item);
        }
    }
    @SuppressWarnings("unchecked")
	public void addItem(String item, int position){
        if (!items.contains(item)){
            items.add(position, item);
        }
    }
    
    public void removeItem(String item){
        if (items.contains(item)){
            items.remove(items.indexOf(item));
        }
    }
    
    public boolean supportsOrdering(){
        return true;
    }
    
    public int getNumberOfItems(){
        return items.size();
    }
    
    public String getItem(int index){
        if (index < items.size()){
            return (String)items.get(index);
        }
        return null;
    }
}
