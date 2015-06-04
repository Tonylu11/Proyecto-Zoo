package Zoo;

import java.io.Serializable;
import java.util.Calendar;
import java.util.regex.Pattern;

/**
 * Clase Hija Mam&iacute;fero.
 * 
 * @author Antonio Luque Bravo
 * 
 */
public class Mamifero extends Animal implements Energizable, Desplazable,
		Serializable {
	/**
	 * Especies de los mam&iacute;feros.
	 */
	private EspeciesMamiferos especiesMamiferos;
	private boolean hibernando;
	/**
	 * Alias de mam&iacute;fero.
	 */
	static final private Pattern aliasMamifero = Pattern
			.compile("^MAM-[A-Za-z¡…Õ”⁄Ò]{5}-[0-9]{2}");

	/**
	 * Constructor de Mam&iacute;fero.
	 * 
	 * @param tipoAlimentacion
	 *            Alimentaci&oacute;n del Mam&iacute;fero.
	 * @param codigo
	 *            alias del Mam&iacute;fero.
	 * @param energia
	 *            energ&iacute;a del Mam&iacute;fero.
	 * @param peso
	 *            peso del Mam&iacute;fero.
	 * @param fecha
	 *            fecha de almacenamiento del Mam&iacute;fero.
	 * @param tipo
	 * @param especiesMamiferos
	 *            Especies de Mam&iacute;feros.
	 * @param hibernando
	 *            Muestra si hiberna el Mam&iacute;fero o no.
	 * @throws CodigoNoValidoException
	 *             Cuando el C&oacute;digo no es v&aacute;lido.
	 * @throws AnimalSinPesoException
	 *             Cuando el peso no es v&aacute;lido.
	 * @throws AnimalSinEnergiaException
	 *             Cuando se intenta crear un animal sin energ&iacute;a.
	 */
	public Mamifero(Alimentacion tipoAlimentacion, String codigo, int energia,
			double peso, Calendar fecha, int tipo,
			EspeciesMamiferos especiesMamiferos, boolean hibernando)
			throws CodigoNoValidoException, AnimalSinPesoException,
			AnimalSinEnergiaException {
		super(tipoAlimentacion, codigo, energia, peso, fecha, tipo);
		setEspeciesMamiferos(especiesMamiferos);
		setHibernando(hibernando);

	}

	/**
	 * Constructor por alias.
	 * 
	 * @param codigo
	 *            Alias del Mam&iacute;fero.
	 * @throws CodigoNoValidoException
	 *             Cuando el alias del Mam&iacute;fero no es correcto.
	 */
	public Mamifero(String codigo) throws CodigoNoValidoException {
		setCodigo(codigo);
	}

	protected static Mamifero instanciarMamifero(Alimentacion tipoAlimentacion,
			String codigo, int energia, double peso, Calendar fecha, int tipo,
			EspeciesMamiferos especiesMamiferos, boolean hibernando)
			throws CodigoNoValidoException, AnimalSinPesoException,
			AnimalSinEnergiaException {
		return new Mamifero(tipoAlimentacion, codigo, energia, peso, fecha, 1,
				especiesMamiferos, hibernando);

	}

	/**
	 * Especies de mam&iacute;feros.
	 * 
	 * @return Devuelve las especies de mam&iacute;feros.
	 */
	public EspeciesMamiferos getEspeciesMamiferos() {
		return especiesMamiferos;
	}

	public void setEspeciesMamiferos(EspeciesMamiferos especiesMamiferos) {
		this.especiesMamiferos = especiesMamiferos;
	}

	public boolean isHibernando() {
		return hibernando;
	}

	public void setHibernando(boolean hibernando) {
		this.hibernando = hibernando;
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
		return aliasMamifero.matcher(codigo).matches();
	}

	/**
	 * M&eacute;todo comer de la interfaz Energizable.
	 */
	@Override
	public void comer() {
		switch (getEspeciesMamiferos()) {
		case MARMOTA:
			energia = energia + 3000;
			peso = peso + 3;
			break;
		case OSO:
			energia = energia + 5000;
			peso = peso + 40;
			break;
		case SURICATO:
			energia = energia + 3500;
			peso = peso + 4;
			break;
		case TIGRE:
			energia = energia + 4500;
			peso = peso + 40;
			break;
		}

	}

	/**
	 * M&eacute;todo desplazarse de la interfaz Desplazable.
	 */
	@Override
	public void desplazarse() {
		switch (getEspeciesMamiferos()) {
		case MARMOTA:
			energia = energia - 2800;
			peso = peso - 2;
			break;
		case OSO:
			energia = energia - 4000;
			peso = peso - 15;
			break;
		case SURICATO:
			energia = energia - 2500;
			peso = peso - 2;
			break;
		case TIGRE:
			energia = energia - 3700;
			peso = peso - 10;
			break;
		}

	}
}