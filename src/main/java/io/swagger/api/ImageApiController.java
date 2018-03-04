package io.swagger.api;

import java.io.IOException;
import java.util.List;

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

    public ResponseEntity<List<Image>> getAllImagesUsingGET(Pageable pageable) {
    	Page<Image> images = repo.findAll(pageable);   	
        return new ResponseEntity<List<Image>>(images.getContent(), HttpStatus.OK);
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
	    	img = repo.save(image);
	        return new ResponseEntity<Image>(img, HttpStatus.OK);
    	}
    }

	@Override
	public ResponseEntity<Void> uploadImage(Long id, MultipartFile file) {
		Image img = repo.findOne(id);
		if(img != null)
		{
			try {
				img.setFile(file.getBytes());
				img = repo.save(img);
				return new ResponseEntity<Void>(HttpStatus.OK);
			} catch (IOException e) {
				e.printStackTrace();
				return new ResponseEntity<Void>(HttpStatus.INTERNAL_SERVER_ERROR);
			}
		}
		else
			return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
	}

	@Override
	public ResponseEntity<byte[]> downloadImage(Long id) {
		Image img = repo.findOne(id);
		if(img != null && img.getFile() != null)
			return new ResponseEntity<byte[]>(img.getFile(), HttpStatus.OK);
		else
			return new ResponseEntity<byte[]>(HttpStatus.NOT_FOUND);
	}

	@Override
	public ResponseEntity<List<Image>> findByUser(Long idUtil) {
		return new ResponseEntity<List<Image>>(repo.findByIdUtilisateur(idUtil), HttpStatus.OK);
	}

}
