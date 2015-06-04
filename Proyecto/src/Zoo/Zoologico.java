package Zoo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 * Clase envoltorio del Zoo.
 * 
 * @author Antonio Luque Bravo.
 *
 */
public class Zoologico implements Serializable {
	private ArrayList<Animal> zoologico = new ArrayList<Animal>();
	public static ArrayList<Animal> almacenMamiferos = new ArrayList<Animal>();
	public ArrayList<Animal> almacenAves = new ArrayList<Animal>();
	public ArrayList<Animal> almacenPeces = new ArrayList<Animal>();
	public boolean modificado;
	private Calendar fecha = new GregorianCalendar();
	Animal animal;

	/**
	 * A&ntilde;ade un animal al ArrayList.
	 * 
	 * @param animal
	 *            Animal.
	 * @return Adici&oacute;n del animal al Zoo.
	 * @throws AnimalYaExisteException
	 *             Cuando el animal ya existe en el Zoo.
	 */
	public boolean annadir(Animal animal) throws AnimalYaExisteException {
		if (yaExiste(animal) == true) {
			if (animal.tipo == 1) {
				setModificado(true);
				return almacenMamiferos.add((Mamifero) animal)
						&& zoologico.add(animal);
			} else if (animal.tipo == 2) {
				setModificado(true);
				return almacenAves.add((Ave) animal) && zoologico.add(animal);
			} else if (animal.tipo == 3) {
				setModificado(true);
				return almacenPeces.add((Pez) animal) && zoologico.add(animal);
			}
		}
		return false;
	}

	/**
	 * Elimina al animal del ArrayList zoologico.
	 * 
	 * @param animal
	 *            Animal.
	 * @param codigo
	 *            Alias del animal.
	 * @return Su eliminaci&oacute;n del Zoo.
	 * @throws CodigoNoValidoException
	 *             Cuando el alias no es correcto.
	 * @throws AnimalNoExisteException
	 *             Cuando el animal que intentamos eliminar no existe en nuestro
	 *             Zoo.
	 * 
	 */
	public boolean eliminar(Animal animal, String codigo)
			throws CodigoNoValidoException, AnimalNoExisteException {
		if (animal.tipo == 1) {
			setModificado(true);
			return almacenMamiferos.remove(new Mamifero(codigo))
					&& zoologico.remove(new Mamifero(codigo));
		} else if (animal.tipo == 2) {
			setModificado(true);
			return almacenAves.remove(new Ave(codigo))
					&& zoologico.remove(new Ave(codigo));
		} else if (animal.tipo == 3) {
			setModificado(true);
			return almacenPeces.remove(new Pez(codigo))
					&& zoologico.remove(new Pez(codigo));
		}
		throw new AnimalNoExisteException("El animal no existe.");

	}

	public boolean isModificado() {
		return modificado;
	}

	public void setModificado(boolean modificado) {
		this.modificado = modificado;
	}

	/**
	 * Comprueba si ya existe el animal en el Zoo.
	 * 
	 * @param animal
	 *            Animal.
	 * @return Devuelve true o false dependiendo si existiese o no.
	 * @throws AnimalYaExisteException
	 *             Si ya existe el animal en el Zoo.
	 */
	public boolean yaExiste(Animal animal) throws AnimalYaExisteException {
		if (zoologico.contains(animal) || almacenMamiferos.contains(animal)
				|| almacenAves.contains(animal)
				|| almacenPeces.contains(animal))
			throw new AnimalYaExisteException("");
		else
			return true;
	}

	/**
	 * Tama&ntilde;o del ArrayList zoologico.
	 * 
	 * @return Tama&ntilde;o del ArrayList zoologico.
	 */
	public int size() {
		return zoologico.size();
	}

	/**
	 * &Iacute;ndice del ArrayList.
	 * 
	 * @param index
	 *            &Iacute;ndice del ArrayList.
	 * @return Devuelve el &iacute;ndice.
	 */
	public Animal get(int index) {
		if (zoologico.isEmpty() | index < 0 | index > zoologico.size() - 1)
			return null;
		return zoologico.get(index);

	}

	public Calendar getFecha() {
		return fecha;
	}

	public Animal get(String alias) throws CodigoNoValidoException,
			AnimalNoExisteException {
		Animal animal = new Animal(alias);
		int index = zoologico.indexOf(animal);
		if (index != -1) {
			return zoologico.get(index);
		}
		throw new AnimalNoExisteException();
	}

}
