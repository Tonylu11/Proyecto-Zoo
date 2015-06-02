/**
 * 
 */
package Zoo;

import GUI.AnimalSinPesoException;

/**
 * @author Antonio Luque Bravo
 *
 */
public interface Energizable {
	void comer() throws AnimalSinEnergiaException, AnimalSinPesoException;

}
