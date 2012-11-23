package com.sportsmanager.model.dao;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity (name="ORGANIZATIONS")
public class OrganizationDAO extends BaseDAO  
{
	
	@Id 
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	private String name_short;
	private String name_long;
	@OneToMany(mappedBy="organization")
	private Collection<LeagueDAO> leagueList = new ArrayList<LeagueDAO>();
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
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
	public Collection<LeagueDAO> getLeagueList() {
		return leagueList;
	}
	public void setLeagueList(Collection<LeagueDAO> leagueList) {
		this.leagueList = leagueList;
	}
	
	
	
	
}
