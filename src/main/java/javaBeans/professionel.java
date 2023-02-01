package javaBeans;

public class professionel extends utilisateur {
	private String cin;
	private String surMoi; // les infos de professionnel qui s'affichent dans son profil
	private String Cv;

//constructeur sans parametre
	public professionel() {
		// TODO Auto-generated constructor stub
	}

//cv : getters et setters

	public String getCv() {
		return Cv;
	}

	public void setCv(String cv) {
		Cv = cv;
	}

//cin : getters et setters

	public String getCin() {
		return cin;
	}

	public void setCin(String cin) {
		this.cin = cin;
	}

//surMoi : getters et setters

	public String getSurMoi() {
		return surMoi;
	}

	public void setSurMoi(String surMoi) {
		this.surMoi = surMoi;
	}

	@Override
	public String toString() {
		return "professionel [cin=" + cin + ", surMoi=" + surMoi + ", Cv=" + Cv + "]";
	}
	
	
	
}
