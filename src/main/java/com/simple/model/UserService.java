package com.simple.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepository;
	public UserModel registerUser(String login,String password,String email) {
		if(login ==null && password ==null) {
			return null;
		}else {
			if(userRepository.findFirstByLogin(login).isPresent()) {
				System.out.println("Duplicate Login");
				return null;
			}
			UserModel usermodel = new UserModel();
			usermodel.setLogin(login);
			usermodel.setPassword(password);
			usermodel.setEmail(email);
			return userRepository.save(usermodel);
			
		}
		
	}
	
	public UserModel authenticates(String login,String password) {
		return userRepository.findByLoginAndPassword(login, password).orElse(null);
		
	}

}
