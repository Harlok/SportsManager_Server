package com.sportsmanager.model.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;

public class VolleyType implements Serializable 
{
	private static final long serialVersionUID = 1L;
	
	private int id;
	private String name_short;
	private String name_long;
	private int env;
	private int sex;
	private int playerCount;
	private Collection<LevelInterest> interestedPlayers = new ArrayList<LevelInterest>();
	
	public VolleyType() 
	{
		super();
	}
	
	public VolleyType(int env, int sex, int playerCount, String name_short, String name_long) 
	{
		super();
		this.name_short = name_short;
		this.name_long = name_long;
		this.env = env;
		this.sex = sex;
		this.playerCount = playerCount;
	}
	
	public String getName_short() {
		return name_short;
	}
	public void setName_short(String name_short) {
		this.name_short = name_short;
	}
	public String getName_long() {
		return name_long;
	}
	public void setName_long(String name_long) {
		this.name_long = name_long;
	}
	public int getEnv() {
		return env;
	}
	public void setEnv(int env) {
		this.env = env;
	}
	public int getSex() {
		return sex;
	}
	public void setSex(int sex) {
		this.sex = sex;
	}
	public int getPlayerCount() {
		return playerCount;
	}
	public void setPlayerCount(int playerCount) {
		this.playerCount = playerCount;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getId() {
		return id;
	}

	public void setInterestedPlayers(Collection<LevelInterest> interestedPlayers) {
		this.interestedPlayers = interestedPlayers;
	}

	public Collection<LevelInterest> getInterestedPlayers() {
		return interestedPlayers;
	}
	
}
