package Zoo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;

public class Zoologico implements Serializable {
	private ArrayList<Animal> zoologico = new ArrayList<Animal>();
	public boolean modificado;
	Animal animal;

	public boolean annadir(Animal animal, String codigo) {
		// throws AnimalYaExisteException {
		// if (yaExiste(codigo))
		// throw new AnimalYaExisteException("");
		setModificado(true);
		return zoologico.add(animal);
	}

	public boolean isModificado() {
		return modificado;
	}

	public void setModificado(boolean modificado) {
		this.modificado = modificado;
	}

	// public boolean yaExiste(String codigo) {
	// for (Animal animalAux : zoologico) {
	// if (animal.getCodigo().equals(codigo)) {
	// animal = animalAux;
	// }
	// }
	// if (zoologico.contains(animal))
	// return true;
	//
	// return false;
	// }

	public int size() {
		return zoologico.size();
	}

	public Animal get(int index) {
		if (zoologico.isEmpty() | index < 0 | index > zoologico.size() - 1)
			return null;
		return zoologico.get(index);

	}

}
