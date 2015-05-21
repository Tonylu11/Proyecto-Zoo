package Zoo;

import java.util.Calendar;

public class Mamifero extends Animal {
	private EspeciesMamiferos especiesMamiferos;
	private boolean hibernando;

	public Mamifero(Alimentacion tipoAlimentacion, String codigo, int energia,
			double peso, Calendar fecha) throws CodigoNoValidoException {
		super(tipoAlimentacion, codigo, energia, peso, fecha);
		setEspeciesMamiferos(especiesMamiferos);
		setHibernando(hibernando);
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
}