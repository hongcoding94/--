package hide.common;

public class Search {
	private String condition;
	private String keyword;
	
	public Search() {
		super();
	}

	public Search(String condition, String keyword) {
		super();
		this.condition = condition;
		this.keyword = keyword;
	}

	public String getCondition() {
		return condition;
	}

	public void setCondition(String condition) {
		this.condition = condition;
	}

	public String getKeyword() {
		return keyword;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}

	@Override
	public String toString() {
		return "Search [condition=" + condition + ", keyword=" + keyword + "]";
	}
	
	
	
	
}

