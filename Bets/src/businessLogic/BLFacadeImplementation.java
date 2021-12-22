package businessLogic;
import java.util.Date;

import java.util.List;
import java.util.ResourceBundle;
import java.util.Vector;

import dataAccess.HibernateDataAccess;
import eredua.domain.Question;
import eredua.domain.User;
import eredua.domain.Event;
import exceptions.EmailAlreadyExists;
import exceptions.EmailNotExists;
import exceptions.EventFinished;
import exceptions.EventNotFinished;
import exceptions.QuestionAlreadyExist;
import exceptions.WrongPassword;

public class BLFacadeImplementation  implements BLFacade {
	HibernateDataAccess dbManager;

	public BLFacadeImplementation()  {		
//		System.out.println("Creating BLFacadeImplementation instance");
//		ConfigXML c=ConfigXML.getInstance();
//		
//		if (c.getDataBaseOpenMode().equals("initialize")) {
//		    dbManager=new HibernateDataAccess(c.getDataBaseOpenMode().equals("initialize"));
//			dbManager.initializeDB();
//			dbManager.close();
//			}
		dbManager = new HibernateDataAccess();
		dbManager.initializeDB();
		
	}
	
    public BLFacadeImplementation(HibernateDataAccess da)  {
		
//		System.out.println("Creating BLFacadeImplementation instance with DataAccess parameter");
//		ConfigXML c=ConfigXML.getInstance();
//		
//		if (c.getDataBaseOpenMode().equals("initialize")) {
//			da.open(true);
			da.initializeDB();
//			da.close();
//
//		}
		dbManager=da;		
	}
	

	/**
	 * This method creates a question for an event, with a question text and the minimum bet
	 * 
	 * @param event to which question is added
	 * @param question text of the question
	 * @param betMinimum minimum quantity of the bet
	 * @return the created question, or null, or an exception
	 * @throws EventFinished if current data is after data of the event
 	 * @throws QuestionAlreadyExist if the same question already exists for the event
	 */
   public Question createQuestion(Event event, String question, float betMinimum) throws EventFinished, QuestionAlreadyExist{
	   
	    //The minimum bed must be greater than 0
//		dbManager.open(false);
		Question qry=null;
		
	    
		if(new Date().compareTo(event.getEventDate())>0)
			throw new EventFinished("ErrorEventHasFinished");
				
		
		 qry=dbManager.createQuestion(event,question,betMinimum);		

//		dbManager.close();
		
		return qry;
   };
	
	/**
	 * This method invokes the data access to retrieve the events of a given date 
	 * 
	 * @param date in which events are retrieved
	 * @return collection of events
	 */
	public List<Event> getEvents(Date date)  {
		List<Event>  events=dbManager.getEvents(date);
		return events;
	}

    
	/**
	 * This method invokes the data access to retrieve the dates a month for which there are events
	 * 
	 * @param date of the month for which days with events want to be retrieved 
	 * @return collection of dates
	 */
	public List<Date> getEventsMonth(Date date) {
		List<Date>  dates=dbManager.getEventsMonth(date);
		return dates;
	}
	

	/**
	 * This method invokes the data access to initialize the database with some events and questions.
	 * It is invoked only when the option "initialize" is declared in the tag dataBaseOpenMode of resources/config.xml file
	 */	
	public void initializeBD(){
		dbManager.initializeDB();
	}
	
	public User login(String emaila, String pasahitza) throws EmailNotExists, WrongPassword{
		return dbManager.login(emaila, pasahitza);
	}

	public User signUp(String izena, String emaila, String pasahitza) throws EmailAlreadyExists{
		return dbManager.signUp(izena, emaila, pasahitza);
	}
	
	public String putResult(Event gertaera, Question galdera, String emaitza) throws EventNotFinished {
		if(new Date().compareTo(gertaera.getEventDate())<0)
			throw new EventNotFinished("Error: oraindik ez da gertaera amaitu");
		return dbManager.putResult(galdera, emaitza);
	}
	
	public static void main(String[] s) {
		BLFacadeImplementation facade = new BLFacadeImplementation(new HibernateDataAccess());

	}
}

