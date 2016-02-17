package java4.fun.patterns.chainofresponsability;

/**
 * Pattern Chain of Resposability que prove um controle do fluxo de execução para que objeto tem tal responsabilidade sobre
 * determinados processamentos. Poderiamos aplicar esse patterm por exemplo em um visualizador de Arquivos onde queremos
 * mostras desde fontes .JAVA a arquivos .PDF, com esse pattern temos uma arvore de responsabilidades onde cada item se 
 * responsabiliza para efetuar tais determinados processamentos.
 * 
 *
 */
public interface Chain {
	public Chain nextChain();
	public boolean isMyResponsability(String operateName);
	public double operate(double a,double b);
}
