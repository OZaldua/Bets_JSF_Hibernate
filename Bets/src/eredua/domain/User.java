package eredua.domain;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class User {
	@Id
	private String emaila = "";
	private String pasahitza = "";
	private String mota ="";
	private String izena = "";


	public User() {
	}
	
	public User(String emaila, String pasahitza,  String mota, String izena) {
		super();
		this.emaila = emaila;
		this.pasahitza = pasahitza;
		this.mota=mota;
		this.izena = izena;
	}
	
	public String getIzena() {
		return izena;
	}

	public void setIzena(String izena) {
		this.izena = izena;
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
}