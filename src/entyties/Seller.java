package entyties;


import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "SELLER")

public class Seller {

    @javax.persistence.Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int Id;

    @Column(name="SELLER_NAME")
    private String sellerName;

    @Column(name ="SELLER_SHORT_NAME")
    private String sellerShortName;

    /// Connect to Table Customer ///////////////////////////////////////
    @OneToMany(fetch = FetchType.EAGER, mappedBy = "seller")
    private List<Customer> customers;

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getSellerName() {
        return sellerName;
    }

    public void setSellerName(String sellerName) {
        this.sellerName = sellerName;
    }

    public String getSellerShortName() {
        return sellerShortName;
    }

    public void setSellerShortName(String sellerShortName) {
        this.sellerShortName = sellerShortName;
    }

    public List<Customer> getCustomers() {
        return customers;
    }

    public void setCustomers(List<Customer> customers) {
        this.customers = customers;
    }

    public Seller() {

    }

    public Seller(String sellerName, String sellerShortName, List<Customer> customers) {
        this.sellerName = sellerName;
        this.sellerShortName = sellerShortName;
        this.customers = customers;
    }
}
