package ejercicioClasesRol;

public class Clerigo extends Personaje{

	//Atributos
	private String diosDevoto;
	
	//Constructor
	public Clerigo(String nombre, TRaza raza, int fuerza, int inteligencia, int vidaMaxima, String diosDevoto) throws PersonajeException {
		super(nombre, raza, fuerza, inteligencia, vidaMaxima);
		
		//Código
		if (this.getFuerza() < 18) {
			throw new PersonajeException("Error, fuerza insuficiente para un clérigo");
		}
		
		if (this.getInteligencia() < 12 || this.getInteligencia() > 16) {
			throw new PersonajeException("Error, inteligencia insuficiente o excesiva para un clérigo");
		}
		
		this.diosDevoto = diosDevoto; 
	}
	
	//toString
	public String toString() {
		return this.toString() + ", Dios Devoto = " + diosDevoto;
	}
		
	//Métodos Propios
	public void curar(Personaje personajeAfectado) throws PersonajeException {
		
		//Código
		personajeAfectado.setVidaActual(personajeAfectado.getVidaActual() + 10);
	}
}