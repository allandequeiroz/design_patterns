package java4.fun.patterns.bridge;

/**
 * Classe que impelmentação que prove recurso adicional a BaseList.
 * Sendo esse recurso a lista ornamentada, onde podemos especificar o simbolo que sera 
 * colocado no momento do get da lista.
 * 
 * @author Doiego Pacheco
 *
 */
class OrnamentedList extends BaseList{
    private char itemType;
    
    public char getItemType(){ return itemType; }
    public void setItemType(char newItemType){
        if (newItemType > ' '){
            itemType = newItemType;
        }
    }
    
    public String get(int index){
        return itemType + " " + super.get(index);
    }
}
