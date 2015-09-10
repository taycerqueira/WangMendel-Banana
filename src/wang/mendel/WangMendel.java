package wang.mendel;

import java.util.ArrayList;
import java.util.List;

/* O conjunto de treinamento são a primeira metade da base, o de teste são a segunda metade.
 * 
 **/
public class WangMendel {
	
	private Database dados;
	private List<Atributo> conjTreinamento;
	private List<Atributo> conjTeste;
	private int qntRegioes = 3;
	private List<Regra> regras;
	

	public WangMendel(Database dados) {
		this.dados = dados;
		init();
		//System.out.println("Quantidade de instâncias: " + dados.getQuantInstancias());
			
	}
	
	public void init(){
		this.conjTreinamento = gerarConjuntoTreinamento();
		this.conjTeste = gerarConjuntoTeste();
		this.regras = geraRegras(this.conjTreinamento);
	}
	
	private List<Atributo> gerarConjuntoTreinamento(){
		List<Atributo> atributos = dados.getAtributos();
		List<Atributo> conjTreinamento = new ArrayList<Atributo>();
		
		for(int i = 0; i < dados.getQuantInstancias()/2; i++){
			conjTreinamento.add(atributos.get(i));
		}
		
		return conjTreinamento;
	}
	
	private List<Atributo> gerarConjuntoTeste(){
		List<Atributo> atributos = dados.getAtributos();
		List<Atributo> conjTeste = new ArrayList<Atributo>();
		
		for(int i = dados.getQuantInstancias()/2; i < dados.getQuantInstancias(); i++){
			conjTeste.add(atributos.get(i));
		}
		
		return conjTeste;
	}
	
	private List<Regra> geraRegras(List<Atributo> conjTreinamento){
		List<Regra> regras = new ArrayList<Regra>();
		
		for(int cont = 0; cont < dados.getQuantInstancias(); cont++){ //cont = número da instância
			
			for(int i = 0; i < dados.getAtributos().size(); i++){ //i = número do atributo
				
			}
			
		}
		
		return regras;
	}
	
	//Retorna o conjunto que possui maior pertinência a partir de um valor x em um determinado atributo
	private ConjuntoFuzzy getConjunto(double valor, Atributo atributo){
		
		ConjuntoFuzzy conjunto = null;
		double maiorPertinencia = 0;
		
		for (ConjuntoFuzzy c : atributo.getConjuntosFuzzy(this.qntRegioes)) {
			double p = c.calculaPertinencia(valor);
			if(p > maiorPertinencia){
				p = maiorPertinencia;
			}
		}
		
		return conjunto;
		
	}

}
