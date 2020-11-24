package ejercicio3;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Empresa empresa=new Empresa("DHL");
		
		empresa.cargarPedido(1, 25, 5, 5000);
		empresa.cargarPedido(2, 30, 5, 10000);
		empresa.cargarPedido(1, 25, 5, 5000);
		empresa.cargarPedido(3, 25, 5, 5000);
		empresa.cargarPedido(4, 25, 5, 5000);
		System.out.println(empresa);
		empresa.entregar(1, 5);
		empresa.entregar(2, 6);
		empresa.entregar(3, 3);
		System.out.println(empresa);
		empresa.pedidoMasAlto();
	}

}
