package kr.co.jdbctest;

import java.util.List;

public interface IDao {
	public List<BoardDTO> list(); // ���
	public List<BoardDTO> paging(int start, int end); // ������
	public BoardDTO read(int num); // �󼼺���
	public int rowCount();	// ���ڵ� ����
	public int insert(BoardDTO dto); // ����
	public void update(BoardDTO dto); // ����
	public void delete(int num); // ���� 
	
}//interface end
