package businessLogic;

import java.util.Vector;
import java.util.Date;
import java.util.List;

import eredua.domain.Question;
import eredua.domain.User;
import eredua.domain.Event;
import exceptions.EmailAlreadyExists;
import exceptions.EmailNotExists;
import exceptions.EventFinished;
import exceptions.EventNotFinished;
import exceptions.QuestionAlreadyExist;
import exceptions.WrongPassword;

/**
 * Interface that specifies the business logic.
 */
public interface BLFacade  {
	  

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
	Question createQuestion(Event event, String question, float betMinimum) throws EventFinished, QuestionAlreadyExist;
	
	
	/**
	 * This method retrieves the events of a given date 
	 * 
	 * @param date in which events are retrieved
	 * @return collection of events
	 */
	public List<Event> getEvents(Date date);
	
	/**
	 * This method retrieves from the database the dates a month for which there are events
	 * 
	 * @param date of the month for which days with events want to be retrieved 
	 * @return collection of dates
	 */
	public List<Date> getEventsMonth(Date date);
	
	/**
	 * This method calls the data access to initialize the database with some events and questions.
	 * It is invoked only when the option "initialize" is declared in the tag dataBaseOpenMode of resources/config.xml file
	 */	
	public void initializeBD();

	public User login(String emaila, String pasahitza) throws EmailNotExists, WrongPassword;

	public User signUp(String izena, String emaila, String pasahitza) throws EmailAlreadyExists;

	public String putResult(Event gertaera, Question galdera, String emaitza) throws EventNotFinished;
}
