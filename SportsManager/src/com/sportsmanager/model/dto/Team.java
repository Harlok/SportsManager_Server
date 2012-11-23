package com.sportsmanager.model.dto;

import java.io.Serializable;
import java.util.ArrayList;

public class Team  implements Serializable
{
	private static final long serialVersionUID = 1L;
	
	private int id;
	private String name;
	private int pos;
	private int pool;
	private int won;
	private int lost;
	//private Collection<LeagueSeason> leagueSeasonList = new ArrayList<LeagueSeason>();
	private ArrayList<TeamPlayer> teamPlayers = new ArrayList<TeamPlayer>();
	//private Collection<Invitation> invitations = new ArrayList<Invitation>();
	
	
	public int getId() 
	{
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setPool(int pool) {
		this.pool = pool;
	}
	public int getPool() {
		return pool;
	}
	public void setPos(int pos) {
		this.pos = pos;
	}
	public int getPos() {
		return pos;
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
	public void setTeamPlayers(ArrayList<TeamPlayer> teamPlayers) {
		this.teamPlayers = teamPlayers;
	}
	public ArrayList<TeamPlayer> getTeamPlayers() {
		return teamPlayers;
	}
	
	
	
}
