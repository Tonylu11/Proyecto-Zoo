package Zoo;

import java.io.Serializable;
import java.util.Calendar;
import java.util.regex.Pattern;

/**
 * Clase padre del Zoo.
 * 
 * @author Antonio Luque Bravo
 *
 */
@SuppressWarnings("serial")
public class Animal implements Serializable, Energizable, Desplazable {
	/**
	 * Tipo de alimentaci&oacute;n del animal.
	 */
	protected Alimentacion tipoAlimentacion;
	/**
	 * Alias del animal.
	 */
	protected String codigo;
	/**
	 * Energ&iacute;a del animal.
	 */
	protected int energia;
	/**
	 * Peso del animal.
	 */
	protected double peso;
	/**
	 * Fecha de cuando se almacena al animal.
	 */
	protected Calendar fecha;
	protected int aumentaEnergia;
	protected double aumentaPeso;
	protected int disminuyeEnergia;
	protected double disminuyePeso;
	/**
	 * Patr&oacute;n para el alias del animal.
	 */
	static final private Pattern aliasAnimal = Pattern
			.compile("^[MAM|AVE|PEZ]-[A-Za-zÁÉÍÓÚñ]{5}-[0-9]{2}$");
	/**
	 * Patr&oacute;n para el peso del animal.
	 */
	static final private Pattern pesoAnimal = Pattern
			.compile("^[0-9][0-9]?[0-9]?$");
	/**
	 * Patr&oacute;n para el peso del animal.
	 */
	static final private Pattern energiaAnimal = Pattern
			.compile("^[0-9][0-9][0-9][0-9]?$");

	/**
	 * Constructor de Animal.
	 * 
	 * @param tipoAlimentacion
	 *            Alimentaci&oacute;n del animal.
	 * @param codigo
	 *            Alias del animal.
	 * @param energia
	 *            Energ&iacute; del animal.
	 * @param peso
	 *            Peso del animal.
	 * @param fecha
	 *            Fecha de cuando se almacena el animal en el Zoo.
	 * @throws CodigoNoValidoException
	 *             Cuando el C&oacute;digo no es v&aacute;lido.
	 * @throws AnimalSinPesoException
	 *             Cuando el peso no es v&aacute;lido.
	 * @throws AnimalSinEnergiaException
	 *             Cuando se intenta crear un animal sin energ&iacute;a.
	 */
	public Animal(Alimentacion tipoAlimentacion, String codigo, int energia,
			double peso, Calendar fecha) throws CodigoNoValidoException,
			AnimalSinPesoException, AnimalSinEnergiaException {
		setTipoAlimentacion(tipoAlimentacion);
		setCodigo(codigo);
		this.energia = energia;
		this.peso = peso;
		setFecha(fecha);

	}

	public Animal() {
	}

	/**
	 * Constructor por alias.
	 * 
	 * @param codigo
	 *            Alias del animal.
	 * @throws CodigoNoValidoException
	 *             Cuando el alias del animal no es correcto.
	 */
	public Animal(String codigo) throws CodigoNoValidoException {
		this.codigo = codigo;
	}

	/**
	 * Obtiene el tipo de alimentaci&oacute;
	 * 
	 * @return Alimentaci&oacute;n del animal.
	 */
	public Alimentacion getTipoAlimentacion() {
		return tipoAlimentacion;
	}

	public void setTipoAlimentacion(Alimentacion tipoAlimentacion) {
		this.tipoAlimentacion = tipoAlimentacion;
	}

	/**
	 * Obtiene el alias del animal.
	 * 
	 * @return Alias del animal.
	 */
	public String getCodigo() {
		return codigo;
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
		if (!esValidoAliasAnimal(codigo))
			throw new CodigoNoValidoException("El código no es válido");
		this.codigo = codigo;// Pidiendolo al usuario
	}

	/**
	 * Comprueba, por medio del patr&oacute;n el alias del animal.
	 * 
	 * @param codigo
	 *            Alias del animal.
	 * @return Devuelve la comprobaci&oacute;n del alias.
	 */
	private boolean esValidoAliasAnimal(String codigo) {
		return aliasAnimal.matcher(codigo).matches();
	}

	/**
	 * Devuelve la energ&iacute;a del animal.
	 * 
	 * @return Energ&iacute; del animal.
	 */
	public int getEnergia() {
		return energia;
	}

	/**
	 * Comprueba, por medio del patr&oacute;n la energ&iacute;a del animal.
	 * 
	 * @param codigo
	 *            Alias del animal.
	 * @return Devuelve la comprobaci&oacute;n de la energ&iacute;a.
	 */
	public static boolean energiaEsValida(String codigo) {
		return energiaAnimal.matcher(codigo).matches();
	}

	/**
	 * Modifica la energ&iacute;a del animal.
	 * 
	 * @param energia
	 *            Energ&iacute;a del animal.
	 * @throws AnimalSinEnergiaException
	 *             Cuando se intenta crear un animal sin energ&iacute;a.
	 */
	public void setEnergia(int energia) throws AnimalSinEnergiaException {
		if (!energiaEsValida(codigo)) {
			throw new AnimalSinEnergiaException("La energía no es válida");
		} else {
			this.energia = energia;
		}
	}

	/**
	 * Devuelve el peso del animal.
	 * 
	 * @return Peso del animal.
	 */
	public double getPeso() {
		return peso;
	}

	/**
	 * Modifica el peso del animal.
	 * 
	 * @param peso
	 *            Peso del animal.
	 * @throws AnimalSinPesoException
	 *             Cuando se intenta crear un animal sin peso.
	 */
	public void setPeso(double peso) throws AnimalSinPesoException {
		if (!pesoEsValido(codigo))
			throw new AnimalSinPesoException("El peso no es válido.");
		this.peso = peso;
	}

	/**
	 * Comprueba, por medio del patr&oacute;n el peso del animal.
	 * 
	 * @param codigo2
	 *            peso del animal.
	 * @return Devuelve la comprobaci&oacute;n del peso.
	 */
	public static boolean pesoEsValido(String codigo2) {
		return pesoAnimal.matcher(codigo2).matches();
	}

	/**
	 * Obtiene la fecha del animal.
	 * 
	 * @return Fecha del animal.
	 */
	public Calendar getFecha() {
		return fecha;
	}

	public void setFecha(Calendar fecha) {
		this.fecha = fecha;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codigo == null) ? 0 : codigo.hashCode());
		return result;
	}

	/**
	 * Compara dos objetos.
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		Animal other = (Animal) obj;
		if (codigo == null) {
			if (other.codigo != null)
				return false;
		} else if (!codigo.equals(other.codigo))
			return false;
		return true;
	}

	/**
	 * M&eacute;todo comer de la interfaz Energizable.
	 */
	@Override
	public void comer() throws AnimalSinPesoException,
			AnimalSinEnergiaException, EnergiaInvalidaException,
			PesoInvalidoException {
		if (energia >= 30000) {
			throw new EnergiaInvalidaException();
		} else {
			energia = energia + aumentaEnergia;
		}
		if (peso >= 1000) {
			throw new PesoInvalidoException();
		} else {
			peso = peso + aumentaPeso;
		}

	}

	/**
	 * M&eacute;todo desplazarse de la interfaz Desplazable.
	 */
	@Override
	public void desplazarse() throws AnimalSinEnergiaException,
			AnimalSinPesoException, EnergiaInvalidaException,
			PesoInvalidoException {
		if (energia <= 500) {
			throw new EnergiaInvalidaException();
		} else {
			energia = energia - disminuyeEnergia;
		}
		if (peso <= 1) {
			throw new PesoInvalidoException();
		} else {
			peso = peso - disminuyePeso;
		}
	}
}
