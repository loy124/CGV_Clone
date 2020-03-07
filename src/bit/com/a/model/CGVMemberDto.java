package bit.com.a.model;

import java.io.Serializable;

public class CGVMemberDto implements Serializable{
	private String id;
	private String password;
	private String name;
	private String phoneNumber;
	private String email;
	private String address;
	private int auth;
	private String registerDate;
	private String unRegisterDate;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public int getAuth() {
		return auth;
	}
	public void setAuth(int auth) {
		this.auth = auth;
	}
	public String getRegisterDate() {
		return registerDate;
	}
	public void setRegisterDate(String registerDate) {
		this.registerDate = registerDate;
	}
	public String getUnRegisterDate() {
		return unRegisterDate;
	}
	public void setUnRegisterDate(String unRegisterDate) {
		this.unRegisterDate = unRegisterDate;
	}
	
	
	public CGVMemberDto() {
		// TODO Auto-generated constructor stub
	}
	public CGVMemberDto(String id, String password, String name, String phoneNumber, String email, String address,
			int auth, String registerDate, String unRegisterDate) {
		super();
		this.id = id;
		this.password = password;
		this.name = name;
		this.phoneNumber = phoneNumber;
		this.email = email;
		this.address = address;
		this.auth = auth;
		this.registerDate = registerDate;
		this.unRegisterDate = unRegisterDate;
	}
	@Override
	public String toString() {
		return "CGVMemberDto [id=" + id + ", password=" + password + ", name=" + name + ", phoneNumber=" + phoneNumber
				+ ", email=" + email + ", address=" + address + ", auth=" + auth + ", registerDate=" + registerDate
				+ ", unRegisterDate=" + unRegisterDate + "]";
	}
	public CGVMemberDto(String id, String password, String name, String phoneNumber, String email, String address) {
		super();
		this.id = id;
		this.password = password;
		this.name = name;
		this.phoneNumber = phoneNumber;
		this.email = email;
		this.address = address;
	}
	public CGVMemberDto(String id, String name, String phoneNumber, String email, String address, int auth,
			String registerDate, String unRegisterDate) {
		super();
		this.id = id;
		this.name = name;
		this.phoneNumber = phoneNumber;
		this.email = email;
		this.address = address;
		this.auth = auth;
		this.registerDate = registerDate;
		this.unRegisterDate = unRegisterDate;
	}
	
	
	
	
	
}


