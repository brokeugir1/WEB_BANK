package domain;

import domain.TransactionDate;

public class Transaction {
private long amount;
public String type;
private TransactionDate transactionDate;
public Transaction(long amount, TransactionDate transactionDate) {
this.amount = amount;
this.transactionDate = transactionDate;
}
public long getAmount() {
return amount; // cума
}
public TransactionDate getTransactionDate() {
return transactionDate; // дата транзакції
}
}

