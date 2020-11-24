package ejercicio4;
import java.util.ArrayList;
public class Gimnasio {
	private String nombre;
	private int cantSocios;
	private ArrayList<Socio> socios;
	
	public Gimnasio(String nombre) {
		this.setNombre(nombre);
		this.socios =new ArrayList<Socio>();
		this.setCantSocios();
	}
	private void setNombre(String nombre) {
		this.nombre = nombre;
	}
	private void setCantSocios() {
		this.cantSocios = this.socios.size();
	}
	@Override
	public String toString() {
		return "Gimnasio [nombre=" + nombre + ", cantSocios=" + cantSocios + "]";
	}
	public void inscribirSocio(String dni, String nombre, TipoCategoria categoria, double deuda) {
		Socio socio = this.buscarSocio(dni);
		
		if (socio == null) {
			this.socios.add(new Socio(dni, nombre, categoria, deuda));
			this.setCantSocios();
			System.out.println("Socio agregado con exito");
		}
		else {
			System.out.println("Socio ya existe");
		}
	}
	private Socio buscarSocio(String dni) {
		int i = 0;
		Socio socio;
		Socio socioBuscado = null;
		
		while (i < this.socios.size() && socioBuscado == null) {
			socio = this.socios.get(i);
			if (socio.getDni().equals(dni)) {
				socioBuscado = socio;
			}
			i++;
		}
		return socioBuscado;
	}
	public void quitarSocio(String dni) {
		Socio socio = buscarSocio(dni);
		
		if (socio == null) {
			System.out.println("Socio no registrado");
		}
		else {
			if (socio.getDeuda() > 0) {
				System.out.println("No puede borrarlo");
			}
			else {
				this.removerSocio(socio);
				this.setCantSocios();
				System.out.println("Socio dado de baja exitosamente");
			}
		}
	}
	private void removerSocio(Socio socio) {
		this.socios.remove(socio);
	}
	public void listarDeudoresCategoria(double deuda, TipoCategoria categoria) {
		for (Socio s: this.socios) {
			if (s.getDeuda() >= deuda && s.getCategoria() == categoria) {
				System.out.println(s.getNombre()+ " categoria "+ s.getCategoria()+ " debe $"+ s.getDeuda());
			}
		}
	}
	public void ponerMoroso(String dni) {
		Socio socio = buscarSocio(dni);
		if (socio != null && socio.tieneDeuda()) {
			socio.cambiarEstado("M");
			System.out.println("Operacion exitosa");
		}
		else {
			System.out.println("Operacion no pudo ser realizada");
		}
	}
}
