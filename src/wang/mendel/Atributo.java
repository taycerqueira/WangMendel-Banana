package wang.mendel;

import java.util.ArrayList;
import java.util.List;

public class Atributo {
	
	private String nomeAtributo;
	private double limiteInferior;
	private double limiteSuperior;
	private int indice;
	
	public Atributo(String nomeAtributo, double limiteInferior, double limiteSuperior, int indice) {
		
		this.nomeAtributo = nomeAtributo;
		this.limiteInferior = limiteInferior;
		this.limiteSuperior = limiteSuperior;
		this.indice = indice;

	}
	
	public String getNomeAtributo() {
		return nomeAtributo;
	}
	
	public void setNomeAtributo(String nomeAtributo) {
		this.nomeAtributo = nomeAtributo;
	}

	public double getLimiteInferior() {
		return limiteInferior;
	}
	public void setLimiteInferior(double limiteInferior) {
		this.limiteInferior = limiteInferior;
	}
	public double getLimiteSuperior() {
		return limiteSuperior;
	}
	public void setLimiteSuperior(double limiteSuperior) {
		this.limiteSuperior = limiteSuperior;
	}
	public int getIndice() {
		return indice;
	}
	public void setIndice(int indice) {
		this.indice = indice;
	}
	
	public List<ConjuntoFuzzy> getConjuntosFuzzy(int qntRegioes){
		
		//System.out.println("=> Criando conjuntos fuzzy");
		List<ConjuntoFuzzy> conjuntosFuzzy = new ArrayList<ConjuntoFuzzy>();
		//ConjuntoFuzzy conjunto = new ConjuntoFuzzy(atributo, limiteSuperior, limiteInferior)
		double tamanhoDominio = this.limiteSuperior - this.limiteInferior;
		//System.out.println("Extensão do domínio: " + tamanhoDominio + "[" + this.limiteInferior + ", " + this.limiteSuperior + "]");
		double range = tamanhoDominio/(qntRegioes - 1);
		double inf = this.limiteInferior;
		double sup = this.limiteInferior + range;
		
		//Definição dos limites das regiões de pertinencia triangular
		for(int i = 0; i < qntRegioes; i++){
			String nomeConjunto = new String(this.nomeAtributo + "(" + i + ")");
			ConjuntoFuzzy conjunto = new ConjuntoFuzzy(this, inf, sup, i, nomeConjunto);
			conjuntosFuzzy.add(conjunto);
			//System.out.println("Conjunto: " + i + " [" + inf + ", " + sup + "]");
			inf += range/2;
			sup += range/2;
		}
		//System.out.println("TAMANHO DA LISTA DE CONJ FUZZY DO ATRIBUTO: " + conjuntosFuzzy.size());
		return conjuntosFuzzy;

	}

}
