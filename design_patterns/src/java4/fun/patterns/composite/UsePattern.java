package java4.fun.patterns.composite;

/**
 * Classe de teste e exemplo de uso do pattern Composite.
 * 
 * 
 * 
 */
public class UsePattern {

	public static void main(String[] args) {

		Empregado marketVP; 
		Empregado salesMgr;
		Empregado advMgr;
		Empregado prodVP;
		Empregado prodMgr;
		Empregado shipMgr;
		
		Empregavel boss = new Empregado("Chefe","CEO", 200000D);
		
		boss.addSubordinado(marketVP = new Empregado("João","Marketing VP", 100000D));
		boss.addSubordinado(prodVP = new Empregado("May","Production VP", 100000D));
		
		marketVP.addSubordinado(salesMgr = new Empregado("Locke","Sales Mgr", 50000D));
		marketVP.addSubordinado(advMgr = new Empregado("Sayd","Advt Mgr", 50000D));
		
		
		// Adiciona vendedores ao vendedor chefe.
		for (int i = 0; i < 5; i++){
			salesMgr.addSubordinado(new Empregado("X" + i,"Sales " + new Integer(i).toString(),
					30000.0F + (float) (Math.random() - 0.5) * 10000D));
		}
		
		advMgr.addSubordinado(new Empregado("jeca","Secy", 20000D));
		prodVP.addSubordinado(prodMgr = new Empregado("Hurley","Prod Mgr", 40000D));
		prodVP.addSubordinado(shipMgr = new Empregado("Ana L.","Ship Mgr", 35000D));
		

		// adiciona funcuionarios de manufaturação.
		for (int i = 0; i < 4; i++){
			prodMgr.addSubordinado(new Empregado("JJ" + i,"Manuf " + new Integer(i).toString(),
					25000.0F + (float) (Math.random() - 0.5) * 5000D));
		}
		
		// adiciona balconistas ao chefe dos balconistas
		for (int i = 0; i < 3; i++){
			shipMgr.addSubordinado(new Empregado("CL" + i,"ShipClrk " + new Integer(i).toString(),
					20000.0F + (float) (Math.random() - 0.5) * 5000D));
		}
		
		System.out.println(boss.getSubordinados());

	}

}
