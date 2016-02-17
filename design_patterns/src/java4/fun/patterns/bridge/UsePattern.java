package java4.fun.patterns.bridge;

/**
 * Classe de teste e exemplo de uso do Pattern Bridge.
 * 
 *
 */
public class UsePattern {
    public static void main(String [] arguments){        
        
        /* Instancia uma classe que implementa o IList, no caso: OrderedListImpl */
        IList implementation = new OrderedListImpl();
        
        /* Cria uma Bridge(BaseList) que recebe a implementação da IList. */
        BaseList listOne = new BaseList();
        listOne.setImplementor(implementation);
        
        /* Popula a lista com elementos. */
        listOne.add("One");
        listOne.add("Two");
        listOne.add("Three");
        listOne.add("Four");
        System.out.println();
        
        
        /* Cria uma lista ornamentada apartir da BaseList(Bridge) */
        OrnamentedList listTwo = new OrnamentedList();
        listTwo.setImplementor(implementation);
        listTwo.setItemType('+');
        System.out.println();
        
        
        /* Cria uma lista numerada apartir da BaseList(Bridge) */
        NumberedList listThree = new NumberedList();
        listThree.setImplementor(implementation);
        
        
        /* Mostra a lista original */
        for (int i = 0; i < listOne.count(); i++){
            System.out.println("\t" + listOne.get(i));
        }       
        System.out.println();
        
        /* Mostra a lista ornamentada */
        for (int i = 0; i < listTwo.count(); i++){
            System.out.println("\t" + listTwo.get(i));
        }
        System.out.println();
        
        
        /* Mostra a lista nmumerada */
        for (int i = 0; i < listThree.count(); i++){
            System.out.println("\t" + listThree.get(i));
        }
    }
}