package com.kh.first.board.model.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kh.first.board.model.vo.Board;

@Repository("boardDao")
public class BoardDao {
	
	@Autowired
	private SqlSessionTemplate mybatis;
	
	public List<Board> selectList(){
		return mybatis.selectList("boardMapper.selectAll");
	}

	public int insertBoard(Board board) {
		return mybatis.insert("boardMapper.insertBoard", board);
	}
	
	public Board selectBoardDetail(Board board) {
		return mybatis.selectOne("boardMapper.boardDetail", board);
	}

	public int deleteBoard(Board board) {
		return mybatis.delete("boardMapper.bdelete", board);
	}
	
}
