package Zoo;

import java.util.Calendar;

public class Pez extends Animal implements Desplazable, Energizable {
	private EspeciesPeces especiesPeces;
	private boolean escamas;

	public Pez(Alimentacion tipoAlimentacion, String codigo, int energia,
			double peso, Calendar fecha) throws CodigoNoValidoException {
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

	@Override
	public void desplazarse() {
		nadar();
	}

	private void nadar() {
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

	}

}
