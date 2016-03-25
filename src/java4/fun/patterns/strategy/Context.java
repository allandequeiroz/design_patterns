package java4.fun.patterns.strategy;

/**
 * Pattern Strategy, em um primeiro momento este pattern pode ser bem parecido com o State, mas não é.
 * Esse pattern se baseia em um conjunto de algoritimos (no exemplo: TXTStrategy,PDFStrategy,HTMLStrategy)
 * que estão 'aglutinados' na classe Context assim podemos manter um possibilidade de escolha de qual estrategia(algoritimo)
 * será adotada. Poderiamos usar esse pattern para determinar a maneira de mostrar um arquivo ou a maneira de salvar um
 * arquivo(como nesse exemplo), sempre que tivermos multiplos algoritimos e não queremos aglutinar todos em um bloco de if.
 * 
 * 
 *
 */
public class Context {
	
	private AbstractStrategy abstractStrategy;
	
	// cria o contexto com a estrategia default.
	
	public Context() {
		setDefaultStrategy();
	}
	private void setDefaultStrategy() {
		abstractStrategy = new TXTStrategy();
	}
	
	
	// METODOS QUE TROCAM A ESTRATEGIA.
	
	public void setSavePDF(){
		abstractStrategy = new PDFStrategy();
	}
	
	public void setSaveHTML(){
		abstractStrategy = new HTMLStrategy();
	}
	
	public void setSaveTXT(){
		abstractStrategy = new TXTStrategy();
	}
	
	
	// metodo que executa o save.
	public void save(Object resource){
		abstractStrategy.save(resource);
	}
	
}
