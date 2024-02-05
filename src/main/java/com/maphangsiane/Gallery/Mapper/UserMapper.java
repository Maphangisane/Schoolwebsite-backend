package com.maphangsiane.Gallery.Mapper;

import com.maphangsiane.Gallery.DTO.UserDTO;
import com.maphangsiane.Gallery.Entity.User;

import java.util.stream.Collectors;

public class UserMapper {
	public static UserDTO toDTO(User user) {
		UserDTO userDTO = new UserDTO();
		userDTO.setId(user.getId());
		userDTO.setUsername(user.getUsername());
//		userDTO.setFirstName(user.getFirstName());
//		userDTO.setLastName(user.getLastName());
//		userDTO.setEmail(user.getEmail());

		// Map images if needed
//		if (user.getImages() != null) {
//			userDTO.setImages(user.getImages().stream()
//					.map(ImageMapper::toDTO) // Assuming you have an ImageMapper class
//					.collect(Collectors.toList()));
//		}

		return userDTO;
	}

	public static User toEntity(UserDTO userDTO) {
		User user = new User();
		user.setId(userDTO.getId());
		user.setUsername(userDTO.getUsername());
//		user.setFirstName(userDTO.getFirstName());
//		user.setLastName(userDTO.getLastName());
//		user.setEmail(userDTO.getEmail());

		// Map images if needed
//		if (userDTO.getImages() != null) {
//			user.setImages(userDTO.getImages().stream()
//					.map(ImageMapper::toEntity) // Assuming you have an ImageMapper class
//					.collect(Collectors.toList()));
//		}

		return user;
	}
}
