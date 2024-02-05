package com.maphangsiane.Gallery.Service;

import com.maphangsiane.Gallery.Entity.Image;

import java.util.List;
import java.util.Optional;

public interface ImageService {
	// create a new image
	Image saveImage(Long UserId, Image image);
	// get an image by ID
	Optional<Image> findImageById(Long id);
	// get all images by user ID
	List<Image> getImagesByUserId(Long userId);
	// get all images
	List<Image> getAllImages();
	// Update an existing image
	Image updateImage(Long id, Image updatedImage);
	// Delete an image by ID
	public void deleteImage(Long id);
}
