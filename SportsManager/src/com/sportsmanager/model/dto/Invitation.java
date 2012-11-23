package com.sportsmanager.model.dto;

import java.io.Serializable;


public class Invitation implements Serializable 
{
	private static final long serialVersionUID = 1L;
	
	public static final int PENDING = 0;
	public static final int ACCEPTED = 1;
	public static final int REJECTED = -1;
	
	private int id;
	private Player fromPlayer;
	private Player toPlayer;
	private Team team;
	private SeasonEvent seasonEvent;
	private int status = 0;
	private String fromMessage;
	private String response;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Player getFromPlayer() {
		return fromPlayer;
	}
	public void setFromPlayer(Player fromPlayer) {
		this.fromPlayer = fromPlayer;
	}
	public Player getToPlayer() {
		return toPlayer;
	}
	public void setToPlayer(Player toPlayer) {
		this.toPlayer = toPlayer;
	}
	public Team getTeam() {
		return team;
	}
	public void setTeam(Team team) {
		this.team = team;
	}
	public SeasonEvent getSeasonEvent() {
		return seasonEvent;
	}
	public void setSeasonEvent(SeasonEvent seasonEvent) {
		this.seasonEvent = seasonEvent;
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
	
	
}
