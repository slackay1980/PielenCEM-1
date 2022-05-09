package entyties;


import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="REGION")
public class Region {

    @javax.persistence.Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int Id;


    @Column(name="REGION_NAME")
    private String regionName;

    @Column(name="REGION_SHORT_NAME")
    private String regionShortName;

    //////////////////CONNECT TO CUSTOMER_STATION  TABLE ////////////////
    @OneToMany(mappedBy = "region")
    private List<CustomerStation> customerStations;

    @OneToMany(mappedBy = "region")
    private List<ProducerStation> producerStations;


    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getRegionName() {
        return regionName;
    }

    public void setRegionName(String regionName) {
        this.regionName = regionName;
    }

    public String getRegionShortName() {
        return regionShortName;
    }

    public void setRegionShortName(String regionShortName) {
        this.regionShortName = regionShortName;
    }

    public Region() {

    }

    public Region(String regionName, String regionShortName) {
        this.regionName = regionName;
        this.regionShortName = regionShortName;
    }
}
