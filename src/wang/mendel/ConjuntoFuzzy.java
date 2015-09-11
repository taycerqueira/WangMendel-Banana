package wang.mendel;

public class ConjuntoFuzzy {
	
	private Atributo atributo;
	private double limiteInferior;
	private double limiteSuperior;
	private int indiceConjunto;
	private String nomeConjunto; //[nome do atributo](indice do conjunto)
	
	public ConjuntoFuzzy(Atributo atributo, double limiteInferior, double limiteSuperior, int indiceConjunto, String nomeConjunto) {

		this.atributo = atributo;
		this.limiteInferior = limiteInferior;
		this.limiteSuperior = limiteSuperior;
		this.indiceConjunto = indiceConjunto;
		this.nomeConjunto = nomeConjunto;
		
		//System.out.println("Conjunto fuzzy criado! [" + this.limiteInferior + ", " + this.limiteSuperior + "]");
		
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

	public String getNomeConjunto() {
		return nomeConjunto;
	}

	public void setNomeConjunto(String nomeConjunto) {
		this.nomeConjunto = nomeConjunto;
	}

	//Calculo da pertinência triangular
	public double calculaPertinencia(double x){
		//System.out.println("Calculando pertinência no conjunto " + this.indiceConjunto);
		double pertinencia = 0;
		double m = (limiteSuperior + limiteInferior)/2;

		//System.out.println("Valor de x: " + x + " | Valor de m: " + m + " | Limite Inferior: " + limiteInferior + " | Limite Superior: " + limiteSuperior);
		
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
		//System.out.println("Pertinência calculada: " + pertinencia);
		return pertinencia;

	}

}
