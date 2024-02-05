package com.maphangsiane.Gallery.Service;

import com.maphangsiane.Gallery.Entity.User;

import java.util.List;
import java.util.Optional;

public interface UserService {
	User saveUser(User user);
	Optional<User> findById(Long id);
	List<User> getAllUsers();
	// Update user by id
	User updateUser(Long id, User updatedUser);
	// Delete user by id
	 void deleteUser(Long id);
}
