package kr.co.jdbctest;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class JdbcMainTest {

	public static void main(String[] args) {
		// JdbcTemplate Ŭ���� ����
		// -> �⺻ �ڹ� JDBC�� �� �� ���ϰ� ����� �� �ִ�.
		// -> JdbcTemplate = DriverManager + Connection + Statement + ResultSet
		// DB����
		String jdbc = "src/main/java/kr/co/jdbctest/jdbc.xml";
		ApplicationContext context = new FileSystemXmlApplicationContext(jdbc);
		//<bean id="boardDAO" class="kr.co.jdbctest.BoardDAO">
		IDao dao = (IDao) context.getBean("boardDAO");
		
//--------------------------------------------------------------------------------
		BoardDTO dto = null;
		List<BoardDTO> list = null;
				
		//1) �߰�
		/*
		int result = dao.insert(new BoardDTO("������", "sol1@soldesk.com", "www.soldesk.com", "�౸����", "���� ��Ʈ��", "1234", "", 0));
		if(result==0) {
			System.out.println("�� �߰� ����");
		}else {
			System.out.println("�� �߰� ����");
		}// if end
		 */	
		
		//4) ����
		// -> idx=1 ���ڵ��� �̸��� ����
		/*
		dto = new BoardDTO();
		dto.setIdx(1);
		dto.setName("���϶�");
		dao.update(dto);
		*/
		
		//5) ����
		// -> idx=1 ���ڵ� ����
		dao.delete(1);
		
		
		//2) ��� 
		
		list = dao.list();
		for(int idx=0; idx<list.size(); idx++) {
			dto = list.get(idx);
			System.out.print(dto.getIdx() + "");
			System.out.print(dto.getName() + "");
			System.out.print(dto.getEmail() + "");
			System.out.print(dto.getHomepage() + "");
			System.out.print(dto.getTitle() + "");
			System.out.print(dto.getContent() + "");
			System.out.print(dto.getPwd() + "");
			System.out.print(dto.getWdate() + "");
			System.out.print(dto.getHit() + "");
			System.out.println();
		}//for end
		
		//3) ���ڵ� ����
		System.out.println("��ü ���ڵ� ���� : " + dao.rowCount());
		
		
		//6) �󼼺���
		dto = dao.read(3);
		System.out.print(dto.getIdx() + "");
		System.out.print(dto.getName() + "");
		System.out.print(dto.getEmail() + "");
		System.out.print(dto.getHomepage() + "");
		System.out.print(dto.getTitle() + "");
		System.out.print(dto.getContent() + "");
		System.out.print(dto.getPwd() + "");
		System.out.print(dto.getWdate() + "");
		System.out.print(dto.getHit() + "");
		System.out.println();
		
		//7) ����¡
		int start = 2, end = 3;
		list = dao.paging(start, end);
		for(int idx=0; idx<list.size(); idx++) {
			dto = list.get(idx);
			System.out.print(dto.getIdx() + "");
			System.out.print(dto.getName() + "");
			System.out.print(dto.getEmail() + "");
			System.out.print(dto.getHomepage() + "");
			System.out.print(dto.getTitle() + "");
			System.out.print(dto.getContent() + "");
			System.out.print(dto.getPwd() + "");
			System.out.print(dto.getWdate() + "");
			System.out.print(dto.getHit() + "");
			System.out.println();
		}//for end
		
	}// main end

}// class end
