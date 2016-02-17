package java4.fun.patterns.command;

/**
 * Classe de teste e exemplo de uso do pattern Command.
 * @author diegop
 *
 */
public class UsePattern {
	
	public static void main(String[] args) {
		
		/* Intancia todos os Commands(Fluxos de execução diferentes) */
		Command a = new BuscaUsuarioLogado();
		Command b = new DeletaItensObsoleotosNoEstoque();
		Command c = new InsereDadosNaBase();
		
		
		/* Escolhe ramdomicamente um fluxo de execução(Command) a ser executado */
		Command commandToExecute = new Command[]{a,b,c}[(int)(Math.random() * 2)]; 
		
		
		/* Executa de maneira igual independente do que vai ser executado.
		 * Assim podemos facilmete trocar o Action(o que vai ser executado) sem mexer na locia de execução.
		 *  */
		Action act = new Action();		
		act.onStoreData(commandToExecute);
		
	}
}
