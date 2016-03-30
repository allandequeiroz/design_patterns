package java4.fun.patterns.bridge;

/**
 * Classe que traz a implementação dos recursos basicos de um 
 * Implementador de IList.(Semelhante ao Adpter, mas com uma difereça)
 * Esse patterm prove total separação dentre as interfaces e as implementações.
 * Tanto que a Bridge( no caso BaseList) recdebe uma implementadora de IList(no caso implementor)
 * Assim podemos crirar varias impelementações de Ilist como é o caso de(BaseList) e nos prover colocar
 * muitos recursos na ponte que são as classes que herdam de BaseList(OrnamentedList,NumberedList)
 * Assim Bridge(BaseList) funciona como Adpter de certa forma, mas ele prove essa separação entre interfaces 
 * e implementação.  
 * 
 * 
 *
 */
public class BaseList {

	protected IList implementor;
    
    public void setImplementor(IList impl){
        implementor = impl;
    }
    
    public void add(String item){
        implementor.addItem(item);
    }
    public void add(String item, int position){
        if (implementor.supportsOrdering()){
            implementor.addItem(item, position);
        }
    }
    
    public void remove(String item){
        implementor.removeItem(item);
    }
    
    public String get(int index){
        return implementor.getItem(index);
    }
    
    public int count(){
        return implementor.getNumberOfItems();
    }
	
}
