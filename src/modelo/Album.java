package modelo;
import java.util.ArrayList;
import java.util.List;

public class Album extends Produto implements Comparable<Album> {
	
	private int faixas;
	private List<Musica> musicas = new ArrayList<>();
	private List<Genero> generos = new ArrayList<>();
	
	public Album(String n, double p, int a, int f) {
		super(n,p,a);
		this.faixas = f;
	}

	public int getFaixas() {
		return faixas;
	}

	public void setFaixas(int faixas) {
		this.faixas = faixas;
	}

	public List<Musica> getMusicas() {
		return musicas;
	}

	public void setMusicas(List<Musica> musicas) {
		this.musicas = musicas;
	}

	public List<Genero> getGeneros() {
		return generos;
	}

	public void setGeneros(List<Genero> generos) {
		this.generos = generos;
	}


	@Override
	public String toString() {
		return "Album [faixas=" + faixas + ", musicas=" + musicas + ", generos=" + generos + "]";
	}

	@Override
	public int compareTo(Album o) {
		// TODO Auto-generated method stub
		return 0;
	}
	
}
