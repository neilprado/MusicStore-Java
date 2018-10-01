package dao;
import java.util.List;

import com.db4o.query.Query;

import modelo.Genero;

public class DAOGenero extends DAO<Genero> {
	public Genero buscaUnitaria(String nome) {
		Query q = manager.query();
		q.constrain(Genero.class);
		q.descend("nome").constrain(nome);
		List<Genero> resultados = q.execute();
		if(resultados.size()>0)
			return resultados.get(0);
		return null;
	}
}
