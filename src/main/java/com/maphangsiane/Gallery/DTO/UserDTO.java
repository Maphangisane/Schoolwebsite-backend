package com.maphangsiane.Gallery.DTO;

import java.util.List;

public class UserDTO {
	private Long id;
	private String username;
	private List<ImageDTO> images;

	// Constructors, getters, setters, etc.

	public UserDTO() {
		// Default constructor
	}

	public UserDTO(Long id, String username, List<ImageDTO> images) {
		this.id = id;
		this.username = username;
		this.images = images;
	}

	// Getters and Setters

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public List<ImageDTO> getImages() {
		return images;
	}

	public void setImages(List<ImageDTO> images) {
		this.images = images;
	}
}
