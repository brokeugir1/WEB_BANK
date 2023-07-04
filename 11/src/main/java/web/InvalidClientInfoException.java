package web;
import java.util.List;
class InvalidClientInfoException extends RuntimeException {
InvalidClientInfoException(List<String> errors) {
super("Errors:" + String.join(";", errors));
}
}