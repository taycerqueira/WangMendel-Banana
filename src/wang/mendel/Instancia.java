package wang.mendel;

public class Instancia {
	
	private Double atributo0;
	private Double atributo1;
	private Double classe;
	
	public Instancia(Double atributo1, Double atributo2, Double classe) {
		this.atributo0 = atributo1;
		this.atributo1 = atributo2;
		this.classe = classe;
	}

	public Double getAtributo0() {
		return atributo0;
	}

	public void setAtributo0(Double atributo0) {
		this.atributo0 = atributo0;
	}

	public Double getAtributo1() {
		return atributo1;
	}

	public void setAtributo1(Double atributo1) {
		this.atributo1 = atributo1;
	}

	public Double getClasse() {
		return classe;
	}

	public void setClasse(Double classe) {
		this.classe = classe;
	}
	
}
