package beans;

public class BesoinBean extends Publication{

	
	
	
	
	public BesoinBean(String titre, String description, String prix, String status, String cin, String categoirie,
			int idBesoin) {
		super(titre, description, prix, status, cin, categoirie, idBesoin);
		// TODO Auto-generated constructor stub
	}
	
	

	public BesoinBean() {
		super();
		// TODO Auto-generated constructor stub
	}



	@Override
	public String toString() {
		return "BesoinBean [titre=" + titre + ", description=" + description + ", prix=" + prix + ", Status=" + Status
				+ ", cin=" + cin + ", Categoirie=" + Categoirie + ", idBesoin=" + idBesoin + ", getCategoirie()="
				+ getCategoirie() + ", getIdBesoin()=" + getIdBesoin() + ", getTitre()=" + getTitre()
				+ ", getDescription()=" + getDescription() + ", getPrix()=" + getPrix() + ", getStatus()=" + getStatus()
				+ ", getCin()=" + getCin() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode()
				+ ", toString()=" + super.toString() + "]";
	}

	
	
	
	
}
