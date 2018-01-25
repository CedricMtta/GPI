package io.swagger.api;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.ApiParam;
import io.swagger.model.Image;
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2018-01-16T20:34:37.063Z")

@RestController
public class ImageApiController implements ImageApi {



    public ResponseEntity<Image> createImageUsingPOST(@ApiParam(value = "image" ,required=true )  @Valid @RequestBody Image image) {
        // do some magic!
        return new ResponseEntity<Image>(HttpStatus.OK);
    }

    public ResponseEntity<Void> deleteImageUsingDELETE(@ApiParam(value = "id",required=true ) @PathVariable("id") Long id) {
        // do some magic!
        return new ResponseEntity<Void>(HttpStatus.OK);
    }

    public ResponseEntity<List<Image>> getAllImagesUsingGET() {
    	List<Image> images = new ArrayList<Image>();
        return new ResponseEntity<List<Image>>(images, HttpStatus.OK);
    }

    public ResponseEntity<Image> getImageUsingGET(@ApiParam(value = "id",required=true ) @PathVariable("id") Long id) {
        // do some magic!
        return new ResponseEntity<Image>(HttpStatus.OK);
    }

    public ResponseEntity<Image> updateImageUsingPUT(@ApiParam(value = "id",required=true ) @PathVariable("id") Long id) {
        // do some magic!
        return new ResponseEntity<Image>(HttpStatus.OK);
    }

}
