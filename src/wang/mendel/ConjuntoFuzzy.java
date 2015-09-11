package wang.mendel;

public class ConjuntoFuzzy {
	
	private Atributo atributo;
	private static double limiteInferior;
	private static double limiteSuperior;
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
	
	public int getIndiceConjunto() {
		return indiceConjunto;
	}

	public void setIndiceConjunto(int indiceConjunto) {
		this.indiceConjunto = indiceConjunto;
	}

	//Calculo da pertinência triangular
	public static double calculaPertinencia(double x){
		
		double pertinencia = 0;
		double m = (limiteSuperior - limiteInferior)/2;
		
		if(x <= limiteInferior){
			pertinencia = 0;
		}
		else if(x > limiteInferior && x < m){
			pertinencia = (x - limiteInferior)/(m - limiteInferior);
		}
		else if(x > m && x < limiteSuperior){
			pertinencia = (limiteSuperior - x)/(limiteSuperior - m);
		}
		else if(x > limiteSuperior){
			pertinencia = 0;
		}
		
		return pertinencia;

	}

}
