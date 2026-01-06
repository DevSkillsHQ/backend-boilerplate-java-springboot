package co.devskills.springbootboilerplate.error;


public class NotFoundException extends RuntimeException {
    public NotFoundException(String message) {
        super(message);
    }
}