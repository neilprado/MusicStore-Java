package modelo;
import javax.persistence.ManyToOne;

public class Musica extends Produto implements Comparable<Musica> {

	private String url;
	@ManyToOne
	private Album album;
	private int duracao;
	
	public Musica(String nome, double preco, int ano, Album a, Artista ar, int d) {
		super(nome, preco, ano, ar);
		this.album = a;
		this.duracao = d;
	}
	
	public Musica() {}

	public String getUrl() {
		return url;
	}


	public Album getAlbum() {
		return album;
	}


	public void setAlbum(Album album) {
		this.album = album;
	}

	public double getDuracao() {
		return duracao;
	}


	public void setDuracao(int duracao) {
		this.duracao = duracao;
	}

	@Override
	public String toString() {
		return "Musica [url=" + url + ", album=" + album + ", duracao=" + duracao + "]";
	}


	@Override
	public int compareTo(Musica m) {
		return super.getNome().compareToIgnoreCase(m.getNome());
	}

}
