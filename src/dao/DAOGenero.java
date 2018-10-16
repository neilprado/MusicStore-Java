package dao;
import java.util.List;

import com.db4o.query.Query;

import modelo.Genero;

public class DAOGenero extends DAO<Genero> {
	public Genero buscaGenero(String nome) {
		Query q = manager.query();
		q.constrain(Genero.class);
		q.descend("nome").constrain(nome);
		List<Genero> resultados = q.execute();
		if(resultados.size()>0)
			return resultados.get(0);
		return null;
	}
	
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
	}
}
