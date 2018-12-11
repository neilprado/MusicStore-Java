package daojpa;

import java.util.List;

import com.db4o.query.Query;

import modelo.Genero;
import modelo.Musica;
import modelo.Produto;

public class DAOProduto extends DAO<Produto> {
	/*
	public Produto listarPorNome(String nome) {
		Query q = manager.query();
		q.constrain(Produto.class);
		q.descend("nome").constrain(nome);
		List<Produto> resultado = q.execute();
		if(resultado.size() > 0)
			return resultado.get(0);
		return null;
	}
	
/*	public List<Musica> buscarMusicas(String genero){
		Query q = manager.query();
		q.constrain(Produto.class);
		q.descend("nome").descend("generos").descend("nome").constrain(genero);
		List<Musica> resultados = q.execute();
		if(resultados.size()>0)
			return resultados;
		return null;
	}
*/	
} 
