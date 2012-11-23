package com.sportsmanager.model.dao;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Transient;

@Entity (name="Event_Teams")
public class EventTeamDAO extends BaseDAO  
{
	
	@Id 
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	
	@ManyToOne
	@JoinColumn(name="eventId")
	private SeasonEventDAO seasonEvent;
	
	@OneToOne
	@JoinColumn(name="teamId")
	private TeamDAO team;

	private int pos;
	private int won;
	private int lost;
	private int pool;
	
	@Transient
	private int happy;  // This variable is used to count happy points when generating schedule.  
						//A team which just played is happier and will be sorted lower in the list of priority.

	
	public int getPool() {
		return pool;
	}
	public void setPool(int pool) {
		this.pool = pool;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getPos() {
		return pos;
	}
	public void setPos(int pos) {
		this.pos = pos;
	}
	public TeamDAO getTeam() {
		return team;
	}
	public void setTeam(TeamDAO team) {
		this.team = team;
	}
	public void setSeasonEvent(SeasonEventDAO seasonEvent) {
		this.seasonEvent = seasonEvent;
	}
	public SeasonEventDAO getSeasonEvent() {
		return seasonEvent;
	}
	public void setWon(int won) {
		this.won = won;
	}
	public int getWon() {
		return won;
	}
	public void setLost(int lost) {
		this.lost = lost;
	}
	public int getLost() {
		return lost;
	}
	public void setHappy(int happy) {
		this.happy = happy;
	}
	public int getHappy() {
		return happy;
	}
	
}
