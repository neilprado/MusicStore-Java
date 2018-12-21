package daojpa;
import java.util.List;

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
	
	public List<Genero> listaGeneros(String album){
		try {
			Query q = manager.createQuery("select g from Genero g join g.albuns a where a.nome='" + album + "'");
			@SuppressWarnings("unchecked")
			List<Genero> resultados = q.getResultList();
			if(resultados.size()>0)
				return resultados;
		}catch(NoResultException e) {
			System.out.println(e.getMessage());
		}
		return null;
	}
	
	public List<Genero> listaGenerosPorArtista(String artista){
		try {
			Query q = manager.createQuery("select g from Genero g join g.albuns al join al.artista a where a.nome='"+ artista + "'");
			@SuppressWarnings("unchecked")
			List<Genero> resultados = q.getResultList();
			if(resultados.size()>0)
				return resultados;
		}catch(NoResultException e) {
			System.out.println(e.getMessage());
		}
		return null;
	}
}
