/**
 * 
 */
package Zoo;

/**
 * Interfaz Energizable para dar de comer a un animal.
 * 
 * @author Antonio Luque Bravo
 *
 */
public interface Energizable {
	void comer() throws AnimalSinEnergiaException, AnimalSinPesoException,
			EnergiaInvalidaException, PesoInvalidoException;

}
