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

@Entity (name="LEAGUES")
public class LeagueDAO extends BaseDAO  
{
	
	@Id @GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	@ManyToOne
	@JoinColumn(name="orgId")
	private OrganizationDAO organization;
	private String name;
	@ManyToOne
	@JoinColumn(name="volleyTypeId")
	private VolleyTypeDAO volleyType;
	@OneToMany(mappedBy="league")
	private Collection<LeagueSeasonDAO> seasonList = new ArrayList<LeagueSeasonDAO>();
	@OneToMany(mappedBy="league")
	private Collection<LeagueAdminDAO> adminList = new ArrayList<LeagueAdminDAO>();

	private Boolean hasSeasonTeams;
	
	public void setId(int leagueId) {
		this.id = leagueId;
	}
	public int getId() {
		return id;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getName() {
		return name;
	}
	public void setOrganization(OrganizationDAO organization) {
		this.organization = organization;
	}
	public OrganizationDAO getOrganization() {
		return organization;
	}
	public void setHasSeasonTeams(Boolean hasSeasonTeams) {
		this.hasSeasonTeams = hasSeasonTeams;
	}
	public Boolean getHasSeasonTeams() {
		return hasSeasonTeams;
	}
	public void setSeasonList(Collection<LeagueSeasonDAO> seasonList) {
		this.seasonList = seasonList;
	}
	public Collection<LeagueSeasonDAO> getSeasonList() {
		return seasonList;
	}
	public void setVolleyType(VolleyTypeDAO volleyType) {
		this.volleyType = volleyType;
	}
	public VolleyTypeDAO getVolleyType() {
		return volleyType;
	}
	public void setAdminList(Collection<LeagueAdminDAO> adminList) {
		this.adminList = adminList;
	}
	public Collection<LeagueAdminDAO> getAdminList() {
		return adminList;
	}
	
	
	
}
