package javaBeans;


public class besoin {
 private int	idBesoin;
 private String titreBesoin;
 private String description;
 private float prixApayer;
 private String Statut;
private client cin;
private professionel cinP;
public int getIdBesoin() {
	return idBesoin;
}
public void setIdBesoin(int idBesoin) {
	this.idBesoin = idBesoin;
}
public String getTitreBesoin() {
	return titreBesoin;
}
public void setTitreBesoin(String titreBesoin) {
	this.titreBesoin = titreBesoin;
}
public String getDescription() {
	return description;
}
public void setDescription(String description) {
	this.description = description;
}
public float getPrixApayer() {
	return prixApayer;
}
public void setPrixApayer(float prixApayer) {
	this.prixApayer = prixApayer;
}
public String getStatut() {
	return Statut;
}
public void setStatut(String statut) {
	Statut = statut;
}
public client getCin() {
	return cin;
}
public void setCin(client cin) {
	this.cin = cin;
}
public professionel getCinP() {
	return cinP;
}
public void setCinP(professionel cinP) {
	this.cinP = cinP;
}

}
