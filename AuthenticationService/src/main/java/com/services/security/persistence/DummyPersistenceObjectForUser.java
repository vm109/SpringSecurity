package com.services.security.persistence;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Component;

import com.services.security.pojobuilders.UserBuilder;
import com.services.security.pojos.User;

@Component 
public class DummyPersistenceObjectForUser {
private static Map<String,User> usersPersistence = new HashMap<>();
static int userid=0;
String[] defaultAuthorities = new String[1];

public DummyPersistenceObjectForUser() {
	defaultAuthorities[0]="ADMIN";
	usersPersistence.put("admin", new UserBuilder().buildUser().withUserName("admin")
			.withUserAuthorities(defaultAuthorities).withUserEmail("admin@firstmail.com").withUserPassword("password").userisActivated(true).getUser());
}
public void saveUserDetails(String username, String email, String password, boolean activationStatus, String[] authorities) {
	DummyPersistenceObjectForUser.usersPersistence.put(username, new UserBuilder().buildUser().withUserName(username).withUserEmail(email).withUserPassword(password)
			.userisActivated(activationStatus).withUserAuthorities(authorities).getUser());
}

public User findUserByUsername(String username) {
	if(DummyPersistenceObjectForUser.usersPersistence.get(username)!=null) return DummyPersistenceObjectForUser.usersPersistence.get(username); 
	else return null;
}
}
