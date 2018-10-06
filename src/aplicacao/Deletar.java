package aplicacao;

import fachada.Fachada;

public class Deletar {
	public Deletar() {
		Fachada.inicializar();
		try {
			System.out.println("Deletando...");
			Fachada.removerArtista("Bon Jovi");
			Fachada.removerGenero("Pop");
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public static void main(String[] args) {
		new Deletar();
	}

}
