package Zoo;

/**
 * Interfaz Desplazable para desplazar a un animal.
 * 
 * @author Antonio Luque Bravo
 *
 */
public interface Desplazable {
	void desplazarse() throws AnimalSinEnergiaException,
			AnimalSinPesoException, EnergiaInvalidaException,
			PesoInvalidoException;

}
