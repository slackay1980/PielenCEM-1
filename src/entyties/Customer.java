package entyties;



import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "CUSTOMER")
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="ID")
    private int id;

    @Transient
	private Integer posNumber;

    @Column(name ="CUSTOMER_NAME")
    private String customerName;
    
    @Column(name ="CUSTOMER_STREET")
    private String customerStreet;
    
    @Column(name ="CUSTOMER_LAND")
    private String customerLand;

	@Column(name ="CUSTOMER_POSTCODE")
	private String customerPostCode;

	@Transient
	private String customerCountryAndPOstCode;

	@Column(name ="CUSTOMER_CITY")
    private String customerCity;
    
    @Column(name ="CUSTOMER_EMPLOEE")
    private String customerEmploee;
 
    @Column(name ="CUSTOMER_TELEFONE_1")
    private String customerTelefone1;
    
    @Column(name ="CUSTOMER_TELEFONE_2")
    private String customerTelefone2;
    
    @Column(name ="CUSTOMER_TELEFONE_3")
    private String customerTelefone3;
    
    @Column(name ="CUSTOMER_EMAIL")
    private String customerEmail;
    
    @Column(name ="CUSTOMER_LOGICID")
    private String customerLogicId;
    
    @Column(name ="CUSTOMER_NOTE")
    private String customerNote;

    /////// Connect to Seller Table ///////
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="SELLER_ID")
	private Seller seller;

	@Transient
	private String sellerName;



	//// Connect to CustomerStation Table /////////////
    @OneToMany(fetch = FetchType.EAGER, mappedBy = "customer")
    private List<CustomerStation> customerStations;






	public void setId(int id) {
		this.id = id;
	}

	public int getId() {
		return id;
	}

	public Integer getPosNumber() {
		return posNumber;
	}

	public void setPosNumber(Integer posNumber) {
		this.posNumber = posNumber;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getCustomerName() {
		return customerName;
	}


    public String getCustomerStreet() {
		return customerStreet;
	}

	public void setCustomerStreet(String customerStreet) {
		this.customerStreet = customerStreet;
	}

	public String getCustomerLand() {
		return customerLand;
	}

	public void setCustomerLand(String customerLand) {
		this.customerLand = customerLand;
	}

	public String getCustomerPostCode() {
		return customerPostCode;
	}

	public void setCustomerPostCode(String customerPostCode) {
		this.customerPostCode = customerPostCode;
	}

	public String getCustomerCountryAndPOstCode() {
		return getCustomerLand()+"-"+getCustomerPostCode();
	}

	public void setCustomerCountryAndPOstCode(String customerCountryAndPOstCode) {
		this.customerCountryAndPOstCode = customerCountryAndPOstCode;
	}

	public String getCustomerCity() {
		return customerCity;
	}

	public void setCustomerCity(String customerCity) {
		this.customerCity = customerCity;
	}

	public String getCustomerEmploee() {
		return customerEmploee;
	}

	public void setCustomerEmploee(String customerEmploee) {
		this.customerEmploee = customerEmploee;
	}

	public String getCustomerTelefone1() {
		return customerTelefone1;
	}

	public void setCustomerTelefone1(String customerTelefone1) {
		this.customerTelefone1 = customerTelefone1;
	}

	public String getCustomerTelefone2() {
		return customerTelefone2;
	}

	public void setCustomerTelefone2(String customerTelefone2) {
		this.customerTelefone2 = customerTelefone2;
	}

	public String getCustomerTelefone3() {
		return customerTelefone3;
	}

	public void setCustomerTelefone3(String customerTelefone3) {
		this.customerTelefone3 = customerTelefone3;
	}

	public String getCustomerEmail() {
		return customerEmail;
	}

	public void setCustomerEmail(String customerEmail) {
		this.customerEmail = customerEmail;
	}

	public String getCustomerNote() {
		return customerNote;
	}

	public void setCustomerNote(String customerNote) {
		this.customerNote = customerNote;
	}
	
	public String getCustomerLogicId() {
		return customerLogicId;
	}

	public void setCustomerLogicId(String customerLogicId) {
		this.customerLogicId = customerLogicId;
	}



	public void setCustomerStations(List<CustomerStation> customerStations) {
		this.customerStations = customerStations;
	}

    public List<CustomerStation> getCustomerStations() {
        return customerStations;
    }

	public Seller getSeller() {
		return seller;
	}

	public void setSeller(Seller seller) {
		this.seller = seller;
	}

	public String getSellerName() {
		if (getSeller()!=null) {
			return getSeller().getSellerShortName();
		}
		else {
			return "kein Betreuer";
		}
	}

	public Customer(){

    }

   
   

    public Customer(String customerName, String customerStreet, String customerLand,String customerPostCode,
			String customerCity, String customerEmploee, String customerTelefone1, String customerTelefone2,
			String customerTelefone3, String customerEmail, String customerLogicId, String customerNote) {

		this.customerName = customerName;
		this.customerStreet = customerStreet;
		this.customerLand = customerLand;
		this.customerPostCode = customerPostCode;
		this.customerCity = customerCity;
		this.customerEmploee = customerEmploee;
		this.customerTelefone1 = customerTelefone1;
		this.customerTelefone2 = customerTelefone2;
		this.customerTelefone3 = customerTelefone3;
		this.customerEmail = customerEmail;
		this.customerLogicId = customerLogicId;
		this.customerNote = customerNote;
		
	}

	

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", customerName='" + customerName + '\'' +
                ", customerStations=" + customerStations +
                '}';
    }
}
