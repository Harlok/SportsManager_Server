package com.sportsmanager.model.dao;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;


@Entity (name="PLAYERS")
public class PlayerDAO extends BaseDAO 
{
	private static final long serialVersionUID = 1L;

	public static final int SETTER = 1;
	public static final int TECH = 2;
	public static final int CENTER = 3;
	public static final int POWER = 4;
	public static final int LIBERO = 6;
	public static final int BEACH_LEFT = 10;
	public static final int BEACH_RIGHT = 11;
	
	
	@Id 
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	private String firstName;
	private String lastName;
	@Column(unique=true)
	private String email;
	private String phone;
	private String zipCode;
	private int sex;
	private int height;
	private long birthDate;
	private float latitude;
	private float longitude;
	private String password;
	
	@OneToMany(mappedBy="player")
	private Collection<TeamPlayerDAO> teamList = new ArrayList<TeamPlayerDAO>();
	
	@OneToMany(mappedBy="fromPlayer")
	private Collection<InvitationDAO> invitationsSent = new ArrayList<InvitationDAO>();
	
	@OneToMany(mappedBy="toPlayer")
	private Collection<InvitationDAO> invitationsReceived = new ArrayList<InvitationDAO>();
	
	@OneToMany(mappedBy="player")
	private Collection<LeagueAdminDAO> adminList = new ArrayList<LeagueAdminDAO>();
	
	@ManyToMany
	@JoinTable(name="player_league_interest", joinColumns=@JoinColumn(name="playerId"), inverseJoinColumns=@JoinColumn(name="leagueSeasonId"))
	private Collection<LeagueSeasonDAO> leagueSeasonInterest = new ArrayList<LeagueSeasonDAO>();

	@OneToMany(mappedBy="player")
	private Collection<LevelInterestDAO> levelInterestList = new ArrayList<LevelInterestDAO>();
	
	@OneToMany(mappedBy="player")
	private Collection<PlayerAvailabilityDAO> availabilityList = new ArrayList<PlayerAvailabilityDAO>();

	
	public PlayerDAO()
	{
		super();
	}
	
	public PlayerDAO(String firstName, String lastName, String email, String password) 
	{
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.password = password;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getZipCode() {
		return zipCode;
	}
	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}
	public int getSex() {
		return sex;
	}
	public void setSex(int sex) {
		this.sex = sex;
	}
	public int getHeight() {
		return height;
	}
	public void setHeight(int height) {
		this.height = height;
	}
	public long getBirthDate() {
		return birthDate;
	}
	public void setBirthDate(long birthDate) {
		this.birthDate = birthDate;
	}
	public float getLatitude() {
		return latitude;
	}
	public void setLatitude(float latitude) {
		this.latitude = latitude;
	}
	public float getLongitude() {
		return longitude;
	}
	public void setLongitude(float longitude) {
		this.longitude = longitude;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public void setTeamList(Collection<TeamPlayerDAO> teamList) {
		this.teamList = teamList;
	}
	public Collection<TeamPlayerDAO> getTeamList() 
	{
		return teamList;
	}
	public void setInvitationsSent(Collection<InvitationDAO> invitationsSent) {
		this.invitationsSent = invitationsSent;
	}
	public Collection<InvitationDAO> getInvitationsSent() {
		return invitationsSent;
	}
	public void setInvitationsReceived(Collection<InvitationDAO> invitationsReceived) {
		this.invitationsReceived = invitationsReceived;
	}
	public Collection<InvitationDAO> getInvitationsReceived() {
		return invitationsReceived;
	}
	public void setAdminList(Collection<LeagueAdminDAO> adminList) {
		this.adminList = adminList;
	}
	public Collection<LeagueAdminDAO> getAdminList() {
		return adminList;
	}
	public void setLeagueSeasonInterest(Collection<LeagueSeasonDAO> leagueSeasonInterest) {
		this.leagueSeasonInterest = leagueSeasonInterest;
	}
	public Collection<LeagueSeasonDAO> getLeagueSeasonInterest() {
		return leagueSeasonInterest;
	}
	public void setLevelInterestList(Collection<LevelInterestDAO> levelInterestList) {
		this.levelInterestList = levelInterestList;
	}
	public Collection<LevelInterestDAO> getLevelInterestList() {
		return levelInterestList;
	}
	public void setAvailabilityList(Collection<PlayerAvailabilityDAO> availabilityList) {
		this.availabilityList = availabilityList;
	}
	public Collection<PlayerAvailabilityDAO> getAvailabilityList() {
		return availabilityList;
	}

}
