import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

import com.sportsmanager.model.dao.EventTeamDAO;
import com.sportsmanager.model.dao.LeagueDAO;
import com.sportsmanager.model.dao.LeagueSeasonDAO;
import com.sportsmanager.model.dao.LocationDAO;
import com.sportsmanager.model.dao.MatchSetDAO;
import com.sportsmanager.model.dao.OrganizationDAO;
import com.sportsmanager.model.dao.PlayerDAO;
import com.sportsmanager.model.dao.SeasonEventDAO;
import com.sportsmanager.model.dao.TeamDAO;
import com.sportsmanager.model.dao.TeamPlayerDAO;
import com.sportsmanager.model.dao.VolleyLevelDAO;
import com.sportsmanager.model.dao.VolleyTypeDAO;
import com.sportsmanager.model.dto.MatchSet;
import com.sportsmanager.model.dto.Player;
import com.sportsmanager.service.PlayerService;

public class main {

	private static SessionFactory sessionFactory;
	private static ServiceRegistry serviceRegistry;
	
	public static void main(String[] args) 
	{
		System.out.println("main+param)");
		//testLogin("test@test.com","qwerty");
		
		//createContent();
		//createEventSchedule();
		
		//testCloning();
		//testCreatePlayer();
		//testCopyDTO();
		
		//getPoolCounts(18,5);
		
		PlayerService ps = new PlayerService();
		//ps.getPlayerSchedule(1);
		ps.getEventPackage(21);
		
		
		System.out.println("main.DONE!");
	}
	
	private static void createEventSchedule() 
	{
		int eventId = 21;
		PlayerService ps = new PlayerService();
		ps.generateEventSchedule(eventId);
	}

	private static void testCopyDTO() 
	{
//		Player player = new Player();
//		player.setId(555);
//		player.setFirstName("Loki");
//		player.setLastName("Patawow");
//		player.setEmail("loki.patawow@gmail.com");
//		
//		PlayerDAO dao = new PlayerDAO();
//		dao.copyDTO(player);
//		System.out.println("Copied player id " + dao.getId() + " " + dao.getFirstName() + " " + dao.getLastName() + " " + dao.getEmail());
		
		MatchSet dto = new MatchSet();
		dto.setSetNo(1);
		dto.setScoreTeam1(10);
		dto.setScoreTeam2(15);
		dto.setSetPoints(25);
		
		MatchSetDAO dao = new MatchSetDAO();
		dao.copyDTO(dto);
	}

	private static void testCreatePlayer() 
	{
		Player player = new Player();
		player.setFirstName("test");
		player.setLastName("test");
		player.setEmail("test@test.com");
		
		PlayerService ps = new PlayerService();
		ps.savePlayerProfile(player);
		
	}

	private static void testCloning() 
	{
		Player dto;// = new Player();
		PlayerDAO dao = new PlayerDAO();
		
		dao.setId(555);
		dao.setFirstName("Luc");
		dao.setLastName("Chevalier");
		
		dto = (Player)dao.asDTO();
		
	}

	private static void testLogin(String email, String password)
	{
		PlayerService ps = new PlayerService();
		ps.login(email, password);
	}

	public static void addPlayerToTeam(Session session, TeamDAO team, PlayerDAO player, int pos)
	{
		TeamPlayerDAO teamPlayer = new TeamPlayerDAO();
		session.save(teamPlayer);
		teamPlayer.setPlayer(player);
		teamPlayer.setRole(pos);
		teamPlayer.setTeam(team);
		team.getTeamPlayers().add(teamPlayer);
		player.getTeamList().add(teamPlayer);
	}
	
	private static void createContent() 
	{
		System.out.println("createOrg.start)");
		Session session = null;
		try
		{
			
			session = PlayerService.getSession();
			Transaction tx = session.beginTransaction();

			PlayerService ps = new PlayerService();
			
			// LOCATIONS
			
			LocationDAO loc1 = new LocationDAO();
			session.save(loc1);
			loc1.setName("Espace Griffintown");
			loc1.setCity("Montreal");
			loc1.setProvince("Québec");
			loc1.setCountry("Canada");
			//ps.addLocation(loc1);
			
			LocationDAO loc2 = new LocationDAO();
			session.save(loc2);
			loc2.setName("Charlemagne");
			loc2.setCity("Charlemagne");
			loc2.setProvince("Québec");
			loc2.setCountry("Canada");
			//ps.addLocation(loc2);
			// VOLLEY TYPES
			
			VolleyTypeDAO volleyType1 = new VolleyTypeDAO(0, 0, 2, "BFEM2", "2x2 Beach Féminin");
			VolleyTypeDAO volleyType2 = new VolleyTypeDAO(0, 1, 2, "BMAS2", "2x2 Beach Masculin");
			VolleyTypeDAO volleyType3 = new VolleyTypeDAO(0, 2, 2, "BMIX2", "2x2 Beach Mixed");
			VolleyTypeDAO volleyType4 = new VolleyTypeDAO(0, 0, 4, "BFEM4", "4x4 Beach Féminin");
			VolleyTypeDAO volleyType5 = new VolleyTypeDAO(0, 1, 4, "BMAS4", "4x4 Beach Masculin");
			VolleyTypeDAO volleyType6 = new VolleyTypeDAO(0, 2, 4, "BMIX4", "4x4 Beach Mixed");
			VolleyTypeDAO volleyType7 = new VolleyTypeDAO(1, 0, 4, "IFEM4", "4x4 Féminin Intérieur");
			VolleyTypeDAO volleyType8 = new VolleyTypeDAO(1, 1, 4, "IMAS4", "4x4 Masculin Intérieur");
			VolleyTypeDAO volleyType9 = new VolleyTypeDAO(1, 2, 4, "IMIX4", "4x4 Mixed Intérieur");
			VolleyTypeDAO volleyType10 = new VolleyTypeDAO(1, 0, 6, "IFEM6", "6x6 Féminin Intérieur");
			VolleyTypeDAO volleyType11 = new VolleyTypeDAO(1, 1, 6, "IMAS6", "6x6 Masculin Intérieur");
			VolleyTypeDAO volleyType12 = new VolleyTypeDAO(1, 2, 6, "IMIX6", "6x6 Mixed Intrérieur");
			session.save(volleyType1);
			session.save(volleyType2);
			session.save(volleyType3);
			session.save(volleyType4);
			session.save(volleyType5);
			session.save(volleyType6);
			session.save(volleyType7);
			session.save(volleyType8);
			session.save(volleyType9);
			session.save(volleyType10);
			session.save(volleyType11);
			session.save(volleyType12);
			
			// LEVELS
			
			VolleyLevelDAO levelD = new VolleyLevelDAO(2,"D");
			VolleyLevelDAO levelC = new VolleyLevelDAO(5,"C");
			VolleyLevelDAO levelB = new VolleyLevelDAO(8,"B");
			VolleyLevelDAO levelA = new VolleyLevelDAO(11,"A");
			VolleyLevelDAO levelAA = new VolleyLevelDAO(14,"AA");
			VolleyLevelDAO levelAAA = new VolleyLevelDAO(17,"AAA");
			VolleyLevelDAO levelOPEN = new VolleyLevelDAO(20,"OPEN");
			session.save(levelD);
			session.save(levelC);
			session.save(levelB);
			session.save(levelA);
			session.save(levelAA);
			session.save(levelAAA);
			session.save(levelOPEN);
			
			// PLAYERS
			
			PlayerDAO player1 = new PlayerDAO("Luc","Chevalier","lucchevalier@hotmail.com","qwerty");
			PlayerDAO player2 = new PlayerDAO("Julie","Marquis","julie.marquis@hotmail.com","12345");
			PlayerDAO player3 = new PlayerDAO("Sylvain","Baril","sylvain.baril@hec.ca","1234");
			PlayerDAO player4 = new PlayerDAO("Chloé","Hardy","sway_24@hotmail.com","12345");
			PlayerDAO player5 = new PlayerDAO("Michael","Gaucher","gaucmich@hotmail.com","12345");
			PlayerDAO player6 = new PlayerDAO("Stephanie","Bazinet","sbazinet@hotmail.com","12345");
			PlayerDAO player7 = new PlayerDAO("Philippe","Roth","philippe.roth@gmail.com","12345");
			PlayerDAO player8 = new PlayerDAO("Virginie","Malette","euiltherese@hotmail.com","12345");
			PlayerDAO player9 = new PlayerDAO("Clodine","Dupuis","clodupuis@hotmail.com","12345");
			PlayerDAO player10 = new PlayerDAO("David","Turgeon","david@nsbspecialistes.com","12345");

			PlayerDAO player11 = new PlayerDAO("FN11","LN11","test11@hotmail.com","12345");
			PlayerDAO player12 = new PlayerDAO("FN12","LN12","test12@hotmail.com","12345");
			PlayerDAO player13 = new PlayerDAO("FN13","LN13","test13@hotmail.com","12345");
			PlayerDAO player14 = new PlayerDAO("FN14","LN14","test14@hotmail.com","12345");
			PlayerDAO player15 = new PlayerDAO("FN15","Ln15","test15@hotmail.com","12345");
			PlayerDAO player16 = new PlayerDAO("FN16","LN16","test16@hotmail.com","12345");
			
			
			session.save(player1);
			session.save(player2);
			session.save(player3);
			session.save(player4);
			session.save(player5);
			session.save(player6);
			session.save(player7);
			session.save(player8);
			session.save(player9);
			session.save(player10);
			session.save(player11);
			session.save(player12);
			session.save(player13);
			session.save(player14);
			session.save(player15);
			session.save(player16);
			
			
			// AVAILABILITIES
			
			
//			PlayerAvailabilityDAO avail0 = new PlayerAvailabilityDAO(player1, 0, 7, 23);
//			PlayerAvailabilityDAO avail1 = new PlayerAvailabilityDAO(player1, 1, 17.5, 23.5);
//			PlayerAvailabilityDAO avail2 = new PlayerAvailabilityDAO(player1, 2, 18, 23);
//			PlayerAvailabilityDAO avail3 = new PlayerAvailabilityDAO(player1, 3, 18, 23);
//			PlayerAvailabilityDAO avail4 = new PlayerAvailabilityDAO(player1, 4, 17.5, 23.5);
//			PlayerAvailabilityDAO avail5 = new PlayerAvailabilityDAO(player1, 5, 17, 23);
//			PlayerAvailabilityDAO avail6 = new PlayerAvailabilityDAO(player1, 6, 7, 23);
//			session.save(avail0);
//			session.save(avail1);
//			session.save(avail2);
//			session.save(avail3);
//			session.save(avail4);
//			session.save(avail5);
//			session.save(avail6);
			
			
			// PLAYER LEVEL INTERESTS
			
//			LevelInterestDAO levelInterest1 = new LevelInterestDAO();
//			session.save(levelInterest1);
//			levelInterest1.setVolleyType(volleyType2);
//			levelInterest1.setMinLevel(levelB);
//			levelInterest1.setMaxLevel(levelA);
//			levelInterest1.setPlayer(player1);
//			player1.getLevelInterestList().add(levelInterest1);
//			volleyType2.getInterestedPlayers().add(levelInterest1);
//			levelA.getMinInterest().add(levelInterest1);
//			levelB.getMaxInterest().add(levelInterest1);
//			
//			LevelInterestDAO levelInterest2 = new LevelInterestDAO();
//			session.save(levelInterest2);
//			levelInterest2.setPlayer(player1);
//			levelInterest2.setVolleyType(volleyType3);
//			levelInterest2.setMinLevel(levelB);
//			levelInterest2.setMaxLevel(levelB);
//			player1.getLevelInterestList().add(levelInterest2);
//			player1.getLevelInterestList().add(levelInterest2);
//			levelB.getMinInterest().add(levelInterest2);
//			levelB.getMaxInterest().add(levelInterest2);
//			
			// PLAYER POSITION INTEREST
			
//			PlayerVolleyPosDAO playerPos = new PlayerVolleyPosDAO();
//			session.save(playerPos);
//			playerPos.setPlayer(player1);
//			playerPos.setPowerPos(1);
//			playerPos.setTechPos(2);
//			playerPos.setCenterPos(3);
//			playerPos.setSetterPos(4);
//			playerPos.setLiberoPos(5);
//			playerPos.setLeftSide(1);
//			playerPos.setRightSide(2);
			//player1.setPositionPreference(playerPos);
			
			

			// ORGANIZATIONS
			
			OrganizationDAO org1 = new OrganizationDAO();
			session.save(org1);
			org1.setName_short("Espace Griffintown");
			
			OrganizationDAO org2 = new OrganizationDAO();
			session.save(org2);
			org2.setName_short("Sandblast");
			
			// LEAGUES
			
			LeagueDAO league1 = new LeagueDAO();
			session.save(league1);
			league1.setName("2x2 beach mixed");
			league1.setVolleyType(volleyType3);
			league1.setHasSeasonTeams(true);
			org1.getLeagueList().add(league1);
			league1.setOrganization(org1);
			
			LeagueDAO league2 = new LeagueDAO();
			session.save(league2);
			league2.setName("2x2 beach masculin");
			league2.setVolleyType(volleyType2);
			league2.setHasSeasonTeams(false);
			org2.getLeagueList().add(league2);
			league2.setOrganization(org2);
			
			
			
//			LeagueDAO league2x2Fem = new LeagueDAO();
//			session.save(league2x2Fem);
//			league2x2Fem.setName("2x2 beach feminin");
//			league2x2Fem.setVolleyType(volleyType2);
//			org.getLeagueList().add(league2x2Fem);

			//league2x2Masc.setOrganization(org);
			//league2x2Fem.setOrganization(org);
			
			// LEAGUE ADMIN
			
//			LeagueAdminDAO admin1 = new LeagueAdminDAO();
//			session.save(admin1);
//			admin1.setPlayer(player1);
//			admin1.setLeague(league2x2Masc);
//			admin1.setRole(LeagueAdminDAO.MASTER);
//			league2x2Masc.getAdminList().add(admin1);
//			player1.getAdminList().add(admin1);
//			
//			LeagueAdminDAO admin2 = new LeagueAdminDAO();
//			session.save(admin2);
//			admin2.setPlayer(player2);
//			admin2.setLeague(league2x2Fem);
//			admin2.setRole(LeagueAdminDAO.ADMIN);
//			league2x2Fem.getAdminList().add(admin2);
//			player2.getAdminList().add(admin2);
//			
			// LEAGUE SEASONS
			
			LeagueSeasonDAO season1 = new LeagueSeasonDAO();
			session.save(season1);
			season1.setName("Automne 2012");
			season1.setDefaultMaxPlayerPerPool(5);
			season1.setDefaultSetConfig(MatchSetDAO.SET_TYPE_2X25);
			season1.setDefaultCapOn15(17);
			season1.setDefaultCapOn21(23);
			season1.setDefaultCapOn25(27);
			season1.setDefaultTimePerPoint(1);
			
			//season1.setDefaultLocation(loc1);
			
			Calendar startCal = Calendar.getInstance();
			startCal.set(2012, 9, 15, 19, 0,0);
			season1.setStartDate(startCal.getTime().getTime());
			
			Calendar endCal = Calendar.getInstance();
			endCal.set(2012, 11, 17, 19, 0,0);
			season1.setEndDate(endCal.getTime().getTime());
			
			season1.setEventCount(10);
			season1.setDefaultStartTime(19);
			season1.setDefaultCourtCount(4);
			season1.setLeague(league1);
			league1.getSeasonList().add(season1);
			

			
			LeagueSeasonDAO season2 = new LeagueSeasonDAO();
			session.save(season2);
			season2.setName("Fall 2012");
			season2.setDefaultMaxPlayerPerPool(5);
			season2.setDefaultSetConfig(MatchSetDAO.SET_TYPE_2X25);
			season2.setDefaultCapOn15(17);
			season2.setDefaultCapOn21(23);
			season2.setDefaultCapOn25(27);
			season2.setDefaultTimePerPoint(1);
			
			startCal = Calendar.getInstance();
			startCal.set(2012, 9, 20, 8, 30,0);
			season2.setStartDate(startCal.getTime().getTime());
			
			endCal = Calendar.getInstance();
			endCal.set(2012, 11, 22, 8, 30,0);
			season2.setEndDate(endCal.getTime().getTime());
			
			season2.setEventCount(10);
			season2.setDefaultStartTime(8.5);
			season2.setDefaultCourtCount(2);
			season2.setLeague(league2);
			league2.getSeasonList().add(season2);
			
			
			
			
//			
//			LeagueSeasonDAO mascS2 = new LeagueSeasonDAO();
//			session.save(mascS2);
//			mascS2.setName("Été 2013");
//			mascS2.setStartDate(Calendar.getInstance().getTime().getTime());
//			mascS2.setDefaultLocation(loc1);
//			mascS2.setCourtCount(2);
//			mascS2.setLeague(league2x2Masc);
//			league2x2Masc.getSeasonList().add(mascS2);
//			
//			LeagueSeasonDAO femS1 = new LeagueSeasonDAO();
//			session.save(femS1);
//			femS1.setName("Été 2012");
//			femS1.setStartDate(Calendar.getInstance().getTime().getTime());
//			femS1.setCourtCount(2);
//			femS1.setLeague(league2x2Fem);
//			league2x2Fem.getSeasonList().add(femS1);
//			
//			LeagueSeasonDAO femS2 = new LeagueSeasonDAO();
//			session.save(femS2);
//			femS2.setName("Été 2013");
//			femS2.setStartDate(Calendar.getInstance().getTime().getTime());
//			femS2.setCourtCount(2);
//			femS2.setLeague(league2x2Fem);
//			league2x2Fem.getSeasonList().add(femS2);
			
			// PLAYER LEAGUE INTEREST
			
//			player1.getLeagueSeasonInterest().add(mascS1);
//			player1.getLeagueSeasonInterest().add(mascS2);
			
			// SEASON EVENTS
			
//			SeasonEventDAO seasonEvent1 = new SeasonEventDAO();
//			session.save(seasonEvent1);
//			seasonEvent1.setLeagueSeason(mascS1);
//			cal = Calendar.getInstance();
//			cal.set(2012,05,11,8,30,0);
//			seasonEvent1.setDate(cal.getTime().getTime());
//			mascS1.getEventList().add(seasonEvent1);
//			
//			SeasonEventDAO seasonEvent2 = new SeasonEventDAO();
//			session.save(seasonEvent2);
//			seasonEvent2.setLeagueSeason(mascS1);
//			cal = Calendar.getInstance();
//			cal.set(2012,05,18);
//			seasonEvent2.setDate(cal.getTime().getTime());
//			mascS1.getEventList().add(seasonEvent2);
//			
//			SeasonEventDAO seasonEvent3 = new SeasonEventDAO();
//			session.save(seasonEvent3);
//			seasonEvent3.setLeagueSeason(femS1);
//			cal = Calendar.getInstance();
//			cal.set(2012,05,11);
//			seasonEvent3.setDate(cal.getTime().getTime());
//			femS1.getEventList().add(seasonEvent3);
//			
//			SeasonEventDAO seasonEvent4 = new SeasonEventDAO();
//			session.save(seasonEvent4);
//			seasonEvent4.setLeagueSeason(femS1);
//			cal = Calendar.getInstance();
//			cal.set(2012,05,18);
//			seasonEvent4.setDate(cal.getTime().getTime());
//			femS1.getEventList().add(seasonEvent4);
			
			// TEAMS and SEASON_TEAMS
			
			TeamDAO team1 = new TeamDAO();
			session.save(team1);
			team1.setName("Sandstorm");
			
			TeamDAO team2 = new TeamDAO();
			session.save(team2);
			team2.setName("Beach killers");
			
			TeamDAO team3 = new TeamDAO();
			session.save(team3);
			team3.setName("Carotes cuites");
			
			TeamDAO team4 = new TeamDAO();
			session.save(team4);
			team4.setName("La Bête Mikeisa");
			
			TeamDAO team5 = new TeamDAO();
			session.save(team5);
			team5.setName("Les Immortels");
			
			TeamDAO team6 = new TeamDAO();
			session.save(team6);
			team6.setName("Bogus team 6");
			
			TeamDAO team7 = new TeamDAO();
			session.save(team7);
			team7.setName("Bogus team 7");
			
			TeamDAO team8 = new TeamDAO();
			session.save(team8);
			team8.setName("Bogus team 8");
			
			season1.getSeasonTeamList().add(team1);
			season1.getSeasonTeamList().add(team2);
			season1.getSeasonTeamList().add(team3);
			season1.getSeasonTeamList().add(team4);
			season1.getSeasonTeamList().add(team5);
			season1.getSeasonTeamList().add(team6);
			season1.getSeasonTeamList().add(team7);
			season1.getSeasonTeamList().add(team8);
			
			TeamDAO team9 = new TeamDAO();
			session.save(team9);
			team8.setName("Dust Devils");
			
			TeamDAO team10 = new TeamDAO();
			session.save(team10);
			team8.setName("Sand cats");
			
			TeamDAO team11 = new TeamDAO();
			session.save(team11);
			team8.setName("Desert Nomads");
			
			TeamDAO team12 = new TeamDAO();
			session.save(team12);
			team8.setName("Camel Racers");
			
//			season2.getSeasonTeamList().add(team9);
//			season2.getSeasonTeamList().add(team10);
//			season2.getSeasonTeamList().add(team11);
//			season2.getSeasonTeamList().add(team12);
			
			// TEAM PLAYERS

			addPlayerToTeam(session,team1, player1, PlayerDAO.BEACH_LEFT);
			addPlayerToTeam(session,team1, player2, PlayerDAO.BEACH_LEFT);
			
			addPlayerToTeam(session,team2, player3, PlayerDAO.BEACH_LEFT);
			addPlayerToTeam(session,team2, player4, PlayerDAO.BEACH_RIGHT);
			
			addPlayerToTeam(session,team3, player5, PlayerDAO.BEACH_LEFT);
			addPlayerToTeam(session,team3, player6, PlayerDAO.BEACH_RIGHT);
			
			addPlayerToTeam(session,team4, player7, PlayerDAO.BEACH_LEFT);
			addPlayerToTeam(session,team4, player8, PlayerDAO.BEACH_RIGHT);
			
			addPlayerToTeam(session,team5, player9, PlayerDAO.BEACH_LEFT);
			addPlayerToTeam(session,team5, player10, PlayerDAO.BEACH_RIGHT);
			
			addPlayerToTeam(session,team9, player1, PlayerDAO.BEACH_LEFT);
			addPlayerToTeam(session,team9, player2, PlayerDAO.BEACH_RIGHT);
			
			addPlayerToTeam(session,team11, player1, PlayerDAO.BEACH_LEFT);
			addPlayerToTeam(session,team11, player3, PlayerDAO.BEACH_RIGHT);
			
			createSeasonEvents(session, season1);
			createSeasonEvents(session, season2);
			
			List<SeasonEventDAO> eventList = new ArrayList<SeasonEventDAO>(season2.getEventList());
			SeasonEventDAO event = eventList.get(5);
	
			addTeamToEvent(session, eventList.get(5), team9, 1);
			addTeamToEvent(session, eventList.get(5), team10, 1);

			addTeamToEvent(session, eventList.get(7), team11, 1);
			addTeamToEvent(session, eventList.get(7), team12, 1);

			
			// LTVQ sample
			
			OrganizationDAO ltvq = new OrganizationDAO();
			ltvq.setName_short("LTVQ");
			session.save(ltvq);
			
			LeagueDAO ltvq6x6Masc = new LeagueDAO();
			ltvq6x6Masc.setHasSeasonTeams(true);
			ltvq6x6Masc.setName("6x6 mixed");
			ltvq6x6Masc.setOrganization(ltvq);
			ltvq.getLeagueList().add(ltvq6x6Masc);
			ltvq6x6Masc.setVolleyType(volleyType12);
			session.save(ltvq6x6Masc);
			
			LeagueSeasonDAO season = new LeagueSeasonDAO();
			ltvq6x6Masc.getSeasonList().add(season);
			season.setDefaultCourtCount(3);
			season.setDefaultLocation(loc1);
			season.setDefaultSetConfig(MatchSetDAO.SET_TYPE_2X25_1X15);
			season.setDefaultCapOn15(17);
			season.setDefaultCapOn21(23);
			season.setDefaultCapOn25(27);
			season.setDefaultTimePerPoint(1);
			season.setLeague(ltvq6x6Masc);
			season.setDefaultMaxPlayerPerPool(5);
			season.setName("Hivers 2013");

			event.setSetConfig(MatchSetDAO.SET_TYPE_2X25);
			event.setCapOn15(17);
			event.setCapOn21(23);
			event.setCapOn25(27);
			event.setTimePerPoint(1);
			Calendar cal3 = Calendar.getInstance();
			cal3.set(2012, 11, 15, 8, 30, 0);
			season.setStartDate(cal3.getTime().getTime());
			season.setDefaultStartTime(8.5);
			session.save(season);

			String[] teamNames = {"Les Killers","Marmottes enragées","Red Bulls","Les Taouins","Les Charbonniers",
								  "Mefisto","Devil Jumpers","Les Machines Atomiques","Rotoculteurs en cahouchouc","Rif Rif",
								  "Seek and Destroy", "Les Garnottes Vollantes", "Les Grandes Taloches", "Bump et Varge", "Couilles Bleues",
								  "Claque swa Yeule","Les Canadiens","Pandas Cocainomans","Chameaux en Rut","Face Laitte"};
			
			for (int t=1; t<=13; t++) // create 9 teams
			{
				TeamDAO team = new TeamDAO();
				team.setName(teamNames[t-1]);
				session.save(team);
				
				PlayerDAO player;
				TeamPlayerDAO teamPlayer;
				
				for (int p=1; p<=6; p++)
				{
					player = new PlayerDAO();
					player.setFirstName("FN" + t + p);
					player.setFirstName("LN" + t + p);
					player.setEmail("test" + t + p + "@test.com");
					player.setPassword("12345");
					player.setSex(p % 2);
					session.save(player);
					
					teamPlayer = new TeamPlayerDAO();
					teamPlayer.setTeam(team);
					teamPlayer.setPlayer(player);
					session.save(teamPlayer);
				}
				
				season.getSeasonTeamList().add(team);
			}
			
			SeasonEventDAO tournois = new SeasonEventDAO();
			tournois.setLeagueSeason(season);
			tournois.setDate(cal3.getTime().getTime());
			tournois.setCourtCount(season.getDefaultCourtCount());
			tournois.setLocation(season.getDefaultLocation());
			tournois.setMaxPlayerPerPool(season.getDefaultMaxPlayerPerPool());
			tournois.setSetConfig(season.getDefaultSetConfig());
			tournois.setCapOn15(season.getDefaultCapOn15());
			tournois.setCapOn21(season.getDefaultCapOn21());
			tournois.setCapOn25(season.getDefaultCapOn25());
			tournois.setTimePerPoint(season.getDefaultTimePerPoint());
			tournois.setStartTime(season.getDefaultStartTime());
			session.save(tournois);
			
			
			
			
			
			
			
			
			
			
			// INVITATIONS
			
//			InvitationDAO invite1 = new InvitationDAO();
//			session.save(invite1);
//			invite1.setFromMessage("Hey you want to join us on thursday night?");
//			invite1.setResponse("Fuck yeah!");
//			invite1.setFromPlayer(player3);
//			invite1.setToPlayer(player4);
//			invite1.setTeam(team2);
//			
//			player3.getInvitationsSent().add(invite1);
//			player4.getInvitationsReceived().add(invite1);
//			team2.getInvitations().add(invite1);
//			
//			InvitationDAO invite2 = new InvitationDAO();
//			session.save(invite2);
//			invite2.setFromMessage("Join the team?");
//			invite2.setResponse("Ok, sounds good!");
//			invite2.setFromPlayer(player1);
//			invite2.setToPlayer(player2);
//			invite2.setTeam(team1);
//			
//			player1.getInvitationsSent().add(invite2);
//			player2.getInvitationsReceived().add(invite2);
//			team1.getInvitations().add(invite2);
			
			
			// TEAM POSITIONS FOR AN EVENT
//			EventTeamDAO teamPos1 = new EventTeamDAO();
//			session.save(teamPos1);
//			teamPos1.setPos(1);
//			teamPos1.setTeam(team1);
//
//			teamPos1.setSeasonEvent(seasonEvent1);
//			seasonEvent1.getTeamPosList().add(teamPos1);
//			
//			EventTeamDAO teamPos2 = new EventTeamDAO();
//			session.save(teamPos2);
//			teamPos2.setPos(2);
//			teamPos2.setTeam(team2);
//			
//			teamPos2.setSeasonEvent(seasonEvent1);
//			seasonEvent1.getTeamPosList().add(teamPos2);
//			
//			EventTeamDAO teamPos3 = new EventTeamDAO();
//			session.save(teamPos3);
//			teamPos3.setPos(3);
//			teamPos3.setTeam(team3);
//			
//			teamPos3.setSeasonEvent(seasonEvent1);
//			seasonEvent1.getTeamPosList().add(teamPos3);
//			
//			EventTeamDAO teamPos4 = new EventTeamDAO();
//			session.save(teamPos4);
//			teamPos4.setPos(4);
//			teamPos4.setTeam(team4);
//			
//			teamPos4.setSeasonEvent(seasonEvent1);
//			seasonEvent1.getTeamPosList().add(teamPos4);
//			
//			// MATCHES
//			
//			EventMatchDAO match1 = new EventMatchDAO();
//			session.save(match1);
//			match1.setTeam1(team1);
//			match1.setTeam2(team2);
//			match1.setSeasonEvent(seasonEvent1);
//			seasonEvent1.getMatchList().add(match1);
//			
//			EventMatchDAO match2 = new EventMatchDAO();
//			session.save(match2);
//			match2.setTeam1(team1);
//			match2.setTeam2(team3);
//			match2.setSeasonEvent(seasonEvent1);
//			seasonEvent1.getMatchList().add(match2);
//			
//			EventMatchDAO match3 = new EventMatchDAO();
//			session.save(match3);
//			match3.setTeam1(team1);
//			match3.setTeam2(team4);
//			match3.setSeasonEvent(seasonEvent1);
//			seasonEvent1.getMatchList().add(match3);
//			
//			EventMatchDAO match4 = new EventMatchDAO();
//			session.save(match4);
//			match4.setTeam1(team2);
//			match4.setTeam2(team3);
//			match4.setSeasonEvent(seasonEvent1);
//			seasonEvent1.getMatchList().add(match4);
//			
//			EventMatchDAO match5 = new EventMatchDAO();
//			session.save(match5);
//			match5.setTeam1(team2);
//			match5.setTeam2(team4);
//			match5.setSeasonEvent(seasonEvent1);
//			seasonEvent1.getMatchList().add(match5);
//			
//			EventMatchDAO match6 = new EventMatchDAO();
//			session.save(match6);
//			match6.setTeam1(team3);
//			match6.setTeam2(team4);
//			match6.setSeasonEvent(seasonEvent1);
//			seasonEvent1.getMatchList().add(match6);
//
//			// SETS
//			
//			MatchSetDAO set1 = new MatchSetDAO();
//			session.save(set1);
//			set1.setEventMatch(match1);
//			set1.setSetNo(1);
//			set1.setSetPoints(21);
//			set1.setScoreTeam1(21);
//			set1.setScoreTeam2(17);
//			match1.getSetList().add(set1);
//			
//			MatchSetDAO set2 = new MatchSetDAO();
//			session.save(set2);
//			set2.setEventMatch(match1);
//			set2.setSetNo(2);
//			set2.setSetPoints(21);
//			set2.setScoreTeam1(18);
//			set2.setScoreTeam2(21);
//			match1.getSetList().add(set2);
//			
//			MatchSetDAO set3 = new MatchSetDAO();
//			session.save(set3);
//			set3.setEventMatch(match1);
//			set3.setSetNo(3);
//			set3.setSetPoints(15);
//			set3.setScoreTeam1(13);
//			set3.setScoreTeam2(15);
//			match1.getSetList().add(set3);
//			
//			MatchSetDAO set4 = new MatchSetDAO();
//			session.save(set4);
//			set4.setSetNo(1);
//			set4.setSetPoints(21);
//			set4.setScoreTeam1(21);
//			set4.setScoreTeam2(12);
//			set4.setEventMatch(match2);
//			match2.getSetList().add(set4);
//			
//			MatchSetDAO set5 = new MatchSetDAO();
//			session.save(set5);
//			set5.setSetNo(2);
//			set5.setSetPoints(21);
//			set5.setScoreTeam1(21);
//			set5.setScoreTeam2(15);
//			set5.setEventMatch(match2);
//			match2.getSetList().add(set5);
			
			tx.commit();
			System.out.println("Done");
		} 
		catch (Exception e) 
		{
			System.out.println(e.getMessage());
		} 
		finally 
		{
			session.close();
		}
			
		System.out.println("createOrg.end)");
	}

	private static void addTeamToEvent(Session session,	SeasonEventDAO event, TeamDAO team, int i) 
	{
		EventTeamDAO eventTeam = new EventTeamDAO();
		eventTeam.setPos(i);
		eventTeam.setTeam(team);
		eventTeam.setSeasonEvent(event);
		event.getTeamPosList().add(eventTeam);
	}

	private static int[] getPoolCounts(int teamCount, int maxPoolSize)
	{
		//List<Integer> pool = new ArrayList<Integer>();
		int teamsLeft = teamCount;
		int poolCount = (int)Math.ceil((double)teamsLeft/maxPoolSize);
		int[] pool = new int[poolCount];
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
		
		String str = teamCount + " / " + maxPoolSize + " = ";
		for (poolNo=0; poolNo < pool.length; poolNo++)
		{
			str += "," + pool[poolNo];
		}
		System.out.println(str);
		
		return pool;
	}
	
	private static void createPools(Session session, SeasonEventDAO seasonEvent) 
	{
		int poolNo, i, teamNo;
		EventTeamDAO team;
		
		List<EventTeamDAO> teamList = new ArrayList<EventTeamDAO>(seasonEvent.getTeamPosList());
		
		Collections.sort(teamList, new Comparator<EventTeamDAO>() {
			public int compare(EventTeamDAO t1, EventTeamDAO t2) 
			{ 
				return (t1.getPos() - t2.getPos()); 
			}
		});
		
		int[] poolSize = getPoolCounts(teamList.size(), 5);

		teamNo=0;
		for (poolNo=0; poolNo<poolSize.length; poolNo++)
		{
			for (i=0; i<poolSize[poolNo]; i++)
			{
				team = teamList.get(teamNo++);
				team.setPool(poolNo+1);
				System.out.println("Team " + team.getId() + " pos = " + team.getPos() + " pool = " + team.getPool()); 
			}
		}
		
		
		
	}

	private static void calculateTeamPositions(Session session,SeasonEventDAO seasonEvent) 
	{
		SeasonEventDAO previousEvent = null; // go get the previous event to calculate who goes up or down
		
		Collection<EventTeamDAO> teamList = seasonEvent.getTeamPosList();
		if (previousEvent == null) // if there is no previous event
		{
			int pos = 1;
			for (Iterator<EventTeamDAO> iterator = teamList.iterator(); iterator.hasNext();) 
			{
				EventTeamDAO team = (EventTeamDAO) iterator.next();
				team.setPos(pos++);
				//team.setPos((int)(Math.random()*1000));
			}
		}
		else
		{
			// Calculate based on previous scores
		}
	}

	private static void copySeasonTeamsToEvent(Session session,	SeasonEventDAO event) 
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

	private static void generateEventSchedule(Session session, SeasonEventDAO event) 
	{
		//event.getLeagueSeason().getLeague().getHas
		
	}

	private static void createSeasonEvents(Session session,	LeagueSeasonDAO season) 
	{
		long startDate = season.getStartDate();
		long endDate = season.getEndDate();
		long interval = (long)Math.floor((endDate - startDate) / (season.getEventCount()-1));
		int i;
		SeasonEventDAO event;
		//Calendar cal;
		
		System.out.println("interval = " + interval);
		
		for (i=season.getEventList().size()-1; i>=0; i--)
		{
			event = (SeasonEventDAO)season.getEventList().toArray()[i];
			session.delete(event);
		}
		season.getEventList().clear();
		
		for (i=0; i<season.getEventCount(); i++)
		{
			event = new SeasonEventDAO();
			event.setLeagueSeason(season);
			event.setDate(startDate + i*interval);
			season.getEventList().add(event);
			session.save(event);
			
			event.setCourtCount(season.getDefaultCourtCount());
			event.setLocation(season.getDefaultLocation());
			event.setMaxPlayerPerPool(season.getDefaultMaxPlayerPerPool());
			event.setSetConfig(season.getDefaultSetConfig());
			event.setCapOn15(season.getDefaultCapOn15());
			event.setCapOn21(season.getDefaultCapOn21());
			event.setCapOn25(season.getDefaultCapOn25());
			event.setTimePerPoint(season.getDefaultTimePerPoint());
			event.setStartTime(season.getDefaultStartTime());
			
			Date d = new Date(event.getDate());
			System.out.println("Event " + i + " = " + event.getDate() + " = " + d.toString());
		}
		
		
		
		
	}

	private static Session getSession()
	{
		Session session = null;
		if (sessionFactory == null)
		{
			try 
			{
				//Configuration cfg = new Configuration().addResource("person.hbm.xml").configure();
				Configuration cfg = new Configuration().configure();
				serviceRegistry = new ServiceRegistryBuilder().applySettings(cfg.getProperties()).buildServiceRegistry();
				sessionFactory = cfg.buildSessionFactory(serviceRegistry);
			} 
			catch (Throwable ex) 
			{
				System.err.println("Failed to create sessionFactory object." + ex);
				throw new ExceptionInInitializerError(ex);
			}
		}
		session = sessionFactory.openSession();
		
		return session;
	}
	
}
