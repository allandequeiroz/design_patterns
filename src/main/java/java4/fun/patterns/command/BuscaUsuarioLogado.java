package java4.fun.patterns.command;

public class BuscaUsuarioLogado implements Command {
	public void execute() {
		System.out.println("Busquei os dados do usuario logado.");
	}
}
