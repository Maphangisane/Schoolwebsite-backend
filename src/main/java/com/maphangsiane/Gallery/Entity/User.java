package com.maphangsiane.Gallery.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "user_id")
	private Long id;
	private String username;
//	private String firstName;
//	private String lastName;
//
//	@Column(name = "email_id", nullable = false, unique = true)
//	private String email;

	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
	private List<Image> images = new ArrayList<>();
}
