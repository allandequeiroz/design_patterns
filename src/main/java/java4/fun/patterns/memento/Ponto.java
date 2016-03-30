package java4.fun.patterns.memento;

/**
 * Classe utilizará o pattern Memento
 * 
 *
 */
public class Ponto {
	
	private int x = 0;
	private int y = 0;
	
	public Ponto() {}
	public Ponto(int x,int y) {
		
		this.x = x;
		this.y = y;
		
		/* guarda o estado dos objetos */
		pm.setXPontoMemento(x);
		pm.setYPontoMemento(y);
		
	}	
	
	public void restore(){
		x = pm.getXPontoMemento();
		y = pm.getYPontoMemento();
	}
	
	// GETTERS AND SETTERS
	
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
	
	
	/**
	 * Padrão Memento, que prove mecanismos para fazer "redo e undo". Este pattern se foca em guardar o estado de um objeto.
	 * Pode ser utilizado em intefaces graficas e editor de texto por exemplo.
	 * Poderiamos ter um List e assim guradar multiplos estados.
	 *  
	 * 
	 *
	 */
	private class PontoMemento{		
		
		private int xPontoMemento = 0;
		private int yPontoMemento = 0;		
		
		public int getXPontoMemento() {
			return xPontoMemento;
		}
		public void setXPontoMemento(int pontoMemento) {
			xPontoMemento = pontoMemento;
		}

		public int getYPontoMemento() {
			return yPontoMemento;
		}
		public void setYPontoMemento(int pontoMemento) {
			yPontoMemento = pontoMemento;
		}

		public void undo(){
			x = xPontoMemento;
			y = yPontoMemento;
		}		
	}
	
	
	/* Variavel Holder do Memento */
	private PontoMemento pm = new PontoMemento();
	
}
