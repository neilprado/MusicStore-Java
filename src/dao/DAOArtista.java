package dao;
import java.util.List;

import com.db4o.query.Candidate;
import com.db4o.query.Evaluation;
import com.db4o.query.Query;

import modelo.Album;
import modelo.Artista;

public class DAOArtista extends DAO<Artista> {
	public Artista buscaPorNome(String nome) {
		Query q = manager.query();
		q.constrain(Artista.class);
		q.descend("nome").constrain(nome);
		List<Artista> resultados = q.execute();
		if(resultados.size()>0)
			return resultados.get(0);
		return null;
	}
	
	// Consultas
	
}

class Filtro implements Evaluation{
	private int n;
	@Override
	public void evaluate(Candidate arg0) {
		// TODO Auto-generated method stub
		
	}
}

	
