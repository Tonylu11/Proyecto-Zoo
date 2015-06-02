package Zoo;

import java.io.Serializable;
import java.util.Calendar;
import java.util.regex.Pattern;

import GUI.AnimalSinPesoException;

public class Pez extends Animal implements Desplazable, Energizable,
		Serializable {
	private EspeciesPeces especiesPeces;
	private boolean escamas;
	static final private Pattern aliasPez = Pattern
			.compile("^PEZ-[A-Za-z¡…Õ”⁄Ò]{5}-[0-9]{2}");

	public Pez(Alimentacion tipoAlimentacion, String codigo, int energia,
			double peso, Calendar fecha, EspeciesPeces especiesPeces,
			boolean escamas) throws CodigoNoValidoException,
			AnimalSinPesoException, AnimalSinEnergiaException {
		super(tipoAlimentacion, codigo, energia, peso, fecha);
		setEspeciesPeces(especiesPeces);
		setEscamas(escamas);
	}

	public EspeciesPeces getEspeciesPeces() {
		return especiesPeces;
	}

	public void setEspeciesPeces(EspeciesPeces especiesPeces) {
		this.especiesPeces = especiesPeces;
	}

	public boolean isEscamas() {
		return escamas;
	}

	public void setEscamas(boolean escamas) {
		this.escamas = escamas;
	}

	public void setCodigo(String codigo) throws CodigoNoValidoException {
		if (!esValido(codigo))
			throw new CodigoNoValidoException("El cÛdigo no es v·lido");
		this.codigo = codigo;// Pidiendolo al usuario
	}

	private boolean esValido(String codigo) {
		return aliasPez.matcher(codigo).matches();
	}

	@Override
	public void desplazarse() {
		switch (getEspeciesPeces()) {
		case TIBURON:
			energia = getEnergia() - 4800;// calorias por pesar 800kg---por
											// 100kg
											// de peso y una actividad de 1 hora
											// el tiburon quema 4800 calorias.
			peso = getPeso() - 20;
			break;
		case SALMON:
			energia = getEnergia() - 42;// por 1 hora de actividad y por pesar
										// normalmente 7 kg quema 42 calorias
			peso = getPeso() - 1;
			break;
		case CARPA:
			energia = getEnergia() - 20;// Pesa normalmente 5 kg y quema por
										// hora 20 calorias.
			peso = getPeso() - 1;
			break;
		case PEZ_GATO:
			energia = getEnergia() - 6;// Pesa normalmente 1 kg y quema por hora
										// 6 calorias.
			peso = getPeso() - 0.2;
			break;
		}
	}

	@Override
	public void comer() {
		// Energias y pesos
		switch (getEspeciesPeces()) {
		case TIBURON:
			energia = getEnergia() + 5000;
			peso = getPeso() + 30;
			break;
		case SALMON:
			energia = getEnergia() + 50;
			peso = getPeso() + 3;
		case CARPA:
			energia = getEnergia() + 40;
			peso = getPeso() + 2;
		case PEZ_GATO:
			energia = getEnergia() + 10;
			peso = getPeso() + 1;
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
