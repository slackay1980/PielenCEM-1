package entyties;

import java.util.List;

import javax.persistence.*;


@Entity
@Table(name="CUSTOMER_STATION")
public class CustomerStation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int Id;
 

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


	//////// Connect to Customer Table ///////////////////
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="CUSTOMER_ID")
    private Customer customer;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="REGION_ID")
	private Region region;

	@OneToMany(fetch = FetchType.EAGER,mappedBy = "customerStation")
	private List<Relation> relations;

	public int getId() {
		return Id;
	}

	public void setId(int id) {
		Id = id;
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

	public void setStationStreet(String stationStreet) {
		this.stationStreet = stationStreet;
	}

	public String getStationLandPostCode() {
		return stationLandPostCode;
	}

	public void setStationLandPostCode(String stationLandPostCode) {
		this.stationLandPostCode = stationLandPostCode;
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

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}


	public CustomerStation(String stationName, String stationStreet, String stationLandPostCode, String stationCity,
			String stationEmploee, String stationTelefone1, String stationTelefone2, String stationEmail,
			String stationNote) {
		super();
		this.stationName = stationName;
		this.stationStreet = stationStreet;
		this.stationLandPostCode = stationLandPostCode;
		this.stationCity = stationCity;
		this.stationEmploee = stationEmploee;
		this.stationTelefone1 = stationTelefone1;
		this.stationTelefone2 = stationTelefone2;
		this.stationEmail = stationEmail;
		this.stationNote = stationNote;
	}

	public CustomerStation() {
		
	}

	@Override
	public String toString() {
		return "CustomerStation [stationName=" + stationName + ", stationStreet=" + stationStreet
				+ ", stationLandPostCode=" + stationLandPostCode + ", stationCity=" + stationCity + ", stationEmploee="
				+ stationEmploee + ", stationTelefone1=" + stationTelefone1 + ", stationTelefone2=" + stationTelefone2
				+ ", stationEmail=" + stationEmail + ", stationNote=" + stationNote + "]";
	}
	
	
    
    

   
}
