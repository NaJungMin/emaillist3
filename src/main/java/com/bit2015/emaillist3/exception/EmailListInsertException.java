package com.bit2015.emaillist3.exception;

public class EmailListInsertException extends RuntimeException {
	public EmailListInsertException(){
		super("EmailListDao:insert Exception");
	}
	public EmailListInsertException(String msg){
		super(msg);
	}
}
