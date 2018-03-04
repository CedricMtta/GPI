package io.swagger.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

import io.swagger.model.Image;

public interface ImageRepository extends PagingAndSortingRepository<Image, Long> {
	//Page<Image> findByIdUtilisateur(Long id, Pageable pageable);
	List<Image> findByIdUtilisateur(Long id_utilisateur);
}
