package daojpa;

import javax.persistence.NoResultException;
import javax.persistence.Query;
import modelo.Produto;

public class DAOProduto extends DAO<Produto> {
	
	public Produto listarPorNome(String nome) {
		try {
			Query q = manager.createQuery("select p from Produto p where p.nome='" + nome + "'");
			return (Produto) q.getSingleResult();
		}catch(NoResultException e){
			return null;
		}
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
