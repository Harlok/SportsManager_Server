package com.sportsmanager.model.dto;

import java.io.Serializable;


public class PlayerVolleyPos implements Serializable 
{
	private static final long serialVersionUID = 1L;
	
	private int id;
	private Player player;
	private int powerPos;
	private int centerPos;
	private int techPos;
	private int setterPos;
	private int liberoPos;
	
	private int leftSide;
	private int rightSide;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Player getPlayer() {
		return player;
	}
	public void setPlayer(Player player) {
		this.player = player;
	}
	public int getPowerPos() {
		return powerPos;
	}
	public void setPowerPos(int powerPos) {
		this.powerPos = powerPos;
	}
	public int getCenterPos() {
		return centerPos;
	}
	public void setCenterPos(int centerPos) {
		this.centerPos = centerPos;
	}
	public int getTechPos() {
		return techPos;
	}
	public void setTechPos(int techPos) {
		this.techPos = techPos;
	}
	public int getSetterPos() {
		return setterPos;
	}
	public void setSetterPos(int setterPos) {
		this.setterPos = setterPos;
	}
	public int getLiberoPos() {
		return liberoPos;
	}
	public void setLiberoPos(int liberoPos) {
		this.liberoPos = liberoPos;
	}
	public int getLeftSide() {
		return leftSide;
	}
	public void setLeftSide(int leftSide) {
		this.leftSide = leftSide;
	}
	public int getRightSide() {
		return rightSide;
	}
	public void setRightSide(int rightSide) {
		this.rightSide = rightSide;
	}
	
	
	
}
