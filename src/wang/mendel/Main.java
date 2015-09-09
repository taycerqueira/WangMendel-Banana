package wang.mendel;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {

	public static void main(String[] args) {
		
		Database dados = new Database();
		dados.lerDados("banana.dat");
		WangMendel wm = new WangMendel(dados);

	}

}
