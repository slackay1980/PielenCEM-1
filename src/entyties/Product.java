package entyties;

import java.util.List;

import javax.persistence.*;


@Entity
@Table(name = "PRODUCT")
public class Product {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="ID")
    private int id;


    @Column(name ="PRODUCT_NAME")
    private String productName;

	@Column(name ="PRODUCT_NAME_MORE")
	private String productNameMore;

	@Column(name ="FIELD_1")
	private String field1;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="producent_station_id")
	private ProducentStation producentStation;



	public String getProductNameMore() {
		return productNameMore;
	}

	public void setProductNameMore(String productNameMore) {
		this.productNameMore = productNameMore;
	}

	public String getField1() {
		return field1;
	}

	public void setField1(String field1) {
		this.field1 = field1;
	}

	public String getField2() {
		return field2;
	}

	public void setField2(String field2) {
		this.field2 = field2;
	}

	public Product(ProducentStation producentStation, String productName, String productNameMore, String field1, String field2) {
		this.producentStation = producentStation;
		this.productName = productName;
		this.productNameMore = productNameMore;
		this.field1 = field1;
		this.field2 = field2;
	}

	@Column(name ="FIELD_2")
	private String field2;




	public Product() {
		
	}



	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public ProducentStation getProducentStation() {
		return producentStation;
	}

	public void setProducentStation(ProducentStation producentStation) {
		this.producentStation = producentStation;
	}
	
	
	
	

}
