package vn.its.service;

import java.util.List;

import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.security.access.prepost.PreAuthorize;

import vn.its.model.User;


public interface UserService {

	List<User> findAllUsers();

	@PostAuthorize ("returnObject.type == authentication.name")
	User findById(int id);

	@PreAuthorize("hasRole('ADMIN')")
	void updateUser(User user);
	
	@PreAuthorize("hasRole('ADMIN') AND hasRole('DBA')")
	void deleteUser(int id);
}