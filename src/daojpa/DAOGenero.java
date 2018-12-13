package daojpa;
import javax.persistence.NoResultException;
import javax.persistence.Query;
import modelo.Genero;

public class DAOGenero extends DAO<Genero> {
	
	
	public Genero buscaGenero(String nome) {
		try {
			Query q = manager.createQuery("select g from Genero g where g.nome='" + nome + "'");
			return (Genero) q.getSingleResult();
		}catch(NoResultException e){
			return null;
		}
	}
	/*
	public List<Genero> listaGeneros(String album) {
		Query q = manager.query();
		q.constrain(Genero.class);
		q.descend("albuns").descend("nome").constrain(album);
		List<Genero> resultados = q.execute();
		if(resultados.size()>0)
			return resultados;
		return null;
	}
	
	public List<Genero> listaGenerosPorArtista(String artista){
		Query q = manager.query();
		q.constrain(Genero.class);
		q.descend("albuns").descend("artista").descend("nome").constrain(artista);
		List<Genero> resultados = q.execute();
		if(resultados.size()>0)
			return resultados;
		return null;
	}*/
}
