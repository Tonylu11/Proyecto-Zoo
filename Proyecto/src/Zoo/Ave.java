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
public class Ave extends Animal implements Desplazable, Energizable,
		Serializable {
	private EspeciesAves especiesAves;
	private boolean migrando;
	static final private Pattern aliasAve = Pattern
			.compile("^AVE-[A-Za-z¡…Õ”⁄Ò]{5}-[0-9]{2}");

	public Ave(Alimentacion tipoAlimentacion, String codigo, int energia,
			double peso, Calendar fecha, EspeciesAves especiesAves,
			boolean migrando) throws CodigoNoValidoException,
			AnimalSinPesoException, AnimalSinEnergiaException {
		super(tipoAlimentacion, codigo, energia, peso, fecha);
		setEspeciesAves(especiesAves);
		setMigrando(migrando);

	}

	public static Ave instanciarAve(Alimentacion tipoAlimentacion,
			String codigo, int energia, double peso, Calendar fecha,
			EspeciesAves especiesAves, boolean migrando)
			throws CodigoNoValidoException, AnimalSinPesoException,
			AnimalSinEnergiaException {
		return new Ave(tipoAlimentacion, codigo, energia, peso, fecha,
				especiesAves, migrando);
	}

	public void setCodigo(String codigo) throws CodigoNoValidoException {
		if (!esValido(codigo))
			throw new CodigoNoValidoException("El cÛdigo no es v·lido");
		this.codigo = codigo;// Pidiendolo al usuario
	}

	private boolean esValido(String codigo) {
		return aliasAve.matcher(codigo).matches();
	}

	@Override
	public void desplazarse() throws AnimalSinEnergiaException,
			AnimalSinPesoException {
		switch (getEspeciesAves()) {
		case AVESTRUZ:
			correr();
			break;
		default:
			volar();
			break;
		}
	}

	private void correr() throws AnimalSinEnergiaException,
			AnimalSinPesoException {
		setEnergia(getEnergia() - 1400);
		setPeso(getPeso() - 2);
	}

	private void volar() throws AnimalSinEnergiaException,
			AnimalSinPesoException {
		setEnergia(getEnergia() - 2000);
		setPeso(getPeso() - 4);
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

	@Override
	public void comer() throws AnimalSinEnergiaException,
			AnimalSinPesoException {
		setEnergia(getEnergia() + 2500);
		setPeso(getPeso() + 9);
	}
}
