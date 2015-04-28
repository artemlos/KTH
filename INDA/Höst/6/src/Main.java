import java.util.logging.LogRecord;

import com.sun.org.apache.xalan.internal.xsltc.compiler.util.ErrorMessages;


public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//LogfileCreator lc = new LogfileCreator();
		//lc.createFile("bin//weblog.txt",5);
		noOfAccessesTest();
		busiestHourTest();
		quietestHourTest();
		busiestTwoHourTest();
		
		
	}
	public static void noOfAccessesTest()
	{
		//LogfileReader lf = new LogfileReader("weblog.txt");
		LogAnalyzer la = new LogAnalyzer();
		la.analyzeHourlyData();
		
		//if (la.numberOfAccesses() != 3749)
			//throw new Error("Fail.");
		System.out.println(la.numberOfAccesses());
		
		
	}
	
	public static void busiestHourTest()
	{
		//LogfileReader lf = new LogfileReader("weblog.txt");
		LogAnalyzer la = new LogAnalyzer();
		la.analyzeHourlyData();
		
		//if (la.numberOfAccesses() != 3749)
			//throw new Error("Fail.");
		System.out.println(la.busiestHour());
		
		
	}
	
	public static void quietestHourTest()
	{
		//LogfileReader lf = new LogfileReader("weblog.txt");
		LogAnalyzer la = new LogAnalyzer();
		la.analyzeHourlyData();
		
		//if (la.numberOfAccesses() != 3749)
			//throw new Error("Fail.");
		System.out.println(la.quietestHour());
		
		
	}
	public static void busiestTwoHourTest()
	{
		//LogfileReader lf = new LogfileReader("weblog.txt");
		LogAnalyzer la = new LogAnalyzer();
		la.analyzeHourlyData();
		
		//if (la.numberOfAccesses() != 3749)
			//throw new Error("Fail.");
		System.out.println(la.busiestTwoHour());
		
		
	}


}


