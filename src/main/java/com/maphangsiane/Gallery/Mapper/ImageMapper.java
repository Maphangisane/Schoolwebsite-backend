package com.maphangsiane.Gallery.Mapper;

import com.maphangsiane.Gallery.DTO.ImageDTO;
import com.maphangsiane.Gallery.Entity.Image;

public class ImageMapper {


	public static ImageDTO imageToImageDTO(Image image) {
		if (image == null) {
			return null;
		}

		ImageDTO imageDTO = new ImageDTO();
		imageDTO.setId(image.getId());
		imageDTO.setImageUrl(image.getImageUrl());

		if (image.getUser() != null) {
			imageDTO.setUserId(image.getUser().getId());
		}

		return imageDTO;
	}

	public static Image imageDTOToImage(ImageDTO imageDTO) {
		if (imageDTO == null) {
			return null;
		}

		Image image = new Image();
		image.setId(imageDTO.getId());
		image.setImageUrl(imageDTO.getImageUrl());

		// Note: You may need to set the User entity for the Image entity if needed.
		// image.setUser(userService.findById(imageDTO.getUserId()));

		// Other mapping methods
/*
		public static Image imageDTOToImage(ImageDTO imageDTO) {
			if (imageDTO == null) {
				return null;
			}

			Image image = new Image();
			image.setId(imageDTO.getId());
			image.setImageUrl(imageDTO.getImageUrl());

			// Fetch the User entity and set it for the Image entity
			if (imageDTO.getUserId() != null) {
				// Assuming you have a UserService to fetch the User by ID
				User user = userService.findById(imageDTO.getUserId());
				image.setUser(user);
			}
*/
			return image;
	}
}
