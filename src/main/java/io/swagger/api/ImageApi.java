/**
 * NOTE: This class is auto generated by the swagger code generator program (2.2.3).
 * https://github.com/swagger-api/swagger-codegen
 * Do not edit the class manually.
 */
package io.swagger.api;

import java.util.List;

import javax.validation.Valid;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import io.swagger.model.Image;
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2018-01-16T20:34:37.063Z")

public interface ImageApi {

	@ApiOperation(value = "createImage", notes = "", response = Image.class, tags={ "image-resource", })
	@ApiResponses(value = { 
			@ApiResponse(code = 200, message = "OK", response = Image.class),
			@ApiResponse(code = 201, message = "Created", response = Void.class),
			@ApiResponse(code = 401, message = "Unauthorized", response = Void.class),
			@ApiResponse(code = 403, message = "Forbidden", response = Void.class),
			@ApiResponse(code = 404, message = "Not Found", response = Void.class) })

	@RequestMapping(value = "/api/images",
			produces = { "application/json" },
			method = RequestMethod.POST)
	ResponseEntity<Image> createImageUsingPOST(@ApiParam(value = "image" ,required=true )  @Valid @RequestBody Image image);


	@ApiOperation(value = "deleteImage", notes = "", response = Void.class, tags={ "image-resource", })
	@ApiResponses(value = { 
			@ApiResponse(code = 200, message = "OK", response = Void.class),
			@ApiResponse(code = 204, message = "No Content", response = Void.class),
			@ApiResponse(code = 401, message = "Unauthorized", response = Void.class),
			@ApiResponse(code = 403, message = "Forbidden", response = Void.class) })

	@RequestMapping(value = "/api/images/{id}",
	produces = { "application/json" }, 
	method = RequestMethod.DELETE)
	ResponseEntity<Void> deleteImageUsingDELETE(@ApiParam(value = "id",required=true ) @PathVariable("id") Long id);


	@ApiOperation(value = "getAllImages", notes = "", response = Image.class, responseContainer = "List", tags={ "image-resource", })
	@ApiResponses(value = { 
			@ApiResponse(code = 200, message = "OK", response = Image.class, responseContainer = "List"),
			@ApiResponse(code = 401, message = "Unauthorized", response = Void.class),
			@ApiResponse(code = 403, message = "Forbidden", response = Void.class),
			@ApiResponse(code = 404, message = "Not Found", response = Void.class) })

	@RequestMapping(value = "/api/images",
	produces = { "application/json" },
	method = RequestMethod.GET)
	ResponseEntity<Page<Image>> getAllImagesUsingGET(@ApiParam(value = "pageable", required = false) Pageable pageable);


	@ApiOperation(value = "getImage", notes = "", response = Image.class, tags={ "image-resource", })
	@ApiResponses(value = { 
			@ApiResponse(code = 200, message = "OK", response = Image.class),
			@ApiResponse(code = 401, message = "Unauthorized", response = Void.class),
			@ApiResponse(code = 403, message = "Forbidden", response = Void.class),
			@ApiResponse(code = 404, message = "Not Found", response = Void.class) })

	@RequestMapping(value = "/api/images/{id}",
	produces = { "application/json" },
	method = RequestMethod.GET)
	ResponseEntity<Image> getImageUsingGET(@ApiParam(value = "id",required=true ) @PathVariable("id") Long id);
	


	@ApiOperation(value = "updateImage", notes = "", response = Image.class, tags={ "image-resource", })
	@ApiResponses(value = { 
			@ApiResponse(code = 200, message = "OK", response = Image.class),
			@ApiResponse(code = 201, message = "Created", response = Void.class),
			@ApiResponse(code = 401, message = "Unauthorized", response = Void.class),
			@ApiResponse(code = 403, message = "Forbidden", response = Void.class),
			@ApiResponse(code = 404, message = "Not Found", response = Void.class) })

	@RequestMapping(value = "/api/images/{id}",
	produces = { "application/json" }, 
	consumes = { "application/json" },
	method = RequestMethod.PUT)
	ResponseEntity<Image> updateImageUsingPUT(@ApiParam(value = "id",required=true ) @PathVariable("id") Long id, @Valid @RequestBody Image image);
	
	@ApiOperation(value = "uploadImage", notes = "", response = Void.class, tags={ "image-resource", })
	@ApiResponses(value = { 
			@ApiResponse(code = 200, message = "OK", response = Void.class),
			@ApiResponse(code = 201, message = "Created", response = Void.class),
			@ApiResponse(code = 401, message = "Unauthorized", response = Void.class),
			@ApiResponse(code = 403, message = "Forbidden", response = Void.class),
			@ApiResponse(code = 404, message = "Not Found", response = Void.class) })
	
	@RequestMapping(value = "/api/images/{id}/uploadImage",
			consumes = { "multipart/form-data" },
			produces = { "application/json" },
			method = RequestMethod.POST)
	ResponseEntity<Void> uploadImage(@PathVariable("id") Long id,  @RequestParam("file") MultipartFile file);
	
	@ApiOperation(value = "downloadImage", notes = "", response = Void.class, tags={ "image-resource", })
	@ApiResponses(value = { 
			@ApiResponse(code = 200, message = "OK", response = Void.class),
			@ApiResponse(code = 201, message = "Created", response = Void.class),
			@ApiResponse(code = 401, message = "Unauthorized", response = Void.class),
			@ApiResponse(code = 403, message = "Forbidden", response = Void.class),
			@ApiResponse(code = 404, message = "Not Found", response = Void.class) })
	
	@RequestMapping(value = "/api/images/{id}/getImage",
			produces = { "image/jpeg" },
			method = RequestMethod.GET)
	ResponseEntity<byte[]> downloadImage(@PathVariable("id") Long id);
	
	@ApiOperation(value = "findByUser", notes = "", response = Image.class, tags={ "image-resource", })
	@ApiResponses(value = { 
			@ApiResponse(code = 200, message = "OK", response = Image.class),
			@ApiResponse(code = 401, message = "Unauthorized", response = Void.class),
			@ApiResponse(code = 403, message = "Forbidden", response = Void.class),
			@ApiResponse(code = 404, message = "Not Found", response = Void.class) })

	@RequestMapping(value = "/api/images/user",
	produces = { "application/json" },
	method = RequestMethod.GET)
	ResponseEntity<Page<Image>> findByUser(@PathVariable("idUtil") Long idUtil, Pageable pageable);
}
