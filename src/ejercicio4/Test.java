package ejercicio4;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Gimnasio noHayForma=new Gimnasio("No hay forma");
		
		noHayForma.inscribirSocio("12345", "Osvaldo", TipoCategoria.CATEG_1, 0);
		noHayForma.inscribirSocio("12345", "Osvaldo", TipoCategoria.CATEG_1, 0);
		noHayForma.inscribirSocio("22334", "Matias", TipoCategoria.CATEG_2, 10000);
		noHayForma.inscribirSocio("44556", "Gabriel", TipoCategoria.CATEG_3, 200);
		noHayForma.inscribirSocio("66778", "Agustin", TipoCategoria.CATEG_1, 0);
		System.out.println(noHayForma);	
		noHayForma.ponerMoroso("12345");
		noHayForma.ponerMoroso("22334");
		noHayForma.listarDeudoresCategoria(10, TipoCategoria.CATEG_3);
		noHayForma.listarDeudoresCategoria(10, TipoCategoria.CATEG_2);
		
	}

}
