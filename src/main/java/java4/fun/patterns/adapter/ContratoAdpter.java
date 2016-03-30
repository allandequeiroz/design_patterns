package java4.fun.patterns.adapter;

/**
 * Pattern Adapter, esse pattern prove uma forme de atender uma interface ou determinadas premissas sem
 * alterar um interface já existente(Pessoa) ou uma implementação já existente(PessoaImpl) assim com esse
 * adaptador podemos fazer isso de forma elegante sem alterar a classe ou a interface.
 * O Pattern adapter faz com que uma ou mais classes e/ou interfaces olhem para uma unica classe em particular. 
 * 
 * Devemos usar esse pattarn sempre que tivermos esses casos, para manter compatibilidade com API's 
 * ou na criação de componentes. 
 */
public class ContratoAdpter implements Contrato {

	Pessoa p;
	
	public ContratoAdpter() {
		p = new PessoaImpl(); 
	}
	
	public int getIdade() {
		return p.getIdadePessoa();
	}
	
	public String getNome() {		
		return p.getNomePessoa();
	}
	public String getTelefone() {
		return p.getTelefonePessoa();
	}
	
	public void setIdade(int idade) {
		p.setIdadePessoa(idade);
	}
	
	public void setNome(String nome) {
		p.setNomePessoa(nome);
	}
	
	public void setTelefone(String telefone) {
		p.setTelefonePessoa(telefone);
	}	
	
	public String toString() {
		return p.toString(); 
	}
	
}
