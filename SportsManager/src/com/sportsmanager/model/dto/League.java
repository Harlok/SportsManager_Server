package com.sportsmanager.model.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;

public class League implements Serializable 
{
	private static final long serialVersionUID = 1L;
	
	private int id;
	private Organization organization;
	private String name;
	private VolleyType volleyType;
	private Boolean hasSeasonTeams;
	private Collection<LeagueSeason> seasonList = new ArrayList<LeagueSeason>();
	private Collection<LeagueAdmin> adminList = new ArrayList<LeagueAdmin>();
	
	
	public void setId(int leagueId) 
	{
		this.id = leagueId;
	}
	public int getId() {
		return id;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getName() {
		return name;
	}
	public void setOrganization(Organization organization) {
		this.organization = organization;
	}
	public Organization getOrganization() {
		return organization;
	}
	public void setHasSeasonTeams(Boolean hasSeasonTeams) {
		this.hasSeasonTeams = hasSeasonTeams;
	}
	public Boolean getHasSeasonTeams() {
		return hasSeasonTeams;
	}
	public void setSeasonList(Collection<LeagueSeason> seasonList) {
		this.seasonList = seasonList;
	}
	public Collection<LeagueSeason> getSeasonList() {
		return seasonList;
	}
	public void setVolleyType(VolleyType volleyType) {
		this.volleyType = volleyType;
	}
	public VolleyType getVolleyType() {
		return volleyType;
	}
	public void setAdminList(Collection<LeagueAdmin> adminList) {
		this.adminList = adminList;
	}
	public Collection<LeagueAdmin> getAdminList() {
		return adminList;
	}
	
	
	
}
