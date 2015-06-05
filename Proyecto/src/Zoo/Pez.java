package Zoo;

import java.io.Serializable;
import java.util.Calendar;
import java.util.regex.Pattern;

/**
 * Clase Hija Pez.
 * 
 * @author Antonio Luque Bravo
 *
 */
public class Pez extends Animal implements Desplazable, Energizable,
		Serializable {
	/**
	 * Especies de Peces.
	 */
	private EspeciesPeces especiesPeces;
	/**
	 * Boolean para saber si el pez posee escamas o no.
	 */
	private boolean escamas;
	/**
	 * Alias del pez.
	 */
	static final private Pattern aliasPez = Pattern
			.compile("^PEZ-[A-Za-z¡…Õ”⁄Ò]{5}-[0-9]{2}");

	/**
	 * Constructor de Pez.
	 * 
	 * @param tipoAlimentacion
	 *            Alimentaci&oacute;n de Pez.
	 * @param codigo
	 *            Alias del Pez.
	 * @param energia
	 *            Energ&iacute; del Pez.
	 * @param peso
	 *            Peso del Pez.
	 * @param fecha
	 *            Fecha de almacenamiento del Pez.
	 * @param especiesPeces
	 *            Especies de Peces.
	 * @param escamas
	 *            boolean si posee escamas o no.
	 * @throws CodigoNoValidoException
	 *             Cuando el C&oacute;digo no es v&aacute;lido.
	 * @throws AnimalSinPesoException
	 *             Cuando el peso no es v&aacute;lido.
	 * @throws AnimalSinEnergiaException
	 *             Cuando se intenta crear un animal sin energ&iacute;a.
	 */
	public Pez(Alimentacion tipoAlimentacion, String codigo, int energia,
			double peso, Calendar fecha, EspeciesPeces especiesPeces,
			boolean escamas) throws CodigoNoValidoException,
			AnimalSinPesoException, AnimalSinEnergiaException {
		super(tipoAlimentacion, codigo, energia, peso, fecha);
		setEspeciesPeces(especiesPeces);
		setEscamas(escamas);
	}

	/**
	 * 
	 * @param codigo
	 *            Alias del Pez.
	 * @throws CodigoNoValidoException
	 *             Cuando el C&oacute;digo no es v&aacute;lido.
	 */
	public Pez(String codigo) throws CodigoNoValidoException {
		setCodigo(codigo);
	}

	/**
	 * Especies de Peces.
	 * 
	 * @return Devuelve la especie de Pez.
	 */
	public EspeciesPeces getEspeciesPeces() {
		return especiesPeces;
	}

	/**
	 * Especies de peces.
	 * 
	 * @param especiesPeces
	 *            Especies de peces.
	 */
	public void setEspeciesPeces(EspeciesPeces especiesPeces) {
		this.especiesPeces = especiesPeces;
	}

	/**
	 * Boolean de si el pez tiene escamas o no.
	 * 
	 * @return Devuelve true o false dependiendo si tiene escamas o no.
	 */
	public boolean isEscamas() {
		return escamas;
	}

	public void setEscamas(boolean escamas) {
		this.escamas = escamas;
	}

	/**
	 * Modifica el alias del animal.
	 * 
	 * @param codigo
	 *            Alias del animal.
	 * @throws CodigoNoValidoException
	 *             Cuando el alias no es v&aacute;lido.
	 */
	public void setCodigo(String codigo) throws CodigoNoValidoException {
		if (!esValido(codigo))
			throw new CodigoNoValidoException("El cÛdigo no es v·lido");
		this.codigo = codigo;// Pidiendolo al usuario
	}

	/**
	 * Comprueba, por medio del patr&oacute;n el alias del animal.
	 * 
	 * @param codigo
	 *            Alias del animal.
	 * @return Devuelve la comprobaci&oacute;n del alias.
	 */
	public static boolean esValido(String codigo) {
		return aliasPez.matcher(codigo).matches();
	}

	/**
	 * M&eacute;todo comer de la interfaz Energizable.
	 */
	@Override
	public void comer() {
		// Energias y pesos
		switch (getEspeciesPeces()) {
		case TIBURON:
			energia = energia + 5000;
			peso = peso + 30;
			break;
		case SALMON:
			energia = energia + 505;
			peso = peso + 3;
		case CARPA:
			energia = energia + 404;
			peso = peso + 2;
		case PEZ_GATO:
			energia = energia + 100;
			peso = peso + 2;
		}

	}

	/**
	 * M&eacute;todo desplazarse de la interfaz Desplazable.
	 * 
	 * @throws EnergiaInvalidaException
	 *             Cuando la energ&iacute;a no es correcta.
	 * @throws PesoInvalidoException
	 *             Cuando el peso no es correcto.
	 */
	@Override
	public void desplazarse() throws EnergiaInvalidaException,
			PesoInvalidoException {
		switch (getEspeciesPeces()) {
		case TIBURON:
			if (energia < 4800)
				throw new EnergiaInvalidaException();
			energia = energia - 4800;// calorias por pesar 800kg---por
										// 100kg
										// de peso y una actividad de 1 hora
										// el tiburon quema 4800 calorias.
			if (peso < 20)
				throw new PesoInvalidoException();
			peso = peso - 20;
			break;
		case SALMON:
			if (energia < 420)
				throw new EnergiaInvalidaException();
			energia = energia - 420;// por 1 hora de actividad y por pesar
									// normalmente 7 kg quema 420 calorias
			if (peso < 4)
				throw new PesoInvalidoException();
			peso = peso - 4;
			break;
		case CARPA:
			if (energia < 200)
				throw new EnergiaInvalidaException();
			energia = energia - 200;// Pesa normalmente 5 kg y quema por
									// hora 200 calorias.
			if (peso < 2)
				throw new PesoInvalidoException();
			peso = peso - 2;
			break;
		case PEZ_GATO:
			if (energia < 60)
				throw new EnergiaInvalidaException();
			energia = energia - 60;// Pesa normalmente 1 kg y quema por hora
									// 6 calorias.
			if (peso < 1)
				throw new PesoInvalidoException();
			peso = peso - 1;
			break;
		}
	}

	public static Pez instanciarPez(Alimentacion tipoAlimentacion,
			String codigo, int energia, double peso, Calendar fecha,
			EspeciesPeces especiesPeces, boolean escamas)
			throws CodigoNoValidoException, AnimalSinPesoException,
			AnimalSinEnergiaException {
		return new Pez(tipoAlimentacion, codigo, energia, peso, fecha,
				especiesPeces, escamas);
	}

}
