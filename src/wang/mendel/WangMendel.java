package wang.mendel;

import java.util.List;

public class WangMendel {
	
	private Database dados;
	private List<ConjuntoFuzzy> conjuntosEntrada;
	private ConjuntoFuzzy conjuntoSaida;
	
	public WangMendel(Database dados) {
		this.dados = dados;
		criaConjuntosFuzzyEntrada(dados.getAtributos());
	}
	
	private void criaConjuntosFuzzyEntrada(List<Atributo> atributos){
		System.out.println("=> Criando conjuntos fuzzy");
		for (Atributo atributo : atributos) {
			System.out.println("* Variável: " + atributo.getNomeAtributo());
			//ConjuntoFuzzy conjunto = new ConjuntoFuzzy(atributo, limiteSuperior, limiteInferior)
			double tamanhoDominio = atributo.getLimiteSuperior() - atributo.getLimiteInferior();
			System.out.println("Tamanho do domínio: " + tamanhoDominio);
			double range = tamanhoDominio/3;
			for(int i = 0; i < 3; i++){
				//SEPARAR AQUI OS LIMITES DAS REGIÕES E CRIAR NOVO CONJUNTO
			}
			
			
			
		}
	}

}
