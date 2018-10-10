package com.zfl.bean;
/*
 * 与message表相对应
 * */
public class Message {
	
	private int id;//主键
	
	private String command;//指令
	
	private String description;//描述
	
	private String content;//内容

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCommand() {
		return command;
	}

	public void setCommand(String command) {
		this.command = command;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}
	
	
}
