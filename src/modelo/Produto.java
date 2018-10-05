package modelo;

import dao.IDInterface;

public abstract class Produto implements IDInterface {
	private int id;
	private String nome;
	private double preco;
	private Artista artista;
	private int ano;
	
	public Produto(String nome, double preco, int ano, Artista a) {
		this.nome = nome;
		this.preco = preco;
		this.ano = ano;
		this.artista = a;
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
	public double getPreco() {
		return preco;
	}
	public void setPreco(double preco) {
		this.preco = preco;
	}
	public Artista getArtista() {
		return artista;
	}
	public void setArtista(Artista artista) {
		this.artista = artista;
	}
	public int getAno() {
		return ano;
	}
	public void setAno(int ano) {
		this.ano = ano;
	}
	@Override
	public String toString() {
		return "Produto [id=" + id + ", nome=" + nome + ", preco=" + preco + ", artista=" + artista + ", ano=" + ano
				+ "]";
	}
}
