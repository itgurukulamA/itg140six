package Datbase;

import java.sql.*;


import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;



public class Insertdata {
	static Logger lo=Logger.getLogger(Insertdata.class); 
   public static void main(String args[]) {
	try { 	                                    			
		
		//PropertyConfigurator.configure("log4j.properties"); 
		
		 lo.info("Loading the Driver");
	     Class.forName("com.mysql.cj.jdbc.Driver"); 
	     lo.info("Establishing the connection");  
	     Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/mss","root","Rajesh@523");
	     
	     lo.info("Creating the Statement");
	     Statement s=con.createStatement();
	     
	     int i=s.executeUpdate("insert into itg140 values(22,'Naveen','Naveen@gmail.com',9010912345)");
	     lo.info("Statements Executed");
	     if(i>0) 
	     {
	    	 lo.debug("data inserted successfully");
	    	 System.out.println("Data Inserted successfully");
	     }
	     else 
	     {
	    	 lo.error("data is not inserted ");
	    	 System.out.println("Dta not inserted");
	     }
	     lo.info("Closing the Log4j Session");
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
}

}
