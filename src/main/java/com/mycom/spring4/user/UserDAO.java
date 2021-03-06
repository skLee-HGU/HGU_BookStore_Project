package com.mycom.spring4.user;

import org.apache.ibatis.session.SqlSession;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mycom.spring3.board.BoardVO;

@Repository
public class UserDAO {
	
	@Autowired
	SqlSessionTemplate sqlSession;

	public UserVO getUser(UserVO vo) {
		UserVO one = sqlSession.selectOne("User.getUser", vo);
		return one;
	}
	
	public UserVO getDuplicatedUser(UserVO vo) {
		UserVO one = sqlSession.selectOne("User.getDuplicatedUser", vo);
		return one;
	}
	
	public int insertUser(UserVO vo) {
		int count = sqlSession.insert("User.insertUser", vo);
		return count;
	}
}