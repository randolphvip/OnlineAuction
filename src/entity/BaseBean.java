package entity;

public class BaseBean {
	private String orderBy;
	
	private int pageNumber=0;
	private int pageSize =10;
	private int limitBegin=-1;
	private int limitEnd =-1;
	
	
	public int getLimitBegin() {
		return limitBegin;
	}

	public void setLimitBegin(int limitBegin) {
		this.limitBegin = limitBegin;
	}

	public int getLimitEnd() {
		return limitEnd;
	}

	public void setLimitEnd(int limitEnd) {
		this.limitEnd = limitEnd;
	}

	public int getPageNumber() {
		return pageNumber;
	}

	public void setPageNumber(int pageNumber) {
		this.pageNumber = pageNumber;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

 
	private int limit;

	public String getOrderBy() {
		return orderBy;
	}

	public void setOrderBy(String orderBy) {
		this.orderBy = orderBy;
	}

	public int getLimit() {
		return limit;
	}

	public void setLimit(int limit) {
		this.limit = limit;
	}

}
