package no.ntnu.mathieno.inventorymanager.backend.exceptions;

/**
 * Custom exception class that will be thrown if a string is invalid.
 *
 * @author Mathias Erik Nord
 * @version 0.0.1
 * @since 08.03.2025
 */
public class InvalidStringException extends RuntimeException {

  /**
   * Exception that will be thrown.
   *
   * @param message the message to display.
   */
  public InvalidStringException(String message) {
    super(message);
  }
}
