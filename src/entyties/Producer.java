package entyties;

import javax.persistence.*;
import java.util.List;



@Entity
@Table(name = "PRODUCENT")
public class Producer {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="ID")
    private int id;
    
    @Column(name ="PRODUCENT_NAME")
    private String producerName;
    
    @Column(name ="PRODUCENT_STREET")
    private String producentStreet;


	@Column(name ="PRODUCENT_LAND")
	private String producentLand;

	@Column(name ="PRODUCENT_POSTCODE")
	private String producentPostCode;
    
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
	@OneToMany(fetch = FetchType.EAGER, mappedBy = "producer")
	private List<ProducerStation> producerStations;


	public Producer() {
	
	}


	


	public Producer(int id, List<ProducerStation> producerStations, String producentName, String producentStreet,
					String producentLand, String producentPostCode, String producentCity, String producentEmploee, String producentTelefone1,
					String cproducentTelefone2, String producentTelefone3, String producentEmail, String producentLogicId,
					String producentNote) {
		super();
		this.id = id;
		this.producerStations = producerStations;
		this.producerName = producentName;
		this.producentStreet = producentStreet;
		this.producentLand = producentLand;
		this.producentPostCode = producentPostCode;
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
		return producerName;
	}


	public void setProducentName(String producerName) {
		this.producerName = producerName;
	}


	public String getProducentCity() {
		return producentCity;
	}


	public void setProducentCity(String producentCity) {
		this.producentCity = producentCity;
	}


	public List<ProducerStation> getProducerStations() {
		return producerStations;
	}


	public void setProducerStations(List<ProducerStation> producerStations) {
		this.producerStations = producerStations;
	}





	public String getProducentStreet() {
		return producentStreet;
	}





	public void setProducentStreet(String producentStreet) {
		this.producentStreet = producentStreet;
	}


	public String getProducentLand() {
		return producentLand;
	}

	public void setProducentLand(String producentLand) {
		this.producentLand = producentLand;
	}

	public String getProducentPostCode() {
		return producentPostCode;
	}

	public void setProducentPostCode(String producentPostCode) {
		this.producentPostCode = producentPostCode;
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
