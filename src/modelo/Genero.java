package modelo;
import java.util.ArrayList;
import dao.IDInterface;

public class Genero implements IDInterface {
	private int id;
	private String nome;
	private ArrayList<Album> albuns = new ArrayList<>();
	
	public Genero(String nome) {
		this.nome = nome;
	}
	
	public Genero (String nome, ArrayList<Album> a) {
		this.nome = nome;
		this.albuns = a;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}
	
	public void adicionar(Album a) {
		albuns.add(a);
	}
	
	public void remover (Album a) {
		albuns.remove(a);
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
		return "Genero [id=" + id + ", nome=" + nome + ", albuns=" + albuns + "]";
	}	
}
