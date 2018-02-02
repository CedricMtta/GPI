package io.swagger.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import io.swagger.model.Image;

public interface ImageRepository extends JpaRepository<Image, Long> {
	
}
