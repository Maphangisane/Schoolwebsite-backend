package com.maphangsiane.Gallery.Service.Impl;

import com.maphangsiane.Gallery.Entity.Image;
import com.maphangsiane.Gallery.Entity.User;
import com.maphangsiane.Gallery.Repository.ImageRepository;
import com.maphangsiane.Gallery.Repository.UserRepository;
import com.maphangsiane.Gallery.Service.ImageService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ImageServiceImpl implements ImageService {

	// dependency injection
	@Autowired
	private ImageRepository imageRepository;

	@Autowired
	private UserRepository userRepository;

	// creates new image
	@Override
	public Image saveImage(Long userId, Image image) {
		Optional<User> optionalUser = userRepository.findById(userId);

		if (optionalUser.isPresent()) {
			User user = optionalUser.get();
			image.setUser(user);
			return (Image) imageRepository.save(image);
		} else {
			throw new EntityNotFoundException("User not found with ID: " + userId);
		}
	}

	// get image by id
	@Override
	public Optional<Image> findImageById(Long id) {
		return imageRepository.findById(id);
	}

	// get all images by user id
	@Override
	public List<Image> getImagesByUserId(Long userId) {

		return imageRepository.findByUserId(userId); // method in repo
	}

	// gets all images
	@Override
	public List<Image> getAllImages() {
		return imageRepository.findAll();
	}

	// Update an existing image
	public Image updateImage(Long id, Image updatedImage) {
		// Implement the logic to update the existing image
		// For example: find the existing image by ID, update its properties, and save it
		Image existingImage = imageRepository.findById(id).orElse(null);

		if (existingImage != null) {
			// Update properties of the existing image with the ones from the updatedImage
			existingImage.setImageUrl(updatedImage.getImageUrl());
			// Update other properties as needed

			// Save the updated image
			return imageRepository.save(existingImage);
		}

		// Handle the case when the image with the given ID is not found
		return null;
	}

	// Delete an image by ID
	public void deleteImage(Long id) {
		// Implement the logic to delete the image by ID
		imageRepository.deleteById(id);
	}
}
