package bean;

import java.util.Date;
import java.util.List;
import java.util.Vector;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import org.primefaces.event.SelectEvent;

import businessLogic.BLFacade;
import businessLogic.BLFacadeImplementation;
import eredua.domain.Event;
import eredua.domain.Question;
import exceptions.EventFinished;
import exceptions.EventNotFinished;
import exceptions.QuestionAlreadyExist;

public class QuestionsBean {

	private Date data = null;
	private BLFacade facadeBL;
	private Event gertaera = null;
	private static List<Event> gertaerak = new Vector<Event>();
	private Question galdera = null;
	private static List<Question> questionsFromEvent = new Vector<Question>();
	private String galderaBerria;
	private float galderaBerriaMinBet;
	private List<Event> gertaeraGuztiak = new Vector<Event>();
	private String emaitza = null;
	
	public QuestionsBean() {
		data=null;
		System.out.println("Data hau da: " + data);
		setGertaeraGuztiak();
	}
	
	public String getGalderaBerria() {
		return galderaBerria;
	}


	public void setGalderaBerria(String galderaBerria) {
		this.galderaBerria = galderaBerria;
	}


	public float getGalderaBerriaMinBet() {
		return galderaBerriaMinBet;
	}


	public void setGalderaBerriaMinBet(float galderaBerriaMinBet) {
		this.galderaBerriaMinBet = galderaBerriaMinBet;
	}


	public Date getData() {
		return data;
	}


	public void setData(Date data) {
		this.data = data;
	}

	public List<Event> getGertaerak() {
		return gertaerak;
	}


	public void setGertaerak(List<Event> gertaerak) {
		QuestionsBean.gertaerak = gertaerak;
	}


	public Event getGertaera() {
		return gertaera;
	}


	public void setGertaera(Event gertaera) {
		this.gertaera = gertaera;
	}
	
	public static Event getObject(String ev) {
		for (Event e : gertaerak) {
			if (ev.equals(e.getDescription()))
				return e;
		}
		return null;
	}

	public List<Question> getQuestionsFromEvent() {
		return questionsFromEvent;
	}


	public void setQuestionsFromEvent(List<Question> questionsFromEvent) {
		QuestionsBean.questionsFromEvent = questionsFromEvent;
	}
	
	public String getEmaitza() {
		return emaitza;
	}

	public void setEmaitza(String emaitza) {
		this.emaitza = emaitza;
	}
	
	public void onQuestionSelect(SelectEvent question) {
		this.galdera = (Question) question.getObject();
		setGaldera(galdera);
	}
	
	public void onEventSelect(SelectEvent event) {
		this.gertaera = (Event) event.getObject();
		setQuestionsFromEvent(gertaera.getQuestions());
		
	}

	public void onDateSelect(SelectEvent event) {
		facadeBL=FacadeBean.getBusinessLogic();
		gertaerak=facadeBL.getEvents(data);
		questionsFromEvent = null;
	}

	public Question getGaldera() {
		return galdera;
	}

	public void setGaldera(Question galdera) {
		this.galdera = galdera;
	}

	public List<Event> getGertaeraGuztiak() {
		return gertaeraGuztiak;
	}

	public void setGertaeraGuztiak() {
		facadeBL=FacadeBean.getBusinessLogic();
		gertaeraGuztiak = facadeBL.getEvents(null);		
	}
	
	public void setGertaeraGuztiak(List<Event> gertaeraGuztiak) {
		this.gertaeraGuztiak = gertaeraGuztiak;
	}
	
	public String createQuestion() {
		facadeBL=FacadeBean.getBusinessLogic();
		if (gertaera==null || galderaBerria==null || galderaBerriaMinBet==0.0) {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Errorea: gertaera, galdera eta 0 ez den apustu minimo bat sartu behar dira."));
			return null;
		}
		try {
			facadeBL.createQuestion(gertaera, galderaBerria, galderaBerriaMinBet);
			data = null;
			gertaerak = new Vector<Event>();
			questionsFromEvent = new Vector<Question>();
			return "success";
		} catch (EventFinished e) {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Errorea: " + e.toString()));
			return null;
		} catch (QuestionAlreadyExist e) {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Errorea: " +  e.toString()));
			return null;
		}
	}
	
	public String putResult() {
		facadeBL=FacadeBean.getBusinessLogic();
		if (gertaera==null || galdera==null || emaitza==null) {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Errorea: gertaera, galdera eta emaitza bat sartu behar dira."));
			return null;
		}
		try {
			facadeBL.putResult(gertaera, galdera, emaitza);
			emaitza = null;
			gertaerak = new Vector<Event>();
			galdera = null;
			return "success";
		} catch (EventNotFinished e) {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Errorea: " + e.toString()));
			return null;
		}
	}
}
