package model.vo;

/**
 * @author user1
 *
 */
public class Member {
	private int userNo;
	private String userName;
	private String userId;
	private String addrss;
	
	
	public Member() {
		super();
	}


	public Member(int userNo, String userName, String userId, String addrss) {
		super();
		this.userNo = userNo;
		this.userName = userName;
		this.userId = userId;
		this.addrss = addrss;
	}


	public int getUserNo() {
		return userNo;
	}


	public void setUserNo(int userNo) {
		this.userNo = userNo;
	}


	public String getUserName() {
		return userName;
	}


	public void setUserName(String userName) {
		this.userName = userName;
	}


	public String getUserId() {
		return userId;
	}


	public void setUserId(String userId) {
		this.userId = userId;
	}


	public String getAddrss() {
		return addrss;
	}


	public void setAddrss(String addrss) {
		this.addrss = addrss;
	}


	@Override
	public String toString() {
		return "Member [userNo=" + userNo + ", userName=" + userName + ", userId=" + userId + ", addrss=" + addrss
				+ "]";
	}
	
	
	
	
	
}
