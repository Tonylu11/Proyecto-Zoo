package Zoo;

import java.util.ArrayList;
import java.util.Calendar;

public class Zoologico {
	private ArrayList<Mamifero> mamiferos = new ArrayList<Mamifero>();
	private ArrayList<Ave> almacenAves = new ArrayList<Ave>();
	private ArrayList<Pez> almacenPeces = new ArrayList<Pez>();

	public boolean annadirMamifero(Alimentacion tipoAlimentacion,
			String codigo, int energia, double peso, Calendar fecha,
			EspeciesMamiferos especiesMamiferos, boolean hibernando)
			throws CodigoNoValidoException {
		Mamifero mamifero = Mamifero.instanciarMamifero(tipoAlimentacion,
				codigo, energia, peso, fecha, especiesMamiferos, hibernando);
		return mamiferos.add(mamifero);

	}

	public boolean annadirAve(Alimentacion tipoAlimentacion, String codigo,
			int energia, double peso, Calendar fecha,
			EspeciesAves especiesAves, boolean migrando)
			throws CodigoNoValidoException {
		Ave ave = Ave.instanciarAve(tipoAlimentacion, codigo, energia, peso,
				fecha, especiesAves, migrando);
		return almacenAves.add(ave);

	}

	public boolean annadirPez(Alimentacion tipoAlimentacion, String codigo,
			int energia, double peso, Calendar fecha,
			EspeciesPeces especiesPeces, boolean escamas)
			throws CodigoNoValidoException {
		Pez pez = Pez.instanciarPez(tipoAlimentacion, codigo, energia, peso,
				fecha, especiesPeces, escamas);
		return almacenPeces.add(pez);

	}
}
