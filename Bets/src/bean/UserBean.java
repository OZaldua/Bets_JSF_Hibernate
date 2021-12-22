package bean;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import businessLogic.BLFacade;
import businessLogic.BLFacadeImplementation;
import eredua.domain.User;
import exceptions.EmailAlreadyExists;
import exceptions.EmailNotExists;
import exceptions.WrongPassword;
public class UserBean {

	private String izena = "";
	private String emaila = "";
	private String pasahitza = "";
	private String pasahitza2 ="";
	private String mota = "";
	private BLFacade facadeBL;

	public UserBean() {
	}
	
	public String getMota() {
		return mota;
	}

	public void setMota(String mota) {
		this.mota = mota;
	}

	public String getEmaila() {
		return emaila;
	}

	public void setEmaila(String emaila) {
		this.emaila = emaila;
	}

	public String getPasahitza() {
		return pasahitza;
	}

	public void setPasahitza(String pasahitza) {
		this.pasahitza = pasahitza;
	}

	public String getIzena() {
		return izena;
	}

	public void setIzena(String izena) {
		this.izena = izena;
	}

	public String getPasahitza2() {
		return pasahitza2;
	}

	public void setPasahitza2(String pasahitza2) {
		this.pasahitza2 = pasahitza2;
	}
	
	public String logIn() {
		facadeBL=FacadeBean.getBusinessLogic();
		if (emaila==null || pasahitza==null) {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Errorea: korreoa eta pasahitza sartu behar dituzu"));
			return null;
		}
		try {
			User u = facadeBL.login(emaila, pasahitza);
			FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("user", u.getEmaila());
			FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("mota", u.getMota());
			return u.getMota();
		} catch (EmailNotExists e) {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Errorea: " + e.toString()));
			return null;
		} catch (WrongPassword e) {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Errorea: " +  e.toString()));
			return null;
		}
	}
	
	public String signUp() {
		facadeBL=FacadeBean.getBusinessLogic();
		if(izena == null || emaila == null || pasahitza == null || pasahitza2 == null) {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Errorea: eremu guztiak bete behar dituzu"));
			return null;
		}else if(pasahitza.length()<8) {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Errorea: pasahitzak 8 karaktere izan behar ditu gutxienez"));
			return null;
		}else if (!pasahitza.equals(pasahitza2)) {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Errorea: sartutako bi pasahitzak ez dira berdinak"));
			return null;
		}
		try {
			facadeBL.signUp(izena, emaila, pasahitza);
			return "success";
		} catch (EmailAlreadyExists e) {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Errorea: " + e.toString()));
			return null;
		}
	}

	public String goQuery() {
		String m = (String) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("mota");
		if (m==null)
			return "home";
		else 
			return m;
	}
	
	public String logOut() {
		FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
		return "out";
	}
}
