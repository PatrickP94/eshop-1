package eshop;

import java.io.Serializable;

import javax.enterprise.context.SessionScoped;

@SessionScoped
public class UserHolder implements Serializable{

	private User currentUser;

	public User getCurrentUser() {
		return currentUser;
	}

	public void setCurrentUser(User currentUser) {
		this.currentUser = currentUser;
	}
	
	
}
