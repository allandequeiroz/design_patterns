package java4.fun.patterns.facade;

public class XicaraDeCafe {
	public void addXicara(Xicara x){};
	public void addCafeDoBule(Cafe c){};
	public XicaraDeCafe getXicaraCafe(){
		return new XicaraDeCafe();
	};
	
	@Override
	public String toString() {
		return "Tome café Java!";
	} 
}
