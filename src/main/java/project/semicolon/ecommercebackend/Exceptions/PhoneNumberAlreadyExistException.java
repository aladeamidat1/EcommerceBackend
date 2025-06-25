package project.semicolon.ecommercebackend.Exceptions;

public class PhoneNumberAlreadyExistException extends RuntimeException {
  public PhoneNumberAlreadyExistException(String message) {
    super(message);
  }
}
