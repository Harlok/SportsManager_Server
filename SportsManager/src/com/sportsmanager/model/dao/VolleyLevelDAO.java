package com.sportsmanager.model.dao;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity (name="VOLLEY_LEVELS")
public class VolleyLevelDAO extends BaseDAO  
{
	
	@Id 
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	private int skillLevel;
	private String name;

	@OneToMany(mappedBy="minLevel")
	private Collection<LevelInterestDAO> minInterest = new ArrayList<LevelInterestDAO>();
	@OneToMany(mappedBy="maxLevel")
	private Collection<LevelInterestDAO> maxInterest = new ArrayList<LevelInterestDAO>();
	
	public VolleyLevelDAO() 
	{
		super();
	}
	
	
	
	public VolleyLevelDAO(int skillLevel, String name) 
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



	public void setMinInterest(Collection<LevelInterestDAO> minInterest) {
		this.minInterest = minInterest;
	}



	public Collection<LevelInterestDAO> getMinInterest() {
		return minInterest;
	}



	public void setMaxInterest(Collection<LevelInterestDAO> maxInterest) {
		this.maxInterest = maxInterest;
	}



	public Collection<LevelInterestDAO> getMaxInterest() {
		return maxInterest;
	}
	
	
	
	
}
