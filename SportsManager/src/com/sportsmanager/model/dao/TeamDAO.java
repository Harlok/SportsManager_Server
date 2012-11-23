package com.sportsmanager.model.dao;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

@Entity (name="TEAMS")
public class TeamDAO extends BaseDAO  
{
	
	@Id 
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	private String name;
	@ManyToMany(mappedBy="seasonTeamList")
	private Collection<LeagueSeasonDAO> leagueSeasonList = new ArrayList<LeagueSeasonDAO>();
	@OneToMany(mappedBy="team")
	private Collection<TeamPlayerDAO> teamPlayers = new ArrayList<TeamPlayerDAO>();
	@OneToMany(mappedBy="team")
	private Collection<InvitationDAO> invitations = new ArrayList<InvitationDAO>();
	@OneToMany(mappedBy="team")
	private Collection<EventTeamDAO> teamEvents = new ArrayList<EventTeamDAO>();	
	
	
	
	public int getId() 
	{
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
	public Collection<TeamPlayerDAO> getTeamPlayers() {
		return teamPlayers;
	}
	public void setTeamPlayers(Collection<TeamPlayerDAO> teamPlayers) {
		this.teamPlayers = teamPlayers;
	}
	public void setLeagueSeasonList(Collection<LeagueSeasonDAO> leagueSeasonList) {
		this.leagueSeasonList = leagueSeasonList;
	}
	public Collection<LeagueSeasonDAO> getLeagueSeasonList() {
		return leagueSeasonList;
	}
	public void setInvitations(Collection<InvitationDAO> invitations) {
		this.invitations = invitations;
	}
	public Collection<InvitationDAO> getInvitations() {
		return invitations;
	}
	public void setTeamEvents(Collection<EventTeamDAO> teamEvents) {
		this.teamEvents = teamEvents;
	}
	public Collection<EventTeamDAO> getTeamEvents() {
		return teamEvents;
	}
}
