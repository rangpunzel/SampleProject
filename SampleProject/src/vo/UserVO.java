package vo;

public class UserVO {	//유저 정보를 담는 클래스
	

	private String id;
	private String password;
	private String name;
	
	public String getId() {  //아이디 리턴해주는 메서드
		return id;
	}
	public void setId(String id) { //메서드로 받은 아이디로 수정해주는 메서드
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

}
