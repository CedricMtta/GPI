package io.swagger.api;

@SuppressWarnings("serial")
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2018-01-16T20:34:37.063Z")

public class NotFoundException extends ApiException {
    @SuppressWarnings("unused")
	private int code;
    public NotFoundException (int code, String msg) {
        super(code, msg);
        this.code = code;
    }
}
