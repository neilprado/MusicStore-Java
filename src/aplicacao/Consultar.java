package aplicacao;

import fachada.Fachada;

public class Consultar {
	public Consultar() {
		Fachada.inicializar();
		try {
			//Consultas ser�o realizadas aqui
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
