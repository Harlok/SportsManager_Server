package com.sportsmanager.model.dao;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity (name="SEASON_EVENTS")
public class SeasonEventDAO extends BaseDAO  
{
	@Id 
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	@ManyToOne
	@JoinColumn(name="seasonId")
	private LeagueSeasonDAO leagueSeason;
	private long date;
	@OneToMany(mappedBy="seasonEvent")
	private Collection<EventTeamDAO> teamPosList = new ArrayList<EventTeamDAO>();
	@OneToMany(mappedBy="seasonEvent")
	private Collection<EventMatchDAO> matchList = new ArrayList<EventMatchDAO>();
	@OneToMany(mappedBy="seasonEvent")
	private Collection<InvitationDAO> teamInvitations = new ArrayList<InvitationDAO>();
	@OneToOne @JoinColumn(name="locationId")
	private LocationDAO location;
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
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public LeagueSeasonDAO getLeagueSeason() {
		return leagueSeason;
	}
	public void setLeagueSeason(LeagueSeasonDAO leagueSeason) {
		this.leagueSeason = leagueSeason;
	}
	public long getDate() {
		return date;
	}
	public void setDate(long date) {
		this.date = date;
	}
	public Collection<EventTeamDAO> getTeamPosList() {
		return teamPosList;
	}
	public void setTeamPosList(Collection<EventTeamDAO> teamPosList) {
		this.teamPosList = teamPosList;
	}
	public Collection<EventMatchDAO> getMatchList() {
		return matchList;
	}
	public void setMatchList(Collection<EventMatchDAO> matchList) {
		this.matchList = matchList;
	}
	public Collection<InvitationDAO> getTeamInvitations() {
		return teamInvitations;
	}
	public void setTeamInvitations(Collection<InvitationDAO> teamInvitations) {
		this.teamInvitations = teamInvitations;
	}
	public LocationDAO getLocation() {
		return location;
	}
	public void setLocation(LocationDAO location) {
		this.location = location;
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
	public boolean isScheduleLocked() {
		return scheduleLocked;
	}
	public void setScheduleLocked(boolean scheduleLocked) {
		this.scheduleLocked = scheduleLocked;
	}
	public int getPoolCount() {
		return poolCount;
	}
	public void setPoolCount(int poolCount) {
		this.poolCount = poolCount;
	}	
}
