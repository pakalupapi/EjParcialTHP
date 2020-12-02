package recuperatorio1;

public class Lampara {
	private int numeroId;
	private boolean estaEncendida;
	private Sector sector;
	private Color color;
	private int contador;
	
	public Lampara(int numeroId, Sector sector, Color color) {
		this.setNumeroId(numeroId);
		this.setEncendido(false);
		this.setSector(sector);
		this.setColor(color);
		this.contador = 0;
	}
	private void setNumeroId(int num) {
		this.numeroId = num;
	}
	protected int getId() {
		return numeroId;
	}
	private void setEncendido(boolean b) {
		this.estaEncendida = b;
	}
	protected boolean estaPrendida() {
		return estaEncendida;
	}
	public boolean prender() {
		boolean resul = false;
		if (this.contador == 0) {
			this.setEncendido(true);
			resul = true;
		}
		else {
			if (!this.estaPrendida()) {
				this.setEncendido(true);
			}
		}
		this.contador++;
		return resul;
	}
	public void apagar() {
		this.setEncendido(false);
	}
	private void setSector(Sector sector) {
		this.sector = sector;
	}
	protected Sector getSector(){
		return sector;
	}
	protected void setColor(Color color) {
		this.color = color;
	}
	protected Color getColor() {
		return color;
	}
}
