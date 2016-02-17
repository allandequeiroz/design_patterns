package java4.fun.patterns.state;

/**
 * Pattern State. Esse pataren define como mudar o comportamento de
 * um Objeto via composição. Nesse caso apos o gerente vender duas cervejas
 * ele percebe que acabou seu estoque e assim ele muda o estado via composição assim: bar = new BarFechado();
 * Podemos usar esse pattern em interfaces graficas ou em momentos que necessitamos trocar o comportamento
 * de um objeto atravez de um estado, que é representado via composição. 
 *  
 * 
 * 
 *
 */
public class GerenteDoBar {

	private int tot = 0 ;
	Bar bar = new BarAberto();
	
	public Beer vender(){
		
		if (tot==2){
			changeState();
		}
		
		tot++;
		return bar.buyBeer();		
		
	}
	
	private void changeState(){
		bar = new BarFechado();
	}
	
}
