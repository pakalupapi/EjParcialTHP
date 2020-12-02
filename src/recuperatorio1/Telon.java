package recuperatorio1;

public class Telon {
	private boolean abierto;
	
	public Telon() {
		this.setAbierto(false);
	}
	private void setAbierto(boolean b) {
		this.abierto = b;
	}
	public boolean subir() {
		boolean resul = false;
		if (!this.estaAbierto()) {
			this.setAbierto(true);
			resul = true;
		}
		return resul;
	}
	public boolean bajar() {
		boolean resul = false;
		if (this.estaAbierto()) {
			this.setAbierto(false);
			resul = true;
		}
		return resul;
	}
	public boolean estaAbierto() {
		return this.abierto;
	}
}
