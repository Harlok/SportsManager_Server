package com.sportsmanager.model.dto;

import java.io.Serializable;

public class TransacResult implements Serializable 
{
	private static final long serialVersionUID = 1L;
	
	private boolean success = true;
	private int id = 0;
	private int errorCode;
	private String message = "";
	
	

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public void setErrorCode(int errorCode) 
	{
		this.errorCode = errorCode;
		if (errorCode != 0)
		{
			this.success = false;
		}
	}
	public int getErrorCode() {
		return errorCode;
	}
	public void setSuccess(boolean success) {
		this.success = success;
	}
	public boolean isSuccess() {
		return success;
	}
	
	public void createError(int errorCode, String errorMessage)
	{
		this.errorCode = errorCode;
		this.message = errorMessage;
		if (errorCode != 0)
		{
			this.success = false;
		}
	}
}
