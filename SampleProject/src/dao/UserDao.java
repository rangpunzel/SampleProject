package dao;

import java.util.ArrayList;
import java.util.HashMap;

import vo.UserVO;

public interface UserDao {

	UserVO selectUser(String key, String value);

	void insertUser(UserVO user);

	UserVO selectUser(HashMap<String, String> param);

	ArrayList<UserVO> selectUserList();
}
