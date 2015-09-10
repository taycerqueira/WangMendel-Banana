package wang.mendel;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.StringTokenizer;

public class Database {
	
	private String nomeRelacao;
	private List<Atributo> atributos;
	private List<Double> classes;
	private int quantInstancias = 0;

	public Database() {
		super();
	}
	
	public void lerDados(String nomeArquivo) {
		
		try {
			BufferedReader dados = new BufferedReader(new FileReader(nomeArquivo));
			this.nomeRelacao = new String();
			this.atributos = new ArrayList<Atributo>();
			this.classes = new ArrayList<Double>();
			int contIndiceAtributo = 0;
		
			while (dados.ready()) { 
				
				String linha = dados.readLine();
				
				if (linha.matches("\\s*")){
					continue; 
				}
				
				//System.out.println(linha);
				
				if(linha.startsWith("@")){
					//System.out.println(linha);
					String[] token = linha.split(" ");
					//System.out.println(token[0]);
					switch(token[0]){
						case "@relation":
							this.nomeRelacao = token[1];
							System.out.println("=> Relation: " + this.nomeRelacao);
							break;
						case "@attribute":
							String nomeAtributo = token[1];
							if(!nomeAtributo.equals("Class")){
								//System.out.println(token[2]);
								String t = token[2].replaceAll("real", "");
								t = t.replaceAll("\\[", "");
								t = t.replaceAll("\\]", "");
								//System.out.println(t);
								String[] limites = t.split(",");
								double limiteInferior = Double.parseDouble(limites[0]);
								double limiteSuperior = Double.parseDouble(limites[1]);
								
								Atributo atributo = new Atributo(nomeAtributo, limiteInferior, limiteSuperior, contIndiceAtributo);
								this.atributos.add(atributo);
								System.out.println("=> Atributo " + contIndiceAtributo + ": " + nomeAtributo + " [" + limiteInferior + ", " + limiteSuperior + "]");
								contIndiceAtributo++;
							}
							else{
								String t = token[2].replaceAll("\\{", "");
								t = t.replaceAll("\\}", "");
								//System.out.println(t);
								String[] classes = t.split(",");
								System.out.println("=> Classes: ");
								for (String classe : classes) {
									this.classes.add(Double.parseDouble(classe));
									System.out.println(classe);
								}
							}
							
							break;
					}
					
				}
				//Dados
				else{
					//System.out.println(linha);
					this.quantInstancias++;
					String[] l = linha.split(",");
					for(int i = 0; i < contIndiceAtributo; i++){
						//System.out.println("i == " + i);
						atributos.get(i).getValores().add(Double.parseDouble(l[i]));
						//System.out.println(Double.parseDouble(l[i]));
					}
				}
			}
			
			System.out.println("=> Quantidade de instâncias: " + quantInstancias);

		}  catch (IOException e) {
			
			System.out.println(e);
			
		} 
		
		/*Atributo atributo = this.atributos.get(1);
		for (Double valor : atributo.getValores()) {
			System.out.println(valor);
		}*/
		
		/*System.out.println("tamanho 1: " + this.atributos.get(0).getValores().size());
		System.out.println("tamanho 2: " + this.atributos.get(1).getValores().size());*/
		

	}

	public String getNomeRelacao() {
		return nomeRelacao;
	}

	public void setNomeRelacao(String nomeRelacao) {
		this.nomeRelacao = nomeRelacao;
	}

	public List<Atributo> getAtributos() {
		return atributos;
	}

	public void setAtributos(List<Atributo> atributos) {
		this.atributos = atributos;
	}

	public List<Double> getClasses() {
		return classes;
	}

	public void setClasses(List<Double> classes) {
		this.classes = classes;
	}

	public int getQuantInstancias() {
		return quantInstancias;
	}

}
