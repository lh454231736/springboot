package com.model;

/**
    * 测试RESTful应用
 * @author LiHuan
 *
 */
public class Message {
    
	private Long id;
	private String text;
	private String summary;
	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getText() {
		return text;
	}
	
	public void setText(String text) {
		this.text = text;
	}
	
	public String getSummary() {
		return summary;
	}
	
	public void setSummary(String summery) {
		this.summary = summery;
	}

	@Override
	public String toString() {
		return "Message [id=" + id + ", text=" + text + ", summery=" + summary + "]";
	}
	
	
}
