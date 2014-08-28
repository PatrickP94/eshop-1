package eshop;

import javax.enterprise.context.RequestScoped;
import javax.faces.application.Application;
import javax.faces.application.FacesMessage;
import javax.faces.application.ViewHandler;
import javax.faces.component.UIViewRoot;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

@Named
@RequestScoped
public class LoginRequest {

	private String username;
	private String password;
	
	@Inject
	private UserHolder userHolder;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	public String login(){
		if(username.equals("u1") && password.equals("p1")){
			userHolder.setCurrentUser(new User("u1", "p1", "1234"));
			String viewId = userHolder.getOriginalViewId();
			if(viewId != null){
				FacesContext context = FacesContext.getCurrentInstance();
				Application app = context.getApplication();
				ViewHandler viewHandler = app.getViewHandler();
				UIViewRoot root = viewHandler.createView(context, viewId);
				context.setViewRoot(root);
				userHolder.setOriginalViewId(null);
				return null;
			}
			return "loggedIn";
		} else {
			FacesContext context = FacesContext.getCurrentInstance();
			context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Login failed", null));
			return null;
		}
	}
}
