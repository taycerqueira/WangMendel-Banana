package wang.mendel;

import java.util.ArrayList;
import java.util.List;

/* O conjunto de treinamento são a primeira metade da base, o de teste são a segunda metade.
 * 
 **/
public class WangMendel {
	
	private Database dados;
	private List<Instancia> conjTreinamento;
	private List<Instancia> conjTeste;
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
	
	private List<Instancia> gerarConjuntoTreinamento(){
		List<Instancia> conjTreinamento = new ArrayList<Instancia>();
		
		for(int i = 0; i < dados.getQuantInstancias()/2; i++){
			conjTreinamento.add(dados.getInstancias().get(i));
		}
		
		return conjTreinamento;
	}
	
	private List<Instancia> gerarConjuntoTeste(){
		List<Instancia> conjTeste = new ArrayList<Instancia>();
		
		for(int i = dados.getQuantInstancias()/2; i < dados.getQuantInstancias(); i++){
			conjTeste.add(dados.getInstancias().get(i));
		}
		
		return conjTeste;
	}
	
	private List<Regra> geraRegras(List<Instancia> conjTreinamento){
		System.out.println("=> Gerando base de regras");
		List<Regra> regras = new ArrayList<Regra>();
	
		for (Instancia instancia : conjTreinamento) {
			double x0 = instancia.getAtributo0();
			double x1 = instancia.getAtributo1();
			double classe = instancia.getClasse();
			//System.out.println("* Instância: " + x0 + " |" + x1 + " -> " + classe);
			//Pega o conjunto fuzzy para o valor x0 no atributo 0
			ConjuntoFuzzy c0 =  null;
			double p0 = -1;
			List<ConjuntoFuzzy> listaConjuntos0 = dados.getAtributos().get(0).getConjuntosFuzzy(qntRegioes);
			//System.out.println("QUANTIDADE DE CONJ FUZZY/ATRIBUTO: " + listaConjuntos0.size());
			for (ConjuntoFuzzy c : listaConjuntos0) {
				double p = c.calculaPertinencia(x0);
				//System.out.println("CONJUNTO DA VEZ: " + c.getIndiceConjunto());
				//System.out.println("PERTINENCIA CALCULADA: " + p);
				//Escolho o conjunto fuzzy com maior pertinencia	
				//System.out.println("p: " + p + " | p0: " + p0);
				if(p > p0){
					p0 = p;
					c0 = c;
					//System.out.println("indice do conjunto: " + c0.getIndiceConjunto());
				}
			}
			//System.out.println("Conjunto escolhido 0: " + c0.getIndiceConjunto() + " {" + p0 + "}");
			
			//Pega o conjunto fuzzy para o valor x1 no atributo 1
			ConjuntoFuzzy c1 =  null;
			List<ConjuntoFuzzy> listaConjuntos1 = dados.getAtributos().get(1).getConjuntosFuzzy(qntRegioes);
			double p1 = -1;
			for (ConjuntoFuzzy c : listaConjuntos1) {
				double p = c.calculaPertinencia(x1);
				//Escolho o conjunto fuzzy com maior pertinencia
				if(p > p1){
					p1 = p;
					c1 = c;
				}
			}
			//System.out.println("Conjunto escolhido 1: " + c1.getIndiceConjunto() + " {" + p1 + "}");
			
			//Crio a regra
			Regra regra = new Regra(c0, c1, classe, p0*p1);
			//System.out.println("Regra: " + c0.getAtributo().getNomeAtributo() + "(" + c0.getIndiceConjunto() + ") e " + c1.getAtributo().getNomeAtributo() + "(" + c1.getIndiceConjunto() + ") => " + classe);
			regras.add(regra);
		}
		System.out.println("* Quantidade bruta de regras geradas: " + regras.size());
		//Remove as regras conflitantes
		System.out.println("* Removendo regras conflitantes...");
		this.regras = removeRegrasConflitantes(regras);
		System.out.println("=> BASE DE CONHECIMENTO");
		/*for (Regra regra : regras) {
			System.out.println(regra.printRegra());
		}*/;
		return regras;
	}
	
	private List<Regra> removeRegrasConflitantes(List<Regra> regras){
		//MÉTODO BICHADO! PENSAR NUM ALGORTIMO PRA FAZER ISSO...
		List<Regra> r = null;
	    
	    for(int i = 0; i < regras.size(); i++){
	    	Regra regra1 = regras.get(i);
			String antecedente1 = regra1.getAntecedente1().getNomeConjunto();
			String antecedente2 = regra1.getAntecedente2().getNomeConjunto();
			//System.out.println("Regra atual: ");
			regra1.printRegra();
			
			for(int j =  i + 1; j < regras.size(); j++){
				Regra regra2 = regras.get(j);
				if(antecedente1.equals(regra2.getAntecedente1().getNomeConjunto()) && (antecedente2.equals(regra2.getAntecedente2().getNomeConjunto()))){
					System.out.println("Regras iguais detectada!");
					System.out.println("1 - " + regra1.printRegra() + " | Grau: " + regra1.getGrau());
					System.out.println("2 - " + regra2.printRegra() + " | Grau: " + regra2.getGrau());
					if(regra1.getGrau() > regra2.getGrau()){
						regras.remove(j);
					}
					else{
						regras.remove(i);
					}

				}
			}
	    }
		
	    r = regras;
		return r;
		
	}
	
	//Retorna o conjunto que possui maior pertinência a partir de um valor x em um determinado atributo
	/*private ConjuntoFuzzy getConjunto(double valor, Atributo atributo){
		
		ConjuntoFuzzy conjunto = null;
		double maiorPertinencia = 0;
		
		for (ConjuntoFuzzy c : atributo.getConjuntosFuzzy(this.qntRegioes)) {
			double p = c.calculaPertinencia(valor);
			if(p > maiorPertinencia){
				p = maiorPertinencia;
			}
		}
		
		return conjunto;
		
	}*/

}
