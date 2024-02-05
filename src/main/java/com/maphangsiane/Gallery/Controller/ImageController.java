package com.maphangsiane.Gallery.Controller;

import com.maphangsiane.Gallery.DTO.ImageDTO;
import com.maphangsiane.Gallery.DTO.UserDTO;
import com.maphangsiane.Gallery.Entity.Image;
import com.maphangsiane.Gallery.Entity.User;
import com.maphangsiane.Gallery.Mapper.ImageMapper;
import static com.maphangsiane.Gallery.Mapper.ImageMapper.imageToImageDTO;
import static com.maphangsiane.Gallery.Mapper.ImageMapper.imageDTOToImage;
import com.maphangsiane.Gallery.Service.ImageService;
import com.maphangsiane.Gallery.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/images")
@CrossOrigin(origins = {"http://localhost:3000", "http://localhost:3001"})
public class ImageController {
	@Autowired
	private ImageService imageService;

	@Autowired
	private UserService userService;
	/***
	@PostMapping("/{userId}/upload")
	public ResponseEntity<Image> addImage(@PathVariable Long userId, @RequestBody Image image) {
		Image savedImage = imageService.saveImage(userId, image);
		return new ResponseEntity<>(savedImage, HttpStatus.CREATED);
	}
	 */
//	@PostMapping("/{userId}")
//	public ResponseEntity<ImageDTO> addImage(@PathVariable Long userId, @RequestBody ImageDTO imageDTO) {
//		// Convert ImageDTO to Image entity if needed
//		Image image = new Image();
//		image.setImageUrl(imageDTO.getImageUrl());
//
//		// Assuming you have a method in your service to save the image
//		Image savedImage = imageService.saveImage(userId, image);
//
//		// Convert the saved Image entity to ImageDTO for response
//		ImageDTO savedImageDTO = new ImageDTO();
//		savedImageDTO.setImageUrl(savedImage.getImageUrl());
//
//		return new ResponseEntity<>(savedImageDTO, HttpStatus.CREATED);
//	}

	// create a new image with user id
	@PostMapping("/{userId}/upload")
	public ResponseEntity<ImageDTO> addImage(@PathVariable Long userId, @RequestBody ImageDTO imageDTO) {
		// Convert ImageDTO to Image entity using the mapper
		Image image = ImageMapper.imageDTOToImage(imageDTO);

		// Assuming you have a method in your service to save the image
		Image savedImage = imageService.saveImage(userId, image);

		// Convert the saved Image entity to ImageDTO using the mapper for response
		ImageDTO savedImageDTO = ImageMapper.imageToImageDTO(savedImage);

		return new ResponseEntity<>(savedImageDTO, HttpStatus.CREATED);
	}

	// Get image by id
	/*
	@GetMapping("/{userId}")
	public ResponseEntity<List<Image>> getImagesByUserId(@PathVariable Long userId) {
		List<Image> images = imageService.getImagesByUserId(userId);
		return new ResponseEntity<>(images, HttpStatus.OK);
	}
	 */

	// Get image by id using DTO and Mapper
	@GetMapping("/{imageId}")
	public ResponseEntity<ImageDTO> getImageById(@PathVariable Long imageId) {
		Optional<Image> image = imageService.findImageById(imageId);

		if (image.isPresent()) {
			// Convert Image entity to ImageDTO using the mapper
			ImageDTO imageDTO = ImageMapper.imageToImageDTO(image.get());
			return new ResponseEntity<>(imageDTO, HttpStatus.OK);
		} else {
			// Handle the case where the image with the given id is not found
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	// Endpoint to get all images by user ID
//	@GetMapping("/user/{userId}")
//	public ResponseEntity<List<Image>> getImagesByUserId(@PathVariable Long userId) {
//		List<Image> images = imageService.getImagesByUserId(userId);
//		return new ResponseEntity<>(images, HttpStatus.OK);
//	}

	// Get all images by user ID using DTO and Mapper
	@GetMapping("/user/{userId}")
	public ResponseEntity<List<ImageDTO>> getImagesByUserId(@PathVariable Long userId) {
		List<Image> images = imageService.getImagesByUserId(userId);

		// Convert List<Image> to List<ImageDTO> using the mapper
		List<ImageDTO> imageDTOs = images.stream()
				.map(ImageMapper::imageToImageDTO)
				.collect(Collectors.toList());

		return new ResponseEntity<>(imageDTOs, HttpStatus.OK);
	}

//	// Endpoint to get all images
//	@GetMapping("/all")
////	public ResponseEntity<List<Image>> getAllImages() {
////		List<Image> images = imageService.getAllImages();
////		return new ResponseEntity<>(images, HttpStatus.OK);
////	}

	// Get all images using DTO and Mapper
	@GetMapping("/all")
	public ResponseEntity<List<ImageDTO>> getAllImages() {
		List<Image> images = imageService.getAllImages();

		// Convert List<Image> to List<ImageDTO> using the mapper
		List<ImageDTO> imageDTOs = images.stream()
				.map(ImageMapper::imageToImageDTO)
				.collect(Collectors.toList());

		return new ResponseEntity<>(imageDTOs, HttpStatus.OK);
	}

	// Update an existing image by id

//	@PutMapping("/{id}/update")
//	public ResponseEntity<Image> updateImage(@PathVariable Long id, @RequestBody Image updatedImage) {
//		Image updated = imageService.updateImage(id, updatedImage);
//		return new ResponseEntity<>(updated, HttpStatus.OK);
//	}

	@PutMapping("/{id}/update")
	public ResponseEntity<ImageDTO> updateImage(@PathVariable Long id, @RequestBody ImageDTO updatedImageDTO) {
		// Convert ImageDTO to Image entity using the mapper
		Image updatedImage = ImageMapper.imageDTOToImage(updatedImageDTO);

		// Assuming you have a method in your service to update the image
		Image updated = imageService.updateImage(id, updatedImage);

		// Update imageUrl specifically
		if (updatedImageDTO.getImageUrl() != null) {
			updated.setImageUrl(updatedImageDTO.getImageUrl());
		}

		// Convert the updated Image entity to ImageDTO using the mapper for response
		ImageDTO updatedImageResponseDTO = ImageMapper.imageToImageDTO(updated);

		return new ResponseEntity<>(updatedImageResponseDTO, HttpStatus.OK);
	}

	// Delete an image by ID

	@DeleteMapping("/{id}/delete")
	public ResponseEntity<String> deleteImage(@PathVariable Long id) {
		imageService.deleteImage(id);
		return new ResponseEntity<>("Image deleted successfully", HttpStatus.OK);
	}

	// update image by user id

}
