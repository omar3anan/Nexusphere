package com.RestAPIs.restfulwebservice.Server.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.RestAPIs.restfulwebservice.Server.Entity.User;
import com.RestAPIs.restfulwebservice.Server.Repository.UserDataRepository;

//Data Access Object 
@Component
public class UserDaoService {
	// private UserDataRepository theUserRepository;

	// public UserDaoService(UserDataRepository theUserRepository) {
	// super();
	// this.theUserRepository = theUserRepository;
	// }

	// public List<User> findAll() {
	// return theUserRepository.findAll();
	// }

	// public User save(User theUser) {
	// theUser.setId(0);
	// return theUserRepository.save(theUser);
	// }
	// public User findById(int id) {
	// Predicate<? super User> predicate =user-> user.getId().equals(id);
	// return users.predicate.stream.filter();
	// }

}
