package com.sportsmanager.model.dao;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity (name="TEAM_PLAYERS")
public class TeamPlayerDAO extends BaseDAO 
{
	
	@Id 
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	@ManyToOne
	@JoinColumn(name="teamId")
	private TeamDAO team;
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
	public TeamDAO getTeam() {
		return team;
	}
	public void setTeam(TeamDAO team) {
		this.team = team;
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
