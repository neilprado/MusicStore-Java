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
			al = Fachada.cadastrarAlbum("Più Che Logico", 22.90, 2017, 13, a);
			p = Fachada.cadastrarMusica("Logico #1", 3.60, 2013, al, a, 4.11);
			al = Fachada.cadastrarAlbum("Il Primo Bacio Sulla Luna", 18.20, 2008, 15, a);
			p = Fachada.cadastrarMusica("Dicono di me", 3.10, 2010, al, a, 3.20);
			p = Fachada.cadastrarMusica("Le Sei e Ventisei", 2.10, 2010, al, a, 3.10);
			a = Fachada.cadastrarArtista("Iron Maiden", "EUA", 6);
			al = Fachada.cadastrarAlbum("The Number of the Beast", 32.10, 1982, 8, a);
			p = Fachada.cadastrarMusica("Run to the Hills", 2.70, 1981, al, a, 6.20);
			p = Fachada.cadastrarMusica("Gangland", 2.80, 1982, al, a, 3.10);
			a = Fachada.cadastrarArtista("Jon Bovi", "EUA", 5);
			g = Fachada.cadastrarGenero("Pop Rock");
			g = Fachada.cadastrarGenero("Pop");
			g = Fachada.cadastrarGenero("Heavy Metal");
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
