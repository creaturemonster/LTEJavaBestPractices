package com.ltree.crs516.data;

@SuppressWarnings("serial")
public class DAOException extends Exception {
	
	public DAOException() {}
	
	public DAOException(Exception e) {
		super(e);
	}
	
	public DAOException(String message, Throwable cause) {
		super(message, cause);
	}
}
