package aplicacao;

import modelo.Album;
import modelo.Musica;
import modelo.Produto;

public class Teste {

	public static void main(String[] args) {
		Album a = new Album("Più Che Logico", 28.90, 2012, 29);
		Musica m = new Musica("Logico #1", 2.90, 2012, a, 3.89 );
		
		System.out.println(m);

	}

}
