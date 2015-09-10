package wang.mendel;

public class Regra {
	
	private double grau;
	private ConjuntoFuzzy antecedente1;
	private ConjuntoFuzzy antecedente2;
	private double consequente; //classe 
	
	public Regra(ConjuntoFuzzy antecedente1, ConjuntoFuzzy antecedente2, double consequente, double grau) {
		this.antecedente1 = antecedente1;
		this.antecedente2 = antecedente2;
		this.consequente = consequente;
		this.grau = grau; 
	}

	public double getGrau() {
		return grau;
	}

	public void setGrau(double grau) {
		this.grau = grau;
	}

	public ConjuntoFuzzy getAntecedente1() {
		return antecedente1;
	}

	public void setAntecedente1(ConjuntoFuzzy antecedente1) {
		this.antecedente1 = antecedente1;
	}

	public ConjuntoFuzzy getAntecedente2() {
		return antecedente2;
	}

	public void setAntecedente2(ConjuntoFuzzy antecedente2) {
		this.antecedente2 = antecedente2;
	}

	public double getConsequente() {
		return consequente;
	}

	public void setConsequente(double consequente) {
		this.consequente = consequente;
	}	

}
