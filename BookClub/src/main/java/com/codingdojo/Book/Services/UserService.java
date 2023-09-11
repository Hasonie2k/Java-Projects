package com.codingdojo.Book.Services;

import java.util.Optional;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import com.codingdojo.Book.Models.User;
import com.codingdojo.Book.Repositiories.UserRepo;
import com.codingdojo.Book.validates.LoginValidator;


@Service
public class UserService{
	@Autowired
	private UserRepo uRepo ;
	
	public User findByid(Long id) {
		return this.uRepo.findById(id).orElse(null);
	}
    
    public User register(User newUser, BindingResult result) {

    	Optional<User> potentialUser = uRepo.findByEmail(newUser.getEmail());

    	 if (potentialUser.isPresent()) {
    		  result.rejectValue("email", "Matches", "choose different email");
    	 }


        if (!newUser.getPassword().equals(newUser.getConfirm() )) {
        	 result.rejectValue("confirm", "Matches", "The Confirm Password must match Password!");
        }
        if (result.hasErrors()) {
        	return null;
        }

        String hashed = BCrypt.hashpw(newUser.getPassword(), BCrypt.gensalt());
        newUser.setPassword(hashed);
        return this.uRepo.save(newUser);
    }
    
        public User login(LoginValidator newLoginObject, BindingResult result) {
        	Optional<User> potentialUser = uRepo.findByEmail(newLoginObject.getEmail());

       	 if (potentialUser.isPresent()) {
       		 User user = potentialUser.get();
       		if(!BCrypt.checkpw(newLoginObject.getPassword(), user.getPassword())) {
       			result.rejectValue("email", "Matches", "choose different email");
       		    result.rejectValue("password", "Matches", "Invalid Password!");
       		}
       		return user;
       	 	}
       	 	else { result.rejectValue("email","Matches", "email already registered");  
       		return null;      	 
       	}
    }

}

