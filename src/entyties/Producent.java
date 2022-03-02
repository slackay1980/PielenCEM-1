package entyties;

import javax.persistence.*;
import java.util.List;



@Entity
@Table(name = "PRODUCENT")
public class Producent {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="ID")
    private int id;
    
    @Column(name ="PRODUCENT_NAME")
    private String producentName;
    
    @Column(name ="PRODUCENT_STREET")
    private String producentStreet;
    
    @Column(name ="CPRODUCENT_LAND_POSTCODE")
    private String producentLandPostCode;
    
    @Column(name ="PRODUCENT_CITY")
    private String producentCity;
    
    @Column(name ="PRODUCENT_EMPLOEE")
    private String producentEmploee;
 
    @Column(name ="PRODUCENT_TELEFONE_1")
    private String producentTelefone1;
    
    @Column(name ="PRODUCENT_TELEFONE_2")
    private String producentTelefone2;
    
    @Column(name ="PRODUCENT_TELEFONE_3")
    private String producentTelefone3;
    
    @Column(name ="PRODUCENT_EMAIL")
    private String producentEmail;
    
    @Column(name ="PRODUCENT_LOGICID")
    private String producentLogicId;
    
    @Column(name ="PRODUCENT_NOTE")
    private String producentNote;

///////////////////CONNECTION TO PRODUCENTSTATION///////////////////////////////////////
	@OneToMany(fetch = FetchType.EAGER, mappedBy = "producent")
	private List<ProducentStation> producentStations;


	public Producent() {
	
	}


	


	public Producent(int id, List<ProducentStation> producentStations, String producentName, String producentStreet,
			String producentLandPostCode, String producentCity, String producentEmploee, String producentTelefone1,
			String cproducentTelefone2, String producentTelefone3, String producentEmail, String producentLogicId,
			String producentNote) {
		super();
		this.id = id;
		this.producentStations = producentStations;
		this.producentName = producentName;
		this.producentStreet = producentStreet;
		this.producentLandPostCode = producentLandPostCode;
		this.producentCity = producentCity;
		this.producentEmploee = producentEmploee;
		this.producentTelefone1 = producentTelefone1;
		this.producentTelefone2 = cproducentTelefone2;
		this.producentTelefone3 = producentTelefone3;
		this.producentEmail = producentEmail;
		this.producentLogicId = producentLogicId;
		this.producentNote = producentNote;
	}





	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getProducentName() {
		return producentName;
	}


	public void setProducentName(String producentName) {
		this.producentName = producentName;
	}


	public String getProducentCity() {
		return producentCity;
	}


	public void setProducentCity(String producentCity) {
		this.producentCity = producentCity;
	}


	public List<ProducentStation> getProducentStations() {
		return producentStations;
	}


	public void setProducentStations(List<ProducentStation> producentStations) {
		this.producentStations = producentStations;
	}





	public String getProducentStreet() {
		return producentStreet;
	}





	public void setProducentStreet(String producentStreet) {
		this.producentStreet = producentStreet;
	}





	public String getProducentLandPostCode() {
		return producentLandPostCode;
	}





	public void setProducentLandPostCode(String producentLandPostCode) {
		this.producentLandPostCode = producentLandPostCode;
	}





	public String getProducentEmploee() {
		return producentEmploee;
	}





	public void setProducentEmploee(String producentEmploee) {
		this.producentEmploee = producentEmploee;
	}





	public String getProducentTelefone1() {
		return producentTelefone1;
	}





	public void setProducentTelefone1(String producentTelefone1) {
		this.producentTelefone1 = producentTelefone1;
	}





	public String getProducentTelefone2() {
		return producentTelefone2;
	}





	public void setProducentTelefone2(String producentTelefone2) {
		this.producentTelefone2 = producentTelefone2;
	}





	public String getProducentTelefone3() {
		return producentTelefone3;
	}





	public void setProducentTelefone3(String producentTelefone3) {
		this.producentTelefone3 = producentTelefone3;
	}





	public String getProducentEmail() {
		return producentEmail;
	}





	public void setProducentEmail(String producentEmail) {
		this.producentEmail = producentEmail;
	}





	public String getProducentLogicId() {
		return producentLogicId;
	}





	public void setProducentLogicId(String producentLogicId) {
		this.producentLogicId = producentLogicId;
	}





	public String getProducentNote() {
		return producentNote;
	}





	public void setProducentNote(String producentNote) {
		this.producentNote = producentNote;
	}

	

	
    
    

}
