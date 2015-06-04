package Zoo;

/**
 * Excepci&oacute;n para cuando un animal se intente crear sin energ&iacute;a.
 * 
 * @author Antonio Luque Bravo
 *
 */
public class AnimalSinEnergiaException extends Exception {

	public AnimalSinEnergiaException() {
		// TODO Auto-generated constructor stub
	}

	public AnimalSinEnergiaException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	public AnimalSinEnergiaException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}

	public AnimalSinEnergiaException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	public AnimalSinEnergiaException(String message, Throwable cause,
			boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}

}
