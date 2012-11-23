package com.sportsmanager.model.dto;

import java.io.Serializable;
import java.util.ArrayList;

public class SeasonEvent implements Serializable
{
	private static final long serialVersionUID = 1L;
	
	private int id;
	//private LeagueSeason leagueSeason;
	private long date;
	private ArrayList<EventTeam> teamPosList = new ArrayList<EventTeam>();
	private ArrayList<EventMatch> matchList = new ArrayList<EventMatch>();
	//private Collection<Invitation> teamInvitations = new ArrayList<Invitation>();
	
	//private Location location;
	private double startTime;
	private int maxPlayerPerPool;
	private int courtCount;
	private int setConfig;
	private int capOn15;
	private int capOn21;
	private int capOn25;
	private int timePerPoint;
	private boolean scheduleLocked = false;
	private int poolCount = 1;
	
	
	public int getSetConfig() {
		return setConfig;
	}
	public void setSetConfig(int setConfig) {
		this.setConfig = setConfig;
	}
	public int getCapOn15() {
		return capOn15;
	}
	public void setCapOn15(int capOn15) {
		this.capOn15 = capOn15;
	}
	public int getCapOn21() {
		return capOn21;
	}
	public void setCapOn21(int capOn21) {
		this.capOn21 = capOn21;
	}
	public int getCapOn25() {
		return capOn25;
	}
	public void setCapOn25(int capOn25) {
		this.capOn25 = capOn25;
	}
	public int getTimePerPoint() {
		return timePerPoint;
	}
	public void setTimePerPoint(int timePerPoint) {
		this.timePerPoint = timePerPoint;
	}
	public double getStartTime() {
		return startTime;
	}
	public void setStartTime(double startTime) {
		this.startTime = startTime;
	}
	public int getMaxPlayerPerPool() {
		return maxPlayerPerPool;
	}
	public void setMaxPlayerPerPool(int maxPlayerPerPool) {
		this.maxPlayerPerPool = maxPlayerPerPool;
	}
	public int getCourtCount() {
		return courtCount;
	}
	public void setCourtCount(int courtCount) {
		this.courtCount = courtCount;
	}
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public long getDate() {
		return date;
	}
	public void setDate(long date) {
		this.date = date;
	}

	public void setScheduleLocked(boolean scheduleLocked) {
		this.scheduleLocked = scheduleLocked;
	}
	public boolean isScheduleLocked() {
		return scheduleLocked;
	}
	public void setPoolCount(int poolCount) {
		this.poolCount = poolCount;
	}
	public int getPoolCount() {
		return poolCount;
	}
	public void setTeamPosList(ArrayList<EventTeam> teamPosList) {
		this.teamPosList = teamPosList;
	}
	public ArrayList<EventTeam> getTeamPosList() {
		return teamPosList;
	}
	public void setMatchList(ArrayList<EventMatch> matchList) {
		this.matchList = matchList;
	}
	public ArrayList<EventMatch> getMatchList() {
		return matchList;
	}
		
}
