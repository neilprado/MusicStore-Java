package modelo;
import java.util.ArrayList;

public class Genero {
	private String nome;
	private ArrayList<Album> albuns;

	public String getNome() {
		return nome;
	}
	
	public void adicionar(Album a) {
		albuns.add(a);
		a.adicionarGenero(this);
	}
	
	public void remover (Album a) {
		albuns.remove(a);
		a.removerGenero(this);
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public ArrayList<Album> getAlbuns() {
		return albuns;
	}

	public void setAlbuns(ArrayList<Album> a) {
		this.albuns = a;
	}

	@Override
	public String toString() {
		return "Genero [nome=" + nome + ", albuns=" + albuns + "]";
	}	
}
