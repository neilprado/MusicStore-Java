package aplicacao;

import fachada.Fachada;
import modelo.Album;
import modelo.Artista;
import modelo.Genero;
import modelo.Musica;
import modelo.Produto;

public class Cadastrar {
	
	public Cadastrar() {
		Fachada.inicializar();
		Artista a;
		Album al;
		Produto p;
		Genero g;
		try {
			System.out.println("Cadastrando...");
			a = Fachada.cadastrarArtista("Cesare Cremonini", "Italia", 1);
			p = Fachada.cadastrarProduto("Logico #1", 3.60, 2013);
			al = Fachada.cadastrarAlbum("Nessuno Vuole Essere Robin", 22.90, 2017, 13);
			g = Fachada.cadastrarGenero("Pop Rock");
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		Fachada.finalizar();
		System.out.println("Fim do programa");
		
	}
	
	public void cadastrar() {
		
	}

	public static void main(String[] args) {
		new Cadastrar();
	}

}
