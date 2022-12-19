package com.MGNREGA.model;

public class GPM {
	
	private int gmpId;
	private String name;
	private String password;
	private String address;
	
	public GPM() {
		// TODO Auto-generated constructor stub
	}

	public GPM(int gmpId, String name, String password, String address) {
		super();
		this.gmpId = gmpId;
		this.name = name;
		this.password = password;
		this.address = address;
	}

	@Override
	public String toString() {
		return "GPM [gmpId=" + gmpId + ", name=" + name + ", password=" + password + ", address=" + address + "]";
	}

	public int getGmpId() {
		return gmpId;
	}

	public void setGmpId(int gmpId) {
		this.gmpId = gmpId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	
	
	
}
