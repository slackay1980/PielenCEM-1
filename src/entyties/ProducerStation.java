package entyties;

import java.util.List;

import javax.persistence.*;


@Entity
@Table(name = "PRODUCENT_STATION")
public class ProducerStation {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="ID")
    private int id;

	 @Column(name="STATION_NAME")
	 private String stationName;
	    
	    @Column(name ="STATION_STREET")
	    private String stationStreet;
	    
	    @Column(name ="STATION_LAND")
	    private String stationLand;

		@Column(name ="STATION_POSTCODE")
		private String stationPostCode;


		@Column(name ="STATION_CITY")
	    private String stationCity;
	    
	    @Column(name ="station_EMPLOEE")
	    private String stationEmploee;
	 
	    @Column(name ="STATION_TELEFONE_1")
	    private String stationTelefone1;
	    
	    @Column(name ="STATION_TELEFONE_2")
	    private String stationTelefone2;

	    @Column(name ="STATION_TELEFONE_3")
		private String stationTelefone3;
	    
	    @Column(name ="STATION_EMAIL")
	    private String stationEmail;
	    
	   
	    @Column(name ="STATION_NOTE")
	    private String stationNote;
	    

    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="producer_id")
    private Producer producer;
    

    
    @OneToMany(fetch = FetchType.EAGER, mappedBy = "producerStation")
    private List<Product> product;


	@OneToMany(mappedBy = "producerStation")
	private List<Relation> relations;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="REGION_ID")
	private Region region;



	public ProducerStation() {
		
	}


	public ProducerStation(int id, String stationName, String stationStreet, String stationLand, String stationPostCode,
						   String stationCity, String stationEmploee, String stationTelefone1, String stationTelefone2,
						   String stationEmail, String stationNote, Producer producer,
						   List<Product> product) {
		super();
		this.id = id;
		this.stationName = stationName;
		this.stationStreet = stationStreet;
		this.stationLand = stationLand;
		this.stationPostCode = stationPostCode;
		this.stationCity = stationCity;
		this.stationEmploee = stationEmploee;
		this.stationTelefone1 = stationTelefone1;
		this.stationTelefone2 = stationTelefone2;
		this.stationEmail = stationEmail;
		this.stationNote = stationNote;
		this.producer = producer;
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

	public String getStationLand() {
		if(stationLand==null) {
			return "";
		}
		else {
			return stationLand;
		}
	}

	public void setStationLand(String stationLand) {
		this.stationLand = stationLand;
	}

	public String getStationPostCode() {
		if(stationPostCode==null) {
			return "";
		}
		else {
			return stationPostCode;
		}
	}

	public void setStationPostCode(String stationPostCode) {
		this.stationPostCode = stationPostCode;
	}

	public Region getRegion() {
		return region;
	}

	public void setRegion(Region region) {
		this.region = region;
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
		if(stationTelefone1==null) {
			return "";
		}
		else {
			return stationTelefone1;
		}
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

	public String getStationTelefone3() { return stationTelefone3; }

	public void setStationTelefone3(String stationTelefone3) { this.stationTelefone3 = stationTelefone3; }


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


	public Producer getProducer() {
		return producer;
	}


	public void setProducer(Producer producer) {
		this.producer = producer;
	}




	public List<Product> getProduct() {
		return product;
	}


	public void setProduct(List<Product> product) {
		this.product = product;
	}


	@Override
	public String toString() {
		return "ProducerStation [id=" + id + ", stationName=" + stationName + ", stationStreet=" + stationStreet
				+ ", stationLandPostCode=" + stationLand + ", stationCity=" + stationCity + ", stationEmploee="
				+ stationEmploee + ", stationTelefone1=" + stationTelefone1 + ", stationTelefone2=" + stationTelefone2
				+ ", stationEmail=" + stationEmail + ", stationNote=" + stationNote + ", producer=" + producer
				+ ", product=" + product + "]";
	}

	
	
    
    

}
