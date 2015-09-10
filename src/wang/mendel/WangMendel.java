package wang.mendel;

import java.util.ArrayList;
import java.util.List;

/* O conjunto de treinamento são a primeira metade da base, o de teste são a segunda metade.
 * 
 **/
public class WangMendel {
	
	private Database dados;

	
	public WangMendel(Database dados) {
		this.dados = dados;
		//System.out.println("Quantidade de instâncias: " + dados.getQuantInstancias());
			
	}
	

	
	private void gerarConjuntoTeste(){
		
	}
	
	private void gerarConjuntoTreinamento(){
		
	}
	
	private static double pertinenciaTriangular(double x, double limInferior, double limSuperior, double m){
		
		double pertinencia = 0;
		
		if(x <= limInferior){
			pertinencia = 0;
		}
		else if(x > limInferior && x < m){
			pertinencia = (x - limInferior)/(m - limInferior);
		}
		else if(x > m && x < limSuperior){
			pertinencia = (limSuperior - x)/(limSuperior - m);
		}
		else if(x > limSuperior){
			pertinencia = 0;
		}
		
		return pertinencia;

	}

}
