package com.sportsmanager.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.exception.ConstraintViolationException;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

import com.sportsmanager.model.dao.EventMatchDAO;
import com.sportsmanager.model.dao.EventTeamDAO;
import com.sportsmanager.model.dao.InvitationDAO;
import com.sportsmanager.model.dao.LeagueDAO;
import com.sportsmanager.model.dao.LeagueSeasonDAO;
import com.sportsmanager.model.dao.LevelInterestDAO;
import com.sportsmanager.model.dao.LocationDAO;
import com.sportsmanager.model.dao.MatchSetDAO;
import com.sportsmanager.model.dao.OrganizationDAO;
import com.sportsmanager.model.dao.PlayerDAO;
import com.sportsmanager.model.dao.SeasonEventDAO;
import com.sportsmanager.model.dao.TeamDAO;
import com.sportsmanager.model.dao.TeamPlayerDAO;
import com.sportsmanager.model.dto.EventMatch;
import com.sportsmanager.model.dto.EventTeam;
import com.sportsmanager.model.dto.Invitation;
import com.sportsmanager.model.dto.League;
import com.sportsmanager.model.dto.LeagueSeason;
import com.sportsmanager.model.dto.Location;
import com.sportsmanager.model.dto.MatchSet;
import com.sportsmanager.model.dto.Organization;
import com.sportsmanager.model.dto.Player;
import com.sportsmanager.model.dto.PlayerScheduleItem;
import com.sportsmanager.model.dto.SeasonEvent;
import com.sportsmanager.model.dto.Team;
import com.sportsmanager.model.dto.TeamPlayer;
import com.sportsmanager.model.dto.TransacResult;
import com.sportsmanager.model.util.SchedulerTimeSlot;

public class PlayerService 
{
	private static SessionFactory sessionFactory;
	private static ServiceRegistry serviceRegistry;
	private static String serverVersion = "0.0.4";
	
	public PlayerService() { }
	
	public static Session getSession()
	{
		Session session = null;
		if (getSessionFactory() == null)
		{
			try 
			{
				Configuration cfg = new Configuration().configure();
				serviceRegistry = new ServiceRegistryBuilder().applySettings(cfg.getProperties()).buildServiceRegistry();
				setSessionFactory(cfg.buildSessionFactory(serviceRegistry));
			} 
			catch (Throwable ex) 
			{
				System.err.println("Failed to create sessionFactory object." + ex);
				throw new ExceptionInInitializerError(ex);
			}
		}
		session = getSessionFactory().openSession();
		
		return session;
	}
	
	public Player login(String email, String pssw)
	{
		Player player = null;
		
		Session session = getSession();
		Transaction tx = session.beginTransaction();
		
		
		
		Query query = session.createQuery("from PLAYERS where email = :email and password = :password");
		query.setString("email", email);
		query.setString("password", pssw);
		ArrayList<PlayerDAO> players = (ArrayList<PlayerDAO>)query.list();
		
		System.out.println("Players found: " + players.size());
		if (players.size() == 1)
		{
			player = (Player)players.get(0).asDTO();
			System.out.println("Login with [" + player.getId() + "] " + player.getFirstName() + " " + player.getLastName());
		}
		
		tx.commit();
		session.close();
		
		return player;
	}
	
	public TransacResult savePlayerProfile(Player dto)
	{
		TransacResult result = new TransacResult();
		
		PlayerDAO player = new PlayerDAO();
		player.copyDTO(dto);
		
		Session session = getSession();
		Transaction tx = session.beginTransaction();
		
		System.out.println("Saving player id: " + player.getId() + " " + player.getFirstName() + " " + player.getLastName());
		try
		{
			if (player.getId() == 0) // if the player doesn't have an id
			{
				System.out.println("Using save");
				session.save(player); // create it
			}
			else // otherwise
			{
				System.out.println("Using update");
				session.update(player); // update the existing record.
			}
			tx.commit();
			
			result.setId(player.getId());
			System.out.println("New player id: " + player.getId());
		}
		catch (ConstraintViolationException e1)
		{
			result.setSuccess(false);
			result.setErrorCode(-1);
			result.setMessage("Email address already in use");
		}
		catch (Exception e3)
		{
			result.setSuccess(false);
			result.setErrorCode(-1);
			result.setMessage(e3.getMessage());
		}
		finally
		{
			session.close();
		}
		
		return result;
	}
	
	public Player getPlayerById(int id)
	{
		Player player = null;
		
		return player;
	}
	
	public ArrayList<PlayerScheduleItem> getPlayerSchedule(int playerId)
	{
		ArrayList<PlayerScheduleItem> schedule = new ArrayList<PlayerScheduleItem>();
		
		Map<Integer,Boolean> loadedEvent = new HashMap<Integer, Boolean>(); // Map used to avoid loading duplicate events in schedule.
		long fromDate = Calendar.getInstance().getTime().getTime(); // get current date/time in milliseconds
		fromDate = fromDate - 1000*60*60*24*8; // go back 8 days.
		
		
		Session session = getSession();
		Transaction tx = session.beginTransaction();
		
		String str;
		
		str = "SELECT events.date, events.id, league.id, league.name, team.id, team.name, location.id, location.name ";
		str+= "FROM PLAYERS player ";
		str+= "join player.teamList teamPlayer ";
		str+= "join teamPlayer.team team ";
		str+= "join team.leagueSeasonList seasons ";
		str+= "join seasons.eventList events ";
		str+= "join seasons.league league ";
 		str+= "join seasons.defaultLocation location ";
		str+= "WHERE player.id=:playerId and events.date > :eventDate ";
		
		Query query = session.createQuery(str);
		query.setInteger("playerId", playerId);
		query.setLong("eventDate", 1352157600138L);
		
		List<Object[]> items = query.list();
		PlayerScheduleItem item;
		
		for (Object[] obj : items)
		{
			item = new PlayerScheduleItem((Long)obj[0], (Integer)obj[1], (Integer)obj[2], (String)obj[3], (Integer)obj[4], (String)obj[5], (Integer)obj[6], (String)obj[7]);
			schedule.add(item);
			loadedEvent.put(item.getEventId(), true);
		}
		
		str = "SELECT event.date, event.id, league.id, league.name, team.id, team.name, location.id, location.name ";
		str+= "FROM PLAYERS player ";
		str+= "join player.teamList teamPlayer ";
		str+= "join teamPlayer.team team ";
		str+= "join team.teamEvents teamEvent ";
		str+= "join teamEvent.seasonEvent event ";
		str+= "join event.leagueSeason season ";
		str+= "join season.league league ";
 		str+= "join season.defaultLocation location ";
		str+= "WHERE player.id=:playerId and event.date > :eventDate ";

		query = session.createQuery(str);
		query.setInteger("playerId", 1);
		query.setLong("eventDate", 1352157600138L);
		
		items = query.list();
		
		for (Object[] obj : items)
		{
			item = new PlayerScheduleItem((Long)obj[0], (Integer)obj[1], (Integer)obj[2], (String)obj[3], (Integer)obj[4], (String)obj[5], (Integer)obj[6], (String)obj[7]);
			//if (loadedEvent.get(item.getEventId()) != true)
			if (loadedEvent.get(item.getEventId()) == null)
			{
				schedule.add(item);
			}
		}

		tx.commit();
		session.close();
		
		return schedule;
	}
	
	public ArrayList<Organization> listOrganizations()
	{
		ArrayList<Organization> orgList = new ArrayList<Organization>();
		
		
		return orgList;
	}
	
	public int addOrganization(OrganizationDAO org)
	{
		
		return -1;
	}
	
	public boolean updateOrganization(OrganizationDAO org)
	{
		
		return false;
	}
	
	public ArrayList<League> listLeagues(int organizationId)
	{
		ArrayList<League> leagueList = new ArrayList<League>();
		
		return leagueList;
	}
	
	public int addLeague(int organizationId, LeagueDAO league)
	{
		
		return -1;
	}
	
	public boolean updateLeague(LeagueDAO league)
	{
		return false;
	}
	
	public ArrayList<LeagueSeason> listLeagueSeasons(int leagueId)
	{
		ArrayList<LeagueSeason> seasonList = new ArrayList<LeagueSeason>();
		
		return seasonList;
	}
	
	public int addLeagueSeason(int leagueId, LeagueSeasonDAO season)
	{
		
		return -1;
	}
	
	public boolean updateLeagueSeason(LeagueSeasonDAO leagueSeason)
	{
		
		return false;
	}
	
	public ArrayList<Team> listSeasonTeams(int seasonId)
	{
		ArrayList<Team> teamList = new ArrayList<Team>();
		
		return teamList;
	}
	
	public boolean addSeasonTeam(int seasonId, int teamId)
	{
		return false;
	}
	
	public boolean removeSeasonTeam(int seasonId, int teamId)
	{
		return false;
	}
	
	public ArrayList<SeasonEvent> generateSeasonEvents(int seasonId)
	{
		ArrayList<SeasonEvent> eventList = new ArrayList<SeasonEvent>();
		
		return eventList;
	}
	
	public ArrayList<SeasonEvent> listSeasonEvents(int seasonId)
	{
		ArrayList<SeasonEvent> eventList = new ArrayList<SeasonEvent>();
		
		return eventList;
	}
	
	public int addSeasonEvent(SeasonEventDAO seasonEvent)
	{
		
		return -1;
	}
	
	public boolean updateSeasonEvent(SeasonEventDAO seasonEvent)
	{
		
		return false;
	}
	
	public boolean addEventTeam(int seasonEventId, TeamDAO team)
	{
		
		return false;
	}
	
	public boolean removeEventTeam(int seasonEventId, int teamId)
	{
		
		return false;
	}
	
	public boolean updateEventTeamRankings(int seasonEventId, ArrayList<Object> rankList)
	{
		
		return false;
	}
	
	public TransacResult generateEventSchedule(int eventId)
	{
		TransacResult result = new TransacResult();
		SeasonEventDAO event;
		
		Session session = getSession();
		Transaction tx = session.beginTransaction();
		
		try
		{
			event = (SeasonEventDAO)session.get(SeasonEventDAO.class, eventId);
			if (event == null)
			{
				result.createError(-1, "Evènement invalide");
			}
			else if (event.isScheduleLocked())
			{
				result.createError(-2, "Horaire verrouillé!");
			}
			else
			{
				deleteEventMatches(session, event); // Delete the list of match and team positions.
				if (event.getLeagueSeason().getLeague().getHasSeasonTeams()) // if this league always uses the same teams for each event:
				{
					deleteTeamPositions(session, event);
				}
				copySeasonTeamsToEvent(session, event);
				calculateTeamPositions(session, event);
				createPools(session, event);
				createPoolMatches(session, event);
			}
			
			
			tx.commit();
		}
		catch (Exception e3)
		{
			System.out.println("ERROR: " + e3.getMessage());
			result.createError(-1,e3.getMessage());
		}
		finally
		{
			session.close();
		}
		
		return result;
	}
	
	private void deleteTeamPositions(Session session, SeasonEventDAO event) 
	{
		for (EventTeamDAO team : event.getTeamPosList())
		{
			session.delete(team);
		}
		event.getTeamPosList().clear();
	}

	private void deleteEventMatches(Session session, SeasonEventDAO event) 
	{
		for (EventMatchDAO match : event.getMatchList())
		{
			session.delete(match);
		}
		event.getMatchList().clear();
	}

	private void copySeasonTeamsToEvent(Session session, SeasonEventDAO event) 
	{
		if (event.getLeagueSeason().getLeague().getHasSeasonTeams())
		{
			int pos = 1;
			
			Collection<TeamDAO> oList = event.getLeagueSeason().getSeasonTeamList();
			for (Iterator<TeamDAO> iterator = oList.iterator(); iterator.hasNext();) 
			{
				TeamDAO teamDAO = (TeamDAO) iterator.next();
				EventTeamDAO eventTeam = new EventTeamDAO();
				session.save(eventTeam);
				eventTeam.setTeam(teamDAO);
				eventTeam.setPos(pos++);
				eventTeam.setWon(0);
				eventTeam.setLost(0);
				eventTeam.setSeasonEvent(event);
				event.getTeamPosList().add(eventTeam);
				teamDAO.getTeamEvents().add(eventTeam);
			}
		}
		else
		{
			System.out.println("This event is not part of a league which has season teams.");
		}
		
	}
	
	private void calculateTeamPositions(Session session,SeasonEventDAO event) 
	{
		SeasonEventDAO previousEvent = null; // go get the previous event to calculate who goes up or down
		
		Collection<EventTeamDAO> teamList = event.getTeamPosList();
		if (previousEvent == null) // if there is no previous event
		{
			int pos = 1;
			for (Iterator<EventTeamDAO> iterator = teamList.iterator(); iterator.hasNext();) 
			{
				EventTeamDAO team = (EventTeamDAO) iterator.next();
				team.setPos(pos++);
			}
		}
		else
		{
			// Calculate based on previous scores
		}
	}
	
	private void createPools(Session session, SeasonEventDAO event) 
	{
		int maxPlayersPerPool = event.getMaxPlayerPerPool();
		int poolNo, i, teamNo;
		EventTeamDAO team;
		
		List<EventTeamDAO> teamList = new ArrayList<EventTeamDAO>(event.getTeamPosList());
		
		Collections.sort(teamList, new Comparator<EventTeamDAO>() {
			public int compare(EventTeamDAO t1, EventTeamDAO t2) 
			{ 
				return (t1.getPos() - t2.getPos()); 
			}
		});
		
		int[] poolSize = getPoolCounts(teamList.size(), maxPlayersPerPool);

		teamNo=0;
		for (poolNo=0; poolNo<poolSize.length; poolNo++)
		{
			for (i=0; i<poolSize[poolNo]; i++)
			{
				team = teamList.get(teamNo++);
				team.setPool(poolNo+1);
				//System.out.println("Team " + team.getId() + " pos = " + team.getPos() + " pool = " + team.getPool()); 
			}
			if ((poolNo+1) > event.getPoolCount()) 
			{ 
				event.setPoolCount(poolNo+1); 
			}
		}
	}

	private int[] getPoolCounts(int teamCount, int maxPoolSize)
	{
		//List<Integer> pool = new ArrayList<Integer>();
		int teamsLeft = teamCount;
		int poolCount = (int)Math.ceil((double)teamsLeft/maxPoolSize);
		int[] pool = new int[poolCount];
		int[] revPool = new int[poolCount];
		int poolNo = 0;
		int poolSize;
		
		while (teamsLeft > 0)
		{
			poolSize = (int)Math.round(teamsLeft/poolCount);
			pool[poolNo++] = poolSize;
			
			teamsLeft = teamsLeft - poolSize;
			poolCount--;
		}
		Arrays.sort(pool);
		
		for (int i=0; i<pool.length; i++)
		{
			revPool[i] = pool[pool.length-1-i];
		}
		
//		String str = teamCount + " / " + maxPoolSize + " = ";
//		for (poolNo=0; poolNo < revPool.length; poolNo++)
//		{
//			str += "," + revPool[poolNo];
//		}
//		System.out.println(str);
		
		return revPool;
	}
	
	private void createPoolMatches(Session session, SeasonEventDAO event)
	{
		int poolNo;
		//int maxPool = 0;
		//TeamDAO team;
		ArrayList<ArrayList<EventTeamDAO>> poolList = new ArrayList<ArrayList<EventTeamDAO>>();
		ArrayList<ArrayList<EventMatchDAO>> poolMatchList = new ArrayList<ArrayList<EventMatchDAO>>();
		
		for (int i=0; i<event.getPoolCount(); i++)
		{
			poolList.add(new ArrayList<EventTeamDAO>());
			poolMatchList.add(new ArrayList<EventMatchDAO>());
		}
		
		// Place each team in their pool
		//String[] letter = {"", "A","B","C","D","E","F","G","H"};
		for (EventTeamDAO eventTeam : event.getTeamPosList())
		{
			poolNo = eventTeam.getPool();
			ArrayList<EventTeamDAO> pool = poolList.get(poolNo-1); // Get the pool in which this team goes.
			eventTeam.setHappy(event.getMaxPlayerPerPool() + 1 - pool.size()); // Start top down so teams 1,2,3,4,5 will be happy 5,4,3,2,1. So 5 starts agains 4.
			pool.add(eventTeam); // add this team to their pool.
			// TODO Remove altering team names in createPoolMatches
			//eventTeam.getTeam().setName(letter[eventTeam.getPool()] + pool.size()); // Change name to A1, A2, A3, B1, B2, B3...
		}
		
		
		int maxCombo = 0;
		
		for (ArrayList<EventTeamDAO> pool : poolList)
		{
			EventTeamDAO teamPos1;
			EventTeamDAO teamPos2;
			
			EventTeamDAO teamPos[] = pool.toArray(new EventTeamDAO[pool.size()]);
			for (int i=0; i<(teamPos.length-1); i++)
			{
				teamPos1 = teamPos[i];
				for (int j=(i+1); j<teamPos.length; j++)
				{
					poolNo = teamPos1.getPool();
					//ArrayList<EventMatchDAO> matchList = poolMatchList.get(poolNo-1); 
					teamPos2 = teamPos[j];
					//System.out.println("Matching " + teamPos1.getTeam().getName() + " vs " + teamPos2.getTeam().getName());
					ArrayList<EventMatchDAO> poolMatches = poolMatchList.get(poolNo-1);
					EventMatchDAO match = new EventMatchDAO();
					match.setSeasonEvent(event);
					match.setEventTeam1(teamPos1);
					match.setEventTeam2(teamPos2);
					match.setPoolNo(poolNo);
					session.save(match);
					poolMatches.add(match);
					if (poolMatches.size() > maxCombo) { maxCombo = poolMatches.size(); } // Keep the greatest number of pool match combinations.
				}
			}
		}
		
		int ctr = 1;
		ArrayList<EventMatchDAO> altMatchList = new ArrayList<EventMatchDAO>();
		for (int i=0; i<maxCombo; i++)
		{
			for (int j=0; j<poolMatchList.size(); j++)
			{
				ArrayList<EventMatchDAO> poolMatches = poolMatchList.get(j);
				int pos;
				if (i%2 == 1) // Alternate position from beginning to end of each matchList.
				{
					pos = (i-1)/2;
				}
				else
				{
					pos = maxCombo - 1 - (i/2);
				}
				//System.out.println("i = " + i + " = " + pos);
				
				if (poolMatches.size() > pos) // if this pool has more matches than the current i position:
				{
					EventMatchDAO match = poolMatches.get(pos);
					altMatchList.add(match);
					//System.out.println("Match " + ctr++ + " = " + match.getEventTeam1().getTeam().getName() + " --- " + match.getEventTeam2().getTeam().getName());
				}
				else
				{
					//System.out.println("Match " + ctr++ + " = SKIP!");
				}
			}
		}
		
		
		ArrayList<SchedulerTimeSlot> slotList = new ArrayList<SchedulerTimeSlot>();
		Boolean added;
		SchedulerTimeSlot slot;
		for (int i=0; i<altMatchList.size(); i++)
		{
			EventMatchDAO match = altMatchList.get(i);
			added = false;
			for (int j=0; j<slotList.size(); j++) // for each existing time slot:
			{
				slot = slotList.get(j);
				added = slot.addMatch(match);
				if (added) { break; }
			}
			if (!added) // if we were not able to insert this match in ANY of the existing slots:
			{
				slot = new SchedulerTimeSlot(event.getCourtCount());
				slotList.add(slot); // add this slot to the list
				slot.addMatch(match);
			}
		}
		
		
		
		for (int i=0; i<slotList.size(); i++)
		{
			slotList.get(i).sortByPool();
			
			String str = "Slot " + i + " = ";
			int court = 1;
			for (EventMatchDAO match : slotList.get(i).getMatchList())
			{
				str += "[" + court + "]";
				if (match != null)
				{
					match.setTimeSlot(i);
					match.setCourtNo(court);
					str += match.getEventTeam1().getTeam().getName() + " / " + match.getEventTeam2().getTeam().getName() + "     ";
					court++;
				}
			}
			System.out.println(str);
		}
		
		
	}
	
	public SeasonEvent getEventPackage(int eventId)
	{
//		EventPackage pack = new EventPackage();
//		pack.setSeasonEvent(getSeasonEvent(eventId));
//		//pack.setTeamList(listEventTeams(eventId));
//		pack.setMatchList(listEventMatches(eventId));
//		pack.setTeamList(new ArrayList<Team>());
//		pack.setPlayerList(new ArrayList<Player>());
//		pack.setTeamPlayerList(new ArrayList<TeamPlayer>());
		
		SeasonEvent eventDTO = new SeasonEvent();
		EventTeam eventTeam;
		Team team; 
		TeamPlayer teamPlayer;
		//Player player;
		EventMatch eventMatch;
		
		Session session = getSession();
		
		try
		{
			SeasonEventDAO eventDAO = (SeasonEventDAO)session.get(SeasonEventDAO.class, eventId);
			eventDTO = (SeasonEvent)eventDAO.asDTO();
			
			for (EventTeamDAO teamPos : eventDAO.getTeamPosList())
			{
				eventTeam = (EventTeam)teamPos.asDTO();
				eventDTO.getTeamPosList().add(eventTeam);
				
				team = (Team)teamPos.getTeam().asDTO();
				eventTeam.setTeam(team);
				
				for (TeamPlayerDAO teamPlayerDAO: teamPos.getTeam().getTeamPlayers())
				{
					teamPlayer = (TeamPlayer)teamPlayerDAO.asDTO();
					//eventTeam.getTeamPlayerList().add(teamPlayer);
					team.getTeamPlayers().add(teamPlayer);
					teamPlayer.setPlayer((Player)teamPlayerDAO.getPlayer().asDTO());
				}
			}
			
			for (EventMatchDAO eventMatchDAO : eventDAO.getMatchList())
			{
				eventMatch = (EventMatch)eventMatchDAO.asDTO();
				eventDTO.getMatchList().add(eventMatch);
				eventMatch.setEventId(eventDTO.getId()); // set back track from match to event
				eventMatch.setTeam1Id(eventMatchDAO.getEventTeam1().getTeam().getId());
				eventMatch.setTeam2Id(eventMatchDAO.getEventTeam2().getTeam().getId());
			}
		}
		catch (Exception e3)
		{
			//result.setError(-1,e3.getMessage());
		}
		finally
		{
			session.close();
		}
		
		return eventDTO;
	}
	
	public SeasonEvent getSeasonEvent(int eventId)
	{
		SeasonEvent seasonEvent = new SeasonEvent();
	
		Session session = getSession();
		
		try
		{
			SeasonEventDAO event = (SeasonEventDAO)session.get(SeasonEventDAO.class, eventId);
			seasonEvent = (SeasonEvent)event.asDTO();
		}
		catch (Exception e3)
		{
			//result.setError(-1,e3.getMessage());
		}
		finally
		{
			session.close();
		}
		
		return seasonEvent;	
			
	}
	
	public ArrayList<Team> listEventTeams(int eventId)
	{
		ArrayList<Team> teamList = new ArrayList<Team>();
		Team team; 
		
		Session session = getSession();
		
		try
		{
			SeasonEventDAO event = (SeasonEventDAO)session.get(SeasonEventDAO.class, eventId);
			for (EventTeamDAO teamPos :event.getTeamPosList())
			{
				team = new Team();
				team.setId(teamPos.getTeam().getId());
				team.setName(teamPos.getTeam().getName());
				team.setPool(teamPos.getPool());
				team.setPos(teamPos.getPos());
				team.setWon(teamPos.getWon());
				team.setLost(teamPos.getLost());
				teamList.add(team);
			}
		}
		catch (Exception e3)
		{
			//result.setError(-1,e3.getMessage());
		}
		finally
		{
			session.close();
		}
		
		return teamList;
		
	}
	
	public ArrayList<EventMatch> listEventMatches(int eventId)
	{
		ArrayList<EventMatch> matchList = new ArrayList<EventMatch>();
		EventMatch match;
		Session session = getSession();
		
		try
		{
			SeasonEventDAO event = (SeasonEventDAO)session.get(SeasonEventDAO.class, eventId);
			for (EventMatchDAO matchDAO : event.getMatchList())
			{
				match = new EventMatch();
				match.setId(matchDAO.getId());
				match.setTeam1Id(matchDAO.getEventTeam1().getTeam().getId());
				match.setTeam2Id(matchDAO.getEventTeam2().getTeam().getId());
				match.setCourtNo(matchDAO.getCourtNo());
				match.setTimeSlot(matchDAO.getTimeSlot());
				matchList.add(match);
			}
		}
		catch (Exception e3)
		{
			//result.setError(-1,e3.getMessage());
		}
		finally
		{
			session.close();
		}
		
		return matchList;
	}
	
	public ArrayList<MatchSet> listMatchSets(int matchId)
	{
		ArrayList<MatchSet> setList = new ArrayList<MatchSet>();
		
		Session session = getSession();
		
		try
		{
			EventMatchDAO matchDAO = (EventMatchDAO)session.get(EventMatchDAO.class, matchId);
			
			for (MatchSetDAO setDAO : matchDAO.getSetList())
			{
				setList.add((MatchSet)setDAO.asDTO());
			}
		}
		catch (Exception e3)
		{
			//result.setError(-1,e3.getMessage());
		}
		finally
		{
			session.close();
		}
		
		return setList;
	}
	
	public TransacResult saveSetScore(MatchSet matchSet)
	{
		TransacResult result = new TransacResult();
		MatchSetDAO setDAO;// = new MatchSetDAO();
		//setDAO.copyDTO(matchSet);
		
		Session session = getSession();
		Transaction tx = session.beginTransaction();

		try
		{
			System.out.println("matchSet.getId() = " + matchSet.getId());
			if (matchSet.getId() == 0) // if the player doesn't have an id
			{
				// Creating MatchSet
				System.out.println("Using save");
				EventMatchDAO match = (EventMatchDAO)session.get(EventMatchDAO.class, matchSet.getMatchId()); // find the match to link to this set
				setDAO = new MatchSetDAO();
				setDAO.copyDTO(matchSet);
				setDAO.setEventMatch(match);
				match.getSetList().add(setDAO);
				session.save(setDAO); // create it
				result.setId(setDAO.getId());
				System.out.println("New set id: " + setDAO.getId() + " finished = " + setDAO.isFinished());
			}
			else // otherwise
			{
				System.out.println("Using update");
				setDAO = (MatchSetDAO)session.get(MatchSetDAO.class, matchSet.getId());
				setDAO.setScoreTeam1(matchSet.getScoreTeam1());
				setDAO.setScoreTeam2(matchSet.getScoreTeam2());
				setDAO.setFinished(matchSet.isFinished());
				setDAO.setWinningTeam(matchSet.getWinningTeam());
				session.update(setDAO); // update the existing record.
				System.out.println("Saved set id: " + setDAO.getId() + " finished = " + setDAO.isFinished());
			}
			tx.commit();
			
		}
		catch (Exception e3)
		{
			result.createError(-1,e3.getMessage());
		}
		finally
		{
			session.close();
		}
		
		return result;
	}
	
	public int createTeam(TeamDAO team)
	{
		
		return -1;
	}
	
	public TransacResult addTeamPlayer(int teamId, int playerId, int position)
	{
		TransacResult result = new TransacResult();

		
		Session session = getSession();
		Transaction tx = session.beginTransaction();

		try
		{
			TeamDAO team = (TeamDAO)session.get(TeamDAO.class, teamId);
			PlayerDAO player = (PlayerDAO)session.get(PlayerDAO.class, 555);
			
			
			tx.commit();
		}
		catch (Exception e3)
		{
			result.createError(-1,e3.getMessage());
		}
		finally
		{
			session.close();
		}
		
		return result;
	}
	
	public boolean removeTeamPlayer(int teamId, int playerId)
	{
		
		return false;
	}
	
	public ArrayList<Invitation> listPlayerInvitations(int playerId)
	{
		ArrayList<Invitation> inviteList = new ArrayList<Invitation>();
		
		return inviteList;
	}
	
	public boolean addInvitation(Invitation invite)
	{
		
		return false;
	}
	
	public boolean updateInvitation(InvitationDAO invite)
	{
		
		return false;
	}
	
	public ArrayList<Player> listLeagueAdministrators(int leagueId)
	{
		ArrayList<Player> adminList = new ArrayList<Player>();
		
		return adminList;
	}
	
	public boolean setPlayerLevelInterest(int playerId, LevelInterestDAO interest)
	{
		
		return true;
	}
	
	public ArrayList<Location> listLocations()
	{
		ArrayList<Location> locList = new ArrayList<Location>();
		
		return locList;
	}
	
	public TransacResult addLocation(Location location)
	{
		TransacResult result = new TransacResult();
		LocationDAO locationDAO = new LocationDAO();
		locationDAO.copyDTO(location);
		
		Session session = getSession();
		Transaction tx = session.beginTransaction();
		
		//System.out.println("addLocation id: " + locationDAO.getId() + " " + locationDAO.getName());
		try
		{
			if (locationDAO.getId() == 0) { session.save(locationDAO);   }
			else                       { session.update(locationDAO); }
			tx.commit();
			result.setId(locationDAO.getId());
		}
		catch (Exception e3)
		{
			result.createError(-1,e3.getMessage());
		}
		finally
		{
			session.close();
		}
		
		return result;
	}
	
	public String getServerVersion()
	{
		return serverVersion;
	}
	
	public boolean testConnection()
	{
		return true;
	}

	public static void setSessionFactory(SessionFactory sessionFactory) {
		PlayerService.sessionFactory = sessionFactory;
	}

	public static SessionFactory getSessionFactory() {
		return sessionFactory;
	}
	
}
