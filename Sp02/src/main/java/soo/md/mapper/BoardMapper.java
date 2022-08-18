package soo.md.mapper;

import java.util.List;

import soo.md.domain.Board;
import soo.md.util.PagingVO;

public interface BoardMapper {	
	List<Board> list();
	void insert(Board board);
	void delete(long seq);
	Board find(long seq);
	void update(Board board);
	int countBoard();
	List<Board> selectBoard(PagingVO vo);
}