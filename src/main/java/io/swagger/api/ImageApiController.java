package io.swagger.api;

import java.io.IOException;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import io.swagger.annotations.ApiParam;
import io.swagger.model.Image;
import io.swagger.repository.ImageRepository;

@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2018-01-16T20:34:37.063Z")

/**
 * Implementation of methods from ImageApi. Describe behavior of requests.
 * 
 * TODO : utiliser un logger *
 */
@RestController
public class ImageApiController implements ImageApi {

	/**
	 * Repository for image
	 */
	@Autowired
	private ImageRepository repo;

	/**
	 * Post an image in the database
	 * 
	 * @return image with status OK
	 */
	public ResponseEntity<Image> createImageUsingPOST(
			@ApiParam(value = "image", required = true) @Valid @RequestBody Image image) {
		image.setId(null);
		image = repo.save(image);
		return new ResponseEntity<Image>(image, HttpStatus.CREATED);
	}

	/**
	 * Delete an image from database with his id
	 * 
	 * @return OK if image exist, NOT_FOUD if not
	 */
	public ResponseEntity<Void> deleteImageUsingDELETE(
			@ApiParam(value = "id", required = true) @PathVariable("id") Long id) {
		if (repo.exists(id)) {
			repo.delete(id);
			return new ResponseEntity<Void>(HttpStatus.OK);
		} else
			return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
	}

	/**
	 * Get a page with images.
	 * 
	 * @return a page with images and status OK
	 */
	public ResponseEntity<Page<Image>> getAllImagesUsingGET(Pageable pageable) {
		Page<Image> images = repo.findAll(pageable);
		return new ResponseEntity<Page<Image>>(images, HttpStatus.OK);
	}

	/**
	 * Get a page by his id.
	 * 
	 * @return the image with status OK if found, status NOT_FOUND otherwise
	 */
	public ResponseEntity<Image> getImageUsingGET(
			@ApiParam(value = "id", required = true) @PathVariable("id") Long id) {
		Image image = null;
		image = repo.findOne(id);
		if (image == null)
			return new ResponseEntity<Image>(HttpStatus.NOT_FOUND);
		else
			return new ResponseEntity<Image>(image, HttpStatus.OK);
	}

	/**
	 * Update an image using his id.
	 * 
	 * @return the image modified with status OK if found, status NOT_FOUND
	 *         otherwise
	 */
	public ResponseEntity<Image> updateImageUsingPUT(
			@ApiParam(value = "id", required = true) @PathVariable("id") Long id, @Valid @RequestBody Image image) {
		Image img = repo.findOne(id);
		if (img == null)
			return new ResponseEntity<Image>(HttpStatus.NOT_FOUND);
		else {
			image.setId(img.getId());
			img = repo.save(image);
			return new ResponseEntity<Image>(img, HttpStatus.OK);
		}
	}

	/**
	 * Upload
	 */
	@Override
	public ResponseEntity<Void> uploadImage(Long id, MultipartFile file) {
		Image img = repo.findOne(id);
		if (img != null) {
			try {
				img.setFile(file.getBytes());
				repo.save(img);
				return new ResponseEntity<Void>(HttpStatus.OK);
			} catch (IOException e) {
				return new ResponseEntity<Void>(HttpStatus.INTERNAL_SERVER_ERROR);
			}
		} else
			return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
	}

	/**
	 * Get only the picture of an image using his id.
	 * 
	 * @param id
	 *            the id of the image
	 * @return a tab of bytes representing the picture with status OK if found,
	 *         status NOT_FOUND otherwise
	 */
	@Override
	public ResponseEntity<byte[]> downloadImage(Long id) {
		Image img = repo.findOne(id);
		byte[] imgFile = null;

		if (img != null && (imgFile = img.getFile()) != null)
			return new ResponseEntity<byte[]>(imgFile, HttpStatus.OK);
		else
			return new ResponseEntity<byte[]>(HttpStatus.NOT_FOUND);
	}

	/**
	 * Get a page of images from an user
	 * 
	 * @param idUtil
	 *            the id of the user
	 * @param pageable
	 *            the page for images
	 * @return a page with images from the user with status OK
	 */
	@Override
	public ResponseEntity<Page<Image>> findByUser(Long idUtil, Pageable pageable) {
		return new ResponseEntity<Page<Image>>(repo.findByIdUtilisateur(idUtil, pageable), HttpStatus.OK);
	}

}
