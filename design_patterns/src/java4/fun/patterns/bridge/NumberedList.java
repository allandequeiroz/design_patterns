package java4.fun.patterns.bridge;

/**
 * Classe de Implementação que prove um recurso adicional a ListBasica.
 * Que nesse caso seria a lista numerada.
 * 
 * 
 *
 */
class NumberedList extends BaseList{
    public String get(int index){
        return (index + 1) + ". " + super.get(index);
    }
}
