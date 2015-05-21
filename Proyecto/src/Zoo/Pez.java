package Zoo;

import java.util.Calendar;

public class Pez extends Animal {
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

}
