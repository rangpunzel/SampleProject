package dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

import vo.UserVO;
import data.Database;

public class UserDaoImpl implements UserDao {
	
	//UserDaoImpl 객체 생성
	private static UserDaoImpl instance;
	
	private UserDaoImpl(){}
	
	public static UserDaoImpl getInstance(){
		if(instance == null){
			instance = new UserDaoImpl();
		}
		return instance;
	}
	
	Database database = Database.getInstance();

	@Override
	public UserVO selectUser(String key, String value) {    //회원 가입 아이디 중복 검사
		for(int i = 0; i<database.tb_user.size();i++){
			UserVO user = database.tb_user.get(i);
			
			if(key.equals("ID")){   //키값이 ID로 넘어왔는지 확인
				if(user.getId().equals(value)){    //데이터베이스에 있는 유저 아이디와 value로 받아온 아이디가 같은지 검사
					return user;
				}
			}/*else if(key.equals("NAME")){      //????????
				if(user.getName().equals(value)){
					return user;
				}
			}*/
		}
		return null;
	}

	@Override
	public void insertUser(UserVO user) {       //유저 추가.
		database.tb_user.add(user);        // 데이터 베이스에 있는 어레이 리스트에 유저 추가.
		
	}

	@Override
	public UserVO selectUser(HashMap<String, String> param) {
		UserVO rtnUser = null;
		for(int i = 0; i<database.tb_user.size();i++){
			UserVO user = database.tb_user.get(i);    //데이터베이스에서 전체 유저 정보를 가져옴.
			boolean flag = true;
			Set<String> keys = param.keySet();     //파라미터로 받아온 키셋을 keys에 옮김
			for(String key : keys){                    //배열 keys를 하나씩 key로 옮김.
				String value = param.get(key);             //키를 이용하여 value에 유저 값을 대입시킴.
				if(key.equals("ID")){                 //비교 하려는게 ID가 맞는지 한번더 체크
					if(!user.getId().equals(value)) flag = false;         //만약에 데이터베이스에서 가져온 유저가 value가 아니면 flag는 false
				}else if(key.equals("PASSWORD")){							//그리고 패스워드도 체크
					if(!user.getPassword().equals(value)) flag = false;     //데이터베이스에서 가져온 유저 패스워드가 value랑 틀리면 flag는 false
				}	
			}
			if(flag) rtnUser = user;       //만약에 flag가 true이면 리턴값에 유저 정보를 넣는다. false면 앞쪽에서 설정한 기본값인 null을 리턴
		}
		return rtnUser;
	}

	@Override
	public ArrayList<UserVO> selectUserList() {
		
		return database.tb_user;
	}

}
