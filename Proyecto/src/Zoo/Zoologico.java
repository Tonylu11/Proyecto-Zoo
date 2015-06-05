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
	/**
	 * Campo que indica si el archivo est&aacute; modificado o no.
	 */
	public boolean modificado;
	/**
	 * Fecha de almacenamiento del animal en el Zoo.
	 */
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
		if (!yaExiste(animal)) {
			setModificado(true);
			return zoologico.add(animal);
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
		if (Mamifero.class == animal.getClass()) {
			setModificado(true);
			return zoologico.remove(new Mamifero(codigo));
		} else if (Ave.class == animal.getClass()) {
			setModificado(true);
			return zoologico.remove(new Ave(codigo));
		} else if (Pez.class == animal.getClass()) {
			setModificado(true);
			return zoologico.remove(new Pez(codigo));
		}
		throw new AnimalNoExisteException("El animal no existe.");

	}

	/**
	 * Boolean para ver si esta modificado el archivo.
	 * 
	 * @return true si est&aacute; modificado, false si no.
	 */
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
		if (zoologico.contains(animal))
			return true;
		else
			return false;
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

	/**
	 * Obtiene la fecha de almacenamiento del animal.
	 * 
	 * @return Fecha de almacenamiento del animal.
	 */
	public Calendar getFecha() {
		return fecha;
	}

	/**
	 * Devuelve el animal que est&aacute; en esa posici&oacute;n.
	 * 
	 * @param alias
	 *            Alias del animal.
	 * @return Devuelve el animal de esa posici&oacute;n.
	 * @throws CodigoNoValidoException
	 *             Cuando el c&oacute;digo no es correcto.
	 * @throws AnimalNoExisteException
	 *             Cuando el animal no existe.
	 */
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
