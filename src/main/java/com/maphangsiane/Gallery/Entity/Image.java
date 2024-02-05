package com.maphangsiane.Gallery.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Image {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private  Long id;
	
	@Column(columnDefinition = "LONGTEXT")
	private String imageUrl;
//	private String contentType;
//	private LocalDate publishedOn;

	@ManyToOne
	@JoinColumn(name = "user_id")
	private User user;

}
