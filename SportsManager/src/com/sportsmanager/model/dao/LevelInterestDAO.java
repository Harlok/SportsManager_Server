package com.sportsmanager.model.dao;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity (name="PLAYER_LEVEL_INTEREST")
public class LevelInterestDAO extends BaseDAO  
{
	@Id 
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	
	@ManyToOne
	@JoinColumn(name="playerId")
	private PlayerDAO player;
	@ManyToOne
	@JoinColumn(name="volleyTypeId")
	private VolleyTypeDAO volleyType;
	@ManyToOne
	@JoinColumn(name="minLevelId")
	private VolleyLevelDAO minLevel;
	@ManyToOne
	@JoinColumn(name="maxLevelId")
	private VolleyLevelDAO maxLevel;
	
	
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
	public VolleyTypeDAO getVolleyType() {
		return volleyType;
	}
	public void setVolleyType(VolleyTypeDAO volleyType) {
		this.volleyType = volleyType;
	}
	public VolleyLevelDAO getMinLevel() {
		return minLevel;
	}
	public void setMinLevel(VolleyLevelDAO minLevel) {
		this.minLevel = minLevel;
	}
	public VolleyLevelDAO getMaxLevel() {
		return maxLevel;
	}
	public void setMaxLevel(VolleyLevelDAO maxLevel) {
		this.maxLevel = maxLevel;
	}
	
	
	
	
}
