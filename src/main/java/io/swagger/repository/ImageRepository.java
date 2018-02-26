package io.swagger.repository;

import org.springframework.data.repository.PagingAndSortingRepository;

import io.swagger.model.Image;

public interface ImageRepository extends PagingAndSortingRepository<Image, Long> {
	
}
