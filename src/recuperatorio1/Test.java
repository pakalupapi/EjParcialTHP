package recuperatorio1;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Tablero tablero = new Tablero(40);
		
		lucesDeColores(tablero);
	}
	private void lucesDeColores(Tablero tablero) {
		int count = 0;
		for (int i=1; i <= tablero.cantidadLuces()/3; i++) {
			tablero.agregarLampara(i, Sector.DERECHA, Color.AMARILLA);
			tablero.agregarLampara(i, Sector.DERECHA, Color.AZUL);
			tablero.agregarLampara(i, )
		}
	}
}
