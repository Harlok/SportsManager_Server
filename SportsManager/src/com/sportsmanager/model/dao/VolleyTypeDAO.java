package com.sportsmanager.model.dao;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity (name="VOLLEY_TYPES")
public class VolleyTypeDAO extends BaseDAO 
{
	
	@Id 
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	private String name_short;
	private String name_long;
	private int env;
	private int sex;
	private int playerCount;
	
	@OneToMany(mappedBy="volleyType")
	private Collection<LevelInterestDAO> interestedPlayers = new ArrayList<LevelInterestDAO>();
	
	public VolleyTypeDAO() 
	{
		super();
	}
	
	public VolleyTypeDAO(int env, int sex, int playerCount, String name_short, String name_long) 
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

	public void setInterestedPlayers(Collection<LevelInterestDAO> interestedPlayers) {
		this.interestedPlayers = interestedPlayers;
	}

	public Collection<LevelInterestDAO> getInterestedPlayers() {
		return interestedPlayers;
	}
	
}
