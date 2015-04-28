/**
 * Read web server data and analyse
 * hourly access patterns.
 * 
 * @author David J. Barnes and Michael Kölling.
 * @version 2011.07.31
 */
public class LogAnalyzer
{
    // Where to calculate the hourly access counts.
    private int[] hourCounts;
    // Use a LogfileReader to access the data.
    private LogfileReader reader;

    /**
     * Create an object to analyze hourly web accesses.
     */
    public LogAnalyzer()
    { 
        // Create the array object to hold the hourly
        // access counts.
        hourCounts = new int[24];
        // Create the reader to obtain the data.
        reader = new LogfileReader();
    }

    /**
     * Analyze the hourly access data from the log file.
     */
    public void analyzeHourlyData()
    {
        while(reader.hasNext()) {
            LogEntry entry = reader.next();
            int hour = entry.getHour();
            hourCounts[hour]++;
        }
    }
    /**
     * Return the number of  accesses recorded in the log file.
     */
    public int numberOfAccesses()
    {
    	int total = 0;
    	
    	/*
    	 * Add the value in each element of hourCounts to
    	 * to total
    	 */
    	
    	for (int hours : hourCounts) {
			total += hours;
		}
    	
    	return total;
    }
    /**
     * Returns the busiest hour.
     */
    public int busiestHour()
    {
    	// we assume that the smallest element is zero.
    	// if this is not the case, use Integer.MIN_VALUE.
    	int busiestHour = 0;
    	
    	for(int hour : hourCounts)
    	{
    		if(hour > busiestHour)
    			busiestHour = hour;
    	}
    	
    	return busiestHour;
    }
    
    /**
     * Returns the quietestHour.
     */
    public int quietestHour()
    {
    	// we could possibly set this to busiestHour()
    	// but that would be to much work.
    	// also, for general case, use
    	// hourCounts.length > 0 ? hourCounts[0] : 0
    	int quietestHour =  hourCounts[0];
    	
    	for (int hour : hourCounts)
    	{
			if(hour < quietestHour)
				quietestHour = hour;
		}
    	
    	return quietestHour;
    }
    /**
     * Returns the busiest two hour period.
     * @return The first hour of that interval.
     */
    public int busiestTwoHour()
    {
    	int busiestTwoHour = 0;
        int busiestHour = 0;
    	
        // the 23 could be replaced with
        // hourCounts.length - hourCounts.length % 2 -1
        // if the array size would not be known in advance.
        
    	for(int i = 0; i < 23; i++)
    	{
    		if(hourCounts[i] + hourCounts[i+1] > busiestTwoHour)
    		{
    			busiestHour = hourCounts[i];
    			busiestTwoHour = hourCounts[i]+ hourCounts[i+1];
    		}
    		
    	}
    	
    	return busiestHour;
    }

    /**
     * Print the hourly counts.
     * These should have been set with a prior
     * call to analyzeHourlyData.
     */
    public void printHourlyCounts()
    {
        System.out.println("Hr: Count");
        for(int hour = 0; hour < hourCounts.length; hour++) {
            System.out.println(hour + ": " + hourCounts[hour]);
        }
    }
    
    /**
     * Print the lines of data read by the LogfileReader
     */
    public void printData()
    {
        reader.printData();
    }
}
