package com.sportsmanager.model.util;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

import com.sportsmanager.model.dao.EventMatchDAO;
import com.sportsmanager.model.dao.EventTeamDAO;

public class SchedulerTimeSlot 
{
	private int courtCount;
	private int index = 0;
	private EventMatchDAO[] matchList;
	private boolean full;
	private Map<Integer, Boolean> teamId = new HashMap<Integer, Boolean>();
	
	public SchedulerTimeSlot(int courtCount) 
	{
		super();
		setCourtCount(courtCount);
	}
	
	public boolean addMatch(EventMatchDAO match)
	{
		boolean result = (index < courtCount); // if our index is too high, this time slot is already full and starts out with a false result.  Can't add.
		
		if (result) // if we still have space
		{
			result = result && !teamId.containsKey(match.getEventTeam1().getId()); // Result = false if this EventTeamDAO is already in this timeslot.
			result = result && !teamId.containsKey(match.getEventTeam2().getId()); // Result = false if this EventTeamDAO is already in this timeslot.
			
			if (result) // if neither the teams were found in this time slot
			{
				teamId.put(match.getEventTeam1().getId(), true);
				teamId.put(match.getEventTeam2().getId(), true);
				matchList[index++] = match;
				match.setScheduled(true);
			}
		}
		
		return result;
	}
	
	public void sortByPool()
	{
		Comparator<EventMatchDAO> compar = new Comparator<EventMatchDAO>() 
		{
			public int compare (EventMatchDAO match1, EventMatchDAO match2)
			{
				
				int result;
				if ((match1 == null) && (match2 != null)) { result = 1; }
				else if ((match1 != null) && (match2 == null)) { result = -1; }
				else if ((match1 == null) && (match2 == null)) { result = 0; }
				else
				{
					int pool1 = match1.getPoolNo();
					int pool2 = match2.getPoolNo();
					result = pool1 - pool2;
				}
				//System.out.println("Comparing " + pool1 + " to " + pool2);
				return (result);
			}
		};
		
		Arrays.sort(matchList, compar);
	}
	
	public void setCourtCount(int courtCount) 
	{
		this.courtCount = courtCount;
		matchList = new EventMatchDAO[courtCount];
	}
	public int getCourtCount() {
		return courtCount;
	}
	public void setMatchList(EventMatchDAO[] matchList) {
		this.matchList = matchList;
	}
	public EventMatchDAO[] getMatchList() {
		return matchList;
	}

	public void setFull(boolean full) {
		this.full = full;
	}

	public boolean isFull() {
		return full;
	}
	
	
	
	
}
