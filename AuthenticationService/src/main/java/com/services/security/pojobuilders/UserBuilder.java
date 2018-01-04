package com.services.security.pojobuilders;

import com.services.security.pojos.User;

public class UserBuilder{
	private User user;
	public UserBuilder(){
	}
	
   public UserBuilder buildUser() {
	   this.user= new User();
	   return this;
   }
   
   public  UserBuilder withUserName(String username) {
	   this.user.setUsername(username);
	   return this;
   }
   
   public UserBuilder withUserEmail(String email) {
	   this.user.setEmail(email);
	   return this;
   }
   public UserBuilder withUserPassword(String password) {
	   this.user.setPassword(password);
	   return this;
   }
   public UserBuilder userisActivated(boolean activationStatus) {
	   this.user.setActivated(activationStatus);
	   return this;
   }
   public UserBuilder withUserAuthorities(String[] authorities) {
	   this.user.setAuthorities(authorities);
	   return this;
   }
   
   public User getUser() {
	   return user;
   }
}
