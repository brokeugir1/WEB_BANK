package domain;

import java.util.ArrayList;

public class Bank {
	public ArrayList<Client> clients;

	public Bank() {
		clients = new ArrayList<Client>();
	}

	public ArrayList<Client> getClients() {
		return clients;
	}

	public Client registryClient(String name, String email) {
		long clientId = 1000 + this.clients.size();
		Client user = new Client(name, clientId, email);
		this.clients.add(user);
		return user;

	}

	public Client findClient(long clientId) {
		for (Client user : clients) {
			if (user.getId() == clientId) {
				return user;
			}
		}
		return null;
	}

	public long getTotalAmount() {
		long balance = 0;
		for (Client user : clients) {
			balance = balance + user.getUserMoney();
		}

		return balance;
	}

	public void removeClient(Client client) {
		clients.remove(client);
	}

	public void depositMoney(long clientId, long amount, TransactionDate transactionDate) { 
		Client user = findClient(clientId);
        if (user == null) {
            System.out.println("***User not found");
            return;
        }
        user.depositMoney(amount, transactionDate);
	}
}
