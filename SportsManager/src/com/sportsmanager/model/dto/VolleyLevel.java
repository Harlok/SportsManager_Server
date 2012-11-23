package com.sportsmanager.model.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;

public class VolleyLevel implements Serializable 
{
	private static final long serialVersionUID = 1L;
	
	private int id;
	private int skillLevel;
	private String name;
	private Collection<LevelInterest> minInterest = new ArrayList<LevelInterest>();
	private Collection<LevelInterest> maxInterest = new ArrayList<LevelInterest>();
	
	public VolleyLevel() 
	{
		super();
	}
	
	
	
	public VolleyLevel(int skillLevel, String name) 
	{
		super();
		this.setSkillLevel(skillLevel);
		this.name = name;
	}



	public int getId() {
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
	public void setSkillLevel(int skillLevel) {
		this.skillLevel = skillLevel;
	}
	public int getSkillLevel() {
		return skillLevel;
	}
	public void setMinInterest(Collection<LevelInterest> minInterest) {
		this.minInterest = minInterest;
	}
	public Collection<LevelInterest> getMinInterest() {
		return minInterest;
	}
	public void setMaxInterest(Collection<LevelInterest> maxInterest) {
		this.maxInterest = maxInterest;
	}



	public Collection<LevelInterest> getMaxInterest() {
		return maxInterest;
	}
	
	
	
	
}
