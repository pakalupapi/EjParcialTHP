package ejercicio2;
import java.util.ArrayList;
public class Edificio {
	private String direccion;
	private int cantDepartamentos;
	private ArrayList<Departamento> departamentos;
	
	public Edificio(String direccion, int cantDepartamentos) {
		setDireccion(direccion);
		setCantDepartamentos(cantDepartamentos);
		this.departamentos=new ArrayList<Departamento>();
	}
	private void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	private void setCantDepartamentos(int deptos) {
		this.cantDepartamentos = deptos;
	}
	@Override
	public String toString() {
		return "Edificio [direccion=" + direccion + ", cantDepartamentos=" + cantDepartamentos + ", departamentosOcupados="
				+ this.departamentos.size() + "]";
	}
	public void agregarUnidad(int numeroUnidad, String dni, String nombre) {
		Departamento unidad;
		
		if (this.departamentos.size() == cantDepartamentos) {
			System.out.println("El numero de unidad excede el numero de departamentos total");
		}
		else {
			unidad = buscarDepartamentoPorUnidad(numeroUnidad);
			if (unidad != null) {
				System.out.println("Esta unidad ya ha sido registrada");
			}
			else {
				unidad = new Departamento(numeroUnidad, dni, nombre);
				this.departamentos.add(unidad);
				System.out.println("Operacion realizada con exito");
			}
		}
	}
	private Departamento buscarDepartamentoPorUnidad(int numeroUnidad) {
		int i = 0;
		Departamento departamento = null;
		Departamento departamentoEncontrado;
		while (i < this.departamentos.size() && departamento == null) {
			departamentoEncontrado = this.departamentos.get(i);
			if (departamentoEncontrado.getNumeroUnidad() == numeroUnidad) {
				departamento = departamentoEncontrado;
			}
			i++;
		}
		return departamento;
	}
	public void actualizarVoto(int numeroUnidad, boolean voto) {
		Departamento unidad = this.buscarDepartamentoPorUnidad(numeroUnidad);
		if (unidad == null) {
			System.out.println("Departamento no registrado");
		}
		else {
			if (unidad.yaVoto()) {
				System.out.println("Esta unidad registro voto previamente");
			}
			else {
				if (voto) {
					unidad.votoPositivo();
				}
				else{
					unidad.votoNegativo();
				}
				System.out.println("Operacion realizada con exito");
			}
		}
	}
	public void listarVotosPositivos() {
		for (Departamento departamento: this.departamentos) {
			if (departamento.isVoto()) {
				System.out.println("Unidad "+ departamento.getNumeroUnidad()+ " voto positivo.");
			}
		}
	}
	public double calcularPorcentaje() {
		double votos = 0;
		for (Departamento departamento: this.departamentos) {
			if (departamento.yaVoto()){
				votos += 1;
			}
		}
		return (votos * 100) / this.cantDepartamentos;
	}
}