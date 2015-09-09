package wang.mendel;

public class ConjuntoFuzzy {
	
	private Atributo atributo;
	private double limiteSuperior;
	private double limiteInferior;
	
	public ConjuntoFuzzy(Atributo atributo, double limiteSuperior, double limiteInferior) {
		
		super();
		this.atributo = atributo;
		this.limiteSuperior = limiteSuperior;
		this.limiteInferior = limiteInferior;
		
	}

	public Atributo getAtributo() {
		return atributo;
	}

	public void setAtributo(Atributo atributo) {
		this.atributo = atributo;
	}

	public double getLimiteSuperior() {
		return limiteSuperior;
	}

	public void setLimiteSuperior(double limiteSuperior) {
		this.limiteSuperior = limiteSuperior;
	}

	public double getLimiteInferior() {
		return limiteInferior;
	}

	public void setLimiteInferior(double limiteInferior) {
		this.limiteInferior = limiteInferior;
	}
	

}
