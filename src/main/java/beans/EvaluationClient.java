package beans;

public class EvaluationClient {
	
	String cinClient , cinProf , nbrEtoileP , nbrEtoileC , desc ;

	public EvaluationClient(String cinClient, String cinProf, String nbrEtoileP, String nbrEtoileC, String desc) {
		super();
		this.cinClient = cinClient;
		this.cinProf = cinProf;
		this.nbrEtoileP = nbrEtoileP;
		this.nbrEtoileC = nbrEtoileC;
		this.desc = desc;
	}

	public EvaluationClient(String cinClient, String cinProf, String nbrEtoileP, String desc) {
		super();
		this.cinClient = cinClient;
		this.cinProf = cinProf;
		this.nbrEtoileP = nbrEtoileP;
		this.desc = desc;
	}

	
	

	@Override
	public String toString() {
		return "EvaluationClient [getCinClient()=" + getCinClient() + ", getCinProf()=" + getCinProf()
				+ ", getNbrEtoileP()=" + getNbrEtoileP() + ", getNbrEtoileC()=" + getNbrEtoileC() + ", getDesc()="
				+ getDesc() + "]";
	}

	public EvaluationClient() {
		super();
	}

	public String getCinClient() {
		return cinClient;
	}

	public void setCinClient(String cinClient) {
		this.cinClient = cinClient;
	}

	public String getCinProf() {
		return cinProf;
	}

	public void setCinProf(String cinProf) {
		this.cinProf = cinProf;
	}

	public String getNbrEtoileP() {
		return nbrEtoileP;
	}

	public void setNbrEtoileP(String nbrEtoileP) {
		this.nbrEtoileP = nbrEtoileP;
	}

	public String getNbrEtoileC() {
		return nbrEtoileC;
	}

	public void setNbrEtoileC(String nbrEtoileC) {
		this.nbrEtoileC = nbrEtoileC;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}
	
	
	
}
