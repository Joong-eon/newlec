package com.newlecture.prj4;

import java.io.Serializable;

public class ChatData implements Serializable{//알아서 serialization 해줌
	
	//type , msg 중에서 뭘 먼저 보낼것인지? 구분자는 어떻게 할 것인지?
	private int type;
	private String msg;
	
	public ChatData() {
		
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}
	
	
}
