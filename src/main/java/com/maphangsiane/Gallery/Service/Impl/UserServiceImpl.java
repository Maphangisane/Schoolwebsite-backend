package com.maphangsiane.Gallery.Service.Impl;

import com.maphangsiane.Gallery.Entity.User;
import com.maphangsiane.Gallery.Repository.UserRepository;
import com.maphangsiane.Gallery.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

	// dependency injection
	@Autowired
	private UserRepository userRepository;

	// create new user
	@Override
	public User saveUser(User user) {
		return (User) userRepository.save(user);
	}

	// get user by id
	@Override
	public Optional<User> findById(Long id) {
		return userRepository.findById(id);
	}

	// gets all users
	@Override
	public List<User> getAllUsers() {
		return userRepository.findAll();
	}

	// Update user by id
	@Override
	public User updateUser(Long id, User updatedUser) {
		Optional<User> optionalUser = userRepository.findById(id);

		if (optionalUser.isPresent()) {
			User existingUser = optionalUser.get();
			// Update the fields you want to change
			existingUser.setUsername(updatedUser.getUsername());
			// Update other fields as needed

			// Save and return the updated user
			return userRepository.save(existingUser);
		} else {
			// Handle the case where the user with the given id is not found
			// You can throw an exception, return a specific response, etc.
			// For simplicity, let's throw an IllegalArgumentException
			throw new IllegalArgumentException("User not found with id: " + id);
		}
	}

	// Delete user by id
	@Override
	public void deleteUser(Long id) {
		userRepository.deleteById(id);
	}
}
