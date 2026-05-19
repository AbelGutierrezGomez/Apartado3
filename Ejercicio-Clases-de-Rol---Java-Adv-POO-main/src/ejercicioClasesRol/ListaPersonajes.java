package ejercicioClasesRol;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;

public class ListaPersonajes {

	//Atributos
	private HashSet<Personaje>  listaPersonajes;

	//Constructor
	public ListaPersonajes() {
		this.listaPersonajes = new HashSet<Personaje>();
	}
	
	/**
	 * Se encarga de annadir en el HashSet el personaje pasado por parametro
	 * @param personajeAnnadir Objeto personaje que se va annadir
	 * @throws PersonajeException Al comprobar que el personaje ya existe 
	 */
	public void annadirPersonaje (Personaje personajeAnnadir) throws PersonajeException{
		
		if (!listaPersonajes.add(personajeAnnadir)) {
			throw new PersonajeException("Error, este personaje ya se ha añadido");
		}
	}

	/**
	 * Se encarga de añadir el hechizo al objeto personaje
	 * @param nombreMago String nombre del mago que aprende el hechizo
	 * @param nombreHechizo String nombre del hechizo que va a aprender el mago
	 * @throws PersonajeException 
	 */
	public void aprenderHechizoMago(String nombreMago, String nombreHechizo) throws PersonajeException{
				
		//Variables
		Personaje personajeEncontrado = encontrarPersonaje(nombreMago);
		
		//Código
		if (personajeEncontrado == null) {
			throw new PersonajeException("Error, el personaje es nulo");
		}
		
		if (nombreHechizo == null) {
			throw new PersonajeException("Error, el nombre del hechizo es nulo");
		}
		
		if ((personajeEncontrado instanceof Mago) == false) {
			throw new PersonajeException("Error, el personaje no es un mago");
		}
		
		((Mago) personajeEncontrado).aprendeHechizo(nombreHechizo);
	}

	/**
	 * Se encarga de buscar el nombre del mago, su hechizo y nombre del personaje
	 * @param nombreMagoAtaca String nombre del mago que ataca
	 * @param nombrePersonajeDefiende String nombre del personaje que es atacado
	 * @param nombreHechizo String del hechizo del mago que ataca
	 * @throws PersonajeException
	 */
	public void lanzarHechizoPersonaje (String nombreMagoAtaca, String nombrePersonajeDefiende, String nombreHechizo) throws PersonajeException{
		
		//Variables
		Personaje magoAtacante = encontrarPersonaje(nombreMagoAtaca);
		Personaje personajeDefensor = encontrarPersonaje(nombrePersonajeDefiende);
		
		//Código
		if (magoAtacante == null) {
			throw new PersonajeException("Error, el personaje " + nombreMagoAtaca + "atacante es nulo");
		}
		
		if (personajeDefensor == null) {
			throw new PersonajeException("Error, el personaje " + nombrePersonajeDefiende + " es nulo");
		}
		
		if (nombreHechizo == null) {
			throw new PersonajeException("Error, el hechizo es nulo");
		}
		
		if ((magoAtacante instanceof Mago) == false) {
			throw new PersonajeException("Error, el atacante no es un mago, por lo que no lanzará el hechizo " + nombreHechizo);
		}
		
		((Mago) magoAtacante).lanzaHechizo(personajeDefensor, nombreHechizo);
	}
	
	/**
	 * Se encarga de buscar un clerigo y buscar un personaje, y el clerigo cura al personaje.
	 * @param nombreClerigo String que contiene el nombre del clerigo que va a curar
	 * @param nombrePersonaje String que contiene el nombre del personaje que se va a curar
	 * @throws PersonajeException 
	 * 
	 */
	public void curarPersonaje (String nombreClerigo, String nombrePersonaje) throws PersonajeException{
		
		//Variables
		Personaje clerigo = encontrarPersonaje(nombreClerigo);
		Personaje personajeAfectado = encontrarPersonaje(nombrePersonaje);
		
		//Código
		if (clerigo == null) {
			throw new PersonajeException("Error, el personaje " + nombreClerigo + "atacante es nulo");
		}
		
		if (personajeAfectado == null) {
			throw new PersonajeException("Error, el personaje " + nombrePersonaje + " es nulo");
		}
		
		if ((clerigo instanceof Clerigo) == false) {
			throw new PersonajeException("Error, el personaje no es un clérigo, por lo que no curará");
		}
		
		((Clerigo) clerigo).curar(personajeAfectado);
	}
	
	/**
	 * Almacena en un String todos los personajes almacenados
	 * @return String de todos los personajes creados
	 */
	public String toString (){
		
		//Variables
		StringBuilder sb = new StringBuilder();
		
		//Código
		for (Personaje personaje : listaPersonajes) {
			sb.append(personaje.getNombre());
			sb.append("\n");
		}
		
		return sb.toString();
	}
	
	/**
	 * Ordena  por el numero de vida actual
	 *  de mayor a menor y luego lo muesta en forma de String
	 * @return 
	 */
	public String mostrarListadoPuntosActuales (){
	
		//Variables
		StringBuilder sb = new StringBuilder();
		ArrayList<Personaje> listaPersonajeOrdenadosSegunVida;
		
		//Código
		listaPersonajeOrdenadosSegunVida = new ArrayList<Personaje>(listaPersonajes);
		Collections.sort(listaPersonajeOrdenadosSegunVida, new OrdenarSegunVidaDescendente());
		
		for (Personaje personaje : listaPersonajeOrdenadosSegunVida) {
			sb.append(personaje);
			sb.append("\n");
		}
		
		return sb.toString();
	}
	
	/**
	 * Busca un personaje por su nombre
	 * @param nombre String nombre del personaje a buscar
	 * @return null si no encuentra el personaje, y el personaje encontrado si se encuentra
	 *
	 */
	private Personaje encontrarPersonaje(String nombre)  {
		
		//Variables
		Personaje personajeEncontrado = null;
		boolean encontrado = false;
		
		//Código
		Iterator<Personaje> it = listaPersonajes.iterator();
		
		while(it.hasNext() && !encontrado) {
			Personaje personaje = it.next();
			
			if (personaje.getNombre().equalsIgnoreCase(nombre)) {
				personajeEncontrado = personaje;
				encontrado = true;
			}
		}
		
		return personajeEncontrado;
	}
}