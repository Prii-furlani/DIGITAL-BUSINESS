package br.com.fiap.progamer.util;

import javax.faces.application.NavigationHandler;
import javax.faces.context.FacesContext;
import javax.faces.event.PhaseEvent;
import javax.faces.event.PhaseId;
import javax.faces.event.PhaseListener;

import br.com.fiap.progamer.model.Usuario;

public class AuthorizationListener implements PhaseListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public void afterPhase(PhaseEvent event) {
		FacesContext contexto = FacesContext.getCurrentInstance();
		
		String viewId = contexto.getViewRoot().getViewId();
		
		if (viewId.equals("/login.xhtml")) return;
		
		Usuario usuario = (Usuario) contexto.getExternalContext().getSessionMap().get("usuario");
		if (usuario != null) return;
		
		NavigationHandler navigator = contexto.getApplication().getNavigationHandler();
		navigator.handleNavigation(contexto, null, "login?faces-redirect=true");
		
	}

	@Override
	public void beforePhase(PhaseEvent event) {
		// TODO Auto-generated method stub

	}

	@Override
	public PhaseId getPhaseId() {
		return PhaseId.RESTORE_VIEW;
	}

}
