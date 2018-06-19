package com.murder.mystery.service.server.response;

public class PageListResponse<T> extends DataResponse<T> {
	
	private static final long serialVersionUID = 1L;
	
	private Integer page;
	private Integer pageSize;
	private long totalCount;
	
	public PageListResponse(){
		this(null);
	}

	public PageListResponse(T data){
		this(SUCCESS_CODE, data);
	}
	
	/*public PageListResponse(Integer code) {
		super(code);
	}*/
	
	public PageListResponse(Integer code, String resultMessage) {
		super(code, resultMessage);
	}
	
	public PageListResponse(Integer code, T data) {
		super(code, data);
	}
	
	public PageListResponse(Integer code, String resultMessage, T data) {
		super(code, resultMessage, data);
	}
	
	public PageListResponse(Integer code, String resultMessage, T data, Integer page, Integer PageSize) {
		super(code, resultMessage, data);
		this.setPage(page);
		this.setPageSize(PageSize);
	}
	
	public  void setPage(Integer page) {
		this.page = page;
	}
	
	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}
	
	public void setTotalCount(long totalCount) {
		this.totalCount = totalCount;
	}
	
	public Integer getPage() {
		return this.page;
	}
	
	public Integer getPageSize() {
		return this.pageSize;
	}
	
	public long getTotalCount() {
		return this.totalCount;
	}

	@Override
	public void setData(T data) {
		super.setData(data);
	}
}
