package wang.mendel;

import java.util.ArrayList;
import java.util.List;

public class Atributo {
	
	private String nomeAtributo;
	private boolean isClass;
	private double limiteInferior;
	private double limiteSuperior;
	private int indice;
	private List<Double> valores;
	
	public Atributo(String nomeAtributo, double limiteInferior, double limiteSuperior, int indice) {
		this.nomeAtributo = nomeAtributo;
		this.limiteInferior = limiteInferior;
		this.limiteSuperior = limiteSuperior;
		this.indice = indice;
		this.valores = new ArrayList<Double>();
	}
	
	public String getNomeAtributo() {
		return nomeAtributo;
	}
	
	public void setNomeAtributo(String nomeAtributo) {
		this.nomeAtributo = nomeAtributo;
	}
	
	public boolean isClass() {
		return isClass;
	}

	public void setClass(boolean isClass) {
		this.isClass = isClass;
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

	public List<Double> getValores() {
		return valores;
	}

	public void setValores(List<Double> valores) {
		this.valores = valores;
	}

}
