package recuperatorio1;
import java.util.ArrayList;
public class Tablero {
	private final int CANT_MINIMA_LUCES = 3;
	private final int CANT_MAXIMA_LUCES = 2;
	private Telon telon;
	private int cantMaxLuces;
	private ArrayList<Lampara> luces;
	private ArrayList<HistoricoLuz> historicoLuces;
	private int countHistorico;
	
	public Tablero(int cantLuces) {
		this.setTelon();
		this.setCantLuces(cantLuces);
		this.luces=new ArrayList<Lampara>();
		this.historicoLuces=new ArrayList<HistoricoLuz>();
		this.countHistorico = 0;
	}
	private void setTelon() {
		this.telon = new Telon();
	}
	private Telon getTelon() {
		return this.telon;
	}
	private void setCantLuces(int cant) {
		if (cant < CANT_MINIMA_LUCES) {
			this.cantMaxLuces = CANT_MINIMA_LUCES;
		}
		else if (cant > CANT_MAXIMA_LUCES) {
			this.cantMaxLuces = CANT_MAXIMA_LUCES;
		}
		else {
			this.cantMaxLuces = cant;
		}
	}
	public boolean agregarLampara(int numeroId, Sector sector, Color color) {
		boolean resul = false;
		Lampara lampara = this.buscarLampara(numeroId);
		
		if (lampara == null) {
			this.activarLampara(new Lampara (numeroId, sector, color));
			resul = true;
		}
		return resul;
	}
	private Lampara buscarLampara(int numeroId) {
		int i = 0;
		Lampara lampara;
		Lampara lamparaEncontrada = null;
		
		while (i < this.luces.size() && lamparaEncontrada == null) {
			lampara = this.luces.get(i);
			if (lampara.getId() == numeroId) {
				lamparaEncontrada = lampara;
			}
			i++;
		}
		return lamparaEncontrada;
	}
	private void activarLampara(Lampara lampara) {
		this.luces.add(lampara);
	}
	public boolean subirTelon() {
		boolean resul = false;
		Telon telon = this.getTelon();
		if (!telon.estaAbierto()) {
			this.telon.subir();
			resul = true;
		}
		return resul;
	}
	public boolean prenderLuz(int numeroId) {
		Lampara lampara = this.buscarLampara(numeroId);
		boolean resul = false;
		if (lampara != null) {
			resul = lampara.prender();
			if (resul) {
				this.addHistorico(Accion.PRENDER, lampara);
			}
		}
		return resul;
	}
	private void addHistorico(Accion accion, Lampara lampara) {
		this.historicoLuces.add(new HistoricoLuz(this.countHistorico, accion, lampara));
		this.countHistorico += 1;
	}
	public int prenderLuces(Sector sector) {
		int cantPrendidas = 0;
		for (Lampara l: this.luces) {
			if (l.getSector() == sector) {
				if (l.prender()) {
					cantPrendidas += 1;
				}
			}
		}
		return cantPrendidas;
	}
	public void mostrarOperatividad() {
		System.out.println("Total de luces posibles: "+ this.cantMaxLuces);
		System.out.println("Porcentaje de luces colocadas: "+ (this.luces.size() * 100) / this.cantMaxLuces);
	}
	public void mostrarHistorico() {
		for (HistoricoLuz h: this.historicoLuces) {
			System.out.println(h);
		}
	}
	public int cantidadLuces() {
		return this.luces.size();
	}
	public int cambiarColor(Color actual, Color deseado) {
		int lucesCambiadas = 0;
		for (Lampara l: this.luces) {
			if (l.getColor() == actual) {
				l.setColor(deseado);
				lucesCambiadas += 1;
			}
		}
		return lucesCambiadas;
	}
	public void apagarYCerrar() {
		for (Lampara l: this.luces) {
			l.apagar();
		}
		this.telon.bajar();
	}
}
