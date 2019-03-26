package kr.co.jdbctest;

import java.util.List;

public interface IDao {
	public List<BoardDTO> list(); // 목록
	public List<BoardDTO> paging(int start, int end); // 페이지
	public BoardDTO read(int num); // 상세보기
	public int rowCount();	// 레코드 갯수
	public int insert(BoardDTO dto); // 쓰기
	public void update(BoardDTO dto); // 수정
	public void delete(int num); // 삭제 
	
}//interface end
