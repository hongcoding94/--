package hide.MemberSystem.model.vo;

import java.io.Serializable;

public class Member implements Serializable {
	
	private static final long serialVersionUID = 1345L;
	
	private int userNo;
	private String userId;
	private String userPssword;
	private String userName;
	private String userPhone;
	private String Address;
	private int userAge;
	private String gender;
	
	public Member() { super(); }

	public Member(int userNo, String userId, String userPssword, String userName, String userPhone, String address,
			int userAge, String gender) {
		super();
		this.userNo = userNo;
		this.userId = userId;
		this.userPssword = userPssword;
		this.userName = userName;
		this.userPhone = userPhone;
		Address = address;
		this.userAge = userAge;
		this.gender = gender;
	}

	public Member(String userId, String userPssword, String userName, String userPhone, String address, int userAge,
			String gender) {
		super();
		this.userId = userId;
		this.userPssword = userPssword;
		this.userName = userName;
		this.userPhone = userPhone;
		Address = address;
		this.userAge = userAge;
		this.gender = gender;
	}

	@Override
	public String toString() {
		return "Member [userNo=" + userNo + ", userId=" + userId + ", userPssword=" + userPssword + ", userName="
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

	public String getUserPssword() {
		return userPssword;
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

	public void setUserPssword(String userPssword) {
		this.userPssword = userPssword;
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
