package javaBeans;

import java.util.List;

public class client extends utilisateur{
private String cin;
private List<besoin> idBesoin;




public String getCin() {
	return cin;
}

public void setCin(String cin) {
	this.cin = cin;
}

public List<besoin> getIdBesoin() {
	return idBesoin;
}

public void setIdBesoin(List<besoin> idBesoin) {
	this.idBesoin = idBesoin;
}

}
