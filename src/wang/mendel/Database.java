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
	private List<String> classes;
	private List<Double> instancias;

	public Database() {
		super();
	}
	
	public void lerDados(String nomeArquivo) {
		
		try {
			BufferedReader dados = new BufferedReader(new FileReader(nomeArquivo));
			this.nomeRelacao = new String();
			this.atributos = new ArrayList<Atributo>();
			this.classes = new ArrayList<String>();
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
							System.out.println("Relation: " + this.nomeRelacao);
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
								System.out.println("Atributo " + contIndiceAtributo + ": " + nomeAtributo + " - [" + limiteInferior + ", " + limiteSuperior + "]");
								contIndiceAtributo++;
							}
							else{
								String t = token[2].replaceAll("\\{", "");
								t = t.replaceAll("\\}", "");
								//System.out.println(t);
								String[] classes = t.split(",");
								System.out.println("Classes: ");
								for (String classe : classes) {
									this.classes.add(classe);
									System.out.println("-> " + classe);
								}
							}
							
							break;
					}
					
				}
				//Dados
				else{
					
					System.out.println(linha);
				}
			}

		}  catch (IOException e) {
			
			System.out.println(e);
			
		} 

	}
	


}
