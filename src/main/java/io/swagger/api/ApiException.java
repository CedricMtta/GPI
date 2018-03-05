package io.swagger.api;

@SuppressWarnings("serial")
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2018-01-16T20:34:37.063Z")

/**
 * 
 * Class for exception, associate :
 * -a code
 * -a message
 *
 */
public class ApiException extends Exception{
    @SuppressWarnings("unused")
	private int code;
    public ApiException (int code, String msg) {
        super(msg);
        this.code = code;
    }
}
