package entyties;

import java.util.List;

import javax.persistence.*;


@Entity
@Table(name = "PRODUCENT_STATION")
public class ProducentStation {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="ID")
    private int id;
	
	 @Column(name="STATION_NAME")
	 private String stationName;
	    
	    @Column(name ="STATION_STREET")
	    private String stationStreet;
	    
	    @Column(name ="STATION_LAND_POSTCODE")
	    private String stationLandPostCode;
	    
	    @Column(name ="STATION_CITY")
	    private String stationCity;
	    
	    @Column(name ="station_EMPLOEE")
	    private String stationEmploee;
	 
	    @Column(name ="STATION_TELEFONE_1")
	    private String stationTelefone1;
	    
	    @Column(name ="STATION_TELEFONE_2")
	    private String stationTelefone2;
	    
	    
	    @Column(name ="STATION_EMAIL")
	    private String stationEmail;
	    
	   
	    @Column(name ="STATION_NOTE")
	    private String stationNote;
	    

    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="producent_id")
    private Producent producent;
    

    
    @OneToMany(fetch = FetchType.EAGER, mappedBy = "producentStation")
    private List<Product> product;


	@OneToMany(mappedBy = "producentStation")
	private List<Relation> relations;



	public ProducentStation() {
		
	}


	public ProducentStation(int id, String stationName, String stationStreet, String stationLandPostCode,
			String stationCity, String stationEmploee, String stationTelefone1, String stationTelefone2,
			String stationEmail, String stationNote, Producent producent,
			List<Product> product) {
		super();
		this.id = id;
		this.stationName = stationName;
		this.stationStreet = stationStreet;
		this.stationLandPostCode = stationLandPostCode;
		this.stationCity = stationCity;
		this.stationEmploee = stationEmploee;
		this.stationTelefone1 = stationTelefone1;
		this.stationTelefone2 = stationTelefone2;
		this.stationEmail = stationEmail;
		this.stationNote = stationNote;
		this.producent = producent;
		this.product = product;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getStationName() {
		return stationName;
	}


	public void setStationName(String stationName) {
		this.stationName = stationName;
	}


	public String getStationStreet() {
		return stationStreet;
	}

	public List<Relation> getRelations() {
		return relations;
	}

	public void setRelations(List<Relation> relations) {
		this.relations = relations;
	}


	public void setStationStreet(String stationStreet) {
		this.stationStreet = stationStreet;
	}


	public String getStationLandPostCode() {
		return stationLandPostCode;
	}


	public void setStationLandPostCode(String stationLandPostCode) {
		this.stationLandPostCode = stationLandPostCode;
	}


	public String getStationCity() {
		return stationCity;
	}


	public void setStationCity(String stationCity) {
		this.stationCity = stationCity;
	}


	public String getStationEmploee() {
		return stationEmploee;
	}


	public void setStationEmploee(String stationEmploee) {
		this.stationEmploee = stationEmploee;
	}


	public String getStationTelefone1() {
		return stationTelefone1;
	}


	public void setStationTelefone1(String stationTelefone1) {
		this.stationTelefone1 = stationTelefone1;
	}


	public String getStationTelefone2() {
		return stationTelefone2;
	}


	public void setStationTelefone2(String stationTelefone2) {
		this.stationTelefone2 = stationTelefone2;
	}


	public String getStationEmail() {
		return stationEmail;
	}


	public void setStationEmail(String stationEmail) {
		this.stationEmail = stationEmail;
	}


	public String getStationNote() {
		return stationNote;
	}


	public void setStationNote(String stationNote) {
		this.stationNote = stationNote;
	}


	public Producent getProducent() {
		return producent;
	}


	public void setProducent(Producent producent) {
		this.producent = producent;
	}




	public List<Product> getProduct() {
		return product;
	}


	public void setProduct(List<Product> product) {
		this.product = product;
	}


	@Override
	public String toString() {
		return "ProducentStation [id=" + id + ", stationName=" + stationName + ", stationStreet=" + stationStreet
				+ ", stationLandPostCode=" + stationLandPostCode + ", stationCity=" + stationCity + ", stationEmploee="
				+ stationEmploee + ", stationTelefone1=" + stationTelefone1 + ", stationTelefone2=" + stationTelefone2
				+ ", stationEmail=" + stationEmail + ", stationNote=" + stationNote + ", producent=" + producent
				+ ", product=" + product + "]";
	}

	
	
    
    

}
