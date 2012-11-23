package com.sportsmanager.model.dao;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity (name="Invitations")
public class InvitationDAO extends BaseDAO  
{
	public static final int PENDING = 0;
	public static final int ACCEPTED = 1;
	public static final int REJECTED = -1;

	private static final long serialVersionUID = 1L;
	
	@Id 
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	@ManyToOne
	@JoinColumn(name="fromPlayerId")
	private PlayerDAO fromPlayer;
	@ManyToOne
	@JoinColumn(name="toPlayerId")
	private PlayerDAO toPlayer;
	@ManyToOne
	@JoinColumn(name="teamId")
	private TeamDAO team;
	@ManyToOne
	@JoinColumn(name="eventId")
	private SeasonEventDAO seasonEvent;
	
	private int status = 0;
	private String fromMessage;
	private String response;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public PlayerDAO getFromPlayer() {
		return fromPlayer;
	}
	public void setFromPlayer(PlayerDAO fromPlayer) {
		this.fromPlayer = fromPlayer;
	}
	public PlayerDAO getToPlayer() {
		return toPlayer;
	}
	public void setToPlayer(PlayerDAO toPlayer) {
		this.toPlayer = toPlayer;
	}
	public TeamDAO getTeam() {
		return team;
	}
	public void setTeam(TeamDAO team) {
		this.team = team;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public String getFromMessage() {
		return fromMessage;
	}
	public void setFromMessage(String fromMessage) {
		this.fromMessage = fromMessage;
	}
	public String getResponse() {
		return response;
	}
	public void setResponse(String response) {
		this.response = response;
	}
	public void setSeasonEvent(SeasonEventDAO seasonEvent) {
		this.seasonEvent = seasonEvent;
	}
	public SeasonEventDAO getSeasonEvent() {
		return seasonEvent;
	}
	
	
	
}
