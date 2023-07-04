package domain;

import java.util.ArrayList;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

public class Client {
	public ArrayList<Transaction> getTransactions() {
		return transactions;
	}

	private ArrayList<Transaction> transactions;

	@NotBlank(message = "Name is required")
	private String name;
	private long id;

	@NotBlank(message = "Email is required")
	@Email(message = "Email is required")
	private String email;

	public Client() {
		this.transactions = new ArrayList<Transaction>();
	}

	public Client(String name, long id, String email) {
		this.name = name;
		this.transactions = new ArrayList<Transaction>();
		this.email = email;
		this.id = id;
	}

	public long getUserMoney() {
		long balance = 0;

		for (Transaction transaction : transactions) {
			balance = balance + transaction.getAmount();
		}
		return balance;
	}

	//// new
	/*
	 * public long putUserMoney() { long balance = 0;
	 * 
	 * for (Transaction transaction : transactions) { balance = balance -
	 * transaction.getAmount(); } return balance; }
	 */
	/////
	public Transaction depositMoney(long amount, TransactionDate transactionDate) {
		long positiveAmount = Math.abs(amount);
		Transaction transaction = new Transaction(positiveAmount, transactionDate);
		addTransaction(transaction);

		return transaction;
	}

	//// new
	public Transaction withdrawMoney(long amount, TransactionDate transactionDate) {
		long negativeAmount = (-1) * amount;
		Transaction transaction = new Transaction(negativeAmount, transactionDate);
		addTransaction(transaction);

		return transaction;
	}

	////
	private void addTransaction(Transaction transaction) {
		transactions.add(transaction);
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public long getId() {
		return id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	@Override
	public String toString() {
		return name + "/" + email + "(id=" + id + ")";

	}

}
