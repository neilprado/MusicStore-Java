package dao;

import java.util.List;

import com.db4o.query.Query;

import modelo.Produto;

public class DAOProduto extends DAO<Produto> {
	public Produto listarPorNome(String nome) {
		Query q = manager.query();
		q.constrain(Produto.class);
		q.descend("nome").constrain(nome);
		List<Produto> resultado = q.execute();
		if(resultado.size() > 0)
			return resultado.get(0);
		return null;
	}
	
}
