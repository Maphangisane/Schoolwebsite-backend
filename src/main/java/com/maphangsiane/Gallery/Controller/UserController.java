package com.maphangsiane.Gallery.Controller;

import com.maphangsiane.Gallery.DTO.UserDTO;
import com.maphangsiane.Gallery.Entity.Image;
import com.maphangsiane.Gallery.Entity.User;
import com.maphangsiane.Gallery.Mapper.UserMapper;
import com.maphangsiane.Gallery.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static com.maphangsiane.Gallery.Mapper.UserMapper.toDTO;

@RestController
@RequestMapping("/api/users")
@CrossOrigin(origins = "http://localhost:3000")
public class UserController {

	@Autowired
	private UserService userService;

	// Create new user
//	@PostMapping("/save")
//	public ResponseEntity<User> createUser(@RequestBody User user){
//		User savedUser = userService.saveUser(user);
//		return new ResponseEntity<>(savedUser, HttpStatus.CREATED);
//	}

	@PostMapping("/save")
	public ResponseEntity<UserDTO> createUser(@RequestBody UserDTO userDTO) {
		// Convert UserDTO to User entity using the mapper
		User user = UserMapper.toEntity(userDTO);

		// Save the user
		User savedUser = userService.saveUser(user);

		// Convert the saved user back to DTO using the mapper for the response
		UserDTO savedUserDTO = toDTO(savedUser);

		return new ResponseEntity<>(savedUserDTO, HttpStatus.CREATED);
	}



	// retrieve a user by ID
//	@GetMapping("/{id}")
//	public ResponseEntity<Optional<User>> getUserById(@PathVariable Long id) {
//		Optional<User> user = userService.findById(id);
//		if (user.isPresent()) {
//			return new ResponseEntity<>(user, HttpStatus.OK);
//		} else {
//			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//		}
//	}

	@GetMapping("/{id}")
	public ResponseEntity<UserDTO> getUserById(@PathVariable Long id) {
		Optional<User> userOptional = userService.findById(id);

		if (userOptional.isPresent()) {
			// Convert the User entity to a UserDTO
			UserDTO userDTO = toDTO(userOptional.get());
			return new ResponseEntity<>(userDTO, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	// Get all users
//	@GetMapping("/all")
//	public ResponseEntity<List<User>> getAllUsers(){
//		List<User> users = userService.getAllUsers();
//		return new ResponseEntity<>(users, HttpStatus.OK);
//	}
	@GetMapping("/all")
	public ResponseEntity<List<UserDTO>> getAllUsers() {
		List<User> users = userService.getAllUsers();

		// Convert the list of User entities to a list of UserDTOs using the UserMapper
		List<UserDTO> userDTOs = users.stream()
				.map(UserMapper::toDTO)
				.collect(Collectors.toList());

		return new ResponseEntity<>(userDTOs, HttpStatus.OK);
	}

	// Update user by id
//	@PutMapping("/{id}")
//	public User updateUser(@PathVariable Long id, @RequestBody User updatedUser) {
//		return userService.updateUser(id, updatedUser);
//	}

	@PutMapping("/{id}")
	public ResponseEntity<UserDTO> updateUser(@PathVariable Long id, @RequestBody UserDTO updatedUserDTO) {
		// Convert the updatedUserDTO to a User entity using the UserMapper
		User updatedUser = UserMapper.toEntity(updatedUserDTO);

		// Update the user and get the updated entity
		User updatedUserEntity = userService.updateUser(id, updatedUser);

		// Convert the updatedUserEntity to a UserDTO using the UserMapper
		UserDTO updatedUserDTOResponse = UserMapper.toDTO(updatedUserEntity);

		return new ResponseEntity<>(updatedUserDTOResponse, HttpStatus.OK);
	}

	// Delete user by id
	@DeleteMapping("/{id}")
	public void deleteUser(@PathVariable Long id) {
		userService.deleteUser(id);
	}

/**
 	// upload image
	@PostMapping("/upload/{user_id}")
	public void uploadImage(@RequestBody Image image, @PathVariable Long user_id){

		User user = userService.findById(user_id).get();
		List<Image> images = user.getImages();
		image.add(image);
		user.setImages(images);
		userService.save(user);
	}
	**/
}