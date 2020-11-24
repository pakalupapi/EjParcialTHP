package ejercicio4;

public class Socio {
	private String dni;
	private String nombre;
	private double deuda;
	private TipoCategoria categoria;
	private String estado;
	
	public Socio(String dni, String nombre, TipoCategoria categoria, double deuda) {
		setDni(dni);
		setNombre(nombre);
		setDeuda(deuda);
		setCategoria(categoria);
		setEstado("N");
	}
	private void setDni(String dni) {
		this.dni = dni;
	}
	public String getDni() {
		return dni;
	}
	private void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getNombre() {
		return nombre;
	}
	private void setDeuda(double deuda) {
		this.deuda = deuda;
	}
	public double getDeuda() {
		return deuda;
	}
	private void setCategoria(TipoCategoria categoria) {
		this.categoria = categoria;
	}
	public TipoCategoria getCategoria() {
		return categoria;
	}
	private void setEstado(String estado) {
		this.estado = estado;
	}
	public boolean tieneDeuda() {
		return this.getDeuda() > 0;
	}
	public void cambiarEstado(String estado) {
		this.setEstado(estado);
	}
}
