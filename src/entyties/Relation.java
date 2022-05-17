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
    private ProducerStation producerStation;

    @OneToMany(mappedBy = "relation")
    private List<Freight> freights;


    @Column(name = "RELATION_NAME")
    private String relationName;


    @Column(name = "DISTANCE")
    private int distance;

    @Column(name = "CUSTOM")
    private boolean ifCustom;


    public Relation() {
    }



    public Relation(CustomerStation customerStation, ProducerStation producerStation, String relationName, int distance) {
        this.customerStation = customerStation;
        this.producerStation = producerStation;
        this.relationName = relationName;
        this.distance = distance;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public ProducerStation getProducerStation() {
        return producerStation;
    }

    public void setProducerStation(ProducerStation producerStation) {
        this.producerStation = producerStation;
    }

    public List<Freight> getFreights() {
        return freights;
    }

    public void setFreights(List<Freight> freights) {
        this.freights = freights;
    }

    public String getRelationName() {
        return relationName;
    }

    public void setRelationName(String relationName)
    {
        if ((relationName==null)||(relationName.equals(""))) {
            relationName = producerStation.getStationName() + ", " + producerStation.getStationCity() +
                    " - " + customerStation.getStationCity() + " (" + customerStation.getStationName() + ")";

        }

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