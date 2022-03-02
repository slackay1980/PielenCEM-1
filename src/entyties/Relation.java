package entyties;
import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "RELATION")
public class Relation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private int id;

    @ManyToOne
    @JoinColumn(name="CUSTOMERSTATION_ID")
    private CustomerStation customerStation;

    @ManyToOne
    @JoinColumn(name="PRODUCENTSTATION_ID")
    private ProducentStation producentStation;

    @OneToMany(mappedBy = "relation")
    private List<Freight> freights;

    public List<Freight> getFreights() {
        return freights;
    }

    public void setFreights(List<Freight> freights) {
        this.freights = freights;
    }



    @Column(name = "RELATION_NAME")
    private String relationName;


    @Column(name = "DISTANCE")
    private int distance;

    @Column(name = "CUSTOM")
    private boolean ifCustom;


    public Relation() {
    }



    public Relation(CustomerStation customerStation, ProducentStation producentStation, String relationName, int distance) {
        this.customerStation = customerStation;
        this.producentStation = producentStation;
        this.relationName = relationName;
        this.distance = distance;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public ProducentStation getProducentStation() {
        return producentStation;
    }

    public void setProducentStation(ProducentStation producentStation) {
        this.producentStation = producentStation;
    }

    public String getRelationName() {
        return relationName;
    }

    public void setRelationName(String relationName) {
        this.relationName = relationName;
    }

    public int getDistance() {
        return distance;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }

    public CustomerStation getCustomerStation() {
        return customerStation;
    }

    public void setCustomerStation(CustomerStation customerStation) {
        this.customerStation = customerStation;
    }

    public boolean isIfCustom() {
        return ifCustom;
    }

    public void setIfCustom(boolean ifCustom) {
        this.ifCustom = ifCustom;
    }


}