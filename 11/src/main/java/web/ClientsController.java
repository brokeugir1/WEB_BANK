package web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ClientsController {
	@GetMapping("/clients")
	public String clients() {
		return "clients";
	}

	@GetMapping("/client")
	public String clients(@RequestParam(name = "clientId", required = false) long clientId, Model model) {
		model.addAttribute("clientId", clientId);
		return "client";
	}

	@GetMapping("/addclient")
	public String addClient() {
		return "addclient";
	}
	
	@GetMapping("/depositmoney")
	public String depositMoney() {
		return "depositmoney";
	}
	
	@GetMapping("/withdrawmoney")
	public String withdrawMoney() {
		return "withdrawmoney";
	}
	
	@GetMapping("/transfermoney")
	public String transferMoney() {
		return "transfermoney";
	}
	
	@GetMapping("/deleteuser")
	public String deleteUser() {
		return "deleteuser";
	}
}
