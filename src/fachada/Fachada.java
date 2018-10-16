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
			throw new Exception("�lbum " + nome + " j� cadastrado");
		a = new Album(nome, preco, ano, ar, faixas);
		if(a.getAno()<1500)
			throw new Exception("Ano "+a.getAno()+" n�o permitido para cadastro");
		if(a.getPreco()<0)
			throw new Exception("Pre�o incorreto, n�o existe pre�o negativo");
		if(a.getFaixas()<0)
			throw new Exception("N�mero de faixas incorreto");
		if(a.getNome() == null)
			throw new Exception("Nome de produto incorreto");
		if(a.getArtista() == null)
			throw new Exception("N�o existe �lbum sem artista");
		ar.adicionar(a);
		 daoproduto.create(a);
		DAO.commit();
		return (Album) a;
	}
	
	public static Musica cadastrarMusica (String nome, double preco, int ano, Album album, Artista ar, int duracao) throws Exception {
		DAO.begin();
		Musica m = (Musica) daoproduto.listarPorNome(nome);
		if(m!=null)
			throw new Exception("M�sica " + nome + " j� cadastrada");
		m = new Musica(nome, preco, ano, album, ar, duracao);
		if(m.getPreco()<0)
			throw new Exception("Pre�o incorreto, n�o existe pre�o negativo");
		if(m.getAlbum()==null)
			throw new Exception("Erro! �lbum n�o informado");
		if(m.getNome() == null)
			throw new Exception("Nome de produto incorreto");
		if(m.getArtista() == null)
			throw new Exception("N�o existe m�sica sem artista");
		if(m.getDuracao()<60)
			throw new Exception("Dura��o de m�sica menor que o permitido");
		ar.adicionar(m);
		album.adicionarMusica(m);
		daoartista.update(ar);
		daoproduto.update(album);
		DAO.commit();
		return (Musica) m;
	}
	
	public static Artista cadastrarArtista(String nome, String nac, int num) throws Exception {
		DAO.begin();
		Artista a = daoartista.buscaPorNome(nome);
		if (a!=null)
			throw new Exception("Artista " + nome + " j� cadastrado");
		a = new Artista(nome, nac, num);
		if(a.getNumIntegrantes()<1)
			throw new Exception("N�o existem artistas com menos de 1 integrante");
		if(a.getNacionalidade() == null)
			throw new Exception("Erro!! O artista precisa ter uma nacionalidade");
		if(a.getNome() == null)
			throw new Exception("Erro!! O artista precisa ter um nome");
		daoartista.create(a);
		DAO.commit();
		return (Artista) a;
	}
	
	public static Genero cadastrarGenero(String nome) throws Exception{
		DAO.begin();
		Genero g = daogenero.buscaGenero(nome);
		if (g!=null)
			throw new Exception("G�nero " + nome + " existente");
		g = new Genero(nome);
		daogenero.create(g);
		DAO.commit();
		return (Genero) g;
	}
	
	public static Genero cadastrarGenero(String nome, ArrayList<Album> a) throws Exception{
		DAO.begin();
		Genero g = daogenero.buscaGenero(nome);
		if (g!=null)
			throw new Exception("G�nero " + nome + " existente");
		g = new Genero(nome, a);
		if(g.getAlbuns() == a)
			throw new Exception("Esse �lbum j� pertence ao g�nero " + nome);
		daogenero.create(g);
		DAO.commit();
		return (Genero) g;
	}
	//Remo��es (DELETIONS)
	public static Album removerAlbum(String nome) throws Exception {
		DAO.begin();
		Album a = (Album) daoproduto.listarPorNome(nome);
		if (a == null)
			throw new Exception("�lbum " + nome + " inexistente");
		daoproduto.delete(a);
		DAO.commit();
		return a;
	}
	
	public static Musica removerMusica(String nome) throws Exception {
		DAO.begin();
		Musica m = (Musica) daoproduto.listarPorNome(nome);
		if(m == null)
			throw new Exception ("M�sica " + nome + " inexistente");
		daoproduto.delete(m);
		DAO.commit();
		return m;
	}
	
	public static Artista removerArtista(String nome) throws Exception{
		DAO.begin();
		Artista a = daoartista.buscaPorNome(nome);
		if (a == null)
			throw new Exception ("Artista " + nome + " n�o cadastrado");
		daoartista.delete(a);
		DAO.commit();
		return a;
	}
	
	public static Genero removerGenero(String nome) throws Exception {
		DAO.begin();
		Genero g = daogenero.buscaGenero(nome);
		if (g == null)
			throw new Exception ("G�nero " + nome + " inexistente");
		daogenero.delete(g);
		DAO.commit();
		return g;
	}
	
	//Atualiza��es (UPDATES)
	public static void atualizarAlbum(String nome, String novo) throws Exception{
		DAO.begin();
		Album a = (Album) daoproduto.listarPorNome(nome);
		if (a == null)
			throw new Exception ("�lbum " + nome + " n�o cadastrado");
		a.setNome(novo);
		a = (Album) daoproduto.update(a);
		DAO.commit();
	}
	
	public static void atualizarMusica(String nome, String novo) throws Exception{
		DAO.begin();
		Musica m = (Musica) daoproduto.listarPorNome(nome);
		if (m == null)
			throw new Exception ("M�sica " + nome + " n�o cadastrado");
		m.setNome(novo);
		m = (Musica) daoproduto.update(m);
		DAO.commit();
	}
	
	public static void atualizarArtista(String nome, String novo) throws Exception{
		DAO.begin();
		Artista a = daoartista.buscaPorNome(nome);
		if (a == null)
			throw new Exception ("�lbum " + nome + " n�o cadastrado");
		a.setNome(novo);
		a = daoartista.update(a);
		DAO.commit();
	}
	
	public static void atualizarGenero(String nome, String novo) throws Exception{
		DAO.begin();
		Genero g = daogenero.buscaGenero(nome);
		if (g == null)
			throw new Exception ("G�nero " + nome + " n�o cadastrado");
		g.setNome(novo);
		g = daogenero.update(g);
		DAO.commit();
	}
	
	//Listagem (READ)
	
	public static String listarAlbum() {
		List<Produto> albuns = daoproduto.readAll();
		String texto = "--- Listagem de �lbuns --- \n";
		for(Produto a: albuns) {
			if(a instanceof Album)
				texto+= a.getNome() + "\n" ;
		}
		return texto;
	}
	
	public static String listarMusicasCadastradas() {
		List<Produto> musicas = daoproduto.readAll();
		String texto = "--- Listagem de M�sicas --- \n";
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
	
	// M�TODOS PERSONALIZADOS
	public static void  relacionaAlbum (String nome, String album) throws Exception {
		DAO.begin();
		Genero g = daogenero.buscaGenero(nome);
		Album a = (Album) daoproduto.listarPorNome(album);
		if (g == null)
			throw new Exception ("G�nero " + nome + " n�o cadastrado");
		if (a == null)
			throw new Exception ("�lbum " + album + " n�o cadastrado");
		a.adicionarGenero(g);
		daogenero.update(g);
		DAO.commit();
	}
	
	public static String consultaGenerosPelaMusica (String nome) throws Exception {
		List<Genero> generos = daogenero.listaGeneros(nome);
		String texto = "Listagem dos g�neros do �lbum: " ;
		if (generos.isEmpty()) {
			texto = " N�o existem g�neros para esse �lbum";
		}
		else {
		for(Genero g: generos)
			texto += g.getNome()+ " \n";
		}
		return texto;
	}
	
	public static String consultaArtistasPorGenero(String nome) throws Exception{
		List<Artista> artistas = daoartista.listaArtistasPorGenero(nome);
		String texto = "Listagem de artistas pelo g�nero " + nome + ": ";
		if(artistas.isEmpty())
			texto = "N�o existem artistas cadastrados para esse g�nero";
		for(Artista a: artistas)
			texto += a.getNome()+" \n";
		return texto;
	}
	
/*	public static String consultarMusicasPorGenero(String nome) throws Exception{
		List<Musica> musicas = daoproduto.buscarMusicas(nome);
		String texto = "Listagem de m�sicas pelo g�nero " + nome + " :" ;
		if(musicas.isEmpty())
			texto = "N�o existem m�sicas cadastradas para esse g�nero";
		for(Musica m: musicas)
			texto+= m.getNome()+" \n";
		return texto;
	} */
	
	public static String consultaGenerosPorArtista(String nomeArtista) throws Exception{
		List<Genero> generos = daogenero.listaGenerosPorArtista(nomeArtista);
		String texto = "Listagem de g�neros do artista " + nomeArtista + " :";
		if(generos.isEmpty())
			texto = "N�o existem g�neros cadastrados para o artista " + nomeArtista;
		for(Genero g: generos)
			texto += g.getNome()+" \n";
		return texto;
	}

}
