package ejercicio3;

public class Pedido {
	private int numeroPedido;
	private int codigoArticulo;
	private int cantPedida;
	private double importePedido;
	private int cantPendienteEntrega;
	private Estado estado;
	
	public Pedido(int numeroPedido, int codigoArticulo, int cantPedida, double importePedido) {
		setNumeroPedido(numeroPedido);
		setCodigoArticulo(codigoArticulo);
		setCantPedida(cantPedida);
		setImportePedido(importePedido);
		setCantPendienteEntrega(cantPedida);
		setEstado(Estado.PENDIENTE);
	}
	private void setNumeroPedido(int numeroPedido) {
		this.numeroPedido = numeroPedido;
	}
	public int getNumeroPedido() {
		return numeroPedido;
	}
	private void setCodigoArticulo(int codigoArticulo) {
		this.codigoArticulo = codigoArticulo;
	}
	private void setCantPedida(int cantPedida) {
		this.cantPedida = cantPedida;
	}
	private void setImportePedido(double importePedido) {
		this.importePedido = importePedido;
	}
	public double getImporte() {
		return importePedido;
	}
	private void setCantPendienteEntrega(int cantPendienteEntrega) {
		this.cantPendienteEntrega = cantPendienteEntrega;
	}
	public int getCantPendiente() {
		return cantPendienteEntrega;
	}
	private void setEstado(Estado estado) {
		this.estado = estado;
	}
	@Override
	public String toString() {
		return "Pedido [numeroPedido=" + numeroPedido + ", codigoArticulo=" + codigoArticulo + ", cantPedida="
				+ cantPedida + ", importePedido=" + importePedido + ", cantPendienteEntrega=" + cantPendienteEntrega
				+ ", estado=" + estado + "]";
	}
	public void entregar(int cant) {
		this.setCantPendienteEntrega(this.getCantPendiente() - cant);
	}
	public void cambiarEstado(Estado estado) {
		this.setEstado(estado);
	}
}
