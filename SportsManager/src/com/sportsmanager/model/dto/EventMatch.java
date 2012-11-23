package com.sportsmanager.model.dto;

import java.io.Serializable;
import java.util.ArrayList;

public class EventMatch implements Serializable 
{
	private static final long serialVersionUID = 1L;
	
	private int id;
	private int eventId;
	private int team1Id;
	private int team2Id;
	private int courtNo;
	private int timeSlot;
	
	private Team team1;
	private Team team2;
	
	private SeasonEvent seasonEvent;
	private ArrayList<MatchSet> setList = new ArrayList<MatchSet>();
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getEventId() {
		return eventId;
	}
	public void setEventId(int eventId) {
		this.eventId = eventId;
	}
	public int getTeam1Id() {
		return team1Id;
	}
	public void setTeam1Id(int team1Id) {
		this.team1Id = team1Id;
	}
	public int getTeam2Id() {
		return team2Id;
	}
	public void setTeam2Id(int team2Id) {
		this.team2Id = team2Id;
	}
	public int getCourtNo() {
		return courtNo;
	}
	public void setCourtNo(int courtNo) {
		this.courtNo = courtNo;
	}
	public int getTimeSlot() {
		return timeSlot;
	}
	public void setTimeSlot(int timeSlot) {
		this.timeSlot = timeSlot;
	}
	public void setTeam1(Team team1) {
		this.team1 = team1;
	}
	public Team getTeam1() {
		return team1;
	}
	public void setTeam2(Team team2) {
		this.team2 = team2;
	}
	public Team getTeam2() {
		return team2;
	}
	public void setSeasonEvent(SeasonEvent seasonEvent) {
		this.seasonEvent = seasonEvent;
	}
	public SeasonEvent getSeasonEvent() {
		return seasonEvent;
	}
	public void setSetList(ArrayList<MatchSet> setList) {
		this.setList = setList;
	}
	public ArrayList<MatchSet> getSetList() {
		return setList;
	}
	
}
