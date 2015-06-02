package Zoo;

import java.io.Serializable;
import java.util.Calendar;
import java.util.regex.Pattern;

import GUI.AnimalSinPesoException;

/**
 * 
 * @author Antonio Luque Bravo
 *
 */
public class Animal implements Serializable {
	protected Alimentacion tipoAlimentacion;
	protected String codigo;
	protected int energia;
	protected double peso;
	protected Calendar fecha;
	static final private Pattern aliasAnimal = Pattern
			.compile("^[MAM|AVE|PEZ]-[A-Za-zÁÉÍÓÚñ]{5}-[0-9]{2}$");
	static final private Pattern pesoAnimal = Pattern
			.compile("^[0-9][0-9]?[0-9]?$");
	static final private Pattern energiaAnimal = Pattern
			.compile("^[0-9][0-9][0-9][0-9]?$");

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

	public Alimentacion getTipoAlimentacion() {
		return tipoAlimentacion;
	}

	public void setTipoAlimentacion(Alimentacion tipoAlimentacion) {
		this.tipoAlimentacion = tipoAlimentacion;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) throws CodigoNoValidoException {
		if (!esValidoAliasAnimal(codigo))
			throw new CodigoNoValidoException("El código no es válido");
		this.codigo = codigo;// Pidiendolo al usuario
	}

	private boolean esValidoAliasAnimal(String codigo) {
		return aliasAnimal.matcher(codigo).matches();
	}

	public int getEnergia() {
		return energia;
	}

	public static boolean energiaEsValida(String codigo) {
		return energiaAnimal.matcher(codigo).matches();
	}

	public void setEnergia(int energia) throws AnimalSinEnergiaException {
		if (!energiaEsValida(codigo)) {
			throw new AnimalSinEnergiaException("El código no es válido");
		} else {
			this.energia = energia;
		}
	}

	public double getPeso() {
		return peso;
	}

	public void setPeso(double peso) throws AnimalSinPesoException {
		if (!pesoEsValido(codigo))
			throw new AnimalSinPesoException("El código no es válido");
		this.peso = peso;
	}

	public static boolean pesoEsValido(String codigo2) {
		return pesoAnimal.matcher(codigo2).matches();
	}

	public Calendar getFecha() {
		return fecha;
	}

	public void setFecha(Calendar fecha) {
		this.fecha = fecha;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codigo == null) ? 0 : codigo.hashCode());
		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Animal other = (Animal) obj;
		if (codigo == null) {
			if (other.codigo != null)
				return false;
		} else if (!codigo.equals(other.codigo))
			return false;
		return true;
	}

}
