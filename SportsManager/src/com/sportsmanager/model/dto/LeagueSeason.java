package com.sportsmanager.model.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;

public class LeagueSeason implements Serializable 
{
	private static final long serialVersionUID = 1L;
	
	private int id;
	
	private League league;
	private Collection<Team> seasonTeamList = new ArrayList<Team>();
	private Collection<SeasonEvent> eventList = new ArrayList<SeasonEvent>();
	private String name;
	
	private long startDate;
	private long endDate;
	private int eventCount;
	
	private Location defaultLocation;
	private double defaultStartTime;
	private int defaultMaxPlayerPerPool;
	private int defaultCourtCount;
	private int defaultSetConfig;
	private int defaultCapOn15;
	private int defaultCapOn21;
	private int defaultCapOn25;
	private int defaultTimePerPoint;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public League getLeague() {
		return league;
	}
	public void setLeague(League league) {
		this.league = league;
	}
	public Location getDefaultLocation() {
		return defaultLocation;
	}
	public void setDefaultLocation(Location defaultLocation) {
		this.defaultLocation = defaultLocation;
	}
	public Collection<Team> getSeasonTeamList() {
		return seasonTeamList;
	}
	public void setSeasonTeamList(Collection<Team> seasonTeamList) {
		this.seasonTeamList = seasonTeamList;
	}
	public Collection<SeasonEvent> getEventList() {
		return eventList;
	}
	public void setEventList(Collection<SeasonEvent> eventList) {
		this.eventList = eventList;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public long getStartDate() {
		return startDate;
	}
	public void setStartDate(long startDate) {
		this.startDate = startDate;
	}
	public long getEndDate() {
		return endDate;
	}
	public void setEndDate(long endDate) {
		this.endDate = endDate;
	}
	public int getEventCount() {
		return eventCount;
	}
	public void setEventCount(int eventCount) {
		this.eventCount = eventCount;
	}
	public double getDefaultStartTime() {
		return defaultStartTime;
	}
	public void setDefaultStartTime(double defaultStartTime) {
		this.defaultStartTime = defaultStartTime;
	}
	public int getDefaultMaxPlayerPerPool() {
		return defaultMaxPlayerPerPool;
	}
	public void setDefaultMaxPlayerPerPool(int defaultMaxPlayerPerPool) {
		this.defaultMaxPlayerPerPool = defaultMaxPlayerPerPool;
	}
	public int getDefaultCourtCount() {
		return defaultCourtCount;
	}
	public void setDefaultCourtCount(int defaultCourtCount) {
		this.defaultCourtCount = defaultCourtCount;
	}
	public int getDefaultSetConfig() {
		return defaultSetConfig;
	}
	public void setDefaultSetConfig(int defaultSetConfig) {
		this.defaultSetConfig = defaultSetConfig;
	}
	public int getDefaultCapOn15() {
		return defaultCapOn15;
	}
	public void setDefaultCapOn15(int defaultCapOn15) {
		this.defaultCapOn15 = defaultCapOn15;
	}
	public int getDefaultCapOn21() {
		return defaultCapOn21;
	}
	public void setDefaultCapOn21(int defaultCapOn21) {
		this.defaultCapOn21 = defaultCapOn21;
	}
	public int getDefaultCapOn25() {
		return defaultCapOn25;
	}
	public void setDefaultCapOn25(int defaultCapOn25) {
		this.defaultCapOn25 = defaultCapOn25;
	}
	public int getDefaultTimePerPoint() {
		return defaultTimePerPoint;
	}
	public void setDefaultTimePerPoint(int defaultTimePerPoint) {
		this.defaultTimePerPoint = defaultTimePerPoint;
	}
	
	
}
