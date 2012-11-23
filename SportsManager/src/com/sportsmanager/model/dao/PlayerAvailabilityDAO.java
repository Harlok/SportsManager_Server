package com.sportsmanager.model.dao;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity (name="PLAYER_AVAILABILITIES")
public class PlayerAvailabilityDAO extends BaseDAO  
{
	private static final long serialVersionUID = 1L;
	
	@Id 
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	@OneToOne
	@JoinColumn(name="playerId")
	private PlayerDAO player;
	private int dayOfWeek;
	//@Temporal(TemporalType.TIME)
	private double startTime;
	//@Temporal(TemporalType.TIME)
	private double endTime;
	
	
	public PlayerAvailabilityDAO() 
	{
		super();
	}
	
	public PlayerAvailabilityDAO(PlayerDAO player, int dayOfWeek, double startTime, double endTime) {
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
	public PlayerDAO getPlayer() {
		return player;
	}
	public void setPlayer(PlayerDAO player) {
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
