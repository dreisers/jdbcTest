package kr.co.jdbctest;

public class BoardDTO {

	private int idx; 
	private String name; 	 
	private String email; 	 
	private String homepage; 
	private String title; 
	private String content;  
	private String pwd; 	 
	private String wdate; 	 
	private int hit;
		
	public BoardDTO() {}
	
	public BoardDTO(String name, String email, String homepage, String title, String content, String pwd, String wdate, int hit) {
		this.name = name;
		this.email = email;
		this.homepage = homepage;
		this.title = title;
		this.content = content;
		this.pwd = pwd;
		this.wdate = wdate;
		this.hit = hit;
	}

	public int getIdx() {
		return idx;
	}

	public void setIdx(int idx) {
		this.idx = idx;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getHomepage() {
		return homepage;
	}

	public void setHomepage(String homepage) {
		this.homepage = homepage;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public String getWdate() {
		return wdate;
	}

	public void setWdate(String wdate) {
		this.wdate = wdate;
	}

	public int getHit() {
		return hit;
	}

	public void setHit(int hit) {
		this.hit = hit;
	}

	@Override
	public String toString() {
		return "boardDTO [idx=" + idx + ", name=" + name + ", email=" + email + ", homepage=" + homepage + ", title=" + title + ", content="
				+ content + ", pwd=" + pwd + ", wdate=" + wdate + ", hit=" + hit + "]";
	} 	 
	
	
	
}
