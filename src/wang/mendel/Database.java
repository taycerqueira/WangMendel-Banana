package wang.mendel;

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

import weka.core.Attribute;
import weka.core.Instances;
import weka.core.converters.ConverterUtils.DataSource;

public class Database {
	
	private DataSource data;
	private Instances instances;

	public Database() {
		super();
	}
	
	public void lerDados(String nomeArquivo) throws Exception{
		this.data = new DataSource(nomeArquivo);
	    this.instances = data.getDataSet();
	}
	
	public List<String> getAttributes() {
		
		List<String> atributos = new ArrayList<String>(); 
		Enumeration<Attribute> c = this.instances.enumerateAttributes(); 
		
		while(c.hasMoreElements()){
			Attribute at = c.nextElement();
			if(!at.name().equals("class"))
				atributos.add(at.name());
		}
		
		return atributos;
	}

}
