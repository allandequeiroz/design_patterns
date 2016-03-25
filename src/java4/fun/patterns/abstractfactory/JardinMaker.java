package java4.fun.patterns.abstractfactory;

/**
 * Pattern Abstract Factory, é muito semelhante ao pattern factory.
 * Porem ele prove uma fabrica de fabricas. Poderiamos usar esse pattern para abtrair a 
 * persistencia de um sistema( hibernate, jdbc, arquivo) ou o look-and-feel de uma aplicação.
 */
public class JardinMaker {

	public static final String JARDIN_PEQUENO = "pequeno";
	public static final String JARDIN_MEDIO   = "medio";
	public static final String JARDIN_GRANDE  = "grande";
	
	private static Jardin jardin = null;
	
	public static Jardin getJardin(String tipo){
	
		if (tipo.equals(JARDIN_PEQUENO)){
			jardin = new JardinVirgen(); 
		}
		
		if (tipo.equals(JARDIN_MEDIO)){
			jardin = new JardinSuspenso(); 
		}
		
		if (tipo.equals(JARDIN_GRANDE)){
			jardin = new JardinPuroMato(); 
		}
		
		return jardin;
		
	}
	
}
