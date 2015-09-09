package wang.mendel;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {

	public static void main(String[] args) {
		
		Database dados = new Database();
		try {
		
			dados.lerDados("banana.dat");
			List<String> attributes = dados.getAttributes(); 
			List<String> values = new ArrayList<String>(); 
			
			System.out.println("ATRIBUTOS: ");
			for(String at : attributes){
				System.out.println(at);
			}
			//naive.processar(values);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
