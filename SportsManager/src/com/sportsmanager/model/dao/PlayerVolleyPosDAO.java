package com.sportsmanager.model.dao;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity (name="PLAYER_VOLLEY_POS")
public class PlayerVolleyPosDAO extends BaseDAO  
{
	
	@Id 
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	
	@OneToOne
	private PlayerDAO player;
	
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
	public PlayerDAO getPlayer() {
		return player;
	}
	public void setPlayer(PlayerDAO player) {
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
