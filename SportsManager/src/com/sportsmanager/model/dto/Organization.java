package com.sportsmanager.model.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;

public class Organization implements Serializable 
{
	private static final long serialVersionUID = 1L;
	
	private int id;
	private String name_short;
	private String name_long;
	private Collection<League> leagueList = new ArrayList<League>();
	
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
	public Collection<League> getLeagueList() {
		return leagueList;
	}
	public void setLeagueList(Collection<League> leagueList) {
		this.leagueList = leagueList;
	}
	
	
	
	
}
