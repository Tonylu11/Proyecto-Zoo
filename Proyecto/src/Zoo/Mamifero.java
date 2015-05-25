package Zoo;

import java.util.Calendar;

public class Mamifero extends Animal implements Desplazable, Energizable {
	private EspeciesMamiferos especiesMamiferos;
	private boolean hibernando;

	public Mamifero(Alimentacion tipoAlimentacion, String codigo, int energia,
			double peso, Calendar fecha, EspeciesMamiferos especiesMamiferos,
			boolean hibernando) throws CodigoNoValidoException {
		super(tipoAlimentacion, codigo, energia, peso, fecha);
		setEspeciesMamiferos(especiesMamiferos);
		setHibernando(hibernando);
	}

	protected static Mamifero instanciarMamifero(Alimentacion tipoAlimentacion,
			String codigo, int energia, double peso, Calendar fecha,
			EspeciesMamiferos especiesMamiferos, boolean hibernando)
			throws CodigoNoValidoException {
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

	@Override
	public void comer() {
		// TODO Auto-generated method stub

	}

	@Override
	public void desplazarse() {
		// TODO Auto-generated method stub

	}
}