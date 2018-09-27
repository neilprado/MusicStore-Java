package modelo;

import javax.swing.JOptionPane;

public class Musica extends Produto implements Comparable<Musica> {

	private String url;
	private Album album;
	private double duracao;
	
	public Musica(String nome, double preco, int ano, Album a, double d) {
		super(nome, preco, ano);
		this.album = a;
		this.setDuracao(d);
	}

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


	public void setDuracao(double duracao) {
		String secs = String.valueOf(duracao);
		secs = secs.substring(secs.indexOf(".")).substring(1);
		double s = Double.parseDouble(secs);
			if(s < 60)
				this.duracao = duracao;
			this.duracao = 0;
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
