package br.com.fiap.progamer.bean;

import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

import br.com.fiap.progamer.dao.SetupDao;
import br.com.fiap.progamer.model.Setup;

@ManagedBean
public class SetupBean {
	
	private Setup setup = new Setup();

	public void save() {
		new SetupDao().save(setup);
		
		FacesMessage mensagem = new FacesMessage("Setup cadastrado com Sucesso!");
		FacesContext.getCurrentInstance().addMessage(null, mensagem);
	}
	
	public void deletar() {
		System.out.println("Irei Deletar!!");
	}
	
	public List<Setup> getSetups() {
		return new SetupDao().getAll();
	}
	
	public Setup getSetup() {
		return setup;
	}
	
	public void setSetup(Setup setup) {
		this.setup = setup;
	}
	
}
