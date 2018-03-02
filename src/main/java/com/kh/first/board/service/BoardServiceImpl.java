package com.kh.first.board.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kh.first.board.model.dao.BoardDao;
import com.kh.first.board.model.vo.Board;
import com.kh.first.member.model.vo.Member;

@Service("boardService")
public class BoardServiceImpl implements BoardService{

	@Autowired
	private BoardDao boardDao;
	
	@Override
	public List<Board> selectBoardList() {
		return boardDao.selectList();
	}
	
	@Override
	public int insertBoard(Board board) {
		return boardDao.insertBoard(board);
	}

	@Override
	public Board selectOne(Board board) {
		return boardDao.selectBoardDetail(board);
	}

	@Override
	public int bdelete(Board board) {
		return boardDao.deleteBoard(board);
		
	}

}
