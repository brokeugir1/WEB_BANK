package web;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

public class DeleteRequest {
	public long getClientId() {
		return clientId;
	}

	public void setClientId(long clientId) {
		this.clientId = clientId;
	}
	
	@NotNull(message="Client id should have value")
	@Min(value = 1, message="Client id should be more than 0") 
	@Max(value = 100000, message="Client id should be less than 100001") 
	private long clientId;
}
