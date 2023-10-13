package hw2.exception;

/**
 * Исключение, которое выбрасывается при неверных входных данных.
 */
public class InvalidInputException extends RuntimeException {
    private final String input;

    public InvalidInputException(String message, String input) {
        super(message);
        this.input = input;
    }

    public String getInput() {
        return input;
    }
}
