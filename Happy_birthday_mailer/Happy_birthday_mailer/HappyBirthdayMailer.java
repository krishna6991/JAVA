/** 
 *  @title <b>THE HR HAPPY BIRTHDAY MAILER</b>
 *  @description The HR mailing system for the organization, It sends Mail everyday at fix time
 *  to each Employee have birthday.
 *  @author IRFAN, KRISHNA, ANAMOL
 *  @version 1.0.0
 *   
 */
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;


import java.util.Map;

public class HappyBirthdayMailer {
	public static void main(String[] args) throws Exception{
		Connectivity connect = Producer.now_start();
		/**
		 * Scheduler to run our program everyday at a fix time only once
		 * @see  {@scheduler} 
		 */
		final ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);
		scheduler.scheduleAtFixedRate(
		        new Runnable() {
		            public void run() {
		                try {
		                	System.out.println("Scheduler Running....");
		                	Map<String,String> s=connect.fetch();
		            		connect.SendMail(s);
		                }catch(Exception ex) {
		                    ex.printStackTrace();
		                }
		            }
		        }, 0, 1, TimeUnit.DAYS);
		 }
}
