package java4.fun.patterns.chainofresponsability;

/**
 * Classe de teste e de exemplo de uso do pattern: Chain of Responsability
 * @author diegop
 *
 */
public class UsePattern {
	
	public static void main(String[] args) {
		
//		String operacao = "multiplicacao";
//		String operacao = "soma";
//		String operacao = "divisao";
		String operacao = "subtracao";
		
		double ret = 0;
		double paramA = 10;
		double paramB = 20;
		
		Chain chain = new Divisao();		
		boolean achei = false;
		
		try{
		
			while(!achei){
				
				if (chain.isMyResponsability(operacao)){
					ret = chain.operate(paramA, paramB);
					achei = true; 
				}else{
					chain = chain.nextChain();
				}				
				
			}
			
			System.out.println("Operação: " + operacao + " retorno: " + ret);
			
		}catch(OperacaoNaoSuportadaException onse){
			System.out.println("Operação não suportada!");
		}catch(Throwable t){
			t.printStackTrace();
		}
		
		
		
		
	}
	
}
