package hide.MemberSystem.model.vo;

import java.io.Serializable;

public class Member implements Serializable {
	
	private static final long serialVersionUID = 1345L;
	
	private int userNo;
	private String userId;
	private String userPassword;
	private String userName;
	private String userPhone;
	private String Address;
	private int userAge;
	private String gender;
	
	public Member() { super(); }

	public Member(int userNo, String userId, String userPassword, String userName, String userPhone, String address,
			int userAge, String gender) {
		super();
		this.userNo = userNo;
		this.userId = userId;
		this.userPassword = userPassword;
		this.userName = userName;
		this.userPhone = userPhone;
		this.Address = address;
		this.userAge = userAge;
		this.gender = gender;
	}
	

	public Member(String userId, String userPassword) {
		super();
		this.userId = userId;
		this.userPassword = userPassword;
	}

	public Member(String userId, String userPassword, String userName, String userPhone, String address, int userAge,
			String gender) {
		super();
		this.userId = userId;
		this.userPassword = userPassword;
		this.userName = userName;
		this.userPhone = userPhone;
		this.Address = address;
		this.userAge = userAge;
		this.gender = gender;
	}

	@Override
	public String toString() {
		return "Member [userNo=" + userNo + ", userId=" + userId + ", userPassword=" + userPassword + ", userName="
				+ userName + ", userPhone=" + userPhone + ", Address=" + Address + ", userAge=" + userAge + ", gender="
				+ gender + "]";
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public int getUserNo() {
		return userNo;
	}

	public String getUserId() {
		return userId;
	}

	public String getUserPassword() {
		return userPassword;
	}

	public String getUserName() {
		return userName;
	}

	public String getUserPhone() {
		return userPhone;
	}

	public String getAddress() {
		return Address;
	}

	public int getUserAge() {
		return userAge;
	}

	public String getGender() {
		return gender;
	}

	public void setUserNo(int userNo) {
		this.userNo = userNo;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public void setUserPhone(String userPhone) {
		this.userPhone = userPhone;
	}

	public void setAddress(String address) {
		Address = address;
	}

	public void setUserAge(int userAge) {
		this.userAge = userAge;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

}
