package kr.co.jdbctest;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

public class BoardDAO implements IDao {

	// 1)POJO����� DB����
	// DBOpen dbopen = new DBOpen()

	// 2)�������� ��ü���� (DI)
	// jdbc.xml-----------------------------------
	// <property name="jt" ref="jdbcTemplate"></property>
	JdbcTemplate jt;

	// jt��ü�̸����� �ݵ�� setter�Լ��� �־�� �Ѵ�(�ʼ�)
	public void setJt(JdbcTemplate jt) {
		this.jt = jt;
	}
	
//-------------------------------------------------------------
	
	@Override
	public List<BoardDTO> list() {
		// ��ü���
		StringBuilder sql = new StringBuilder();
		sql.append(" SELECT * ");
		sql.append(" FROM board2 ");
		sql.append(" ORDER BY idx DESC ");

		// RowMapper<> = PreparedStatement + ResultSet
		RowMapper<BoardDTO> rowMapper = new RowMapper<BoardDTO>() {

			@Override
			public BoardDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
				BoardDTO dto = new BoardDTO();
				dto.setIdx(rs.getInt("idx"));
				dto.setName(rs.getString("name"));
				dto.setEmail(rs.getString("email"));
				dto.setHomepage(rs.getString("homepage"));
				dto.setTitle(rs.getString("title"));
				dto.setContent(rs.getString("content"));
				dto.setPwd(rs.getString("pwd"));
				dto.setWdate(rs.getString("wdate"));
				dto.setHit(rs.getInt("hit"));
				return dto;
			}//mapRow end
		};//rowMapper end

		List<BoardDTO> list = jt.query(sql.toString(), rowMapper);
		return list;

	}//List end

	@Override
	public List<BoardDTO> paging(int start, int end) {
		// ����¡
		StringBuilder sql = new StringBuilder();
		sql.append(" SELECT * ");
		sql.append(" FROM board2 ");
		sql.append(" WHERE idx >=" + start);
		sql.append(" AND idx <=" + end);
		sql.append(" ORDER BY idx DESC ");

		// RowMapper<> = PreparedStatement + ResultSet
		RowMapper<BoardDTO> rowMapper = new RowMapper<BoardDTO>() {

			@Override
			public BoardDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
				BoardDTO dto = new BoardDTO();
				dto.setIdx(rs.getInt("idx"));
				dto.setName(rs.getString("name"));
				dto.setEmail(rs.getString("email"));
				dto.setHomepage(rs.getString("homepage"));
				dto.setTitle(rs.getString("title"));
				dto.setContent(rs.getString("content"));
				dto.setPwd(rs.getString("pwd"));
				dto.setWdate(rs.getString("wdate"));
				dto.setHit(rs.getInt("hit"));
				return dto;
			}//mapRow end
		};//rowMapper end

		List<BoardDTO> list = jt.query(sql.toString(), rowMapper);
		return list;
		
	}//paging end

	@Override
	public BoardDTO read(int num) {
		// �󼼺���
		StringBuilder sql = new StringBuilder();
		sql.append(" SELECT * FROM board2 ");
		sql.append(" WHERE idx = " + num);
		BoardDTO dto = null;
		
		RowMapper<BoardDTO> rowMapper = new RowMapper<BoardDTO>() {

			@Override
			public BoardDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
				BoardDTO dto = new BoardDTO();
				dto.setIdx(rs.getInt("idx"));
				dto.setName(rs.getString("name"));
				dto.setEmail(rs.getString("email"));
				dto.setHomepage(rs.getString("homepage"));
				dto.setTitle(rs.getString("title"));
				dto.setContent(rs.getString("content"));
				dto.setPwd(rs.getString("pwd"));
				dto.setWdate(rs.getString("wdate"));
				dto.setHit(rs.getInt("hit"));
				return dto;
		
			}//mapRow end
		};//rowMapper end

		dto = jt.queryForObject(sql.toString(), rowMapper);
		return dto;
		
	}

	@Override
	public int rowCount() {
		// ���ڵ� ����
		StringBuilder sql = new StringBuilder();
		sql.append(" SELECT COUNT(*) FROM board2");
		return jt.queryForObject(sql.toString(), Integer.class);
	}//rowCount end

	@Override
	public int insert(BoardDTO dto) {
		// ���߰�
		StringBuilder sql = new StringBuilder();
		sql.append(" INSERT INTO board2(idx, name, email, homepage, title, content, pwd, wdate, hit) ");
		sql.append(" VALUES (board2_idx_seq.nextval ");
		sql.append(" , '" + dto.getName() + "' ");
		sql.append(" , '" + dto.getEmail() + "' ");
		sql.append(" , '" + dto.getHomepage() + "' ");
		sql.append(" , '" + dto.getTitle() + "' ");
		sql.append(" , '" + dto.getContent() + "' ");
		sql.append(" , '" + dto.getPwd() + "' ");
		sql.append(" , sysdate ");
		sql.append(" , " + dto.getHit() + ") ");

		int cnt = jt.update(sql.toString());
		return cnt;
	}// insert() end

	
	@Override
	public void update(BoardDTO dto) {
		// ����
		StringBuilder sql = new StringBuilder();
		sql.append(" UPDATE board2 ");
		sql.append(" SET name = '" + dto.getName() + "'");
		sql.append(" WHERE idx = " + dto.getIdx());
		jt.update(sql.toString());
	}//update end

	@Override
	public void delete(int num) {
		// ����
		StringBuilder sql = new StringBuilder();
		sql.append(" DELETE FROM board2 ");
		sql.append(" WHERE idx = " + num);
		jt.update(sql.toString());
	}//delete end

}// class end
