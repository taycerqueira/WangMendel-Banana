package wang.mendel;

public class ConjuntoFuzzy {
	
	private Atributo atributo;
	private double limiteInferior;
	private double limiteSuperior;
	private int indiceConjunto;
	
	public ConjuntoFuzzy(Atributo atributo, double limiteInferior, double limiteSuperior, int indiceConjunto) {

		this.atributo = atributo;
		this.limiteInferior = limiteInferior;
		this.limiteSuperior = limiteSuperior;
		this.indiceConjunto = indiceConjunto;
		
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
