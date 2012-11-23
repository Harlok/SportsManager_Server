package com.sportsmanager.model.dto;

import java.io.Serializable;

public class PlayerScheduleItem implements Serializable
{
	private static final long serialVersionUID = 1L;
	
	private long date;
	private int eventId;
	private int leagueId;
	private String leagueName;
	private int teamId;
	private String teamName;
	private int locationId;
	private String locationName;
	
	public PlayerScheduleItem()
	{
		super();
	}
	
	public PlayerScheduleItem(long date, int eventId, int leagueId,
			String leagueName, int teamId, String teamName, int locationId,
			String locationName) {
		super();
		this.date = date;
		this.eventId = eventId;
		this.leagueId = leagueId;
		this.leagueName = leagueName;
		this.teamId = teamId;
		this.teamName = teamName;
		this.locationId = locationId;
		this.locationName = locationName;
	}
	public long getDate() {
		return date;
	}
	public void setDate(long date) {
		this.date = date;
	}
	public int getEventId() {
		return eventId;
	}
	public void setEventId(int eventId) {
		this.eventId = eventId;
	}
	public String getLeagueName() {
		return leagueName;
	}
	public void setLeagueName(String leagueName) {
		this.leagueName = leagueName;
	}
	public int getTeamId() {
		return teamId;
	}
	public void setTeamId(int teamId) {
		this.teamId = teamId;
	}
	public String getTeamName() {
		return teamName;
	}
	public void setTeamName(String teamName) {
		this.teamName = teamName;
	}
	public int getLocationId() {
		return locationId;
	}
	public void setLocationId(int locationId) {
		this.locationId = locationId;
	}
	public String getLocationName() {
		return locationName;
	}
	public void setLocationName(String locationName) {
		this.locationName = locationName;
	}
	public void setLeagueId(int leagueId) {
		this.leagueId = leagueId;
	}
	public int getLeagueId() {
		return leagueId;
	}
	
}
