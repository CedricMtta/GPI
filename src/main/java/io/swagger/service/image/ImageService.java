package io.swagger.service.image;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.swagger.repository.ImageRepository;

@Service
public class ImageService {

	@Autowired
	ImageRepository imgRep;
}
