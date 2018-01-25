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

import io.swagger.annotations.ApiParam;
import io.swagger.model.Image;
import io.swagger.repository.ImageRepository;
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2018-01-16T20:34:37.063Z")

@RestController
public class ImageApiController implements ImageApi {
	
	@Autowired
	private ImageRepository repo;

    public ResponseEntity<Image> createImageUsingPOST(@ApiParam(value = "image" ,required=true )  @Valid @RequestBody Image image) {
        // do some magic!
    	repo.save(image);
        return new ResponseEntity<Image>(HttpStatus.OK);
    }

    public ResponseEntity<Void> deleteImageUsingDELETE(@ApiParam(value = "id",required=true ) @PathVariable("id") Long id) {
        // do some magic!
    	repo.delete(id);
        return new ResponseEntity<Void>(HttpStatus.OK);
    }

    public ResponseEntity<List<Image>> getAllImagesUsingGET() {
    	List<Image> images = new ArrayList<Image>();    	
    	images = repo.findAll();   	
        return new ResponseEntity<List<Image>>(images, HttpStatus.OK);
    }

    public ResponseEntity<Image> getImageUsingGET(@ApiParam(value = "id",required=true ) @PathVariable("id") Long id) {
        // do some magic!
    	Image image = new Image();
    	image = repo.findOne(id);
    	
        return new ResponseEntity<Image>(image,HttpStatus.OK);
    }

    public ResponseEntity<Image> updateImageUsingPUT(@ApiParam(value = "id",required=true ) @PathVariable("id") Long id) {
        // do some magic!
        return new ResponseEntity<Image>(HttpStatus.OK);
    }

}
