package web;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

public class TransferRequest {
	public long getClientOneId() {
		return clientOneId;
	}

	public void setClientOneId(long clientId) {
		this.clientOneId = clientId;
	}
	
	public long getClientTwoId() {
		return clientTwoId;
	}

	public void setClientTwoId(long clientId) {
		this.clientTwoId = clientId;
	}
	
	public long getAmount() {
		return amount;
	}

	public void setAmount(long amount) {
		this.amount = amount;
	}
	
	public int getDay() {
		return day;
	}

	public void setDay(int day) {
		this.day = day;
	}
	
	public int getMonth() {
		return month;
	}

	public void setMonth(int month) {
		this.month = month;
	}
	
	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}
	
	@NotNull(message="Client id should have value")
	@Min(value = 1, message="Client id should be more than 0") 
	@Max(value = 100000, message="Client id should be less than 100001") 
	private long clientOneId;
	@NotNull(message="Client id should have value")
	@Min(value = 1, message="Client id should be more than 0") 
	@Max(value = 100000, message="Client id should be less than 100001") 
	private long clientTwoId;
	@NotNull(message="Amount should have value")
	@Min(value = 1, message="Amount should be more than 0") 
	@Max(value = 100000, message="Amount should be less than 100001") 
	private long amount;
	@NotNull(message="Day should have value")
	@Min(value = 1, message="Day should be more than 0")
	@Max(value = 31, message="Day should be less than 31")
	private int day;
	@NotNull(message="Month should have value")
	@Min(value = 1, message="Month should be more than 0")
	@Max(value = 12, message="Month should be less than 13")
	private int month;
	@NotNull(message="Year should have value")
	@Min(value = 1999, message="Year should be more than 1998") 
	@Max(value = 2055, message="Year should be less than 2056") 
	private int year;
}
