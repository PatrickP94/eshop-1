package eshop;

import javax.faces.application.Application;
import javax.faces.application.ViewHandler;
import javax.faces.component.UIViewRoot;
import javax.faces.context.FacesContext;
import javax.faces.event.PhaseEvent;
import javax.faces.event.PhaseId;
import javax.faces.event.PhaseListener;

public class ForceLoginPhaseListener implements PhaseListener{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -425282475849776893L;

	public PhaseId getPhaseId(){
		return PhaseId.RENDER_RESPONSE;
	}
	
	public void beforePhase(PhaseEvent even){
		FacesContext context = FacesContext.getCurrentInstance();
		String viewId = context.getViewRoot().getViewId();
		if(viewId.equals("/confirm.xhtml")){
			Application app = context.getApplication();
			UserHolder uh = (UserHolder) app.evaluateExpressionGet(context, "#{uh}",UserHolder.class);
			if(uh.getCurrentUser() == null){
				uh.setOriginalViewId(viewId);
				ViewHandler viewHandler = app.getViewHandler();
				UIViewRoot viewRoot = viewHandler.createView(context, "/login.xhtml");
				context.setViewRoot(viewRoot);
			}
		}
	}
	
	public void afterPhase(PhaseEvent event){
		
	}
}
