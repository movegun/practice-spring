package soo.md.service;

import java.util.List;

import soo.md.domain.Board;
import soo.md.util.PagingVO;

public interface BoardService {

	List<Board> listS();
	void insertS(Board board);
	void deleteS(long seq);
	Board findS(long seq);
	void updateS(Board board);
	int countBoardS();
	List<Board> selectBoardS(PagingVO vo);

}
