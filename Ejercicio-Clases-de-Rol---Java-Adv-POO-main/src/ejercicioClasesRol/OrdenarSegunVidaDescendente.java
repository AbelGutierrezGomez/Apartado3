package ejercicioClasesRol;

import java.util.Comparator;

public class OrdenarSegunVidaDescendente implements Comparator<Personaje> {

	//Código
	public int compare(Personaje o1, Personaje o2) {
		return Integer.compare(o2.getVidaActual(), o1.getVidaActual());
	}
}