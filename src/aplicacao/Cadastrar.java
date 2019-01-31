package aplicacao;

import fachada.Fachada;
import modelo.Album;
import modelo.Artista;
import modelo.Genero;
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
			g = Fachada.cadastrarGenero("Pop Rock");
			Fachada.relacionaAlbum("Pop Rock", "Più Che Logico");
			p = Fachada.cadastrarMusica("Logico #1", 3.60, 2013, al, a, 251, "https://www.youtube.com/watch_popup?v=O33wYhbLqn8");
			p = Fachada.cadastrarMusica("Mondo", 3.50, 2009, al, a, 443, "https://www.youtube.com/watch_popup?v=QZQ1S4wRvpA");
			p = Fachada.cadastrarMusica("Il Comico", 3.40, 2005, al, a, 353, "https://www.youtube.com/watch_popup?v=enQo1ghR5Jk");
			al = Fachada.cadastrarAlbum("Il Primo Bacio Sulla Luna", 18.20, 2008, 15, a);
			p = Fachada.cadastrarMusica("Dicono di me", 3.10, 2010, al, a, 230, "https://www.youtube.com/watch_popup?v=chzzGKN-efQ");
			p = Fachada.cadastrarMusica("Le Sei e Ventisei", 2.10, 2010, al, a, 288, "https://www.youtube.com/watch_popup?v=PsI2kbhBGP0");
			p = Fachada.cadastrarMusica("Il Pagliaccio", 3.60, 2008, al, a, 321, "https://www.youtube.com/watch_popup?v=5DBdnxXiolE");
			a = Fachada.cadastrarArtista("Iron Maiden", "EUA", 6);
			al = Fachada.cadastrarAlbum("The Number of the Beast", 32.10, 1982, 8, a);
			p = Fachada.cadastrarMusica("Run to the Hills", 2.70, 1981, al, a, 380, "https://www.youtube.com/watch_popup?v=86URGgqONvA");
			p = Fachada.cadastrarMusica("Gangland", 2.80, 1982, al, a, 190, "https://www.youtube.com/watch_popup?v=JggUgcse33o");
			a = Fachada.cadastrarArtista("Jon Bovi", "EUA", 5);
			a = Fachada.cadastrarArtista("Stromae", "França", 1);
			al = Fachada.cadastrarAlbum("Cheese", 15.00, 2010, 11, a);
			p = Fachada.cadastrarMusica("Alors on Danse", 3.00, 2009, al, a, 235, "https://www.youtube.com/watch_popup?v=VHoT4N43jK8");
			a = Fachada.cadastrarArtista("Pink Floyd", "Inglaterra", 4);
			al = Fachada.cadastrarAlbum("The Wall", 26, 1979, 26, a);
			p = Fachada.cadastrarMusica("Another Brick in the Wall", 3.80, 1978, al, a, 201, "https://www.youtube.com/watch_popup?v=YR5ApYxkU-U");
			a = Fachada.cadastrarArtista("Frédéric Chopin", "Polônia", 1);
			al = Fachada.cadastrarAlbum("The Best of Chopin", 28.20, 2002, 19, a);
			p = Fachada.cadastrarMusica("Tristesse", 3.10, 1832, al, a, 358, "https://www.youtube.com/watch_popup?v=ikBD3DcSGFM");
			a = Fachada.cadastrarArtista("Alice in Chains", "EUA", 4);
			al = Fachada.cadastrarAlbum("Facelift", 23.00, 1990, 12, a);
			p = Fachada.cadastrarMusica("Man in the Box", 4, 1989, al, a, 286, "https://www.youtube.com/watch_popup?v=TAqZb52sgpU");
			a = Fachada.cadastrarArtista("Zaz", "França", 1);
			al = Fachada.cadastrarAlbum("Recto Verso", 22.00, 2013, 14, a);
			p = Fachada.cadastrarMusica("Je Veux", 3.50, 2011, al, a, 217, "https://www.youtube.com/watch_popup?v=3XRNegs6FdA");
			p = Fachada.cadastrarMusica("On Ira", 3.10, 2012, al, a, 180, "https://www.youtube.com/watch_popup?v=8IjWHBGzsu4");
			p = Fachada.cadastrarMusica("Sous le ciel de Paris", 3.20, 2009, al, a, 196, "https://www.youtube.com/watch_popup?v=XxGeJILz3bQ");
			p = Fachada.cadastrarMusica("Toujours", 3.40, 2013, al, a, 191, "https://www.youtube.com/watch_popup?v=7RQ3Ve6ICG4");
			g = Fachada.cadastrarGenero("Pop");
			g = Fachada.cadastrarGenero("Heavy Metal");
			g = Fachada.cadastrarGenero("Hip Hop");
			g = Fachada.cadastrarGenero("Classic");
			g = Fachada.cadastrarGenero("Rock");
			Fachada.relacionaAlbum("Pop", "Il Primo Bacio Sulla Luna");
			Fachada.relacionaAlbum("Hip Hop", "Cheese");
			Fachada.relacionaAlbum("Pop", "Recto Verso");
			Fachada.relacionaAlbum("Classic", "The Best of Chopin");
			Fachada.relacionaAlbum("Rock", "The Wall");
			a = Fachada.cadastrarArtista("J-AX", "Italia", 1);
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
