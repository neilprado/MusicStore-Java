package modelo;
import java.util.ArrayList;
import java.util.List;

public class Artista implements Comparable<Artista> {
	private int id;
	private String nome;
	private String nacionalidade;
	private int numIntegrantes;
	private List<Produto> produtos = new ArrayList<>();
	
	public Artista(String nome, String nac, int num) {
		this.nome = nome;
		this.nacionalidade = nac;
		this.numIntegrantes = num;
	}
	
	public void adicionar(Produto p) {
		produtos.add(p);
	}
	
	public void remover (Produto p) {
		produtos.remove(p);
	}
	
	public Produto localizar (String nome) {
		for (Produto p: produtos) {
			if(p.getNome().equalsIgnoreCase(nome))
				return p;
		}
		return null;
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

	public List<Produto> getProdutos() {
		return produtos;
	}

	public void setProdutos(List<Produto> produtos) {
		this.produtos = produtos;
	}

	@Override
	public String toString() {
		return "Artista [id=" + id + ", nome=" + nome + ", nacionalidade=" + nacionalidade + ", numIntegrantes="
				+ numIntegrantes + ", produtos=" + produtos + "]";
	}

	@Override
	public int compareTo(Artista o) {
		// TODO Auto-generated method stub
		return 0;
	}
}
