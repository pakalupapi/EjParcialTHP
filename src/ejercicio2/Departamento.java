package ejercicio2;

public class Departamento {
	private int numeroUnidad;
	private String dniProp;
	private String nombreProp;
	private boolean voto;
	private boolean votoDeclarado;
	
	public Departamento(int numeroUnidad, String dni, String nombre) {
		this.numeroUnidad = numeroUnidad;
		this.dniProp = dni;
		this.nombreProp = nombre;
		setVoto();
		setVotoDeclarado();
	}
	private void setVoto() {
		this.voto = false;
	}
	public boolean isVoto() {
		return voto;
	}
	private void setVotoDeclarado() {
		this.votoDeclarado = false;
	}
	public int getNumeroUnidad() {
		return numeroUnidad;
	}
	public void votoPositivo() {
		this.voto = true;
		this.votoDeclarado = true;
	}
	public void votoNegativo() {
		this.votoDeclarado = true;
	}
	public boolean yaVoto() {
		return this.votoDeclarado;
	}
}
