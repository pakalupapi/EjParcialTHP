package recuperatorio1;

public class HistoricoLuz {
	private int numero;
	private boolean prendido;
	private Accion accion;
	private Lampara lampara;
	private Color colorLuz;
	private Sector sectorLuz;
	//no bastaria con tener una lampara?
	
	public HistoricoLuz(int numero, Accion accion, Lampara lampara) {
		this.setNumero(numero);
		this.setAccion(accion);
		this.setLampara(lampara);
		this.setCambios(lampara);
	}
	private void setNumero(int numero) {
		this.numero = numero;
	}
	private void setAccion(Accion accion) {
		this.accion = accion;
	}
	private void setLampara(Lampara lampara) {
		this.lampara = lampara;
	}
	private void setCambios(Lampara lampara) {
		this.colorLuz = lampara.getColor();
		this.sectorLuz = lampara.getSector();
		this.prendido = lampara.estaPrendida();
	}
	@Override
	public String toString() {
		return "HistoricoLuz [numero=" + numero + ", prendido=" + prendido + ", accion=" + accion + ", lampara="
				+ lampara + ", colorLuz=" + colorLuz + ", sectorLuz=" + sectorLuz + "]";
	}
	
}
