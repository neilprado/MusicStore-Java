package modelo;
import java.util.ArrayList;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import dao.IDInterface;

@Entity
public class Artista implements Comparable<Artista>, IDInterface {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String nome;
	private String nacionalidade;
	private int numIntegrantes;
	@OneToMany(mappedBy="artista", cascade=CascadeType.ALL, fetch=FetchType.LAZY)
	private ArrayList<Produto> produtos = new ArrayList<>();
	
	public Artista(String nome, String nac, int num) {
		this.nome = nome;
		this.nacionalidade = nac;
		this.numIntegrantes = num;
	}
	
	public Artista() {}
	
	public void adicionar(Produto p) {
		produtos.add(p);
		p.setArtista(this);
	}
	
	public void remover (Produto p) {
		produtos.remove(p);
		p.setArtista(null);
	}
	
	public Produto localizar (String nome) {
		for (Produto p: produtos) {
			if(p.getNome().equalsIgnoreCase(nome))
				return p;
		}
		return null;
	}
	
	public int totalAlbuns() {
		int cont = 0;
		for (Produto p: produtos) {
			if(p instanceof Album)
				cont++;
		}
		return cont;
	}
	
	public ArrayList<String> listaDeAlbuns(){
		ArrayList<String> titulos = new ArrayList<>();
		for(Produto p: produtos) {
			if (p instanceof Album)
				titulos.add(p.getNome());
		}
		return titulos;
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

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getNacionalidade() {
		return nacionalidade;
	}

	public void setNacionalidade(String nacionalidade) {
		this.nacionalidade = nacionalidade;
	}

	public int getNumIntegrantes() {
		return numIntegrantes;
	}

	public void setNumIntegrantes(int numIntegrantes) {
		this.numIntegrantes = numIntegrantes;
	}

	public ArrayList<Produto> getProdutos() {
		return produtos;
	}

	public void setProdutos(ArrayList<Produto> produtos) {
		this.produtos = produtos;
	}

	@Override
	public String toString() {
		return "Artista [id=" + id + ", nome=" + nome + ", nacionalidade=" + nacionalidade + ", numIntegrantes="
				+ numIntegrantes + ", produtos=" + produtos + "]";
	}

	@Override
	public int compareTo(Artista a) {
		return this.getNome().compareToIgnoreCase(a.getNome());
	}
}
