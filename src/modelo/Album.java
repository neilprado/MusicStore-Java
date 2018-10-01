package modelo;
import java.util.ArrayList;
import java.util.List;

public class Album extends Produto implements Comparable<Album> {
	
	private int faixas;
	private ArrayList<Musica> musicas = new ArrayList<>();
	private ArrayList<Genero> generos = new ArrayList<>();
	
	public Album(String n, double p, int a, int f) {
		super(n,p,a);
		this.faixas = f;
	}
	
	public void adicionarMusica(Musica m) {
		m.setAlbum(this);
		this.musicas.add(m);
	}
	
	public void adicionarGenero(Genero g) {
		this.generos.add(g);
		g.adicionar(this);
	}
	
	public void removerMusica(Musica m) {
		m.setAlbum(null);
		this.musicas.remove(m);
	}
	
	public void removerGenero(Genero g) {
		this.generos.remove(g);
		g.remover(this);
	}
	
	public Musica localizarPorNome(String nome) {
		for (Musica m: musicas) {
			if(m.getNome().equals(nome))
				return m;
		}
		return null;
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

	public void setMusicas(ArrayList<Musica> musicas) {
		this.musicas = musicas;
	}

	public List<Genero> getGeneros() {
		return generos;
	}

	public void setGeneros(ArrayList<Genero> generos) {
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
