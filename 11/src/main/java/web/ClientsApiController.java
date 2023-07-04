package web;

import java.util.List;
import java.util.stream.Collectors;
import javax.validation.Valid;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import domain.Client;
import domain.Utils;

@RestController
public class ClientsApiController {
	 @GetMapping("/api/clients")
	 List<Client> clients() {
		 var bank = Utils.getBank();
         return bank.clients;
	 }
	 @GetMapping("/api/clients/{clientId}")
	 public Client get(@PathVariable long clientId) {
		 var bank = Utils.getBank();
         var client = bank.findClient(clientId);
         if (client == null)
        	 throw new ClientNotFoundException(clientId);
         return client;
	 }
	 @PostMapping("/api/clients")
	    public Client newClient(@Valid @RequestBody Client client, BindingResult bindingResult) {
		    if (bindingResult.hasErrors()) {
		    	throw new InvalidClientInfoException(bindingResult.getFieldErrors().stream()
		    			.map(x -> x.getDefaultMessage()).collect(Collectors.toList()));
		    }
		    
		    var bank = Utils.getBank();
		    var newClient = bank.registryClient(client.getName(), client.getEmail());
		    return newClient;
	 }
	 
	 @DeleteMapping("/api/clients/{clientId}")
	 public void removeClient(@PathVariable long clientId) {
		 var bank = Utils.getBank();
		 var client = bank.findClient(clientId);
		 bank.removeClient(client);
	 }
}
