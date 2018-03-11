package io.swagger.api;

@SuppressWarnings("serial")
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2018-01-16T20:34:37.063Z")

/**
 * 
 * Class for the exception "not found" associate :
 * -a code
 * -a message
 * 
 */
public class NotFoundException extends ApiException {
    public NotFoundException (String msg) {
        super(msg);
    }
}
