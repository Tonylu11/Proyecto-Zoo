package Zoo;

import java.io.Serializable;
import java.util.Calendar;
import java.util.regex.Pattern;

import GUI.AnimalSinPesoException;

public class Mamifero extends Animal implements Desplazable, Energizable,
		Serializable {
	private EspeciesMamiferos especiesMamiferos;
	private boolean hibernando;
	static final private Pattern aliasMamifero = Pattern
			.compile("^MAM-[A-Za-z¡…Õ”⁄Ò]{5}-[0-9]{2}");

	public Mamifero(Alimentacion tipoAlimentacion, String codigo, int energia,
			double peso, Calendar fecha, EspeciesMamiferos especiesMamiferos,
			boolean hibernando) throws CodigoNoValidoException,
			AnimalSinPesoException, AnimalSinEnergiaException {
		super(tipoAlimentacion, codigo, energia, peso, fecha);
		setEspeciesMamiferos(especiesMamiferos);
		setHibernando(hibernando);
	}

	protected static Mamifero instanciarMamifero(Alimentacion tipoAlimentacion,
			String codigo, int energia, double peso, Calendar fecha,
			EspeciesMamiferos especiesMamiferos, boolean hibernando)
			throws CodigoNoValidoException, AnimalSinPesoException,
			AnimalSinEnergiaException {
		return new Mamifero(tipoAlimentacion, codigo, energia, peso, fecha,
				especiesMamiferos, hibernando);

	}

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

	public void setCodigo(String codigo) throws CodigoNoValidoException {
		if (!esValido(codigo))
			throw new CodigoNoValidoException("El cÛdigo no es v·lido");
		this.codigo = codigo;// Pidiendolo al usuario
	}

	public static boolean esValido(String codigo) {
		return aliasMamifero.matcher(codigo).matches();
	}

	@Override
	public void comer() {
		switch (getEspeciesMamiferos()) {
		case MARMOTA:
			energia = getEnergia() + 3000;
			peso = getPeso() + 3;
			break;
		case OSO:
			energia = getEnergia() + 5000;
			peso = getPeso() + 40;
			break;
		case SURICATO:
			energia = getEnergia() + 3500;
			peso = getPeso() + 4;
			break;
		case TIGRE:
			energia = getEnergia() + 4500;
			peso = getPeso() + 40;
			break;
		}

	}

	@Override
	public void desplazarse() {
		switch (getEspeciesMamiferos()) {
		case MARMOTA:
			energia = getEnergia() - 2800;
			peso = getPeso() - 2;
			break;
		case OSO:
			energia = getEnergia() - 4000;
			peso = getPeso() - 15;
			break;
		case SURICATO:
			energia = getEnergia() - 2500;
			peso = getPeso() - 2;
			break;
		case TIGRE:
			energia = getEnergia() - 3700;
			peso = getPeso() - 10;
			break;
		}

	}
}