package Zoo;

import GUI.AnimalSinPesoException;

/**
 * 
 * @author Antonio Luque Bravo
 *
 */
public interface Desplazable {
	void desplazarse() throws AnimalSinEnergiaException, AnimalSinPesoException;

}
