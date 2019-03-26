package kr.co.jdbctest;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class JdbcMainTest {

	public static void main(String[] args) {
		// JdbcTemplate 클래스 연습
		// -> 기본 자바 JDBC를 좀 더 편리하게 사용할 수 있다.
		// -> JdbcTemplate = DriverManager + Connection + Statement + ResultSet
		// DB연결
		String jdbc = "src/main/java/kr/co/jdbctest/jdbc.xml";
		ApplicationContext context = new FileSystemXmlApplicationContext(jdbc);
		//<bean id="boardDAO" class="kr.co.jdbctest.BoardDAO">
		IDao dao = (IDao) context.getBean("boardDAO");
		
//--------------------------------------------------------------------------------
		BoardDTO dto = null;
		List<BoardDTO> list = null;
				
		//1) 추가
		/*
		int result = dao.insert(new BoardDTO("개나리", "sol1@soldesk.com", "www.soldesk.com", "축구선수", "영국 토트넘", "1234", "", 0));
		if(result==0) {
			System.out.println("행 추가 실패");
		}else {
			System.out.println("행 추가 성공");
		}// if end
		 */	
		
		//4) 수정
		// -> idx=1 레코드의 이름을 수정
		/*
		dto = new BoardDTO();
		dto.setIdx(1);
		dto.setName("라일락");
		dao.update(dto);
		*/
		
		//5) 삭제
		// -> idx=1 레코드 삭제
		dao.delete(1);
		
		
		//2) 목록 
		
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
		
		//3) 레코드 갯수
		System.out.println("전체 레코드 갯수 : " + dao.rowCount());
		
		
		//6) 상세보기
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
		
		//7) 페이징
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
