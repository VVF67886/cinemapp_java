package it.vvf.cinemapp.exceptions;

public class BadRequestException extends RuntimeException {
    /**
	 * 
	 */
	private static final long serialVersionUID = -1140365280556407629L;

	public BadRequestException(String message) {
        super(message);
    }
}
