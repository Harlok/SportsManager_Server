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
import javax.persistence.Transient;

@Entity (name="Event_Match")
public class EventMatchDAO extends BaseDAO  
{
	
	@Id 
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	@ManyToOne
	@JoinColumn(name="eventId")
	private SeasonEventDAO seasonEvent;
	@ManyToOne @JoinColumn(name="eventTeam1")
	private EventTeamDAO eventTeam1;
	@ManyToOne @JoinColumn(name="eventTeam2")
	private EventTeamDAO eventTeam2;
	@OneToMany(mappedBy="eventMatch")
	private Collection<MatchSetDAO> setList = new ArrayList<MatchSetDAO>();

	private int courtNo;
	private int timeSlot;
	private boolean finished;
	private int winningTeam;
	
	@Transient
	private int poolNo;
	@Transient
	private boolean scheduled = false;
	
	public boolean isFinished() {
		return finished;
	}
	public void setFinished(boolean finished) {
		this.finished = finished;
	}
	public int getWinningTeam() {
		return winningTeam;
	}
	public void setWinningTeam(int winningTeam) {
		this.winningTeam = winningTeam;
	}
	
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public void setSeasonEvent(SeasonEventDAO seasonEvent) {
		this.seasonEvent = seasonEvent;
	}
	public SeasonEventDAO getSeasonEvent() {
		return seasonEvent;
	}
	
	public EventTeamDAO getEventTeam1() {
		return eventTeam1;
	}
	public void setEventTeam1(EventTeamDAO eventTeam1) {
		this.eventTeam1 = eventTeam1;
	}
	public EventTeamDAO getEventTeam2() {
		return eventTeam2;
	}
	public void setEventTeam2(EventTeamDAO eventTeam2) {
		this.eventTeam2 = eventTeam2;
	}
	public void setSetList(Collection<MatchSetDAO> setList) {
		this.setList = setList;
	}
	public Collection<MatchSetDAO> getSetList() {
		return setList;
	}
	public void setCourtNo(int courtNo) {
		this.courtNo = courtNo;
	}
	public int getCourtNo() {
		return courtNo;
	}
	public void setTimeSlot(int timeSlot) {
		this.timeSlot = timeSlot;
	}
	public int getTimeSlot() {
		return timeSlot;
	}
	public void setPoolNo(int poolNo) {
		this.poolNo = poolNo;
	}
	public int getPoolNo() {
		return poolNo;
	}
	public void setScheduled(boolean scheduled) {
		this.scheduled = scheduled;
	}
	public boolean isScheduled() {
		return scheduled;
	}
	
//	public TeamSets getTeam1Sets() {
//		return team1Sets;
//	}
//	public void setTeam1Sets(TeamSets team1Sets) {
//		this.team1Sets = team1Sets;
//	}
//	public TeamSets getTeam2Sets() {
//		return team2Sets;
//	}
//	public void setTeam2Sets(TeamSets team2Sets) {
//		this.team2Sets = team2Sets;
//	}
	
	
	
	
	
}
