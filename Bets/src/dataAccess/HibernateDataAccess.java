package dataAccess;

import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Vector;

import org.hibernate.Query;
import org.hibernate.Session;

import eredua.domain.*;
import exceptions.EmailAlreadyExists;
import exceptions.EmailNotExists;
import exceptions.QuestionAlreadyExist;
import exceptions.WrongPassword;

public class HibernateDataAccess {

//	public HibernateDataAccess(boolean initializeMode)  {
//		
//		open(initializeMode);
//		
//		if (initializeMode)
//			initializeDB();
//		
//	}

	public HibernateDataAccess()  {	
//		 new HibernateDataAccess(false);
	}

	/**
	 * This is the data access method that initializes the database with some events
	 * and questions. This method is invoked by the business logic (constructor of
	 * BLFacadeImplementation) when the option "initialize" is declared in the tag
	 * dataBaseOpenMode of resources/config.xml file
	 */
	public void initializeDB() {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		try {

			Calendar today = Calendar.getInstance();

			int month = today.get(Calendar.MONTH);
			month += 1;
			int year = today.get(Calendar.YEAR);
			if (month == 12) {
				month = 0;
				year += 1;
			}

//			Event ev1 = new Event(1, "Atlético-Athletic", UtilDate.newDate(year, month, 17));
//			Event ev2 = new Event(2, "Eibar-Barcelona", UtilDate.newDate(year, month, 17));
//			Event ev3 = new Event(3, "Getafe-Celta", UtilDate.newDate(year, month, 17));
//			Event ev4 = new Event(4, "Alavés-Deportivo", UtilDate.newDate(year, month, 17));
//			Event ev5 = new Event(5, "Español-Villareal", UtilDate.newDate(year, month, 17));
//			Event ev6 = new Event(6, "Las Palmas-Sevilla", UtilDate.newDate(year, month, 17));
//			Event ev7 = new Event(7, "Malaga-Valencia", UtilDate.newDate(year, month, 17));
//			Event ev8 = new Event(8, "Girona-Leganés", UtilDate.newDate(year, month, 17));
//			Event ev9 = new Event(9, "Real Sociedad-Levante", UtilDate.newDate(year, month, 17));
//			Event ev10 = new Event(10, "Betis-Real Madrid", UtilDate.newDate(year, month, 17));
//
//			Event ev11 = new Event(11, "Atletico-Athletic", UtilDate.newDate(year, month, 1));
//			Event ev12 = new Event(12, "Eibar-Barcelona", UtilDate.newDate(year, month, 1));
//			Event ev13 = new Event(13, "Getafe-Celta", UtilDate.newDate(year, month, 1));
//			Event ev14 = new Event(14, "Alavés-Deportivo", UtilDate.newDate(year, month, 1));
//			Event ev15 = new Event(15, "Español-Villareal", UtilDate.newDate(year, month, 1));
//			Event ev16 = new Event(16, "Las Palmas-Sevilla", UtilDate.newDate(year, month, 1));
//
//			Event ev17 = new Event(17, "Málaga-Valencia", UtilDate.newDate(year, month, 28));
//			Event ev18 = new Event(18, "Girona-Leganés", UtilDate.newDate(year, month, 28));
//			Event ev19 = new Event(19, "Real Sociedad-Levante", UtilDate.newDate(year, month, 28));
//			Event ev20 = new Event(20, "Betis-Real Madrid", UtilDate.newDate(year, month, 28));

			Event ev1 = new Event("Atlético-Athletic", UtilDate.newDate(year, month, 17));
			Event ev2 = new Event("Eibar-Barcelona", UtilDate.newDate(year, month, 17));
			Event ev3 = new Event("Getafe-Celta", UtilDate.newDate(year, month, 17));
			Event ev4 = new Event("Alavés-Deportivo", UtilDate.newDate(year, month, 17));
			Event ev5 = new Event("Español-Villareal", UtilDate.newDate(year, month, 17));
			Event ev6 = new Event("Las Palmas-Sevilla", UtilDate.newDate(year, month, 17));
			Event ev7 = new Event("Malaga-Valencia", UtilDate.newDate(year, month, 17));
			Event ev8 = new Event("Girona-Leganés", UtilDate.newDate(year, month, 17));
			Event ev9 = new Event("Real Sociedad-Levante", UtilDate.newDate(year, month, 17));
			Event ev10 = new Event("Betis-Real Madrid", UtilDate.newDate(year, month, 17));

			Event ev11 = new Event("Atletico-Athletic", UtilDate.newDate(year, month, 1));
			Event ev12 = new Event("Eibar-Barcelona", UtilDate.newDate(year, month, 1));
			Event ev13 = new Event("Getafe-Celta", UtilDate.newDate(year, month, 1));
			Event ev14 = new Event("Alavés-Deportivo", UtilDate.newDate(year, month, 1));
			Event ev15 = new Event("Español-Villareal", UtilDate.newDate(year, month, 1));
			Event ev16 = new Event("Las Palmas-Sevilla", UtilDate.newDate(year, month, 1));

			Event ev17 = new Event("Málaga-Valencia", UtilDate.newDate(year, month, 28));
			Event ev18 = new Event("Girona-Leganés", UtilDate.newDate(year, month, 28));
			Event ev19 = new Event("Real Sociedad-Levante", UtilDate.newDate(year, month, 28));
			Event ev20 = new Event("Betis-Real Madrid", UtilDate.newDate(year, month, 28));

			Question q1;
			Question q2;
			Question q3;
			Question q4;
			Question q5;
			Question q6;
			
			q1 = ev1.addQuestion("Zeinek irabaziko du partidua?", 1);
			q2 = ev1.addQuestion("Zeinek sartuko du lehenengo gola?", 2);
			q3 = ev11.addQuestion("Zeinek irabaziko du partidua?", 1);
			q4 = ev11.addQuestion("Zenbat gol sartuko dira?", 2);
			q5 = ev17.addQuestion("Zeinek irabaziko du partidua?", 1);
			q6 = ev17.addQuestion("Golak sartuko dira lehenengo zatian?", 2);

			session.persist(q1);
			session.persist(q2);
			session.persist(q3);
			session.persist(q4);
			session.persist(q5);
			session.persist(q6);			

			session.persist(ev1);
			session.persist(ev2);
			session.persist(ev3);
			session.persist(ev4);
			session.persist(ev5);
			session.persist(ev6);
			session.persist(ev7);
			session.persist(ev8);
			session.persist(ev9);
			session.persist(ev10);
			session.persist(ev11);
			session.persist(ev12);
			session.persist(ev13);
			session.persist(ev14);
			session.persist(ev15);
			session.persist(ev16);
			session.persist(ev17);
			session.persist(ev18);
			session.persist(ev19);
			session.persist(ev20);

			
			//Create an admin
			User admin = new User("admin@gmail.com", "adminadmin", "admin", "Administrazailea");
			session.persist(admin);
			

			Event ev21 = new Event("Betis-Real Madrid", UtilDate.newDate(2021, 11, 10));
			Question q7 = ev21.addQuestion("Nork irabaziko du partidua?", 2);
			session.persist(q7);
			session.persist(ev21);
			
			session.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * This method creates a question for an event, with a question text and the
	 * minimum bet
	 * 
	 * @param event      to which question is added
	 * @param question   text of the question
	 * @param betMinimum minimum quantity of the bet
	 * @return the created question, or null, or an exception
	 * @throws QuestionAlreadyExist if the same question already exists for the
	 *                              event
	 */
	public Question createQuestion(Event event, String question, float betMinimum) throws QuestionAlreadyExist {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		Event ev = (Event) session.get(Event.class, event.getEventNumber());
		if (ev.DoesQuestionExists(question)) throw new QuestionAlreadyExist("ErrorQueryAlreadyExist");
		Question q = ev.addQuestion(question, betMinimum);
		session.persist(ev);
		session.getTransaction().commit();
		return q;
	

	}

	/**
	 * This method retrieves from the database the events of a given date
	 * 
	 * @param date in which events are retrieved
	 * @return collection of events
	 */
	public List<Event> getEvents(Date date) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		List<Event> res = new Vector<Event>();
		Query query;
		if(date == null) {
			query = session.createQuery("SELECT ev FROM Event ev");
		}else {
	//		Query query = session.createQuery("SELECT ev FROM Event ev WHERE ev.eventDate=?");
	//		query.setParameter(0, date);
			query = session.createQuery("SELECT ev FROM Event ev WHERE ev.eventDate=:eventDate");
			query.setParameter("eventDate", date);
		}
		List<Event> events = query.list();
		for (Event ev : events) {
			res.add(ev);
		}
		session.getTransaction().commit();
		return res;
	}

	/**
	 * This method retrieves from the database the dates a month for which there are
	 * events
	 * 
	 * @param date of the month for which days with events want to be retrieved
	 * @return collection of dates
	 */
	public Vector<Date> getEventsMonth(Date date) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		
		Vector<Date> res = new Vector<Date>();

		Date firstDayMonthDate = UtilDate.firstDayMonth(date);
		Date lastDayMonthDate = UtilDate.lastDayMonth(date);

		Query query = session.createQuery("SELECT DISTINCT ev.eventDate FROM Event ev WHERE ev.eventDate BETWEEN ? and ?");
		query.setParameter(1, firstDayMonthDate);
		query.setParameter(2, lastDayMonthDate);
		List<Date> dates = query.list();
		for (Date d : dates) {
			res.add(d);
		}
		session.getTransaction().commit();
		return res;
	}

	public boolean existQuestion(Event event, String question) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		Event ev = (Event)session.get(Event.class, event.getEventNumber());
		session.getTransaction().commit();
		return ev.DoesQuestionExists(question);

	}
	
	public String putResult(Question galdera, String emaitza) {
		try{
			Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		Question q = (Question)session.get(Question.class, galdera.getQuestionNumber());
		q.setResult(emaitza);
		session.persist(q);
		session.getTransaction().commit();
		} catch(Exception e) {
			System.out.println(e.getMessage());
		}
		return "success";
	}
	
	//User atala:
	
	public User login(String emaila, String pasahitza) throws EmailNotExists, WrongPassword{
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		User erab = (User)session.get(User.class, emaila);
		session.getTransaction().commit();
		if (erab == null)
			throw new EmailNotExists("You are not registered");
		else if(!erab.getPasahitza().equals(pasahitza))
			throw new WrongPassword("Invalid password");
		else
			return erab;
	}
	
	public User signUp(String izena, String emaila, String pasahitza) throws EmailAlreadyExists{
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		User erab = (User)session.get(User.class, emaila);
		if (erab == null) {
			User u = new User();
			u.setIzena(izena);
			u.setEmaila(emaila);
			u.setPasahitza(pasahitza);
			u.setMota("bezero");
			session.persist(u);
			session.getTransaction().commit();
			return u;
		}else {
			session.getTransaction().commit();
			throw new EmailAlreadyExists("You are already registered");
		}
	}
}
