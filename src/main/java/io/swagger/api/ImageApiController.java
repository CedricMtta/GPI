package io.swagger.api;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
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

@RestController
public class ImageApiController implements ImageApi {
	
	@Autowired
	private ImageRepository repo;

    public ResponseEntity<Image> createImageUsingPOST(@ApiParam(value = "image" ,required=true )  @Valid @RequestBody Image image) {
    	image.setId(null);
    	image = repo.save(image);
        return new ResponseEntity<Image>(image, HttpStatus.OK);
    }

    public ResponseEntity<Void> deleteImageUsingDELETE(@ApiParam(value = "id",required=true ) @PathVariable("id") Long id) {
    	if(repo.exists(id))
    	{
    	repo.delete(id);
        return new ResponseEntity<Void>(HttpStatus.OK);
    	}
    	else
    		return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
    }

    public ResponseEntity<List<Image>> getAllImagesUsingGET() {
    	List<Image> images = new ArrayList<Image>();    	
    	images = repo.findAll();   	
        return new ResponseEntity<List<Image>>(images, HttpStatus.OK);
    }

    public ResponseEntity<Image> getImageUsingGET(@ApiParam(value = "id",required=true ) @PathVariable("id") Long id) {
    	Image image = new Image();
    	image = repo.findOne(id);
    	if(image == null)
    		return new ResponseEntity<Image>(HttpStatus.NOT_FOUND);
    	else
    		return new ResponseEntity<Image>(image,HttpStatus.OK);
    }

    public ResponseEntity<Image> updateImageUsingPUT(@ApiParam(value = "id",required=true ) @PathVariable("id") Long id, @Valid @RequestBody Image image) {
    	Image img = repo.findOne(id);
    	if(img == null)
    		return new ResponseEntity<Image>(HttpStatus.NOT_FOUND);
    	else
	    	{
    		image.setId(img.getId());
	    	img = repo.saveAndFlush(image);
	        return new ResponseEntity<Image>(img, HttpStatus.OK);
    	}
    }

	@Override
	public ResponseEntity<Void> uploadDects(Long id, MultipartFile file) {
		return new ResponseEntity<Void>(HttpStatus.OK);
	}

}
