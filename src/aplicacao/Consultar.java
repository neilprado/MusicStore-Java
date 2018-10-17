package aplicacao;

import fachada.Fachada;

public class Consultar {
	public Consultar() {
		Fachada.inicializar();
		try {
			System.out.println(Fachada.consultaGenerosPeloAlbum("Il Primo Bacio Sulla Luna"));
			System.out.println(Fachada.consultaArtistasPorGenero("Pop"));
		//	System.out.println(Fachada.consultarMusicasPorGenero("Pop Rock"));
			System.out.println(Fachada.consultaGenerosPorArtista("Cesare Cremonini"));
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		Fachada.finalizar();
		System.out.println("Fim do programa");
	}

	public static void main(String[] args) {
		new Consultar();

	}

}
