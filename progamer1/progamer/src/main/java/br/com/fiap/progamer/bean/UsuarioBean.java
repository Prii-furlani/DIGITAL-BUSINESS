package br.com.fiap.progamer.bean;

import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

import br.com.fiap.progamer.dao.UsuarioDao;
import br.com.fiap.progamer.model.Usuario;

@ManagedBean
public class UsuarioBean {

	private Usuario usuario = new Usuario();

	public void save() {

		new UsuarioDao().save(usuario);

		FacesMessage mensagem = new FacesMessage("Usuario cadastrado com sucesso!");
		FacesContext.getCurrentInstance().addMessage(null, mensagem);
	}

	public List<Usuario> getUsuarios() {
		return new UsuarioDao().getAll();
	}

	public String login() {
		boolean exist = new UsuarioDao().exist(this.usuario);
		if (exist) {
			FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("usuario", usuario);
			return "index?faces-redirect=true";
		} else {
			FacesContext.getCurrentInstance().getExternalContext().getFlash().setKeepMessages(true);
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR, "Login Inválido", "Erro"));
		}
		return "login?faces-redirect=true";
	}
	
	public String logout() {
		FacesContext.getCurrentInstance().getExternalContext().getSessionMap().remove("usuario");
		return "login?faces-redirect=true";
	}

	public void deletar() {
		System.out.println("Irei Deletar!!");
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

}
