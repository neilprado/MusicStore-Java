package modelo;
import java.util.ArrayList;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import dao.IDInterface;

@Entity
public class Genero implements IDInterface {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String nome;
	@ManyToMany(mappedBy="generos", cascade=CascadeType.ALL, fetch=FetchType.LAZY)
	private ArrayList<Album> albuns = new ArrayList<>();
	
	public Genero(String nome) {
		this.nome = nome;
	}
	
	public Genero() {}
	
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
		return "Genero [id=" + id + ", nome=" + nome + "]";
	}	
}
