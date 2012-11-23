package com.sportsmanager.model.dto;

import java.io.Serializable;


public class LeagueAdmin implements Serializable 
{
	private static final long serialVersionUID = 1L;
	
	public static final int MASTER = 10;
	public static final int ADMIN = 9;
	public static final int SCOREKEEPER = 5;
	
	private int id;
	private League league;
	private Player player;
	private int role;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public League getLeague() {
		return league;
	}
	public void setLeague(League league) {
		this.league = league;
	}
	public Player getPlayer() {
		return player;
	}
	public void setPlayer(Player player) {
		this.player = player;
	}
	public int getRole() {
		return role;
	}
	public void setRole(int role) {
		this.role = role;
	}
	
	
	
}
