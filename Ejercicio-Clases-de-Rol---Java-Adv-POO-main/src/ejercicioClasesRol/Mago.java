package ejercicioClasesRol;

import java.util.ArrayList;

public class Mago extends Personaje{

	private static final int MINIMO_INTELIGENCIA_MAGO = 17;
	private static final int MAXIMO_FUERZA_MAGO = 15;
	private static final int DANNO_POR_HECHIZO = 10;
	private static final int TAMANNO_LIBRO_HECHIZOS = 4;
	
	//Atributos
	private ArrayList<String> libroDeHechizos;
	
	//Constructor
	public Mago(String nombre, TRaza raza, int fuerza, int inteligencia, int vidaMaxima) throws PersonajeException {
		super(nombre, raza, fuerza, inteligencia, vidaMaxima);
		
		//Código
		if (this.getFuerza() > MAXIMO_FUERZA_MAGO) {
			throw new PersonajeException("Error, límite de fuerza superado para un mago");
		}
		
		if (this.getInteligencia() < MINIMO_INTELIGENCIA_MAGO) {
			throw new PersonajeException("Error, inteligencia insuficiente para un mago");
		}
		
		libroDeHechizos = new ArrayList<String>();
	}
	
	//toString
	public String toString() {
		return this.toString() + ", libro de hechizos = " + libroDeHechizos;
	}
	
	//Métodos Propios
	public void aprendeHechizo(String hechizo) throws PersonajeException {
		
		//Código
		if (libroDeHechizos.size() == TAMANNO_LIBRO_HECHIZOS) {
			throw new PersonajeException("Error, espacio insuficiente");
		}
		
		if (libroDeHechizos.contains(hechizo)) {
			throw new PersonajeException("Error, este hechizo ya está añadido");
		}
		
		libroDeHechizos.add(hechizo);
	}
	
	public void lanzaHechizo(Personaje personajeReceptor, String hechizo) throws PersonajeException {
		
		//Código
		personajeReceptor.setVidaActual(personajeReceptor.getVidaActual() - DANNO_POR_HECHIZO);
		
		libroDeHechizos.remove(hechizo);
	}
}