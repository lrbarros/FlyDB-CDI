package repositorio;

import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import interceptor.Transactional;
import model.Usuario;

public class UsuarioRepositorio {

	
	@Inject
	private EntityManager manager;

	@Transactional
	public void salvar(Usuario user) {
		manager.persist(user);
			
	}
	
	public List<Usuario> listarTodos(){
		return manager.createQuery("SELECT u FROM Usuario u").getResultList();
	}
}
