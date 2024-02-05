package com.maphangsiane.Gallery.DTO;

public class ImageDTO {
	private Long id;
	private String imageUrl;
	private Long userId;

	// Constructors, getters, setters, etc.

	public ImageDTO() {
		// Default constructor
	}

	public ImageDTO(Long id, String imageUrl, Long userId) {
		this.id = id;
		this.imageUrl = imageUrl;
		this.userId = userId;
	}

	// Getters and Setters

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}
}
