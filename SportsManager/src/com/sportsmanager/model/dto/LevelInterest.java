package com.sportsmanager.model.dto;

import java.io.Serializable;


public class LevelInterest implements Serializable 
{
	private static final long serialVersionUID = 1L;
	
	private int id;
	private Player player;
	private VolleyType volleyType;
	private VolleyLevel minLevel;
	private VolleyLevel maxLevel;
	
	
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
	public VolleyType getVolleyType() {
		return volleyType;
	}
	public void setVolleyType(VolleyType volleyType) {
		this.volleyType = volleyType;
	}
	public VolleyLevel getMinLevel() {
		return minLevel;
	}
	public void setMinLevel(VolleyLevel minLevel) {
		this.minLevel = minLevel;
	}
	public VolleyLevel getMaxLevel() {
		return maxLevel;
	}
	public void setMaxLevel(VolleyLevel maxLevel) {
		this.maxLevel = maxLevel;
	}
	
	
	
	
}
