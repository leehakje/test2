package com.kh.first.board.service;

import java.util.List;

import com.kh.first.board.model.vo.Board;

public interface BoardService {
	List<Board> selectBoardList();

	int insertBoard(Board board);

	Board selectOne(Board board);

	int bdelete(Board board);
	
	
}
