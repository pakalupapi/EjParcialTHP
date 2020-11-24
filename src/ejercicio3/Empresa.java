package ejercicio3;
import java.util.ArrayList;
public class Empresa {
	private String nombre;
	private ArrayList<Pedido> pedidos;
	
	public Empresa(String nombre) {
		this.setNombre(nombre);
		this.pedidos=new ArrayList<Pedido>();
	}
	private void setNombre(String nombre) {
		this.nombre = nombre;
	}
	@Override
	public String toString() {
		return "Empresa [nombre=" + nombre + ", pedidos=" + this.pedidos.size() + "]";
	}
	private Pedido buscarPedido(int numeroPedido) {
		int i = 0;
		Pedido pedidoEncontrado = null;
		Pedido pedido;
		while (i < this.pedidos.size() && pedidoEncontrado == null) {
			pedido = this.pedidos.get(i);;
			if (pedido.getNumeroPedido() == numeroPedido) {
				pedidoEncontrado = pedido;
			}
			i++;
		}
		return pedidoEncontrado;
	}
	public void cargarPedido(int numeroPedido, int codigoArticulo, int cantidad, double importe) {
		Pedido pedido = this.buscarPedido(numeroPedido);
		
		if (pedido == null) {
			this.agregarPedido(new Pedido(numeroPedido, codigoArticulo, cantidad, importe));
			System.out.println("Operacion exitosa");
		}
		else {
			System.out.println("Pedido ya registrado");
		}
	}
	private void agregarPedido(Pedido pedido) {
		this.pedidos.add(pedido);
	}
	public void pedidoMasAlto() {
		Pedido pedidoMasAlto = null;
		double importe;
		double mayorImporte = 0;
		
		for (Pedido p: this.pedidos) {
			importe = p.getImporte();
			if (importe > mayorImporte) {
				mayorImporte = importe;
				pedidoMasAlto = p;
			}
		}
		System.out.println(pedidoMasAlto);
	}
	public boolean entregar(int numeroPedido, int cantidadAEntregar) {
		boolean resul = false;
		Pedido pedido = this.buscarPedido(numeroPedido);
		int cantPendiente;
		
		if (pedido == null) {
			System.out.println("El pedido es inexistente");
		}
		else {
			cantPendiente = pedido.getCantPendiente();
			if (cantPendiente < cantidadAEntregar) {
				System.out.println("El pedido no tiene tanta cantidad pendiente");
			}
			else {
				if (cantPendiente > cantidadAEntregar) {
					pedido.entregar(cantidadAEntregar);
					resul = true;
					System.out.println("Entrega parcial");
					System.out.println("Quedan "+ pedido.getCantPendiente()+ " articulos por entregar.");
				}
				else {
					pedido.entregar(cantidadAEntregar);
					pedido.cambiarEstado(Estado.ENTREGADO);
					resul = true;
					System.out.println("Entrega total de articulos");
				}
			}
		}
		return resul;
	}
}
