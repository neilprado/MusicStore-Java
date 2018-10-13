package fachada;
import java.util.ArrayList;
import java.util.List;

import dao.DAO;
import dao.DAOArtista;
import dao.DAOGenero;
import dao.DAOProduto;
import modelo.Album;
import modelo.Artista;
import modelo.Genero;
import modelo.Musica;
import modelo.Produto;

public class Fachada {
	private static DAOProduto daoproduto = new DAOProduto();
	private static DAOArtista daoartista = new DAOArtista(); 
	private static DAOGenero daogenero = new DAOGenero();
	
	public static void inicializar() {
		DAO.open();
	}
	
	public static void finalizar() {
		DAO.close();
	}
	
	//Cadastros (CREATIONS)
	public static Album cadastrarAlbum(String nome, double preco, int ano, int faixas, Artista ar) throws Exception {
		DAO.begin();
		Album a = (Album) daoproduto.listarPorNome(nome);
		if(a!= null)
			throw new Exception("Álbum " + nome + " já cadastrado");
		a = new Album(nome, preco, ano, ar, faixas);
		ar.adicionar(a);
		//daoartista.update(ar);
		 daoproduto.create(a);
		DAO.commit();
		return (Album) a;
	}
	
	public static Musica cadastrarMusica (String nome, double preco, int ano, Album album, Artista ar, int duracao) throws Exception {
		DAO.begin();
		Musica m = (Musica) daoproduto.listarPorNome(nome);
		if(m!=null)
			throw new Exception("Música " + nome + " já cadastrada");
		m = new Musica(nome, preco, ano, album, ar, duracao);
		ar.adicionar(m);
		album.adicionarMusica(m);
		//daoproduto.create(m);
		daoartista.update(ar);
		daoproduto.update(album);
		DAO.commit();
		return (Musica) m;
	}
	
	public static Artista cadastrarArtista(String nome, String nac, int num) throws Exception {
		DAO.begin();
		Artista a = daoartista.buscaPorNome(nome);
		if (a!=null)
			throw new Exception("Artista " + nome + " já cadastrado");
		a = new Artista(nome, nac, num);
		daoartista.create(a);
		DAO.commit();
		return (Artista) a;
	}
	
	public static Genero cadastrarGenero(String nome) throws Exception{
		DAO.begin();
		Genero g = daogenero.buscaGenero(nome);
		if (g!=null)
			throw new Exception("Gênero " + nome + " existente");
		g = new Genero(nome);
		daogenero.create(g);
		DAO.commit();
		return (Genero) g;
	}
	
	public static Genero cadastrarGenero(String nome, ArrayList<Album> a) throws Exception{
		DAO.begin();
		Genero g = daogenero.buscaGenero(nome);
		if (g!=null)
			throw new Exception("Gênero " + nome + " existente");
		g = new Genero(nome, a);
		daogenero.create(g);
		DAO.commit();
		return (Genero) g;
	}
	//Remoções (DELETIONS)
	public static Album removerAlbum(String nome) throws Exception {
		DAO.begin();
		Album a = (Album) daoproduto.listarPorNome(nome);
		if (a == null)
			throw new Exception("Álbum " + nome + " inexistente");
		daoproduto.delete(a);
		DAO.commit();
		return a;
	}
	
	public static Musica removerMusica(String nome) throws Exception {
		DAO.begin();
		Musica m = (Musica) daoproduto.listarPorNome(nome);
		if(m == null)
			throw new Exception ("Música " + nome + " inexistente");
		daoproduto.delete(m);
		DAO.commit();
		return m;
	}
	
	public static Artista removerArtista(String nome) throws Exception{
		DAO.begin();
		Artista a = daoartista.buscaPorNome(nome);
		if (a == null)
			throw new Exception ("Artista " + nome + " não cadastrado");
		daoartista.delete(a);
		DAO.commit();
		return a;
	}
	
	public static Genero removerGenero(String nome) throws Exception {
		DAO.begin();
		Genero g = daogenero.buscaGenero(nome);
		if (g == null)
			throw new Exception ("Gênero " + nome + " inexistente");
		daogenero.delete(g);
		DAO.commit();
		return g;
	}
	
	//Atualizações (UPDATES)
	public static void atualizarAlbum(String nome, String novo) throws Exception{
		DAO.begin();
		Album a = (Album) daoproduto.listarPorNome(nome);
		if (a == null)
			throw new Exception ("Álbum " + nome + " não cadastrado");
		a.setNome(novo);
		a = (Album) daoproduto.update(a);
		DAO.commit();
	}
	
	public static void atualizarMusica(String nome, String novo) throws Exception{
		DAO.begin();
		Musica m = (Musica) daoproduto.listarPorNome(nome);
		if (m == null)
			throw new Exception ("Música " + nome + " não cadastrado");
		m.setNome(novo);
		m = (Musica) daoproduto.update(m);
		DAO.commit();
	}
	
	public static void atualizarArtista(String nome, String novo) throws Exception{
		DAO.begin();
		Artista a = daoartista.buscaPorNome(nome);
		if (a == null)
			throw new Exception ("Álbum " + nome + " não cadastrado");
		a.setNome(novo);
		a = daoartista.update(a);
		DAO.commit();
	}
	
	public static void atualizarGenero(String nome, String novo) throws Exception{
		DAO.begin();
		Genero g = daogenero.buscaGenero(nome);
		if (g == null)
			throw new Exception ("Gênero " + nome + " não cadastrado");
		g.setNome(novo);
		g = daogenero.update(g);
		DAO.commit();
	}
	
	//Listagem (READ)
	
	public static String listarAlbum() {
		List<Produto> albuns = daoproduto.readAll();
		String texto = "--- Listagem de Álbuns --- \n";
		for(Produto a: albuns) {
			if(a instanceof Album)
				texto+= a.getNome() + ((Album) a).listarGenerosPorAlbum() + ((Album) a).listarMusicasPorAlbum() + "\n" ;
		}
		return texto;
	}
	
	public static String listarMusicasCadastradas() {
		List<Produto> musicas = daoproduto.readAll();
		String texto = "--- Listagem de Músicas --- \n";
		for(Produto m: musicas) {
			if(m instanceof Musica)
				texto+= m.getNome() + "\n";
		}
		return texto;
	}
	
	public static String listarArtistas() {
		List<Artista> artistas = daoartista.readAll();
		String texto = "--- Listagem de Artistas --- \n";
		for(Artista a: artistas)
			texto+= a.getNome() + "\n";
		return texto;
	}
	
	public static String listarGeneros() {
		List<Genero> generos = daogenero.readAll();
		String texto = "--- Listagem de Generos --- \n";
		for(Genero g: generos)
			texto+= g.getNome() + "\n";
		return texto;
	}
	
	// MÉTODOS PERSONALIZADOS
	public static void  relacionaAlbum (String nome, String album) throws Exception {
		DAO.begin();
		Genero g = daogenero.buscaGenero(nome);
		Album a = (Album) daoproduto.listarPorNome(album);
		if (g == null)
			throw new Exception ("Gênero " + nome + " não cadastrado");
		if (a == null)
			throw new Exception ("Álbum " + album + " não cadastrado");
		a.adicionarGenero(g);
		daogenero.update(g);
		DAO.commit();
	}

}
