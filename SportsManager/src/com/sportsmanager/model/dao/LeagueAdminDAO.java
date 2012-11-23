package com.sportsmanager.model.dao;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity (name="LEAGUE_ADMINS")
public class LeagueAdminDAO extends BaseDAO  
{
	public static final int MASTER = 10;
	public static final int ADMIN = 9;
	public static final int SCOREKEEPER = 5;
	
	private static final long serialVersionUID = 1L;
	
	@Id 
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	
	@ManyToOne
	@JoinColumn(name="leagueId")
	private LeagueDAO league;
	@ManyToOne
	@JoinColumn(name="playerId")
	private PlayerDAO player;
	private int role;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public LeagueDAO getLeague() {
		return league;
	}
	public void setLeague(LeagueDAO league) {
		this.league = league;
	}
	public PlayerDAO getPlayer() {
		return player;
	}
	public void setPlayer(PlayerDAO player) {
		this.player = player;
	}
	public int getRole() {
		return role;
	}
	public void setRole(int role) {
		this.role = role;
	}
	
	
	
}
