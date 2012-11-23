package com.sportsmanager.model.dto;

import java.io.Serializable;


public class PlayerAvailability implements Serializable
{
	private static final long serialVersionUID = 1L;
	
	private int id;
	private Player player;
	private int dayOfWeek;
	//@Temporal(TemporalType.TIME)
	private double startTime;
	//@Temporal(TemporalType.TIME)
	private double endTime;
	
	
	public PlayerAvailability() 
	{
		super();
	}
	
	public PlayerAvailability(Player player, int dayOfWeek, double startTime, double endTime) {
		super();
		this.player = player;
		this.dayOfWeek = dayOfWeek;
		this.startTime = startTime;
		this.endTime = endTime;
	}
	
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
	public int getDayOfWeek() {
		return dayOfWeek;
	}
	public void setDayOfWeek(int dayOfWeek) {
		this.dayOfWeek = dayOfWeek;
	}

	public double getStartTime() {
		return startTime;
	}

	public void setStartTime(double startTime) {
		this.startTime = startTime;
	}

	public double getEndTime() {
		return endTime;
	}

	public void setEndTime(double endTime) {
		this.endTime = endTime;
	}
	
	
	
	
	
	
	
}
