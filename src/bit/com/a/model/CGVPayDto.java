package bit.com.a.model;

import java.io.Serializable;

public class CGVPayDto implements Serializable {
	private String id;
	private int reserveSequence;
	private String payDate;
	private String payMoney;
	
	public CGVPayDto() {
		// TODO Auto-generated constructor stub
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public int getReserveSequence() {
		return reserveSequence;
	}
	public void setReserveSequence(int reserveSequence) {
		this.reserveSequence = reserveSequence;
	}
	public String getPayDate() {
		return payDate;
	}
	public void setPayDate(String payDate) {
		this.payDate = payDate;
	}
	public String getPayMoney() {
		return payMoney;
	}
	public void setPayMoney(String payMoney) {
		this.payMoney = payMoney;
	}

	public CGVPayDto(String id, int reserveSequence, String payDate, String payMoney) {
		super();
		this.id = id;
		this.reserveSequence = reserveSequence;
		this.payDate = payDate;
		this.payMoney = payMoney;
	}

	@Override
	public String toString() {
		return "CGVPayDto [id=" + id + ", reserveSequence=" + reserveSequence + ", payDate=" + payDate + ", payMoney="
				+ payMoney + "]";
	}
	
	
	
	
	
}
