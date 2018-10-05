package fachada;

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
	
	public static Album cadastrarAlbum(String nome, double preco, int ano, int faixas, Artista ar) throws Exception {
		DAO.begin();
		Album a = (Album) daoproduto.listarPorNome(nome);
		if(a!= null)
			throw new Exception("Álbum " + nome + " já cadastrado");
		a = new Album(nome, preco, ano, ar, faixas);
		daoproduto.create(a);
		DAO.commit();
		return (Album) a;
	}
	
	public static Musica cadastrarMusica (String nome, double preco, int ano, Album album, Artista ar, double duracao) throws Exception {
		DAO.begin();
		Musica m = (Musica) daoproduto.listarPorNome(nome);
		if(m!=null)
			throw new Exception("Música " + nome + " já cadastrada");
		m = new Musica(nome, preco, ano, album, ar, duracao);
		daoproduto.create(m);
		DAO.commit();
		return (Musica) m;
	}
	
	public static Artista cadastrarArtista(String nome, String nac, int num) throws Exception {
		DAO.begin();
		Artista a = daoartista.buscaPorNome(nome);
		if (a!=null)
			throw new Exception("Artista " + nome + "já cadastrado");
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
		g = new Genero();
		daogenero.create(g);
		DAO.commit();
		return (Genero) g;
	}

}
