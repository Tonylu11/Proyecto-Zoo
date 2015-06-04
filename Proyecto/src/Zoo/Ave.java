package Zoo;

import java.io.Serializable;
import java.util.Calendar;
import java.util.regex.Pattern;

/**
 * Clase Hija Ave
 * 
 * @author Antonio Luque Bravo
 *
 */
public class Ave extends Animal implements Desplazable, Energizable,
		Serializable {
	/**
	 * Especies de Aves.
	 */
	private EspeciesAves especiesAves;
	private boolean migrando;
	/**
	 * Alias del ave.
	 */
	static final private Pattern aliasAve = Pattern
			.compile("^AVE-[A-Za-z¡…Õ”⁄Ò]{5}-[0-9]{2}");

	/**
	 * 
	 * @param tipoAlimentacion
	 *            Alimentaci&oacute; del Ave.
	 * @param codigo
	 *            Alias del Ave.
	 * @param energia
	 *            Energ&iacute;a del Ave.
	 * @param peso
	 *            Peso del Ave.
	 * @param fecha
	 *            Fecha del almacenamiento del Ave.
	 * @param especiesAves
	 *            Especies de Aves.
	 * @param tipo
	 *            Tipo de Animal.
	 * @param migrando
	 *            Boolean migrando.
	 * @throws CodigoNoValidoException
	 *             Cuando el C&oacute;digo no es v&aacute;lido.
	 * @throws AnimalSinPesoException
	 *             Cuando el peso no es v&aacute;lido.
	 * @throws AnimalSinEnergiaException
	 *             Cuando se intenta crear un animal sin energ&iacute;a.
	 */
	public Ave(Alimentacion tipoAlimentacion, String codigo, int energia,
			double peso, Calendar fecha, EspeciesAves especiesAves, int tipo,
			boolean migrando) throws CodigoNoValidoException,
			AnimalSinPesoException, AnimalSinEnergiaException {
		super(tipoAlimentacion, codigo, energia, peso, fecha, tipo);
		setEspeciesAves(especiesAves);
		setMigrando(migrando);

	}

	/**
	 * Constructor por alias.
	 * 
	 * @param codigo
	 *            Alias del Ave.
	 * @throws CodigoNoValidoException
	 *             Cuando el alias del Ave no es correcto.
	 */
	public Ave(String codigo) throws CodigoNoValidoException {
		setCodigo(codigo);
	}

	/**
	 * Instacia un ave.
	 * 
	 * @param tipoAlimentacion
	 * @param codigo
	 * @param energia
	 * @param peso
	 * @param fecha
	 * @param tipo
	 * @param especiesAves
	 * @param migrando
	 * @return Devuelve la creaci&oacute;n de un Ave.
	 * @throws CodigoNoValidoException
	 * @throws AnimalSinPesoException
	 * @throws AnimalSinEnergiaException
	 */
	public static Ave instanciarAve(Alimentacion tipoAlimentacion,
			String codigo, int energia, double peso, Calendar fecha, int tipo,
			EspeciesAves especiesAves, boolean migrando)
			throws CodigoNoValidoException, AnimalSinPesoException,
			AnimalSinEnergiaException {
		return new Ave(tipoAlimentacion, codigo, energia, peso, fecha,
				especiesAves, 2, migrando);
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
		return aliasAve.matcher(codigo).matches();
	}

	/**
	 * M&eacute;todo comer de la interfaz Energizable.
	 */
	@Override
	public void comer() throws AnimalSinPesoException,
			AnimalSinEnergiaException {

		switch (getEspeciesAves()) {
		case AVESTRUZ:
			energia = energia + 2300;
			peso = peso + 5;
			break;
		case AGUILA:
			energia = energia + 3500;
			peso = peso + 7;
		case GOLONDRINA:
			energia = energia + 3000;
			peso = peso + 2;
			break;
		}
	}

	/**
	 * M&eacute;todo desplazarse de la interfaz Desplazable.
	 */
	@Override
	public void desplazarse() throws AnimalSinEnergiaException,
			AnimalSinPesoException {
		switch (getEspeciesAves()) {
		case AVESTRUZ:
			energia = energia - 1400;
			peso = peso - 2;
			break;
		case AGUILA:
			energia = energia - 2300;
			peso = peso - 3;
		case GOLONDRINA:
			energia = energia - 2000;
			peso = peso - 4;
			break;
		}
	}

	public EspeciesAves getEspeciesAves() {
		return especiesAves;
	}

	public void setEspeciesAves(EspeciesAves especiesAves) {
		this.especiesAves = especiesAves;
	}

	public boolean isMigrando() {
		return migrando;
	}

	public void setMigrando(boolean migrando) {
		this.migrando = migrando;
	}

}
