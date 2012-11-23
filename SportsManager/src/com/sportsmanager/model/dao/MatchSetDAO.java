package com.sportsmanager.model.dao;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity (name="MATCH_SET")
public class MatchSetDAO extends BaseDAO  
{
	public static final int SET_TYPE_1X15 = 1;
	public static final int SET_TYPE_2X15 = 11;
	public static final int SET_TYPE_1X21 = 2;
	public static final int SET_TYPE_2X21 = 22;
	public static final int SET_TYPE_2X21_1X15 = 221;
	public static final int SET_TYPE_1X25 = 3;
	public static final int SET_TYPE_2X25 = 33;
	public static final int SET_TYPE_2X25_1X15 = 331;

	@Id 
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	@ManyToOne
	@JoinColumn(name="matchId")
	private EventMatchDAO eventMatch;
	private int setNo; // number of the set
	private int setPoints;
	private int scoreTeam1;
	private int scoreTeam2;
	private int winningTeam;
	private boolean finished;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public EventMatchDAO getEventMatch() {
		return eventMatch;
	}
	public void setEventMatch(EventMatchDAO eventMatch) {
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
