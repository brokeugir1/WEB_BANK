package web;
import java.util.List;
public class InvalidDepositMoneyRequestException extends RuntimeException {
InvalidDepositMoneyRequestException(List<String> errors) {
super("Errors:" + String.join(";", errors));
}
}
