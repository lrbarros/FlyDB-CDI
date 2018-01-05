package controller;

import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

import model.Usuario;
import repositorio.UsuarioRepositorio;

@Named
@RequestScoped
public class UsuarioBean {

	@Inject
	private Usuario usuario;

	private List<Usuario> usuarios;

	@Inject
	private UsuarioRepositorio usuarioRepositorio;

	public void salvar() {

		FacesContext context = FacesContext.getCurrentInstance();
		try {

			usuarioRepositorio.salvar(this.usuario);
			this.usuario = new Usuario();
			context.addMessage(null, new FacesMessage("Dados salvo com sucesso!"));
		} catch (Exception e) {
			FacesMessage mensagem = new FacesMessage(e.getMessage());
			mensagem.setSeverity(FacesMessage.SEVERITY_ERROR);
			context.addMessage(null, mensagem);
		}
	}


	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public List<Usuario> getUsuarios() {
		usuarios = usuarioRepositorio.listarTodos();
		return usuarios;
	}

	public void setUsuarios(List<Usuario> usuarios) {
		this.usuarios = usuarios;
	}

}
