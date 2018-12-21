package modelo;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

@Entity
public class Album extends Produto implements Comparable<Album> {
	
	private int faixas;
	@OneToMany(mappedBy="album", cascade=CascadeType.ALL, fetch=FetchType.LAZY)
	private ArrayList<Musica> musicas = new ArrayList<>();
	@ManyToMany(cascade=CascadeType.ALL, fetch=FetchType.LAZY)
	@JoinTable(name="albuns_generos", joinColumns= {@JoinColumn(name="FK_ALBUM_ID")},
	inverseJoinColumns= {@JoinColumn(name="FK_GENERO_ID")})
	private ArrayList<Genero> generos = new ArrayList<>();
	
	public Album(String n, double p, int a, Artista ar, int f) {
		super(n,p,a, ar);
		this.faixas = f;
	}
	
	public Album() {}
	
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
		return "Album [faixas=" + faixas + ", musicas=" + musicas + "]";
	}
	
	public String listarGenerosPorAlbum() {
		String texto = " ";
		for(Genero g: generos)
			texto += " - " + g.getNome();
		return texto;
	}
	
	public String listarMusicasPorAlbum() {
		String texto = "";
		for (Musica m: musicas)
			texto += " - " + m.getNome();
		return texto;
	}

	@Override
	public int compareTo(Album a) {
		return super.getNome().compareToIgnoreCase(a.getNome());
	}
	
}
