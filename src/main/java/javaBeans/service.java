package javaBeans;

public class service {
	private int idService;
	private String titreService;
	private String description;
	private float prix;
	private String Statut;
	private professionel cin;
	private categoriesservices idC;
	public int getIdService() {
		return idService;
	}
	public void setIdService(int idService) {
		this.idService = idService;
	}
	public String getTitreService() {
		return titreService;
	}
	public void setTitreService(String titreService) {
		this.titreService = titreService;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public float getPrix() {
		return prix;
	}
	public void setPrix(float prix) {
		this.prix = prix;
	}
	public String getStatut() {
		return Statut;
	}
	public void setStatut(String statut) {
		Statut = statut;
	}
	public professionel getCin() {
		return cin;
	}
	public void setCin(professionel cin) {
		this.cin = cin;
	}
	public categoriesservices getIdC() {
		return idC;
	}
	public void setIdC(categoriesservices idC) {
		this.idC = idC;
	}





}
