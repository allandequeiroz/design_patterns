package java4.fun.patterns.facade;

public class XicaraDeCafeFacadeImplementada  implements XicaraDeCafeFacade{

	public XicaraDeCafe xicaraDeCafe() {	
		
		Agua agua = new Agua();
		Bule bule = new Bule();
		Cafe cafe = new Cafe();
		Xicara xicara = new Xicara();
		XicaraDeCafe xdc = new XicaraDeCafe();
		
		bule.addAgua(agua);
		bule.addCafe(cafe);
		bule.ferver();
		
		xdc.addCafeDoBule(cafe);
		xdc.addXicara(xicara);
		return xdc.getXicaraCafe();		
	}
	
}
