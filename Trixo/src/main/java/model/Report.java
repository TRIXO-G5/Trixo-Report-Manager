package model;

public class Report {
	private String userId;
	private String status;
	private String reason;
	
	public Report() {}
	
	public Report(String userId, String status, String reason) {
		this.userId = userId;
		this.status = status;
		this.reason = reason;
	}
	
	public String getReason() {
		return reason;
	}
	
	public String getStatus() {
		return status;
	}
	
	public String getUserId() {
		return userId;
	}
	
	public void setReason(String reason) {
		this.reason = reason;
	}
	
	public void setStatus(String status) {
		this.status = status;
	}
	
	public void setUserId(String userId) {
		this.userId = userId;
	}
	
}
