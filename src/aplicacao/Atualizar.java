package aplicacao;

import fachada.Fachada;

public class Atualizar {
	public Atualizar() {
		Fachada.inicializar();
		try {
			System.out.println("Alterando...");
			Fachada.atualizarArtista("Jon Bovi", "Bon Jovi");
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		Fachada.finalizar();
		System.out.println("Fim do Programa");
	}

	public static void main(String[] args) {
		new Atualizar();
	}

}
