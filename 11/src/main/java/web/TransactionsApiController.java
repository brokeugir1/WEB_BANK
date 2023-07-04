package web;
import java.util.List;
import java.util.stream.Collectors;
import javax.validation.Valid;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import domain.Transaction;
import domain.TransactionDate;
import domain.Utils;
@RestController
public class TransactionsApiController {
@GetMapping("/api/clients/{clientId}/transactions")
public List<Transaction> transactions(@PathVariable long clientId) {
var bank = Utils.getBank();
var client = bank.findClient(clientId);
if (client == null)
throw new ClientNotFoundException(clientId);
return client.getTransactions();
}
@PostMapping("/api/clients/{clientId}/transactions")
public Transaction depositmoney(@Valid @RequestBody DepositRequest depositRequest, @PathVariable long
clientId,
BindingResult bindingResult) {
var bank = Utils.getBank();
if (bindingResult.hasErrors()) {
throw new InvalidDepositMoneyRequestException(bindingResult.getFieldErrors().stream()
.map(x -> x.getDefaultMessage()).collect(Collectors.toList()));
}
var client = bank.findClient(clientId);
if (client == null)
throw new ClientNotFoundException(clientId);
return client.depositMoney(depositRequest.getAmount(),
new TransactionDate(depositRequest.getDay(), depositRequest.getMonth(),
depositRequest.getYear()));
}
}
