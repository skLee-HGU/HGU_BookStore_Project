package com.mycom.spring3.board;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class BoardDAO {
	
	@Autowired
	SqlSession sqlSession;
	
	public int insertBoard(BoardVO vo) {
		int count = sqlSession.insert("Board.insertBoard", vo);
		return count;
	}
	
	public int deleteBoard(int id) {
		return sqlSession.delete("Board.deleteBoard", id);
	}
		
	public int updateBoard(BoardVO vo) {
		return sqlSession.update("Board.updateBoard", vo);
	}	
	
	public BoardVO getBoard(int seq) {
		BoardVO one = sqlSession.selectOne("Board.getBoardList");
		return one;
	}
	
	public List<BoardVO> getBoardList(){
		List<BoardVO> list = sqlSession.selectList("Board.getBoardList");
		for(BoardVO board : list){
			System.out.println(board.toString());
		}
		return list;
		
	}
}
