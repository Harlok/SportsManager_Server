package com.sportsmanager.model.dto;

import java.io.Serializable;

public class TeamPlayer implements Serializable 
{
	private static final long serialVersionUID = 1L;
	
	private int id;
	private int teamId;
	private int playerId;
	private Player player;
	private int role;
	
	public int getId() 
	{
		return id;
	}
	public void setId(int id) 
	{
		this.id = id;
	}
	public int getRole() 
	{
		return role;
	}
	public void setRole(int role) 
	{
		this.role = role;
	}
	public void setPlayerId(int playerId) 
	{
		this.playerId = playerId;
	}
	public int getPlayerId() 
	{
		return playerId;
	}
	public void setTeamId(int teamId) 
	{
		this.teamId = teamId;
	}
	public int getTeamId() 
	{
		return teamId;
	}
	public void setPlayer(Player player) {
		this.player = player;
	}
	public Player getPlayer() {
		return player;
	}	
}
