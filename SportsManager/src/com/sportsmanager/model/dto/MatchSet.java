package com.sportsmanager.model.dto;

import java.io.Serializable;


public class MatchSet implements Serializable 
{
	private static final long serialVersionUID = 1L;
	
	private int id;
	private int matchId;
	private EventMatch eventMatch;
	private int setNo; // number of the set
	private int setPoints; // max number of points
	private int scoreTeam1;
	private int scoreTeam2;
	private int winningTeam;
	private boolean finished;
	
	public int getId() 
	{
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public EventMatch getEventMatch() {
		return eventMatch;
	}
	public void setEventMatch(EventMatch eventMatch) {
		this.eventMatch = eventMatch;
	}
	public int getSetNo() {
		return setNo;
	}
	public void setSetNo(int setNo) {
		this.setNo = setNo;
	}
	public int getScoreTeam1() {
		return scoreTeam1;
	}
	public void setScoreTeam1(int scoreTeam1) {
		this.scoreTeam1 = scoreTeam1;
	}
	public int getScoreTeam2() {
		return scoreTeam2;
	}
	public void setScoreTeam2(int scoreTeam2) {
		this.scoreTeam2 = scoreTeam2;
	}
	public void setSetPoints(int setPoints) {
		this.setPoints = setPoints;
	}
	public int getSetPoints() {
		return setPoints;
	}
	public void setMatchId(int matchId) {
		this.matchId = matchId;
	}
	public int getMatchId() {
		return matchId;
	}
	public void setFinished(boolean finished) {
		this.finished = finished;
	}
	public boolean isFinished() {
		return finished;
	}
	public void setWinningTeam(int winningTeam) {
		this.winningTeam = winningTeam;
	}
	public int getWinningTeam() {
		return winningTeam;
	}
	
	
	
}
