package eshop;

import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

@Named("uh")
@SessionScoped
public class UserHolder implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6095009690165268470L;
	
	private User currentUser;
	private String originalViewId;

	public String getOriginalViewId() {
		return originalViewId;
	}

	public void setOriginalViewId(String originalViewId) {
		this.originalViewId = originalViewId;
	}

	public User getCurrentUser() {
		return currentUser;
	}

	public void setCurrentUser(User currentUser) {
		this.currentUser = currentUser;
	}

}
