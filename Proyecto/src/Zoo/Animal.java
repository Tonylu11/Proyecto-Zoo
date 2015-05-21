package Zoo;

import java.util.Calendar;
import java.util.regex.Pattern;

/**
 * 
 * @author Antonio Luque Bravo
 *
 */
public class Animal {
	private Alimentacion tipoAlimentacion;
	private String codigo;
	private int energia;
	private double peso;
	private Calendar fecha;
	static final private Pattern codigoAnimal = Pattern.compile("");

	public Animal(Alimentacion tipoAlimentacion, String codigo, int energia,
			double peso, Calendar fecha) throws CodigoNoValidoException {
		setTipoAlimentacion(tipoAlimentacion);
		setCodigo(codigo);
		setEnergia(energia);
		setPeso(peso);
		setFecha(fecha);
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
		if (!esValido(codigo))
			throw new CodigoNoValidoException("El código no es válido");
		this.codigo = codigo;// Pidiendolo al usuario
	}

	private boolean esValido(String codigo2) {
		return codigoAnimal.matcher(codigo).matches();
	}

	public int getEnergia() {
		return energia;
	}

	public void setEnergia(int energia) {
		this.energia = energia;
	}

	public double getPeso() {
		return peso;
	}

	public void setPeso(double peso) {
		this.peso = peso;
	}

	public Calendar getFecha() {
		return fecha;
	}

	public void setFecha(Calendar fecha) {
		this.fecha = fecha;
	}
}
