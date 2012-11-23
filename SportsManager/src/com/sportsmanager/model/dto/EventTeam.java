package com.sportsmanager.model.dto;

import java.io.Serializable;


public class EventTeam  implements Serializable 
{
	private static final long serialVersionUID = 1L;
	
	private int id;
	//private SeasonEvent seasonEvent;
	private int pos;
	private Team team;
	private int teamId;
	private int won;
	private int lost;
	private int pool;
	//private ArrayList<TeamPlayer> teamPlayerList = new ArrayList<TeamPlayer>();
	
	
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
	public Team getTeam() {
		return team;
	}
	public void setTeam(Team team) {
		this.team = team;
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
	public void setTeamId(int teamId) {
		this.teamId = teamId;
	}
	public int getTeamId() {
		return teamId;
	}
}
