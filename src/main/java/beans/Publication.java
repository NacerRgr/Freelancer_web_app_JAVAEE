package beans;

public class Publication {

	protected  String titre , description , prix , Status , cin , Categoirie ;
	protected int  idBesoin;

	
	
	
	
	public Publication(String titre, String description, String prix, String status, String cin, String categoirie,
			int idBesoin) {
		super();
		this.titre = titre;
		this.description = description;
		this.prix = prix;
		Status = status;
		this.cin = cin;
		Categoirie = categoirie;
		this.idBesoin = idBesoin;
	}

	public String getCategoirie() {
		return Categoirie;
	}

	public void setCategoirie(String categoirie) {
		Categoirie = categoirie;
	}

	public int getIdBesoin() {
		return idBesoin;
	}

	public void setIdBesoin(int idBesoin) {
		this.idBesoin = idBesoin;
	}

	public  Publication() {
		
	}

	public String getTitre() {
		return titre;
	}

	public void setTitre(String titre) {
		this.titre = titre;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getPrix() {
		return prix;
	}

	public void setPrix(String prix) {
		this.prix = prix;
	}

	public String getStatus() {
		return Status;
	}

	public void setStatus(String status) {
		Status = status;
	}

	public String getCin() {
		return cin;
	}

	public void setCin(String cin) {
		this.cin = cin;
	}
	
	
	
	
}
