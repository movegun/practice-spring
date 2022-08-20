package soo.md.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import soo.md.domain.Board;
import soo.md.mapper.BoardMapper;
import soo.md.util.PagingVO;

@Service
public class BoardServiceImpl implements BoardService {
	
	@Autowired
	private BoardMapper boardMapper;
	
	@Override
	public List<Board> listS(){
		return boardMapper.list();		
	}
	
	@Override
	public void insertS(Board board) {
		boardMapper.insert(board);		
	}
	
	@Override
	public void deleteS(long seq) {
		boardMapper.delete(seq);
	}
	
	@Override
	public Board findS(long seq) {
		return boardMapper.find(seq);
		
	}
	
	@Override
	public void updateS(Board board) {
		boardMapper.update(board);		
	}
	
	@Override
	public int countBoardS() {
		return boardMapper.countBoard();		
	}
	
	@Override
	public List<Board> selectBoardS(PagingVO vo) {
		return boardMapper.selectBoard(vo);
	}	
	
	@Override
	public List<Board> selectBoardAscS(PagingVO vo) {
		return boardMapper.selectBoardAsc(vo);
	}		
	
	@Override
	public int countBoardKeywordS(String keyword) {		
		return boardMapper.countBoardKeyword(keyword);
	}
	
	@Override
	public List<Board> selectBoardKeywordS(PagingVO vo){
		return boardMapper.selectBoardKeyword(vo);
	}
	
	

}
