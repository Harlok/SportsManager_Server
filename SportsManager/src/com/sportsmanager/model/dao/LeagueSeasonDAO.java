package com.sportsmanager.model.dao;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity (name="LEAGUE_SEASONS")
public class LeagueSeasonDAO extends BaseDAO  
{
	@Id 
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	
	@ManyToOne
	@JoinColumn(name="leagueId")
	private LeagueDAO league;
	@OneToOne @JoinColumn(name="defaultLocationId")
	private LocationDAO defaultLocation;
	@ManyToMany
	@JoinTable(name="SEASON_TEAMS", joinColumns=@JoinColumn(name="seasonId"), inverseJoinColumns=@JoinColumn(name="teamId"))
	private Collection<TeamDAO> seasonTeamList = new ArrayList<TeamDAO>();
	@OneToMany(mappedBy="leagueSeason")
	private Collection<SeasonEventDAO> eventList = new ArrayList<SeasonEventDAO>();
	private String name;
	//@Temporal(TemporalType.DATE)
	private long startDate;
	//@Temporal(TemporalType.DATE)
	private long endDate;
	//@Temporal(TemporalType.TIME)
	private int eventCount;
	
	private double defaultStartTime;
	private int defaultMaxPlayerPerPool = 5;
	private int defaultCourtCount;
	private int defaultSetConfig;
	private int defaultCapOn15;
	private int defaultCapOn21;
	private int defaultCapOn25;
	private int defaultTimePerPoint;
	
	
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
	
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public LeagueDAO getLeague() {
		return league;
	}
	public void setLeague(LeagueDAO league) {
		this.league = league;
	}
	public LocationDAO getDefaultLocation() {
		return defaultLocation;
	}
	public void setDefaultLocation(LocationDAO defaultLocation) {
		this.defaultLocation = defaultLocation;
	}
	public Collection<TeamDAO> getSeasonTeamList() {
		return seasonTeamList;
	}
	public void setSeasonTeamList(Collection<TeamDAO> seasonTeamList) {
		this.seasonTeamList = seasonTeamList;
	}
	public Collection<SeasonEventDAO> getEventList() {
		return eventList;
	}
	public void setEventList(Collection<SeasonEventDAO> eventList) {
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
	
	
}
