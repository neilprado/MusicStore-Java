package aplicacao;

import fachada.Fachada;

public class Listar {
	public Listar() {
		Fachada.inicializar();
		try {
			//System.out.println(Fachada.listarArtistas());
			System.out.println(Fachada.listarAlbum());
			//System.out.println(Fachada.listarMusicasCadastradas());
			//System.out.println(Fachada.listarGeneros());
		}catch(Exception e){
			System.out.println(e.getMessage());
		}
		Fachada.finalizar();
		System.out.println("Fim do Programa");
	}

	public static void main(String[] args) {
		new Listar();
	}

}
