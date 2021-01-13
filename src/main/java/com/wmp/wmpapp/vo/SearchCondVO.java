package com.wmp.wmpapp.vo;

public class SearchCondVO {
	
	/** URL */
	private String url;
	
	/** 필터링 Type */
	private int scope;
	
	/** 출력 묶음 단위 */
	private int unit;
	
	public String getUrl() {
		return url;
	}
	
	public void setUrl(String url) {
		this.url = url;
	}
	
	public int getScope() {
		return scope;
	}
	
	public void setScope(int scope) {
		this.scope = scope;
	}
	
	public int getUnit() {
		return unit;
	}
	
	public void setUnit(int unit) {
		this.unit = unit;
	}
	
	@Override
	public String toString() {
		StringBuffer sb = new StringBuffer();
		sb.append("url=");
		sb.append(this.url);
		sb.append(", scope=");
		sb.append(this.scope);
		sb.append(", unit=");
		sb.append(this.unit);
		return sb.toString();
	}

}
